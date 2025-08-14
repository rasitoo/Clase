package ejercicios.aaejer;

import java.io.File;
import java.io.IOException;

/**
 * @author Rodrigo
 * @date 18 septiembre, 2024
 */
public class Ejer2 {
    private static final String PATH = ".\\src\\main\\resources\\direcprueba";

    public static void main(String[] args) {
        File directorio = new File(PATH, "nuevo_dir");
        File fichero;

        System.out.println("Directorio de " + PATH);
        try {


            for (int i = 1; i <= 5; i++) {
                String nombre = "ARCHIVO" + i + ".txt";
                fichero = new File(PATH, nombre);
                fichero.createNewFile();
                if (fichero.isFile())
                    System.out.println(nombre + " es un archivo");
            }
            fichero = new File(PATH, "fich_nuevo.txt");
            fichero.createNewFile();
            if (fichero.isFile())
                System.out.println("fich_nuevo.txt" + " es un archivo");

        } catch (IOException e) {
        }
        if (directorio.mkdirs())
            System.out.println("Directorio creado dentro de " + PATH);
        if (directorio.isDirectory())
            System.out.println(PATH + " es un directorio");


    }

}
