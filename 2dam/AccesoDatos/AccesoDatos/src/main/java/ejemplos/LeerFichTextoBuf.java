package ejemplos;

import java.io.*;

/**
 * @author Rodrigo
 * @date 17 septiembre, 2024
 */
public class LeerFichTextoBuf {
    private static final String PATH = ".\\src\\main\\resources";



    public static void main(String[] args) {
        File fichero = new File(PATH + "\\NUEVODIR\\fichero1.txt");

        try {
            FileReader fic = new FileReader(fichero);
            BufferedReader bf = new BufferedReader(fic);
            String linea;
            while ((linea = bf.readLine()) != null)
                System.out.println(linea);
            fic.close();

        } catch (FileNotFoundException r) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
