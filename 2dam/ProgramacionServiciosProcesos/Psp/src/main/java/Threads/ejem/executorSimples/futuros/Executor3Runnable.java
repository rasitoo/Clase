package Threads.ejem.executorSimples.futuros;

import java.util.concurrent.*;

// ver https://howtodoinjava.com/java/multi-threading/how-to-use-blockingqueue-and-threadpoolexecutor-in-java/
public class Executor3Runnable {
    public static void main(String[] args) {
        Runnable tarea = () -> {
            String s = "";
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print(i);
                s += " " + i;
            }
            System.out.println();
        };
        BlockingQueue<Runnable> listaTareas = new ArrayBlockingQueue<>(6);
        //Creo un pool de threads para 2 threads que tomara de la LinkedBlockingQueue
        ThreadPoolExecutor executorService =
                new ThreadPoolExecutor(2, 3, 0L,
                        TimeUnit.MILLISECONDS,
                        (BlockingQueue<Runnable>) listaTareas);
        executorService.prestartAllCoreThreads();
        listaTareas.add(tarea);
        listaTareas.add(tarea);
        listaTareas.add(tarea);
        listaTareas.add(tarea);
        listaTareas.add(tarea);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        listaTareas.add(tarea);
        System.out.println("Pararé el executorService");

        executorService.shutdown();
        try {
            executorService.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
