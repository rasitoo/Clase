package ejercicios.abinarios.binarios2;

import java.io.*;

/**
 * @author Rodrigo
 * @date 09 octubre, 2024
 */
public class Main {
    private static final String PATH = ".\\src\\main\\resources\\Bin2.txt";

    public static void main(String[] args) {
        Libro libro;
        File origen = new File(PATH);
        try {
            if (!origen.exists())
                origen.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File destino = new File(PATH);

        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(origen)); DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(destino, true))) {
            libro = new Libro(1234565, "Rimas y Leyendas", "Gustavo Adolfo Becker");
            libro.grabar(outputStream);

            while (inputStream.available() > 0)
                System.out.println(libro.leer(inputStream));

            outputStream.close();
            inputStream.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
