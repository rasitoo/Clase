package gficheros;

import java.io.File;
import java.util.Scanner;

/**
 * @author Rodrigo🦖
 * @date 02 febrero, 2024
 */
public class G1DirTamaño {

    public static void main(String[] args) {
        File f1;
        String[] listaFicheros;
        long suma = 0;
        boolean terminado = false;

        Scanner sc = new Scanner(System.in);

        while (!terminado) {
            try {
                System.out.println("Introduce la dirección del directorio");
                String dir = sc.nextLine();
                listaFicheros = new File(dir).list();

                for (int i = 0; i < listaFicheros.length; i++) {
                    f1 = new File(dir, listaFicheros[i]);
                    suma += f1.length();
                    System.out.println("Nombre: " + listaFicheros[i] + "\t-> Tamaño:\t" + f1.length());
                }
                System.out.println("Suma total: " + suma);
                terminado = true;
            } catch (NullPointerException e) {
                System.out.println("dirección de directorio no válido");
            }
        }
    }
}
