package ejercicios.simulacro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Rodrigo
 * @date 04 noviembre, 2024
 */

public class Utilidades {

    public static int contarPalabras(String linea) {
        if (linea == null || linea.isEmpty()) {
            return 0;
        }
        String[] palabras = linea.trim().split("\\s+"); //\\s+ sirve para uno o mas espacios consecutivos
        return palabras.length;
    }

    public static void contarLineas(String nombreFichero) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            int numeroLinea = 1;
            int lineasPares = 0;
            int lineasImpares = 0;
            int lineasMasDeCincoPalabras = 0;

            while ((linea = br.readLine()) != null) {
                int numPalabras = contarPalabras(linea);

                if (numeroLinea % 2 == 0) {
                    lineasPares++;
                } else {
                    lineasImpares++;
                }

                if (numPalabras > 5) {
                    lineasMasDeCincoPalabras++;
                }

                numeroLinea++;
            }

            System.out.println("Número de líneas pares: " + lineasPares);
            System.out.println("Número de líneas impares: " + lineasImpares);
            System.out.println("Número de líneas con más de 5 palabras: " + lineasMasDeCincoPalabras);
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
            throw e;
        }
    }
}
