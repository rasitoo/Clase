package ecadenas;

import expresionesbooleanas.Teclado;

import java.io.IOException;
import java.util.Objects;

/**
 * @author Rodrigo🦖
 * @date 26 enero, 2024
 */
public class E9SepararMiles {

    String separarMiles1(String s) {
        java.lang.StringBuffer str = new java.lang.StringBuffer();
        int cont = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (cont == 3) {
                cont = 0;
                str.append('.');
            }
            str.append(s.charAt(i));
            cont++;
        }
        return str.reverse().toString();
    }

    String separarMiles2(int n) {
        java.lang.StringBuffer str = new java.lang.StringBuffer();
        int cont = 0;
        String s = String.valueOf(n);

        for (int i = s.length() - 1; i >= 0; i--) {
            if (cont == 3) {
                cont = 0;
                str.append('.');
            }
            str.append(s.charAt(i));
            cont++;
        }
        return str.reverse().toString();
    }

    String separarMiles3(String f) {
        java.lang.StringBuffer str = new java.lang.StringBuffer();
        int cont = 0;
        String[] sar;
        sar = f.trim().split("[ €]");
        java.lang.StringBuffer straux = null;

        for (int j = 0; j < sar.length; j++) {
            if (!Objects.equals(sar[j], "") && Character.isDigit(sar[j].charAt(0))) {
                straux = new java.lang.StringBuffer();
                for (int i = sar[j].length() - 1; i >= 0; i--) {
                    if (cont == 3) {
                        cont = 0;
                        straux.append('.');
                    }
                    straux.append(sar[j].charAt(i));
                    cont++;
                }
                str.append(" " + straux.reverse());
                cont = 0;
            } else if (Objects.equals(sar[j], "")) {
                str.append("€");
            } else str.append(" " + sar[j]);
        }
        return str.toString().trim();
    }

    public static void main(String[] args) throws IOException {
        E9SepararMiles ej = new E9SepararMiles();
        Teclado sc = new Teclado();

        System.out.print("Escribe un número (como String): ");
        String s = sc.leerString();
        System.out.println(ej.separarMiles1(s));

        System.out.print("Escribe un número (como int): ");
        int n = sc.leerInt();
        System.out.println(ej.separarMiles2(n));

        System.out.print("Escribe un número (frase): ");
        String f = sc.leerString();
        System.out.println(ej.separarMiles3(f));

    }
}
