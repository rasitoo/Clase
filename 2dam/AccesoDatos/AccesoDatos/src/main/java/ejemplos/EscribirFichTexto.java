package ejemplos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Rodrigo
 * @date 17 septiembre, 2024
 */
public class EscribirFichTexto {
    private static final String PATH = ".\\src\\main\\resources\\NUEVODIR";

    public static void main(String[] args) {
        File fichero = new File(PATH + "\\Fich.txt");
        try {
            FileWriter fic = new FileWriter(fichero);
            String str = "Paatata";
            char[] strc = str.toCharArray();
            for (int i = 0; i < strc.length; i++) {
                fic.write(strc[i]);
            }
            fic.append('*');
            fic.close();

        } catch (IOException i) {

        }
    }
}
