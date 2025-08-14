package Threads.ejem;

public class SumarMatrizEnteros extends Thread {
    int[][] m;
    int inicio, fin;
    int suma = 0;

    SumarMatrizEnteros(int[][] m, int inicio, int fin) {
        this.m = m;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void run() {

        for (int i = inicio; i < fin; i++) {
            for (int j = 0; j < m[i].length; j++) {
                suma += m[i][j];
            }
        }
    }

    static void rellenarMatriz(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = 1;
            }
        }
    }

    static int sumarMatriz(int[][] m) {
        int suma = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                suma += m[i][j];
            }
        }
        return suma;
    }

    public static void main(String[] args) throws InterruptedException {
        int[][] m = new int[1000][100000];
        rellenarMatriz(m);
        long inicio = System.currentTimeMillis();
    /*    SumarMatrizEnteros t1= new SumarMatrizEnteros(m,0,500);
        SumarMatrizEnteros t2= new SumarMatrizEnteros(m,500,1000);
        Thread th1=new Thread(t1);
        Thread th2=new Thread(t2);
        th1.start();
        th2.start();

        th2.join();
        th1.join();
       int total=t1.suma+t2.suma;*/
        int total = sumarMatriz(m);
        System.out.println("SumaTotal:" + total);
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución:" + (fin - inicio) + "ms");
    }
}
