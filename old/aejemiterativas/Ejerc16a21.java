package aejemiterativas;

import aejemif.Fecha2;

import java.util.Scanner;

public class Ejerc16a21 {
    Ejerc16a21(){}
    void c16triangulo(){
        Scanner sc = new Scanner(System.in);
        int n = 1;

        while (n != 0){ //el programa termina cuando introduces un 0
            System.out.print("escribe un número: ");
            n = sc.nextInt();

            if (n > 0){ //el programa se ejecuta cuando el numero es ayor de 0, si no da error
                for (int i=1;i<=n;i++){ // contador que empieza en 1 y termina al llegar al valor de n
                    for (int m = 0; m < n-i; m++)
                        System.out.print("   "); // ponemos tantos espacios como digitos no se escriben, es decir, si la piramide es de tamaño 4 ponemos 3 espacios y escribimos un 1, segun avanza el contador se ponen menos espacios y mas numeros
                    for (int x= 1; x<=i; x++){ //otro bucle for, esta vez para poner los números, empieza poniendo el 1 y acaba donde marquen los espacios puestos antes
                        if (x<10)
                            System.out.print("  " + x);
                        else System.out.print(" " + x);
                    }
                    System.out.println();
                }
                for (int i=1;i<n;i++){
                    for (int m = 0; m<i;m++)
                        System.out.print("   "); //bucle para poner espacios como el anterior, pero inverso, el otro empezaba en n-i (4-1=3espacios) este empieza en i (1espacio)
                    for (int x= 1; x<=(n-i); x++){//bucle para poner los números, de nuevo inverso al anterior
                        if (x<10)
                            System.out.print("  " + x);
                        else System.out.print(" " + x);
                    }
                    System.out.println();
                }
            }else if (n<0)
                System.out.println("Error, el número tiene que ser positivo o 0 para finalizar.");
        }
    }
    void c17calendario(int diasemana, int mes, int year){
        Fecha2 f = new Fecha2(1,mes, year);
        int totaldias = f.cuantosdias();
        int contfinlinea = 0;
        System.out.println("\tLun/Mar/Mie/Jue/Vie/Sab/Dom");
        for (int x = 1;x<diasemana;x++){ //ponemos los espacios sin dia basandonos en el dia de la semana en el que empieza el mes
            System.out.print("\t__");
            contfinlinea++;
        }
        for (int i = 1; i<=totaldias; i++){ //ponemos los dias, saltando linea cada 7 dias y poniendo un espacio mas cuando el dia tiene 1 digito
            if (contfinlinea <6){
                if (i <10)
                 System.out.print("\t " +i);
                else System.out.print("\t" + i);
                contfinlinea++;
            }else {
                if (i <10)
                    System.out.println("\t " +i);
                else System.out.println("\t" + i);
                contfinlinea = 0;
            }
        }
    }
    void c18maspositivosOnegativos(){
        Scanner sc = new Scanner(System.in);
        int n = 1;
        int sumanegativos = 0;
        int sumapositivos = 0;

        while (n !=0){
            System.out.println("Da un número: ");
            n = sc.nextInt();
            if (n>0){
                sumapositivos += n;
            }
            else if (n<0){
                sumanegativos += (n*-1);
            }
        }
        boolean posimayor = sumapositivos>sumanegativos;
        if (posimayor){
            System.out.println("La suma de números positivos es mayor. positivos: " + sumapositivos +"  negativos: " + sumanegativos);
        } else if (sumapositivos == sumanegativos) {
            System.out.println("La suma de negativos y positivos es igual. positivos: " + sumapositivos +"  negativos: " + sumanegativos);
        } else System.out.println("La suma de números negativos es mayor. negativos: " + sumanegativos +"  positivos: " + sumapositivos);
    }
    void c19sumamayortercero(){
        Scanner sc = new Scanner(System.in);
        int n1, n2, n3;
        System.out.print("Introduzca el primer número: ");
        n1 = sc.nextInt();
        System.out.print("Introduzca el segundo número: ");
        n2 = sc.nextInt();
        System.out.print("Introduzca el tercer número: ");
        n3 = sc.nextInt();
        while (n3>(n2+n1)){
            n1 = n2;
            n2 = n3;
            System.out.println("Introduzca un número: ");
            n3 = sc.nextInt();
        }
        if (n3==(n2+n1))
            System.out.println(n3 + " es igual a la suma de " + n1 + " y " + n2);
        else System.out.println(n3 + " es menor que la suma de " + n1 + " y " + n2);
    }
    void c20cuadrado(){
        Scanner sc = new Scanner(System.in);
        int n = 1;
        while (n!=0){
            System.out.print("Escribe un número: ");
            n=sc.nextInt();
            if (n<0)
                System.out.println("Error, da un número positivo");
            else{
                for (int i = 0; i<n;i++){
                    for (int x = 0; x<n; x++){
                        System.out.print(" *"); //Escribe los asteriscos correspondientes por fila
                    }
                    System.out.println(); //Una vez escritos los asteriscos pasa de fila
                }
            }
        }
    }
    void c21contarmultiplos235(){
        Scanner sc= new Scanner(System.in);
        int n=0;
        int cont2 = 0;
        int cont3 = 0;
        int cont5 = 0;

        while (n>=0){
            System.out.print("Escribe un número: ");
            n = sc.nextInt();
            if (n != 0) {
                if (n % 2 == 0)
                    cont2++;
                if (n % 3 == 0)
                    cont3++;
                if (n % 5 == 0)
                    cont5++;
            }
        }
        System.out.println("Ha habido " + cont2 + " múltiplos de 2 " + cont3 + " multiplos de 3 " + cont5 + " múltiplos de 5");
    }
    public static void main(String[] args) {
        Ejerc16a21 e = new Ejerc16a21();

        e.c16triangulo();
        //e.c17calendario(3,11, 2023);
        //e.c18masposinega();
        //e.c19sumamayortercero();
        //e.c20cuadrado();
        //e.c21contarmultiplos235();
    }
}
