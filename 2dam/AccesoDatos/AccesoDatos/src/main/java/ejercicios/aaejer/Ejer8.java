package ejercicios.aaejer;

import java.io.*;

/**
 * @author Rodrigo
 * @date 25 septiembre, 2024
 */
public class Ejer8 {
    private static final String PATH = ".\\src\\main\\resources";

    char[] arraynum;


    public void copiar(File origen, File destino) {
        arraynum = new char[(int) origen.length()];
        try {
            if (!origen.exists())
                origen.createNewFile();
            if (!destino.exists())
                destino.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileReader inputStream = new FileReader(origen); FileWriter outputStream = new FileWriter(destino)) {

            for (int i = 0; i < origen.length(); i++)
                arraynum[i] = (char) inputStream.read();
            for (int i = 0; i < arraynum.length; i++) {
                if (arraynum[i] != (char) -1)
                    outputStream.write(arraynum[i]);
            }
            outputStream.write("FIN");

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        Ejer8 ej = new Ejer8();

        File origen = new File(PATH, "\\ejer8entrada.txt");
        File destino = new File(PATH, "\\ejer8copia.txt");
        ej.copiar(origen, destino);

    }
}
