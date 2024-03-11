package aejemiterativas;

import java.util.Scanner;

public class EjemWhile1 {
    static void tablamultiplicar(int num){
        int cont = 1;
        while (cont <=10) {
            System.out.println(num + " * " + cont + " = " + num * cont);
            cont++;
        }
    }
    static void sumar (int n){
        int suma=0;
        int cont=1;
        int sumaant = 0;

        while (cont<=10){
            suma += n;
            System.out.println("La suma de " + sumaant +  " + " + n + " es: " + suma);
            sumaant +=n;
            cont++;
        }

    }
    static void pedirHasta3Multiplosde2(){
        Scanner sc = new Scanner(System.in);
        int cont = 0;
        while (cont<3){
            System.out.println("dar número: ");
            if (sc.nextInt() % 2 ==0)
                cont++;
        }
        System.out.println("Ya has dado 3 multiplos de 2");
    }
    static void pedirHastaxMultiplosde2(int x) {
        Scanner sc = new Scanner(System.in);
        int cont = 0;
        while (cont < x) {
            System.out.println("dar número: ");
            if (sc.nextInt() % 2 == 0)
                cont++;
        }
        System.out.println("Ya has dado "+ x +" multiplos de 2");
    }
    static boolean esPrimo (int n){
        boolean esPrimo = true;
        int cont =2;
        int resto;
        while (esPrimo && cont<n){
            resto = n%cont;
            if (resto == 0)
                esPrimo=false;
            cont++;
        }
        return esPrimo;
    }

    public static void main(String[] args) {
        //tablamultiplicar(123);
        //sumar(7);
        //pedirHasta3Multiplosde2();
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Establece la cantidad de multiplos de 2 del programa");
        pedirHastaxMultiplosde2(sc.nextInt()); */
        System.out.println(esPrimo(1));

    }
}
