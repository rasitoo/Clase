package ejercicios.aaejer;

import java.io.File;

/**
 * @author Rodrigo
 * @date 18 septiembre, 2024
 */
public class Ejer1 {
    private static final String PATH = ".";

    private void verInfo(String archivo) {
        System.out.println("Información sobre el fichero:");
        File f = new File(PATH, archivo);
        System.out.println("Nombre del fichero     : " + f.getName());
        System.out.println("Existe                 : " + f.exists());
        System.out.println("Permiso de escritura   : " + f.canWrite());
        System.out.println("Permiso de lectura     : " + f.canRead());
        System.out.println("Es directorio          : " + f.isDirectory());
        System.out.println("Es archivo             : " + f.isFile());
        System.out.println("Es absoluto            : " + f.isAbsolute());
        System.out.println();

    }
    private void listarInfo(){
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
                this.verInfo(archivos[i]);
            }
        }else {
            System.out.println(PATH + " no es un directorio");
        }
    }

    public static void main(String[] args) {
        Ejer1 ej = new Ejer1();

        ej.listarInfo();
    }
}
