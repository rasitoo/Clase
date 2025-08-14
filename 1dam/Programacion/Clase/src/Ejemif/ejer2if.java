package Ejemif;

import java.util.Scanner;

public class ejer2if {
    ejer2if() {
    }

    static void paresoImpares() {
        Scanner sc = new Scanner(System.in);
        System.out.println("dar número 1:");
        int n1 = sc.nextInt();
        System.out.println("dar número 2:");
        int n2 = sc.nextInt();

        if (n1 % 2 == 0 && n2 % 2 == 0)
            System.out.println("n1 es par y n2 es par");

        else if (n1 % 2 == 0)
            System.out.println("n1 es par y n2 es impar");

        else if (n2 % 2 == 0)
            System.out.println("n1 es impar y n2 es par");

        else
            System.out.println("n1 es impar y n2 es impar");

        System.out.println("FIN");

    }

    public static void main(String[] args) {
        paresoImpares();
    }
}
