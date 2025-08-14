package cliente;

import javax.crypto.*;
import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

/**
 * Clase que representa al cliente que se conecta al servidor para subir y descargar archivos encriptados.
 *
 * @author Rodrigo
 * @date 04 marzo, 2025
 */
public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;
    private static PublicKey serverPublicKey;
    private static final String PATH = ".";
    private static PrivateKey privateKey;
    private static PublicKey publicKey;


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
            //Comprobar usuario y registrarlo si es necesario
            System.out.print("Está registrado? Y/N");
            boolean registered = console.readLine().equalsIgnoreCase("Y");
            System.out.print("Nombre de usuario: ");
            String user = console.readLine().trim();
            if (user == null || user.isEmpty()) {
                System.out.println("El usuario no puede estar vacio");
                return;
            }
            System.out.print("Contraseña: ");
            String pass = console.readLine().trim();
            if (pass == null || pass.isEmpty()) {
                System.out.println("La contraseña no puede estar vacia");
                return;
            } else if (pass.length() < 8) {
                System.out.println("La longitud de la contraseña debe ser mayor de 8 carácteres");
                return;
            } else {
                boolean mayus = false;
                boolean minus = false;
                boolean num = false;
                for (char c : pass.toCharArray()) {
                    if (Character.isUpperCase(c)) {
                        mayus = true;
                    }
                    if (Character.isLowerCase(c)) {
                        minus = true;
                    }
                    if (Character.isDigit(c)) {
                        num = true;
                    }
                }
                if (mayus && minus && num) {
                    System.out.println("Contraseña valida");
                } else {
                    System.out.println("La contraseña debe contener una mayúscula, minúscula o número");
                    return;
                }
            }
            if (registered) {
                if (userExists("usuarios", user)) {
                    if (getUserData("usuarios", user, pass)) {
                        System.out.println("Autenticación correcta");
                    } else {
                        System.out.println("Credenciales incorrectas");
                        return;
                    }
                } else {
                    System.out.println("usuario incorrectas");
                    return;
                }
            } else {
                if (userExists("usuarios", user)) {
                    System.out.println("El usuario ya existe");
                    return;
                }
                generateKeys();
                //Escribir los datos del usuario en el fichero
                String texto = "user " + user + "\npublicKey " + publicKey.getEncoded() + "\nprivateKey " + privateKey.getEncoded() + "\npass " + pass.hashCode() + "\n";
                write("usuarios", texto, false);
            }
            System.out.println("Conectado al servidor");


            receiveAndSendPublicKeys(dos, dis);

            while (true) {
                System.out.print("Ingrese comando (UPLOAD/DOWNLOAD/LIST/EXIT): ");
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
                } else if (command.equals("LIST")) {
                    dos.writeUTF(command);
                    listFiles(dis);
                } else {
                    System.out.println("Comando desconocido");
                }
            }
        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        } catch (NoSuchPaddingException | InvalidKeyException | BadPaddingException | InvalidKeySpecException |
                 NoSuchAlgorithmException | IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        }
    }

    private static void generateKeys() throws NoSuchAlgorithmException {

        // Generar par de claves RSA
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        privateKey = keyPair.getPrivate();
        publicKey = keyPair.getPublic();
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
        // Encriptar el archivo con la clave pública del servidor
        Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        rsaCipher.init(Cipher.ENCRYPT_MODE, serverPublicKey);
        byte[] fileBytes = Files.readAllBytes(file.toPath());
        byte[] encryptedFileBytes = rsaCipher.doFinal(fileBytes);

        System.out.println("Contenido original del fichero: " + new String(fileBytes));
        System.out.println("Contenido encriptado del fichero: " + new String(encryptedFileBytes));

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
        //Desencriptar el archivo
        Cipher aesCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        aesCipher.init(Cipher.DECRYPT_MODE, privateKey);
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
     * Genera el par de claves, recibe la publica del servidor y envía su publica al servidor.
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
    private static void receiveAndSendPublicKeys(DataOutputStream dos, DataInputStream dis) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {

        // Recibir la clave pública del servidor
        int serverPublicKeyLength = dis.readInt();
        byte[] serverPublicKeyBytes = new byte[serverPublicKeyLength];
        dis.readFully(serverPublicKeyBytes);
        serverPublicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(serverPublicKeyBytes));

        // Enviar la clave pública al servidor
        byte[] publicKeyBytes = publicKey.getEncoded();
        System.out.println(publicKeyBytes);
        dos.writeInt(publicKeyBytes.length);
        dos.write(publicKeyBytes);
    }

    //Escribir en el archivo
    private static boolean write(String archivo, String texto, boolean sobreescribir) {
        File fichero = new File(PATH + "\\" + archivo + ".txt");
        StringBuilder escrito = new StringBuilder();


        if (!fichero.exists())
            try {
                if (fichero.createNewFile())
                    System.out.println("Se ha creado un nuevo archivo\n\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        else if (!sobreescribir) {
            escrito.append(read(archivo));
            escrito.append(texto);
        }


        try {
            escrito.append(texto);
            FileWriter fic = new FileWriter(fichero);
            char[] strc = escrito.toString().toCharArray();
            for (int i = 0; i < strc.length; i++) {
                fic.write(strc[i]);
            }
            fic.close();

        } catch (IOException i) {
            return false;
        }

        return true;
    }

    //Leer el archivo
    private static String read(String archivo) {
        File fichero = new File(PATH + "\\" + archivo + ".txt");
        StringBuilder texto = new StringBuilder();

        if (!fichero.exists())
            return "";

        try {
            FileReader fic = new FileReader(fichero);
            BufferedReader bf = new BufferedReader(fic);
            String linea;
            while ((linea = bf.readLine()) != null)
                texto.append(linea + "\n");
            fic.close();
        } catch (FileNotFoundException r) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return texto.toString();
    }


    //Coger los datos del archivo usuario
    private static boolean getUserData(String archivo, String user, String password) {
        File fichero = new File(PATH + "\\" + archivo + ".txt");
        try {
            FileReader fic = new FileReader(fichero);
            BufferedReader bf = new BufferedReader(fic);
            String linea;
            while ((linea = bf.readLine()) != null)
                if (linea.trim().split(" ")[0].equals("user") && linea.trim().split(" ")[1].equals(user)) {
                    while (true) {
                        String linea2 = bf.readLine();
                        String[] palabras = linea2.trim().split(" ");
                        if (palabras[0].equals("publicKey")) {
                            System.out.println();
                            byte[] publicKeyBytes = linea2.split(" ", 2)[1].getBytes();
                            System.out.println(new String(publicKeyBytes));
                            publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(publicKeyBytes));
                        }
                        if (palabras[0].equals("privateKey")) {
                            byte[] privateKeyBytes = Base64.getDecoder().decode(linea2.split(" ", 2)[1]);
                            privateKey = KeyFactory.getInstance("RSA").generatePrivate(new X509EncodedKeySpec(privateKeyBytes));
                        }
                        if (palabras[0].equals("pass")) {
                            if (Integer.parseInt(palabras[1]) == password.hashCode()) {
                                System.out.println("Autenticación completada");
                                return true;
                            } else {
                                System.out.println("No se puede autenticar el usuario");
                                return false;
                            }
                        }
                    }

                }
            fic.close();
        } catch (FileNotFoundException r) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    //Comprueba si el usuario existe
    private static boolean userExists(String archivo, String usuarioBuscar) {
        File fichero = new File(PATH + "\\" + archivo + ".txt");

        if (!fichero.exists())
            return false;

        try {
            FileReader fic = new FileReader(fichero);
            BufferedReader bf = new BufferedReader(fic);
            String linea;
            while ((linea = bf.readLine()) != null)
                if (linea.trim().split(" ")[0].equals("user") && linea.trim().split(" ")[1].equals(usuarioBuscar))
                    return true;
            fic.close();
        } catch (FileNotFoundException r) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
