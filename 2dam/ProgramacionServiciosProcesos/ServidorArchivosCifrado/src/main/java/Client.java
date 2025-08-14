import javax.crypto.*;
import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

/**
 * Clase que representa al cliente que se conecta al servidor para subir y descargar archivos encriptados.
 */
public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;
    private static PublicKey serverPublicKey;
    private static SecretKey aesKey;

    /**
     * Método principal que inicia la conexión con el servidor y maneja las operaciones de subida y descarga de archivos.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             DataInputStream dis = new DataInputStream(socket.getInputStream());
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
             BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {

            //Al iniciarse espera un mensaje del servidor, si el mensaje es que está lleno entonces para
            String serverMessage = dis.readUTF();
            if ("SERVER_FULL".equals(serverMessage)) {
                System.out.println("El servidor está lleno. Inténtelo de nuevo más tarde.");
                return;
            }
            System.out.println("Conectado al servidor");

            generateAndSendKeys(dos, dis);

            while (true) {
                System.out.print("Ingrese comando (UPLOAD/DOWNLOAD/EXIT): ");
                String command = console.readLine().trim().toUpperCase();

                if (command.equals("EXIT")) {
                    break;
                }

                if (command.equals("UPLOAD")) {
                    dos.writeUTF(command);
                    System.out.print("Ingrese la ruta del archivo a subir: ");
                    String filePath = console.readLine();
                    String fileName = new File(filePath).getName();
                    dos.writeUTF(fileName);
                    sendFile(filePath, dos);
                } else if (command.equals("DOWNLOAD")) {
                    dos.writeUTF(command);
                    listFiles(dis);
                    System.out.print("Ingrese el nombre del archivo a descargar: ");
                    String fileName = console.readLine();
                    dos.writeUTF(fileName);
                    receiveFile(fileName, dis);
                } else {
                    System.out.println("Comando desconocido");
                }
            }
        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Lista los archivos disponibles en el servidor y los muestra al usuario.
     *
     * @param dis El DataInputStream para leer datos del servidor.
     * @throws IOException
     */
    private static void listFiles(DataInputStream dis) throws IOException {
        int fileCount = dis.readInt();
        System.out.println("Archivos disponibles en el servidor:");
        for (int i = 0; i < fileCount; i++) {
            System.out.println(dis.readUTF());
        }
    }

    /**
     * Envia un archivo al servidor después de encriptarlo con AES.
     *
     * @param fileName La ruta del archivo a enviar.
     * @param dos      El DataOutputStream para enviar datos al servidor.
     * @throws IOException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    private static void sendFile(String fileName, DataOutputStream dos) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("Archivo no encontrado");
            return;
        }
        // Encriptar el archivo con AES
        Cipher aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        aesCipher.init(Cipher.ENCRYPT_MODE, aesKey);
        byte[] fileBytes = Files.readAllBytes(file.toPath());
        byte[] encryptedFileBytes = aesCipher.doFinal(fileBytes);

        dos.writeInt(encryptedFileBytes.length);
        dos.write(encryptedFileBytes);

        System.out.println("Archivo " + fileName + " enviado encriptado.");
    }

    /**
     * Recibe un archivo del servidor y lo desencripta con AES.
     *
     * @param fileName El nombre del archivo a recibir.
     * @param dis      El DataInputStream para leer datos del servidor.
     * @throws IOException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    private static void receiveFile(String fileName, DataInputStream dis) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String status = dis.readUTF();
        if (status.equals("FILE_NOT_FOUND")) {
            System.out.println("Archivo no encontrado en el servidor");
            return;
        }
        File file = new File(".\\client_files\\" + fileName);
        if (!file.exists()) {
            file.getParentFile().mkdirs(); // Crear directorios si no existen
        }
        int fileSize = dis.readInt();

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


        System.out.println("Archivo " + fileName + " descargado y desencriptado.");
    }

    /**
     * Genera una clave AES, la encripta con la clave pública del servidor y la envía al servidor.
     *
     * @param dos El DataOutputStream para enviar datos al servidor.
     * @param dis El DataInputStream para leer datos del servidor.
     * @throws IOException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws InvalidKeyException
     * @throws InvalidKeySpecException
     */
    private static void generateAndSendKeys(DataOutputStream dos, DataInputStream dis) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {

        // Recibir la clave pública del servidor
        int serverPublicKeyLength = dis.readInt();
        byte[] serverPublicKeyBytes = new byte[serverPublicKeyLength];
        dis.readFully(serverPublicKeyBytes);
        serverPublicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(serverPublicKeyBytes));

        // Generar clave AES
        KeyGenerator aesKeyGen = KeyGenerator.getInstance("AES");
        aesKeyGen.init(128);
        aesKey = aesKeyGen.generateKey();

        // Encriptar la clave AES con la clave pública del servidor
        Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        rsaCipher.init(Cipher.ENCRYPT_MODE, serverPublicKey);
        byte[] encryptedAesKey = rsaCipher.doFinal(aesKey.getEncoded());

        // Enviar la clave AES encriptada
        dos.writeInt(encryptedAesKey.length);
        dos.write(encryptedAesKey);

    }
}
