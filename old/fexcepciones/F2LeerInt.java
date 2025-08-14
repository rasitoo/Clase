package fexcepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Rodrigo🦖
 * @date 30 enero, 2024
 */
public class F2LeerInt {
    int nVacio;
    int n;
    Exception numNoValidoException = new Exception("Solo admite numeros enteros");
    boolean leerInt(int n) throws Exception {
        boolean b = false;

        if (n == nVacio){
            throw numNoValidoException;
        }
        else b = true;

        return b;
    }

    public static void main(String[] args) throws Exception {
        F2LeerInt ej = new F2LeerInt();
        Scanner sc = new Scanner(System.in);

        boolean correcto = false;
        do {
            try {
                System.out.print("Introduce un número entero válido: ");
                ej.n = sc.nextInt();
                correcto = ej.leerInt(ej.n);
            }catch (InputMismatchException e){
                System.out.println("Solo se admiten numeros enteros");
            }
        }while (!correcto);
    }
}
