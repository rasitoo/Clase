package eecadenas;

import aexpresionesbooleanas.Teclado;

import java.io.IOException;

/**
 * @author Rodrigo🦖
 * @date 23 enero, 2024
 */
public class E6Cesar {

    String cifrado2(Teclado sc) throws IOException {
        StringBuilder s = null;
        int con;
        int pos;
        System.out.print("Escribe la frase que quieras cifrar: ");
        s = new StringBuilder(sc.leerString().toLowerCase());
        System.out.print("Escribe la contraseña: ");
        con = sc.leerInt() % 26; //no tengo en cuenta la ñ, tendria que hacer un array con el abecedario español (que pereza)

        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                pos = 'a' + (s.charAt(i) - 'a' + con) % 26; // el nuevo caracter será la posicion del caracter anterior, relativo a la a + la contraseña con la que encriptamos, dividimos entre 26 para no pasar de la z y ya está.
                s.setCharAt(i, (char) pos);
            }
        }

        return s.toString();
    }

    String descifrado2(Teclado sc) throws IOException {
        StringBuilder s = null;
        int con;
        int pos;
        System.out.print("Escribe la frase que quieras descifrar: ");
        s = new StringBuilder(sc.leerString().toLowerCase());
        System.out.print("Escribe la contraseña: ");
        con = (sc.leerInt() % 26) * -1; //no tengo en cuenta la ñ

        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                pos = 'z' + ((s.charAt(i) - 'z' + con) % 26); // el nuevo caracter será la posicion del caracter anterior, relativo a la a + la contraseña con la que encriptamos, dividimos entre 26 para no pasar de la z y ya está.
                s.setCharAt(i, (char) pos);
            }
        }

        return s.toString();
    }

    public static void main(String[] args) throws IOException {
        E6Cesar ej = new E6Cesar();
        Teclado sc = new Teclado();

        System.out.println(ej.cifrado2(sc));
        System.out.println(ej.descifrado2(sc));
    }
}
