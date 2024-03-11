package expresionesbooleanas;

public class ExpresionesBooleanas {
    public static void main(String[] args) {
        System.out.println("HOLA");
        int n=-1;

        boolean b= n<9 && n>5;
        System.out.println("n entre 5 y 9: " + b);

        b = n%2 == 0 && n>10;
        System.out.println("n es par y mayor de 10: " + b);

        b = n<0 && n%2 != 0;
        System.out.println("n es negativo y mayor de 10: " + b);

        int n1=8, n2=6;
        b= n1 % 2 ==0 && n2 % 2 == 0 && n1 < 10 && n2 < 10;
        System.out.println("el numero n1 y el número n2 son ambos pares y menores de 10: " + b);
    }
}
