package ejemiterativas;

import java.util.Scanner;

public class C1suma {
    static void sumaentrenumeros(){
        int suma = 0;
        int contador;

        Scanner sc = new Scanner(System.in);
        System.out.println("n1: ");
        int n1mayor = sc.nextInt();
        System.out.println("n2: ");
        int n2menor = sc.nextInt();

        if (n2menor > n1mayor){
            int naux = n1mayor;
            n1mayor = n2menor;
            n2menor = naux;
        }
        contador = n2menor;
        while (contador <= n1mayor){
            suma += contador;
            contador++;
        }
        System.out.println("la suma de todos los numeros entre " + n2menor + " y " + n1mayor + " es: " + suma);
    }

    public static void main(String[] args) {
        sumaentrenumeros();
    }
}
