package ejercicios.aaejer;

import java.io.*;

/**
 * @author Rodrigo
 * @date 17 septiembre, 2024
 */
public class Ejer4 {
    private static final String PATH = ".\\src\\main\\resources";
    File fichero = null;
    FileReader fic = null;
    BufferedReader bf = null;

    public void leerLineas(){
        fichero = new File(PATH + "\\ejem.txt");

        try {
            fic = new FileReader(fichero);
            bf = new BufferedReader(fic);
            String linea;
            while ((linea = bf.readLine()) != null)
                System.out.println(linea);
            fic.close();

        } catch (FileNotFoundException r) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        Ejer4 ej = new Ejer4();
        ej.leerLineas();

    }
}
