package Ejemif;

import java.util.Scanner;

public class ejer1if {
    static void sumarSiTerminaEn0() {
        Scanner sc = new Scanner(System.in);
        System.out.println("dar número entero:");
        int x = sc.nextInt();

        if (x % 10 == 0) {
            System.out.println("dar otro número entero:");
            int y = sc.nextInt();
            System.out.println("La suma de los números es: " + (x + y));
        } else System.out.println(x + " no termina en 0");
    }

    public static void main(String[] args) {
        sumarSiTerminaEn0();
    }
}
