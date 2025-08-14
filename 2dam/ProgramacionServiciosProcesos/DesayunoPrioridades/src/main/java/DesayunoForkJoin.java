import tareas.TareaForkJoin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * La clase DesayunoForkJoin simula la preparación de un desayuno utilizando tareas concurrentes con el framework Fork/Join.
 */
public class DesayunoForkJoin {

    /**
     * Método principal que inicia la preparación del desayuno.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {

        // Crear un ForkJoinPool para gestionar las tareas
        ForkJoinPool pool = new ForkJoinPool();
        try {
            System.out.println("Me levanto de la cama y empiezo a preparar el desayuno...");
            long inicio = System.currentTimeMillis();

            // Crear una lista de tareas a realizar
            List<TareaForkJoin> tareas = new ArrayList<>();
            tareas.add(new TareaForkJoin("Preparar Tostada", 3, Thread.NORM_PRIORITY));
            tareas.add(new TareaForkJoin("Calentar leche", 1, Thread.MAX_PRIORITY));
            tareas.add(new TareaForkJoin("Cocer huevos", 2, Thread.MIN_PRIORITY));

            // Ordenar las tareas por prioridad
            Collections.sort(tareas);

            // Enviar las tareas al ForkJoinPool y almacenar los futuros
            List<ForkJoinTask<Integer>> futuros = new ArrayList<>();
            for (TareaForkJoin tarea : tareas) {
                futuros.add(pool.submit(tarea));
            }

            // Verificar los resultados de las tareas
            for (ForkJoinTask<Integer> futuro : futuros) {
                verificarFuturo(futuro);
            }

            // Cerrar el ForkJoinPool
            pool.shutdown();
            if (!pool.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("El tiempo de espera se excedió.");
                pool.shutdownNow();
            }

            long total = (System.currentTimeMillis() - inicio) / 1000;
            System.out.println("Me pongo a desayunar tras " + total + " segundos.");
        } catch (Exception e) {
            System.out.println("Error detectado: " + e.getMessage());
            pool.shutdownNow();
        }
    }

    /**
     * Método que verifica el resultado de una tarea ejecutada en un hilo y maneja posibles excepciones.
     *
     * @param future El resultado de la tarea ejecutada en un hilo.
     */
    private static void verificarFuturo(ForkJoinTask<Integer> future) {
        try {
            // Obtener el resultado de la tarea
            future.get();
        } catch (Exception e) {
            System.out.println("Excepción en una tarea: " + e.getCause().getMessage());
            throw new RuntimeException("Tarea fallida, deteniendo ejecución.");
        }
    }
}