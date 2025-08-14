package Threads.ejem.executorSimples;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EjemExecutor1 implements Runnable {
    int x;

    EjemExecutor1(int x) {
        this.x = x;
    }

    @Override
    public void run() {
        System.out.println("Ejecutando " + x);
    }

    public static void main(String[] args) throws InterruptedException {
        EjemExecutor1 ex = new EjemExecutor1(1);
        EjemExecutor1 ex2 = new EjemExecutor1(2);
        ScheduledExecutorService servicio = Executors.newSingleThreadScheduledExecutor();
        servicio.scheduleAtFixedRate(ex, 1, 2, TimeUnit.SECONDS);
        servicio.scheduleAtFixedRate(ex2, 0, 3, TimeUnit.SECONDS);
        Thread.sleep(15000);
        System.out.println("FIN");
        servicio.shutdown();
    }
}
