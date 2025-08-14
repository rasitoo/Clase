package ejercicios.aaejer;

import java.io.*;

/**
 * @author Rodrigo
 * @date 17 septiembre, 2024
 */
public class Ejer5 {
    private static final String PATH = ".\\src\\main\\resources";
    File fichero = null;
    FileReader fic = null;
    BufferedReader bf = null;

    public void leerLineasPares(){
        fichero = new File(PATH + "\\ejem.txt");
        int cont = 0;

        try {
            fic = new FileReader(fichero);
            bf = new BufferedReader(fic);
            String linea;
            while ((linea = bf.readLine()) != null)
                if (cont++ %2 == 0 )
                    System.out.println(linea);
            fic.close();

        } catch (FileNotFoundException r) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        Ejer5 ej = new Ejer5();
        ej.leerLineasPares();

    }
}
