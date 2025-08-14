

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SumaEntreValores {

    //método que recibe una List<Integer> , una posición inicial y una final y suma los valores que están
    //entre la posición inicial y la final, ambos incluidos
    public static int sumaEnRango(List<Integer> numeros, int min, int max) throws IllegalArgumentException {
        if (numeros == null) {
            throw new IllegalArgumentException("El ArrayList no puede ser null");
        }
        int suma = 0;
        if (min > numeros.size())
            return Integer.MIN_VALUE;
        if (max >= numeros.size())
            max = numeros.size() - 1;
        for (int i = min; i <= max; i++)
            suma += numeros.get(i);
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
    @Test
    public void testSumaEntreValores() {
        //Test camino 1 para una lista nula
        ArrayList<Integer> listaNula = null;
        assertThrows(IllegalArgumentException.class, () -> sumaEnRango(listaNula, 1, 7));

        int resultado;
        int min = 30;
        int max = 3;
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        listaNumeros.add(1);
        listaNumeros.add(5);
        listaNumeros.add(10);
        listaNumeros.add(15);
        listaNumeros.add(20);

        //Test camino 2 para valor min incorrecto
        resultado = sumaEnRango(listaNumeros, min, max);
        assertEquals(Integer.MIN_VALUE, resultado);
        //Test camino 3 para valores correctos
        resultado = sumaEnRango(listaNumeros, 1, max);
        assertEquals(30, resultado);
        max = 30;
        resultado = sumaEnRango(listaNumeros, 1, max);
        assertEquals(50, resultado);
    }
    @Test

    public void cajaNegra(){
        int resultado;
        int min = 30;
        int max = 3;
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        listaNumeros.add(1);
        listaNumeros.add(5);
        listaNumeros.add(10);
        listaNumeros.add(15);
        listaNumeros.add(20);

        //Test 1 para valor min negativo
        resultado = sumaEnRango(listaNumeros, -1, max);
        assertEquals(51, resultado);
        //Test 2 para valor min = 0
        resultado = sumaEnRango(listaNumeros, 0, max);
        assertEquals(51, resultado);
        //Test 3 para valor max= size
        max = listaNumeros.size();
        resultado = sumaEnRango(listaNumeros, 1, max);
        assertEquals(50, resultado);
        //Test 4 para valor max = size-1
        max = listaNumeros.size() -1;
        resultado = sumaEnRango(listaNumeros, 1, max);
        assertEquals(30, resultado);


    }

}
