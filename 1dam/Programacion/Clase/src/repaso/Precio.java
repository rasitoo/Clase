package repaso;

import java.util.Scanner;

/**
 * @author Rodrigo🦖
 * @date 05 enero, 2024
 */
public class Precio {
    int[] precios;
    int cont;

    Precio() {
        precios = new int[100];
        cont = 0;
    }

    void arrayPrecios(Scanner sc) {
        int n = -1;
        while (n != 0) {
            System.out.println("Indica el precio del articulo " + cont);
            n = sc.nextInt();
            if (n != 0) {
                precios[cont] = n;
                cont++;
            }
        }
    }

    int masCaro() {
        int producto = -1;
        int precio = 0;

        for (int i = 0; i < cont; i++) {
            if (precios[i] > precio) {
                producto = i;
                precio = precios[i];
            }
        }
        return producto;
    }

    int masBarato() {
        int producto = -1;
        int precio = Integer.MAX_VALUE;

        for (int i = 0; i < cont; i++) {
            if (precios[i] < precio) {
                producto = i;
                precio = precios[i];
            }
        }
        return producto;
    }

    int sumaPrecios(){
        int suma = 0;
        for (int i = 0; i < cont; i++){
            suma += precios[i];
        }
        return suma;
    }
    void menu(Scanner sc) {
        int n = -1;
        while (n != 0) {
            System.out.println("1. anadir precio");
            System.out.println("2. producto mas caro");
            System.out.println("3. Producto mas barato");
            System.out.println("4. Suma de precios");
            System.out.println("0. FIN");

            n = sc.nextInt();
            switch (n) {
                case 1:
                    arrayPrecios(sc);
                    break;
                case 2:
                    int producto = this.masCaro();
                    if (producto == -1)
                        System.out.println("ERROR");
                    else
                        System.out.println("El producto mas caro es el " + producto + " con un precio de " + precios[producto] + "€");
                    break;
                case 3:
                    int producto1 = this.masBarato();
                    if (producto1 == -1)
                        System.out.println("ERROR");
                    else
                        System.out.println("El producto mas barato es el " + producto1 + " con un precio de " + precios[producto1] + "€");
                    break;
                case 4:
                    System.out.println("La suma de todos los precios es: " + sumaPrecios());
                case 0:
                    System.out.println("FIN");
            }
        }
    }

    public static void main(String[] args) {
        Precio ej = new Precio();
        Scanner sc = new Scanner(System.in);

        ej.menu(sc);


    }
}
