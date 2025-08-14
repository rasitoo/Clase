package ejemarrays;

import java.util.Scanner;

public class D5aD9 {
    D5aD9() {

    }

    int[] d5MostrarInverso(Scanner sc) {
        int[] num = new int[20];
        int cont = 0;
        int n = 1;
        for (int i = 0; n != 0 && i < num.length; i++) {
            System.out.println("Introduce un número");
            n = sc.nextInt();
            num[i] = n;
            cont++;
        }
        int[] inv = new int[cont - 1];
        for (int i = 0; i < inv.length; i++) {
            inv[i] = num[cont - (i + 2)];
        }

        return inv;
    }

    int[] d6MostrarAparicionesEntre09(Scanner sc) {
        int[] apariciones = new int[10];
        int n = 0;
        while (n != -1) {
            System.out.println("Introduce un número del 0 al 9:");
            n = sc.nextInt();
            if (n > 9 || n < -1) {
                System.out.println("Error solo números de una cifra o mayores de -1");
            } else if (n >= 0) apariciones[n]++;
        }
        return apariciones;
    }

    void d7MostrarNoIntroducidos() {
        int[] rdm = new int[10];
        boolean[] introducido = new boolean[10];
        for (int i = 0; i < rdm.length; i++) {
            rdm[i] = (int) ((Math.random() * 10) + 1);
        }
        for (int i = 0; i < rdm.length; i++) {
            introducido[rdm[i] - 1] = true; //El array introducido en la posición igual al número del array random (-1, ya que la posición 0 del array introducido equivale al 1) es true, si nunca aparece un número equivalente a la posición introducido nunca es true, no ha sido introducido.
        }
        System.out.print("Los números que no se encuentran en al array son: ");
        for (int i = 0; i < introducido.length; i++) {
            if (!introducido[i])
                System.out.print((i + 1) + " ");
        }

    }

    int[] d8BuscarComunes(int[] v1, int[] v2) {
        int longitud = Math.min(v1.length, v2.length);
        int[] comunestemp = new int[longitud];
        int cont = 0;
        boolean anadido;
        for (int i = 0; i < v1.length; i++) {
            for (int m = 0; m < v2.length; m++) {
                anadido = false;
                if (v1[i] == v2[m]) { //si se encuentra un común primero se comprueba si ya está en la lista de comunes y si no está se añade y se pasa al número siguiente
                    for (int n = 0; n < comunestemp.length; n++) {
                        if (v1[i] == comunestemp[n] || v2[m] == comunestemp[n]) {
                            anadido = true;
                            break;
                        }
                    }
                    if (!anadido) {
                        comunestemp[cont] = v1[i];
                        cont++;
                        break;
                    }
                }
            }
        }
        int[] comunes = new int[cont];
        for (int i = 0; i < cont; i++) {
            comunes[i] = comunestemp[i];
        }
        return comunes;
    }

    int d9NumApareceMasVeces(int[] v) {
        int masapariciones = 0;
        int masrep = 0;

        int[] apariciones = new int[v.length];
        for (int i = 0; i < v.length; i++) { //cada número del array se compara con los numeros del mismo array, si se repite en el array apariciones se suma 1 en la misma posicion que el array original
            for (int m = 0; m < v.length; m++) {
                if (v[i] == v[m])
                    apariciones[i]++;
            }
        }
        for (int i = 0; i < apariciones.length; i++) { //se comprueba si un número en una posicion aparece más que otro y se guarda el que más aparezca y se guarda la posicion
            if (apariciones[i] > masrep) {
                masrep = apariciones[i];
                masapariciones = i;
            }
        }
        return v[masapariciones];
    }

    void mostrar(int[] v) {
        for (int i = 0; i < v.length; i++)
            System.out.println(i + "->" + v[i]);
    }

    int[] crearArray(Scanner sc, int longitud) {
        int[] v = new int[longitud];
        for (int i = 0; i < longitud; i++) {
            System.out.println("Escribe un número:");
            v[i] = sc.nextInt();
        }
        System.out.println("Fin array");
        return v;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        D5aD9 e = new D5aD9();
        int[] v;

//        v = e.d5MostrarInverso(sc);

//        v= e.d6MostrarAparicionesEntre09(sc);

        e.d7MostrarNoIntroducidos();

//        int[] v1 = e.crearArray(sc, 7);
//        int[] v2 = e.crearArray(sc, 5);
//        v = e.d8BuscarComunes(v1,v2);

        //       int[] v = new int[20]; //Creamos el array de x numeros aleatorios, o con el metodo crearArray lo creamos con numeros introducidos
        //       for (int i= 0; i<v.length;i++){
        //           v[i] = (int) (Math.random()*20);
        //       }
        //       e.mostrar(v);
        //       System.out.println("El " + e.d9NumApareceMasVeces(v) + " aparece más veces");
    }
}
