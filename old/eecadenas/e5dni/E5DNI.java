package eecadenas.e5dni;

import java.util.Scanner;

import static java.lang.Integer.valueOf;

/**
 * @author Rodrigo🦖
 * @date 22 enero, 2024
 */
public class E5DNI {
    char[] letras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};

    void comprobarLetra(String dni){
        char letra;

        letra = letras[Integer.parseInt(dni.substring(0,8)) % letras.length];
        if (letra == dni.charAt(8)){
            System.out.println("El Dni " + dni + " es correcto ya que el resto de los números corresponde con " + letra);
        }
        else System.out.println("El Dni " + dni + " es incorrecto ya que el resto de los números corresponde con " + letra);

    }

    public static void main(String[] args) {
        E5DNI ej = new E5DNI();
        Scanner sc = new Scanner(System.in);

        System.out.print("Escribe un DNI: ");
        String dni = sc.nextLine();
        ej.comprobarLetra(dni);

    }
}
