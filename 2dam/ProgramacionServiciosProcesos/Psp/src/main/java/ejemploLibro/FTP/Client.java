package ejemploLibro.FTP;

import java.io.*;
import java.net.Socket;

/**
 * @author Rodrigo
 * @date 18 febrero, 2025
 */
public class Client {
    public static void FileReadExample() {
        String fileName = "example.txt";
        try (FileInputStream fis = new FileInputStream(fileName); BufferedInputStream bis = new BufferedInputStream(fis)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                System.out.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void FileWriteExample() {
        String fileName = "example.txt";
        String content = "Este es un ejemplo de escritura en un archivo.";

        try (FileOutputStream fos = new FileOutputStream(fileName); BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            byte[] bytes = content.getBytes();
            bos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        String host = "127.0.0.1";

        socket = new Socket(host, 4444);

        File file = new File("C:\\Users\\Rodrigo\\Downloads\\PSP\\PSP\\INDICE(OCR).pdf");
        // Get the size of the file
        long length = file.length();
        byte[] bytes = new byte[16 * 1024];
        InputStream in = new FileInputStream(file);
        OutputStream out = socket.getOutputStream();

        int count;
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }

        out.close();
        in.close();
        socket.close();
    }
}