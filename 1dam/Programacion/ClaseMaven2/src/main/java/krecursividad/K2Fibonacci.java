package krecursividad;

import java.io.IOException;

/**
 * @author Rodrigo
 * @date 30 abril, 2024
 */
public class K2Fibonacci {
    int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    public static void main(String arg[]) throws IOException {
        K2Fibonacci f = new K2Fibonacci();
        Teclado t = new Teclado();
        int n;
        System.out.println("Dar un número: ");
        n = t.leerInt();
        System.out.println(f.fibonacci(n));
    }
}
