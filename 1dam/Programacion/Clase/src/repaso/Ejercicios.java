package repaso;

import java.util.Scanner;

/**
 * @author Rodrigo🦖
 * @date 05 enero, 2024
 */
public class Ejercicios {
    int primeroSumarNumDel1Al200(int max) {
        int suma = 0;
        for (int i = 0; i <= max; i++) {
            suma += i;
        }
        return suma;
    }

    int sumImpares(int max) {
        int suma = 0;
        for (int i = 0; i <= max; i++) {
            if (i % 3 == 0 && i % 2 != 0)
                suma += i;
        }
        return suma;
    }

    int sumAcabadosEn0(int n1, int n2) {
        int suma = 0;
        for (int i = n1; i <= n2; i++) {
            if (i % 10 == 0)
                suma += i;
        }
        return suma;
    }

    void leerNum(Scanner sc) {
        System.out.print("Escriba el primer numero: ");
        int suma = sc.nextInt();
        int n;
        boolean terminar = false;
        do {
            System.out.print("Escriba un número: ");
            n = sc.nextInt();
            if (n < suma)
                suma += n;
        } while (n <= suma);
    }

    void sumaPares(int max) {
        int suma = 0;
        for (int i = 1; i <= max; i++) {
            for (int j = 1; j <= max; j++) {
                if (i + j == 34)
                    System.out.println(i + " " + j);
            }
        }
    }

    void cuadrado(Scanner sc) {
        System.out.println("Escribe un número");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    void cuadradoBidireccional(Scanner sc){
        System.out.println("Escribe un número");
        int n = sc.nextInt();
        for (int i = 1; i <= Math.ceil((double) n /2); i++) {
            for (int j = 1; j <= n; j++){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        for (int i = (n/2); i >= 1; i--) {
            for (int j = 1; j <= n; j++){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ejercicios ej = new Ejercicios();
        //System.out.println(ej.primeroSumarNumDel1Al200(200));
        //System.out.println(ej.sumImpares(100));
        //System.out.println(ej.sumAcabadosEn0(10, 50));
        //ej.leerNum(sc);
        //ej.sumaPares(100);
        //ej.cuadrado(sc);
        //ej.cuadradoBidireccional(sc);

    }
}
