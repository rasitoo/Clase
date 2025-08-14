package ejemplos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Rodrigo
 * @date 17 septiembre, 2024
 */
public class EscribirFichTextoPrint {
    private static final String PATH = ".\\src\\main\\resources\\NUEVODIR";

    public static void main(String[] args) {
        File fichero = new File(PATH + "\\Fich.txt");
        try {
            FileWriter fic = new FileWriter(fichero);
            PrintWriter pw = new PrintWriter(fichero);
            for (int i = 1; i < 11; i++)
                pw.println("Fila número: " + i);
            fic.close();

        } catch (IOException i) {

        }
    }
}
