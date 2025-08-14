package ExpresionesBooleanas;

import java.util.Scanner;

public class ExpresionesyConversiones {

    public static void main(String[]args){
        int a = 15;
        int b = 2;
        double c=(double)a/b;
        a=(int)c;
        System.out.println(c);
        System.out.println(a);

        a=(int)7.9;
        System.out.println(a);

        a= (int)Math.round(c);
        System.out.println(a);

        System.out.println(Math.round(3.5));

        a=15/2 * 8;
        System.out.println(a);

        Scanner sc= new Scanner(System.in);

        System.out.println("Dar un número:");
        a=sc.nextInt();
        System.out.println(a);

        System.out.println("Dar un nombre");
        String nombre = sc.nextLine();
        System.out.println("nombre introducido: " + nombre);
        System.out.println("FIN");

        int x = 3;
        int y = 4;
        int xant = x;
        x = y;
        y = xant;
        System.out.println(x + ":" + y);
    }
}
