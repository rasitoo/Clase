package tareas;

import java.util.concurrent.RecursiveTask;
import java.util.Random;

/**
 * La clase TareaForkJoin representa una tarea que se puede ejecutar de forma concurrente utilizando el framework Fork/Join.
 * Extiende RecursiveTask<Integer>.
 */
public class TareaForkJoin extends RecursiveTask<Integer> implements Comparable<TareaForkJoin> {
    private String tarea;
    private int cantidad;
    private static final Random random = new Random();
    private int prioridad;

    /**
     * Constructor de la clase TareaForkJoin.
     *
     * @param tarea     El nombre de la tarea.
     * @param cantidad  La cantidad de veces que se ejecutará la tarea.
     * @param prioridad La prioridad de la tarea.
     */
    public TareaForkJoin(String tarea, int cantidad, int prioridad) {
        this.tarea = tarea;
        this.cantidad = cantidad;
        this.prioridad = prioridad;
    }

    /**
     * Método que ejecuta la tarea y devuelve el tiempo total de ejecución.
     *
     * @return El tiempo total de ejecución en segundos.
     */
    @Override
    protected Integer compute() {
        int tiempoTotal = 0;
        for (int i = 0; i < cantidad; i++) {
            try {
                // Generar un tiempo aleatorio de ejecución entre 1 y 10 segundos
                int tiempoTarea = random.nextInt(10) + 1;
                System.out.println("Tarea en curso: " + tarea);

                // Simular un error aleatorio si el tiempo de tarea es 5 segundos
                if (tiempoTarea == 5) {
                    throw new RuntimeException("Error aleatorio de prueba: " + tarea);
                }

                // Dormir el hilo por el tiempo de tarea generado
                Thread.sleep(tiempoTarea * 1000);
                System.out.println(tarea + " Terminada en " + tiempoTarea + " segundos ");
                tiempoTotal += tiempoTarea;

                // Detener si los segundos del sistema son 0
                if (System.currentTimeMillis() / 1000 % 60 == 0) {
                    throw new RuntimeException("Error los segundos del sistema son 0.: " + tarea);
                }
            } catch (Exception e) {
                // Capturar y lanzar una excepción en caso de error
                throw new RuntimeException("Error de " + tarea + ": " + e);
            }
        }
        System.out.println("En " + tarea + " se tarda " + tiempoTotal + " segundos.");
        return tiempoTotal;
    }

    /**
     * Obtener la prioridad de la tarea.
     *
     * @return La prioridad de la tarea.
     */
    public int getPrioridad() {
        return prioridad;
    }

    /**
     * Comparar esta tarea con otra tarea basada en la prioridad.
     *
     * @param otraTarea La otra tarea con la que se comparará.
     * @return Un valor negativo, cero o positivo si esta tarea tiene menor, igual o mayor prioridad que la otra tarea.
     */
    @Override
    public int compareTo(TareaForkJoin otraTarea) {
        return Integer.compare(otraTarea.prioridad, this.prioridad);
    }
}