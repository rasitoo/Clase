package ejemplos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Rodrigo
 * @date 17 septiembre, 2024
 */
public class LeeFichTexto {
    private static final String PATH = ".\\src\\main\\resources";

    public static void main(String[] args) {
        File fichero = new File(PATH + "\\NUEVODIR\\fichero1.txt");

        try {
            FileReader fic = new FileReader(fichero);
            int i;
            while ((i = fic.read()) != -1)
                System.out.print((char) i);
            fic.close();

        } catch (FileNotFoundException r) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
