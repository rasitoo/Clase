package ecadenas;

import expresionesbooleanas.Teclado;

import java.io.IOException;

/**
 * @author Rodrigo🦖
 * @date 26 enero, 2024
 */
public class E8SumarNumeros {

    int sumaDigitos(Teclado sc) throws IOException {
        int suma = 0;
        String s = null;
        String[] sAr;
        System.out.print("Escribe una frase con números: ");
        s = sc.leerString();
        sAr = s.split(" ");

        for (int i = 0; i<sAr.length; i++){
            if (Character.isDigit(sAr[i].charAt(0))){
                suma += Integer.parseInt(sAr[i]);
            }
        }
        return suma;
    }

    public static void main(String[] args) throws IOException {
        E8SumarNumeros ej = new E8SumarNumeros();
        Teclado sc = new Teclado();

        System.out.println(ej.sumaDigitos(sc));

    }
}
