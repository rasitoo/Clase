package ejemiterativas;

import ejemiterativas.relojobjetos.Tiempo;

import java.util.Scanner;

public class Ejerc11a15 {
    Ejerc11a15(){}
    void c11MenorMayor(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Da el primer número:");
        int n = sc.nextInt();

        int mayor = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;

        while (n!=0) {
            if (n<0){
                System.out.println("Por favor introduce un numero mayor de 0:");
                n= sc.nextInt();
                if (n == 0) {
                    break;
                }
            }
            if (n<menor)
                menor = n;
            if (n>mayor)
                mayor = n;

            System.out.println("Da un numero:");
            n= sc.nextInt();
        }
        System.out.println("El mayor es: " + mayor + " y el menor es:" + menor);
    }

    void c12Parejas(){
        Scanner sc = new Scanner(System.in);
        boolean finalizar=false;
        int n1;
        int n2;
        int suma = 0;

        do {
            System.out.println("Da el primer número: ");
            n1 = sc.nextInt();
            if (n1 == 0)
                finalizar = true;
            else{
                System.out.println("Da el segundo número: ");
                n2 = sc.nextInt();
                if (n2 == 0)
                    finalizar = true;
                else {
                    if (n1%n2 == 0 || n2%n1 == 0)
                        suma++;
                }
            }
        }while (!finalizar);
        System.out.println("Los números eran múltiplos en " + suma + " parejas");
    }
    void c13Porcentajeen0(){
        Scanner sc = new Scanner(System.in);

        int n = 1;
        int sumaterminados0 = 0;
        int sumatotal = 0;

        do {
            System.out.println("Da un número:");
            n = sc.nextInt();

            if (n != 0){
                if (n<0){
                    System.out.println("Por favor, introduce un número positivo:");
                    n = sc.nextInt();
                }else {
                    sumatotal++;
                    if (n%10 == 0)
                        sumaterminados0++;
                }
            }
        }while (n != 0);
        System.out.println("Hay " + sumaterminados0 + " números terminados en 0 de un total de: " + sumatotal);
        System.out.println("El porcentaje de números acabados en 0 es: " + (sumaterminados0 * 100 /sumatotal) + "%");
    }
    void c14Juego(){
        Scanner sc = new Scanner(System.in);
        Tiempo t = new Tiempo(0,0,0);

        int n1 = (int) (Math.random()*10 + 1);
        int aleatoriooperacion;
        String operacion = null;
        int n2;

        boolean perdido = false;
        int resultado = 0;
        int respuesta;
        int puntuacion = 0;
        long tiempoinicio = System.currentTimeMillis();
        long tiempojuego = 0;
        
        while (tiempojuego/1000 < 40 && !perdido){
            aleatoriooperacion = (int) (Math.random()*4);
            n2 = (int) (Math.random()*10 + 1);
            
            if (aleatoriooperacion == 0){
                operacion = "+";
                resultado = n1 + n2;
            }
            else if (aleatoriooperacion == 1) {
                operacion = "-";
                resultado = n1 - n2;
            } else if (aleatoriooperacion == 2) {
                operacion = "*";
                resultado = n1 * n2;
            } else if (aleatoriooperacion == 3) {
                operacion = "/";
                resultado = n1 / n2;
            }
            System.out.println("Resultado de: " + n1 + operacion + n2);
            respuesta = sc.nextInt();
            if (resultado != respuesta)
                perdido=true;
            else puntuacion++;
            tiempojuego = System.currentTimeMillis() - tiempoinicio;
            if (perdido){
                System.out.println("¡Has perdido! \nTienes " + puntuacion + " puntos y has durado " + (int) tiempojuego/1000 + " segundos.");
            }
            n1 = resultado;
        }
        if (tiempojuego/1000 >= 40)
            System.out.println("¡Has ganado! \nTu puntuacion es: " + puntuacion);
    }
    void c156xlinea(){
        Scanner sc = new Scanner(System.in);
        int n = 1;
        int contfinlinea = 0;

        while (n>0){
            System.out.println("\nEscribe un número: ");
            n = sc.nextInt();

            for (int i = 3; i<n; i+=3){
                if (contfinlinea <5){
                    System.out.print(i + " ");
                    contfinlinea++;
                }else {
                    System.out.println(i);
                    contfinlinea = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Ejerc11a15 e = new Ejerc11a15();

        //e.c11MenorMayor();
        //e.c12Parejas();
        //e.c13Porcentajeen0();
        //e.c14Juego();
        e.c156xlinea();
    }
}
