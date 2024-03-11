package ejemarrays;

import java.util.Scanner;

public class D2menureales { //probar sin contador y borrando con -1
    double[] v = new double[10];
    int cont =0;
    Scanner sc = new Scanner(System.in);
    D2menureales(){}

    void menu(){
        int n= 1;

        System.out.println("1.- Añadir número real de tipo double");
        System.out.println("2.- Listar números leídos. Mostrará su posición y el número");
        System.out.println("3.- Modificar número. Pedirá la posición y el nuevo número real y sustituirá el antiguo por el nuevo.");
        System.out.println("4.- Borrar número. Pedirá la posición y eliminará el número.");
        System.out.println("5.- Consultar posición. Pedirá la posición y mostrará el número que está en esa posición");
        System.out.println("6.- Consultar número. Pedirá un número real e indicará si está o no en el array. Si está varias veces indicará cuántas.");
        System.out.println("7.- Media. Mostrará la media de los números almacenados.");
        System.out.println("0.- Finalizará el programa");

        while (n!=0){
            n = sc.nextInt();

            switch (n) {
                case 1:
                    anadirnumero();
                    break;
                case 2:
                    mostrar();
                    break;
                case 3:
                    modificar();
                    break;
                case 4:
                    borrar();
                    break;
                case 5:
                    consultarPos();
                    break;
                case 6:
                    consultarNum();
                    break;
                case 7:
                    media();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Ese número no es una opción");
            }
        }
    }
    void anadirnumero(){
            if (cont<10) {
                System.out.print("Escribe el número que quieres añadir: ");
                double x = sc.nextDouble();
                if (x < 0) {
                    System.out.println("No se admiten números negativos, por favor, introduce otro:");
                    x = sc.nextDouble();
                }
                if (x >= 0) {
                    v[cont] = x;
                    System.out.println("el número se ha añadido correctamente");
                    cont++;
                }
            }else System.out.println("Array lleno");
    }
    void mostrar(){
        for (int i = 0; i<cont;i++)
            System.out.println(i+"->"+v[i]);
    }
    void modificar(){
        System.out.println("Qué posición quieres modificar?");
        int pos = sc.nextInt();
        if (pos>cont){
            System.out.println("El array no llega a esa posición, introduce otra: ");
            pos = sc.nextInt();
        }
        System.out.print("introduce el nuevo número real: ");
        double x = sc.nextDouble();
        if (x < 0) {
            System.out.println("No se admiten números negativos, por favor, introduce otro:");
            x = sc.nextDouble();
        }
        if (x >= 0) {
            v[pos] = x;
            System.out.println("el número se ha modificado correctamente");
        }
    }
    void borrar(){
        System.out.println("Qué posición quieres borrar?");
        int pos = sc.nextInt();
        if (pos>cont){
            System.out.println("El array no llega a esa posición, introduce otra: ");
            pos = sc.nextInt();
        }
        for (int i = pos; i<cont;i++){
            v[i] = v[i+1];
        }
        v[cont--] = 0;
        System.out.println("Se ha borrado correctamente.");
    }
    void consultarPos(){
        System.out.println("Qué posicion quieres consultar?");
        int pos = sc.nextInt();
        if (pos>cont){
            System.out.println("El array no llega a esa posición, introduce otra: ");
            pos = sc.nextInt();
        }
        System.out.println(pos+"->"+v[pos]);
    }
    void consultarNum(){
        int cont2 = 0;
        System.out.println("Que número quieres buscar?");
        double n =sc.nextDouble();
        for (int i = 0; i<cont;i++){
            if (n == v[i])
                cont2++;
        }
        if (cont2 > 0)
            System.out.println("El número se encuentra " + cont2 + " veces.");
        else System.out.println("El número no está.");
    }
    void media(){
        double suma = 0;
        for (int i = 0; i<cont;i++){
            suma += v[i];
        }
        double media = suma / cont;
        System.out.println("La media de los números almacenados es: " + media);
    }
    public static void main(String[] args) {
        D2menureales e = new D2menureales();

        e.menu();


    }
}