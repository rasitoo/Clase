package ejercicios.aaejer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Rodrigo
 * @date 17 septiembre, 2024
 */
public class Ejer6 {
    private static final String PATH = ".\\src\\main\\resources";
    String[] lineas = { "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis",
            "Siete", "..." };

    private void escribirLineas(){
        File fichero = new File(PATH + "\\ejer6.txt");
        try {
            FileWriter fic = new FileWriter(fichero);
            char[] strc;
            for (int i = 0; i < lineas.length; i++) {
                strc = lineas[i].toCharArray();
                for (int j = 0; j < strc.length; j++)
                    fic.write(strc[j]);
                fic.write("\n");
            }
            fic.close();

        } catch (IOException i) {

        }
    }

    public static void main(String[] args) {
        Ejer6 ej = new Ejer6();
        ej.escribirLineas();
    }
}
