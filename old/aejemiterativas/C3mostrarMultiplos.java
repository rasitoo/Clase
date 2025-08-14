package aejemiterativas;

import java.util.Scanner;

public class C3mostrarMultiplos {
    static void mostrarMultiplos(int n1){
        int contador = 1;
        while (contador <= n1){
            if (contador % 2 == 0 || contador % 3 == 0 || contador % 5 == 0){
                System.out.println(contador + " es múltiplo de: 2, 3 o 5");
            }
            contador++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("n1: ");
        int n1 = sc.nextInt();

        mostrarMultiplos(n1);

    }
}
