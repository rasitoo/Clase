

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;



public class SumaEntreValores {
    private static final Logger miLogEnFich = LogManager.getLogger("ClasePrincipal");
    private static final Logger miLogError= LogManager.getLogger("ERROR");
//    public static void main(String[] args) {
//        System.out.println("hola 1");
//        miLogEnFich.info("Errores informativo  de clase principal");
//        miLogEnFich.error("Errores grave de clase principal");
//        miLogConsola.error("Error grave en consola");
//        System.out.println("hola 2");
//        try {
//            throw new Exception("Excepción de jmpl");
//        } catch (Exception e) {
//            miLogEnFich.error(e.getMessage());
//        }
//        System.out.println("hola 3");
//    }

    //método que recibe una List<Integer> , una posición inicial y una final y suma los valores que están
    //entre la posición inicial y la final, ambos incluidos
    public static int sumaEnRango(List<Integer> numeros, int min, int max) throws IllegalArgumentException {
        if (numeros == null) {
            miLogError.warn("El arraylist no puede ser null");
            throw new IllegalArgumentException("El ArrayList no puede ser null");
        }
        int suma = 0;
        if (min > numeros.size())
            return Integer.MIN_VALUE;
        if (max >= numeros.size())
            max = numeros.size() - 1;
        for (int i = min; i <= max; i++) {
            suma += numeros.get(i);
            miLogEnFich.info("SUMA, posicion: " + i + " número: " + numeros.get(i));
        }
        return suma;
    }

    public static void main(String[] args) {
        try {
            ArrayList<Integer> listaNumeros = new ArrayList<>();
            listaNumeros.add(1);
            listaNumeros.add(5);
            listaNumeros.add(10);
            listaNumeros.add(15);
            listaNumeros.add(20);

            int min = 1;
            int max = 3;
            int resultado = sumaEnRango(listaNumeros, min, max);
            System.out.println("La suma de los números entre " + min + " y " + max + " es: " + resultado);

            resultado = sumaEnRango(listaNumeros, 5, 5);
            System.out.println("La suma de los números entre " + 5 + " y " + 5 + " es: " + resultado);
            // Ejemplo con un ArrayList null para mostrar la excepción
            ArrayList<Integer> listaNula = null;
            sumaEnRango(listaNula, min, max);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
