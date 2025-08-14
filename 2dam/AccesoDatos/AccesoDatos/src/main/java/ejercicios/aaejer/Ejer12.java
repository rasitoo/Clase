package ejercicios.aaejer;

import java.io.File;

/**
 * @author Rodrigo
 * @date 01 octubre, 2024
 */
public class Ejer12 {
    private static final String PATH = ".";
    boolean encontrado = false;


    private boolean buscarDirectorio(File path, String busqueda) {
        String[] directorios = null;

        if (path.equals(new File(PATH))) { //Si se busca en el directorio actual directamente se hace la lista
            directorios = path.list();
            for (int j = 0; j < directorios.length; j++) {
                File directorioo = new File(PATH, directorios[j]);
                System.out.println("\t Nombre: " + directorios[j] + "\tes fichero: " + directorioo.isFile() + "\tes directorio: " + directorioo.isDirectory());
            }
        } else if (path.isDirectory()) { //Si es un directorio miramos lo que contiene
            File[] archivos = path.listFiles();
            if (archivos != null) { // Si contiene algo se mira uno a uno
                for (int i = 0; i < archivos.length; i++) {
                    File archivo = archivos[i];
                    if (!archivo.isFile()) { // si es un directorio se comprueba que es el que buscamos, si no entramos y hacemos recursividad
                        if (archivo.getName().equals(busqueda)) {
                            directorios = archivo.list();
                            System.out.println(archivo.getAbsolutePath() + " tiene " + directorios.length + " ficheros:");

                            for (int j = 0; j < directorios.length; j++) {
                                File directorioo = new File(archivo, directorios[j]);
                                System.out.println("\t Nombre: " + directorios[j] + "\tes fichero: " + directorioo.isFile() + "\tes directorio: " + directorioo.isDirectory());
                            }
                            return encontrado = true;
                        } else {
                            buscarDirectorio(archivo, busqueda);
                        }
                    }
                }
            }
        }
        return encontrado;
    }


    public static void main(String[] args) {
        Ejer12 ej = new Ejer12();
        String directorio;
        if (args.length == 0) {
            directorio = PATH;
            ej.buscarDirectorio(new File(PATH), directorio);
        } else
            for (int j = 0; j < args.length; j++) {
                directorio = args[j];
                if (args[j].isEmpty())
                    directorio = PATH;

                for (int i = 0; i < File.listRoots().length; i++) {
                    ej.encontrado = false;
                    if (!ej.buscarDirectorio(File.listRoots()[i], directorio))
                        System.out.println("No se ha podido encontrar el directorio " + directorio + " en: " + File.listRoots()[i]);
                }
            }


    }
}

