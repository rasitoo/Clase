package Threads.ejem.executorSimples.futuros;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EjemCallable1 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int total = 0;
        for (int i = 0; i < 5; i++) {
            total += i;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Nombre thread:" + Thread.currentThread().getName());
        return total;
    }
}

class PrincipalCallable {
    static void espera(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            ExecutorService servicio = Executors.newFixedThreadPool(1);
            Future<Integer> resultado = servicio.submit(new EjemCallable1());
            //No hay porque poner el while pero así vemos que se puede ejecutar mientras espero.
            while (!resultado.isDone()) {
                espera(100);
                System.out.println("Espera");
            }
            System.out.println("Resultado:" + resultado.get());
            //    System.exit(0);  // si no seguirá ejecutando por el servicio.
            servicio.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
