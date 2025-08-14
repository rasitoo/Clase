package hexprlambda.ejemprofe;

import java.util.Random;

public class NumAleatorios {
    public static void main(String[] args) {
        Random numAleat= new Random(System.currentTimeMillis());
        for (int i=0; i<10; i++) {
            System.out.println((int)(numAleat.nextInt()%100));
        }
    }
}
