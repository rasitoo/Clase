import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Clase que maneja la comunicación con un cliente en un hilo separado.
 */
class ServerThread implements Runnable {
    private static SecretKey aesKey;
    private static PrivateKey privateKey;
    private static PublicKey publicKey;
    private final Socket clientSocket;
    private final AtomicInteger clientCount;

    /**
     * Constructor de la clase ServerThread.
     *
     * @param socket      El socket del cliente.
     * @param clientCount El contador de clientes conectados.
     */
    public ServerThread(Socket socket, AtomicInteger clientCount) {
        this.clientSocket = socket;
        this.clientCount = clientCount;
    }
    /**
     * Método que se ejecuta cuando el hilo se inicia.
     */
    @Override
    public void run() {

        try (DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
             DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream())) {
            //Envia un mensaje de bienvenida al hiilo cliente, el cliente al iniciarse espera un mensaje del servidor, por lotanto sin esto el cliente no funcionaria
            dos.writeUTF("Bienvenido al servidor");
            generateAndSendKeys(dos,dis);
            while (true) {
                //Espera a que el cliente de una instruccion
                String command = dis.readUTF();
                if (command.equals("UPLOAD")) {
                    receiveFile(dis);
                } else if (command.equals("DOWNLOAD")) {
                    listFiles(dos);
                    sendFile(dis, dos);
                } else {
                    System.out.println("Se ha recibido un comando desconocido");
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error: Archivo no encontrado - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de IO: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error general: " + e.getMessage());
        } finally {
            try {
                //Cierra el socket y se quita del contador
                clientSocket.close();
                clientCount.decrementAndGet();
                System.out.println("Un cliente se ha desconectado, actualmente hay: " + clientCount.get() + " clientes conectados.");
            } catch (IOException e) {
                System.err.println("Error al cerrar el socket: " + e.getMessage());
            }
        }
    }
    /**
     * Recibe un archivo del cliente y lo desencripta.
     *
     * @param dis El DataInputStream para leer datos del cliente.
     * @throws IOException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    private void receiveFile(DataInputStream dis) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        //Lee nombre y tamaño del archivo
        String fileName = dis.readUTF();
        int fileSize = dis.readInt();
        File file = new File("server_files/" + fileName);
        if (!file.exists()) {
            file.getParentFile().mkdirs(); //Crea directorios si no existen
        }
        byte[] encryptedFileBytes = new byte[fileSize];
        dis.readFully(encryptedFileBytes, 0, fileSize);

        Cipher aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        aesCipher.init(Cipher.DECRYPT_MODE, aesKey);
        byte[] decryptedFileBytes = aesCipher.doFinal(encryptedFileBytes);

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(decryptedFileBytes);
        }
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write("Encriptado:");
            bw.newLine();
            bw.write(new String(encryptedFileBytes));
            bw.newLine();
            bw.write("Desencriptado:");
            bw.newLine();
            bw.write(new String(decryptedFileBytes));
            bw.newLine();
        }
        System.out.println("Archivo " + fileName + " recibido y desencriptado.");
    }
    /**
     * Lista los archivos disponibles en el servidor y los envía al cliente.
     *
     * @param dos El DataOutputStream para enviar datos al cliente.
     * @throws IOException
     */
    private void listFiles(DataOutputStream dos) throws IOException {
        File dir = new File("./server_files");
        File[] files = dir.listFiles();
        if (files != null) {
            dos.writeInt(files.length);
            for (File file : files) {
                dos.writeUTF(file.getName());
            }
        } else {
            dos.writeInt(0);
        }
    }
    /**
     * Envía un archivo encriptado solicitado por el cliente.
     *
     * @param dis El DataInputStream para leer datos del cliente.
     * @param dos El DataOutputStream para enviar datos al cliente.
     * @throws IOException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    private void sendFile(DataInputStream dis, DataOutputStream dos) throws IOException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        //Lee el nombre del archivo que quiere el usuario
        String fileName = dis.readUTF();
        File file = new File("./server_files/" + fileName);
        if (!file.exists()) {
            dos.writeUTF("FILE_NOT_FOUND");
            return;
        }
        dos.writeUTF("FILE_FOUND");

        // Encriptar el archivo con AES
        Cipher aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        aesCipher.init(Cipher.ENCRYPT_MODE, aesKey);
        byte[] fileBytes = Files.readAllBytes(file.toPath());
        byte[] encryptedFileBytes = aesCipher.doFinal(fileBytes);

        dos.writeInt(encryptedFileBytes.length);
        dos.write(encryptedFileBytes);

        System.out.println("Archivo " + fileName + " enviado encriptadp.");
    }
    /**
     * Genera las claves RSA, envía la pública y recibe la AES encriptada
     *
     * @param dos El DataOutputStream para enviar datos al cliente.
     * @param dis El DataInputStream para leer datos del cliente.
     * @throws IOException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws InvalidKeyException
     * @throws InvalidKeySpecException
     */
    private static void generateAndSendKeys(DataOutputStream dos, DataInputStream dis) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {

        // Generar par de claves RSA
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        privateKey = keyPair.getPrivate();
        publicKey = keyPair.getPublic();


        // Enviar la clave pública al cliente, el cliente la usará para encriptar la clave aes y que el servidor pueda desencriptarla
        byte[] publicKeyBytes = publicKey.getEncoded();
        dos.writeInt(publicKeyBytes.length);
        dos.write(publicKeyBytes);

        // Recibir la clave AES encriptada
        int encryptedAesKeyLength = dis.readInt();
        byte[] encryptedAesKey = new byte[encryptedAesKeyLength];
        dis.readFully(encryptedAesKey);

        // Desencriptar la clave AES con la clave privada RSA, el cliente encriptó la aes con nuestra clave publica y nos la envia para que usemos la misma clave en los archivos
        Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        rsaCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedAesKeyBytes = rsaCipher.doFinal(encryptedAesKey);
        aesKey = new SecretKeySpec(decryptedAesKeyBytes, "AES");

    }
}
