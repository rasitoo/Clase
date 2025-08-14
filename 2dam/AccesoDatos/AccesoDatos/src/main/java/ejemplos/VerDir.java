package ejemplos;

import java.io.File;

/**
 * @author Rodrigo
 * @date 17 septiembre, 2024
 */
public class VerDir {
    private static final String PATH = ".\\src\\test\\java\\sdasg";

    public static void main(String[] args) {
        System.out.println("Ficheros en el directorio actual:\n");
        File f = new File(PATH);
        if (!f.exists()) {
            System.out.println(PATH + " no existe.");
            return;
        }
        else if (f.isDirectory()) {
            String[] archivos = f.list();
            if (archivos.length == 0) {
                System.out.println("No hay ficheros en el directorio especificado");
                return;
            }
            for (int i = 0; i < archivos.length; i++) {
                System.out.println(archivos[i]);
            }
        }else {
            System.out.println(PATH + " no es un directorio");
        }
    }
}
