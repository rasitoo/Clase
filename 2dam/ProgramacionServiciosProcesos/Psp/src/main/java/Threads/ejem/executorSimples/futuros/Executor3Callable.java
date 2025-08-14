package Threads.ejem.executorSimples.futuros;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Executor3Callable {
    public static void main(String[] args) throws Exception {
        ExecutorService servicio = null;
        servicio = Executors.newFixedThreadPool(3);
        List<Future<Integer>> lista = new ArrayList<Future<Integer>>();
        for (int i = 0; i < 10; i++) {
            Future<Integer> resultado = servicio.submit(new MiCallable(i));
            lista.add(resultado);
        }
/*        for(Future<Integer> f: lista) {
            System.out.println(f.get().intValue());
        }*/
        while (!lista.isEmpty()) {
            for (int i = 0; i < lista.size(); i++) {
                Future<Integer> f = lista.get(i);
                if (f.isDone()) {
                    System.out.println(f.get().intValue());
                    lista.remove(f);
                }
            }
        }
        servicio.shutdown();
        servicio.awaitTermination(10, TimeUnit.SECONDS);
    }
}

class MiCallable implements Callable<Integer> {
    int numero;

    MiCallable(int n) {
        this.numero = n;
    }

    public Integer call() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("en callable " + numero * 10);

        return numero * 10;
    }
}