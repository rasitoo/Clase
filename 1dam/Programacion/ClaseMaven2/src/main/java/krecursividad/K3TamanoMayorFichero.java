package krecursividad;

import java.io.File;

/**
 * @author Rodrigo
 * @date 07 mayo, 2024
 */
public class K3TamanoMayorFichero {

    public static void main(String[] args) {
        File directorio = new File("C:\\Program Files (x86)");
        File archivoMayor = buscarArchivoMayor(directorio);
        System.out.println("El archivo más grande es: " + archivoMayor.getAbsolutePath());
    }

    public static File buscarArchivoMayor(File directorio) {
        File archivoMayor = null;
        long tamañoMayor = 0;

        if (directorio.isDirectory()) {
            File[] archivos = directorio.listFiles(); //Si es un directorio miramos todos los archivos que tiene
            if (archivos!= null) {
                for (int i= 0; i< archivos.length; i++) {
                    File archivo= archivos[i]; // Si tiene archivos miramos cada uno de ellos
                    if (archivo.isFile()) { //Si es un archivo comparamos su tamaño
                        if (archivo.length()> tamañoMayor) {
                            tamañoMayor= archivo.length();
                            archivoMayor= archivo;
                        }
                    } else if (archivo.isDirectory()) { // Si es un directorio se hace la recursividad
                        File archivoMayorSubdirectorio= buscarArchivoMayor(archivo);
                        if (archivoMayorSubdirectorio!= null && archivoMayorSubdirectorio.length() > tamañoMayor) {
                            tamañoMayor= archivoMayorSubdirectorio.length(); //Si los subprocesos han encontrado un archivo mayor se pasa la informacion a este proceso superior
                            archivoMayor= archivoMayorSubdirectorio;
                        }
                    }
                }
            }
        }

        return archivoMayor;
    }
}
