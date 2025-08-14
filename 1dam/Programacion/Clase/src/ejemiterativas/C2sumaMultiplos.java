package ejemiterativas;

import java.util.Scanner;

public class C2sumaMultiplos {
    static void sumaentremultiplos(){
        int suma = 0;
        int contador = 1;

        Scanner sc = new Scanner(System.in);
        System.out.println("n1: ");
        int n1mayor = sc.nextInt();

        while (contador <= n1mayor){
            if (contador % 3 == 0 || contador % 5 == 0)
                suma += contador;
            contador++;
        }
        System.out.println("la suma de todos los numeros entre " + 1 + " y " + n1mayor + " es: " + suma);
    }

    public static void main(String[] args) {
        sumaentremultiplos();
    }
}
