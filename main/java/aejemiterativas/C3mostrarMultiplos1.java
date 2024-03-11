package aejemiterativas;

import java.util.Scanner;

public class C3mostrarMultiplos1 {
    static boolean comprobarmultiplo2(int n){
        return n % 2 == 0;
        }
    static boolean comprobarmultiplo3(int n){
        return n % 3 == 0;
    }
    static boolean comprobarmultiplo5(int n){
        return n % 5 == 0;
    }
    static void mostrarmultiplos(int n1){
        int contador = 1;
        while (contador <= n1){
            if (comprobarmultiplo2(contador) || comprobarmultiplo3(contador) || comprobarmultiplo5(contador)){
                System.out.print(contador + " es múltiplo de: ");
                if (comprobarmultiplo2(contador)){
                    System.out.print("2");
                    if (comprobarmultiplo3(contador)){
                        System.out.print(", 3");
                        if (comprobarmultiplo5(contador))
                            System.out.print(", 5");
                    } else if (comprobarmultiplo5(contador)){
                    System.out.print(", 5");
                         if (comprobarmultiplo3(contador)) {
                             System.out.print(", 3");
                         }
                    }
                    System.out.println();
                }

                else if (comprobarmultiplo3(contador)) {
                    System.out.print("3");
                    if (comprobarmultiplo2(contador)){
                        System.out.print(", 2");
                        if (comprobarmultiplo5(contador))
                            System.out.print(", 5");
                    } else if (comprobarmultiplo5(contador)){
                        System.out.print(", 5");
                        if (comprobarmultiplo2(contador)) {
                            System.out.print(", 2");
                        }
                    }
                    System.out.println();
                }

                else if (comprobarmultiplo5(contador)) {
                    System.out.print("5");
                    if (comprobarmultiplo3(contador)){
                        System.out.print(", 3");
                        if (comprobarmultiplo2(contador))
                            System.out.print(", 2");
                    } else if (comprobarmultiplo2(contador)){
                        System.out.print(", 2");
                        if (comprobarmultiplo3(contador)) {
                            System.out.print(", 3");
                        }
                    }
                    System.out.println();
                }
            }
            contador++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("n1: ");
        int n1 = sc.nextInt();

        mostrarmultiplos(n1);
    }
}
