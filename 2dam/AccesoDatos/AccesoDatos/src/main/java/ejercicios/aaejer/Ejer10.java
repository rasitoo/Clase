package ejercicios.aaejer;

import java.io.*;
import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 01 octubre, 2024
 */
public class Ejer10 {
    private static final String PATH = ".\\src\\main\\resources";
    String linea;
    int cont = 0;
    boolean encontrado = false;

    public String pedirPalabra() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la palabra a buscar:");
        return sc.nextLine();
    }


    public static void main(String[] args) {
        File origen = new File(PATH, "\\ejer10.txt");
        Ejer10 ej = new Ejer10();

        if (!origen.exists()) {
            if (!origen.canRead())
                System.err.println("el fichero no puede leerse");
            System.err.println("el fichero no existe");
        }

        ej.buscar(origen, ej.pedirPalabra());
    }

    private void buscar(File origen , String palabra) {
        try (BufferedReader bf = new BufferedReader(new FileReader(origen))) {
            while ((linea = bf.readLine()) != null) {
                cont ++;
                for (int i = 0; i < linea.length(); i++) {
                    if (linea.toCharArray()[i] == palabra.toCharArray()[0] && linea.substring(i,i + palabra.length()).equals(palabra)){
                        encontrado = true;
                        System.out.println("Nombre del Fichero: " + origen.getAbsolutePath());
                        System.out.println("Línea: " + linea);
                        System.out.println("Nº Línea: " + cont);
                        System.out.println("Posición: " + i + " a " + (i + palabra.length()));
                        System.out.println();
                    }
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (!encontrado)
            System.out.println("No se ha podido encontrar la linea introducida");

    }
}

