package ecadenas;

import expresionesbooleanas.Teclado;

import java.io.IOException;

/**
 * @author Rodrigo🦖
 * @date 26 enero, 2024
 */
public class E7SumarDigitos {

    int sumaDigitos(Teclado sc) throws IOException {
        int suma = 0;
        String s = null;
        System.out.print("Escribe una frase con números: ");
        s = sc.leerString();

        for (int i = 0; i<s.length(); i++){
            if (Character.isDigit(s.charAt(i))){
                suma += Integer.parseInt(String.valueOf(s.charAt(i)));
            }
        }
        return suma;
    }

    public static void main(String[] args) throws IOException {
        E7SumarDigitos ej = new E7SumarDigitos();
        Teclado sc = new Teclado();

        System.out.println(ej.sumaDigitos(sc));

    }
}
