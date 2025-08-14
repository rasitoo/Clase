package ejemiterativas;

import java.util.Scanner;

public class C4mostrarPrimos {
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
    static void mostrarprimos (int n){
        int cont = 2;
        while (cont <= n){
            if (esPrimo(cont))
                System.out.print(cont + ", ");
            cont++;
        }

}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("numero: ");
        int n = sc.nextInt();

        mostrarprimos(n);
    }
}
