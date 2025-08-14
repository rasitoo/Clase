package krecursividad;

import java.io.IOException;

/**
 * @author Rodrigo
 * @date 30 abril, 2024
 */
public class K1LeerNum {
    int atrpos = 1;

    void procesarnums() throws IOException {
        Teclado t = new Teclado();
        int n, pos;

        System.out.println("Dar un número:");
        n = t.leerInt();
        pos = atrpos;
        atrpos++;
        if (n == 0) {
            System.out.println();
        } else if (n % 2 == 0) {
            procesarnums();
            System.out.println(n + " posicion: " + pos + "/" + (atrpos - 2));//-2 porque cuenta el 0 y empieza en 1
        } else {
            procesarnums();
        }

    }

    public static void main(String arg[]) throws IOException {
        K1LeerNum f = new K1LeerNum();
        f.procesarnums();
        System.out.println("Fin");
    }
}
