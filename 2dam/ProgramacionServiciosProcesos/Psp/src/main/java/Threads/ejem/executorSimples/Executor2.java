package Threads.ejem.executorSimples;

import java.util.concurrent.*;

class HiloEx implements Runnable {
    int x;

    HiloEx(int x) {
        this.x = x;
    }

    @Override
    public void run() {
        for (int i = 0; i < x; i++) {
            System.out.println(x);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // return;  //usar return cuando uses shutdownnow()
                throw new RuntimeException(e);
            }
        }
    }
}

public class Executor2 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        HiloEx hilo1 = new HiloEx(1);
        Runnable hilo2 = new HiloEx(2);
        Runnable hilo3 = new HiloEx(3);
        Runnable hilo4 = new HiloEx(4);
        executor.execute(hilo1);
        executor.execute(hilo4);
        executor.submit(hilo2);
        executor.execute(hilo3);
        executor.shutdown();  //No finaliza hasta que no terminen los hilos
        // executor.shutdownNow(); //finaliza de inmediato


    }
}
