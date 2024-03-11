package aejemif;

import java.util.Scanner;

public class ifs {

    static void ejifs(){
        Scanner sc = new Scanner(System.in);
        System.out.println("dar número entero:");
        int x = sc.nextInt();

        if (x % 5 == 0){
            System.out.println(x +" es multiplo de 5");
        }
        else if (x % 3 == 0) {
            System.out.println(x + " no es multiplo de 5, pero si de 3");
        }
        else System.out.println(x +" no es multiplo de 5 ni de 3");
    }
    static void mostrarParyMenorMayor(){
        Scanner sc= new Scanner (System.in);

        System.out.println("dar número 1:");

        int n1= sc.nextInt();

        System.out.println("dar número 2:");

        int n2= sc.nextInt();

       int mayor = Math.max(n1, n2);
       int menor = Math.min(n1, n2);

        if (n1%2 == 0 && n2% 2 == 0)
            System.out.println("Son pares y el mayor es: " + mayor);
        else System.out.println("No son pares y el menor es: " + menor);
    }
    public static void main(String[] args){

        mostrarParyMenorMayor();
    }
}
