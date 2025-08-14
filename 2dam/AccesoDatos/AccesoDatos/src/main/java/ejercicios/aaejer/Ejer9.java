package ejercicios.aaejer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Rodrigo
 * @date 25 septiembre, 2024
 */
public class Ejer9 {
    private static final String PATH = ".\\src\\main\\resources";

    char[] arraynum;


    public void copiar(File origen, File destino, File destinoImp) {
        arraynum = new char[(int) origen.length()];
        try {
            if (!origen.exists())
                origen.createNewFile();
            if (!destino.exists())
                destino.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileReader inputStream = new FileReader(origen); FileWriter outputStreamPar = new FileWriter(destino); FileWriter outputStreamImp = new FileWriter(destinoImp)) {

            for (int i = 1; i < origen.length(); i++)
                arraynum[i] = (char) inputStream.read();
            for (int i = 1; i < arraynum.length; i++) {
                if (arraynum[i] != (char) -1 && arraynum[i] != '\n'&& arraynum[i] != '\r') {
                    if (i % 2 == 0)
                        outputStreamPar.write(arraynum[i]);
                    else
                        outputStreamImp.write(arraynum[i]);
                }
            }
            outputStreamPar.write("FIN PARES");
            outputStreamImp.write("FIN IMPARES");


        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        Ejer9 ej = new Ejer9();

        File origen = new File(PATH, "\\ejer9entrada.txt");
        File destinoPar = new File(PATH, "\\ejer9par.txt");
        File destinoImp = new File(PATH, "\\ejer9imp.txt");

        ej.copiar(origen, destinoPar, destinoImp);

    }
}
