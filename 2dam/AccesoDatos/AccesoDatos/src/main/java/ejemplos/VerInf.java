package ejemplos;

import java.io.File;

/**
 * @author Rodrigo
 * @date 17 septiembre, 2024
 */
public class VerInf {
    private static final String PATH = ".\\src\\main\\java";

    public static void main(String[] args) {
        System.out.println("Información sobre el fichero:");
        File f = new File(PATH);
        if (!f.exists()) {
            System.out.println(PATH + " no existe.");
            return;
        } else {
            System.out.println("Nombre del fichero: " + f.getName());
            System.out.println("Ruta              : " + f.getPath());
            System.out.println("Ruta absoluta     : " + f.getAbsolutePath());
            System.out.println("Se puede leer     : " + f.canRead());
            System.out.println("Se puede escribir : " + f.canWrite());
            System.out.println("Tamaño            : " + f.length());


        }
        if (f.isDirectory()) {
            System.out.println("Es un directorio");
        } else {
            System.out.println("No es un directorio");
        }
    }
}
