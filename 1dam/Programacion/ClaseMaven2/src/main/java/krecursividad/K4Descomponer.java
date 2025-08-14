package krecursividad;

/**
 * @author Rodrigo
 * @date 13 mayo, 2024
 */
public class K4Descomponer {
    /**
     * Descompone un número en un string que contiene la suma de diferentes digitos que resultan en el número introducido.
     * Al ejecutarse el programa primero comprueba si el número ya se ha descompuesto (n == 0), si ya se ha descompuesto lo imprime.
     * Si el número no se ha descompuesto entonces inicia un bucle desde inicio (1) hasta el número a descomponer(5), en cada iteración el número a descomponer se reduce (se le quita lo que ya se ha descompuesto).
     * El número se terminará de descomponer en cualquiera de los programas ejecutados, no solo en el primero, dependiendo de en cual termine el valor de i del bucle será diferente, esto hace que inicie en diferentes valores y de esta forma da todas las combinaciones posibles
     *
     *
     * @param n      El número que se descompone
     * @param s      El String que será mostrado, contiene el número y su descomposición
     * @param inicio El número con el que inicia la descomposición, normalmente 1, este parámetro es necesario para que la recursividad avance
     */


    public static void descomponer(int n, String s, int inicio) {
        if (n == 0) {
            System.out.println(s); // numero ya descompuesto
        } else {
            for (int i = inicio; i <= n; i++) {
                descomponer(n - i, s + " + " + i, i); //recursividad
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        descomponer(n, n + "= ", 1);
    }
}
