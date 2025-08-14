package fexcepciones;

import java.util.Scanner;

/**
 * @author Rodrigo🦖
 * @date 29 enero, 2024
 */
public class F1dni {
    char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    Exception letraException = new Exception("Esa letra no es válida, no se encuentra entre las letras admitidas para el DNI");
    Exception caracterException = new Exception("Esa letra no corresponde con el numero del dni");

    boolean comprobarLetra(String dni) throws Exception {
        boolean correcto = false;
        char letra = 0;

        for (int i = 0; i < letras.length; i++) {
            if (letras[i] == dni.charAt(8)) {
                letra = letras[i];
            }
        }
        if (letra == 0) {
            throw letraException;
        }
        letra = letras[Integer.parseInt(dni.substring(0, 8)) % letras.length];


        if (letra == dni.charAt(8)) {
            System.out.println("El Dni " + dni + " es correcto ya que el resto de los números corresponde con " + letra);
            correcto = true;
        } else throw caracterException;
        return correcto;
    }

    public static void main(String[] args) throws Exception {
        F1dni ej = new F1dni();
        Scanner sc = new Scanner(System.in);
        String dni;
        boolean correcto = false;
        do {
            System.out.print("Escribe un DNI: ");
            dni = sc.nextLine();
            try {
                correcto = ej.comprobarLetra(dni);
            } catch (StringIndexOutOfBoundsException r) {
                System.out.println("Formato incorrecto, un dni tiene 8 numeros y 1 letra");
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!correcto);


    }
}
