import dataclases.Proceso;

import java.util.List;


public class Planificador {
    private ColaConPrioridades<Proceso> colaPrioridades;
    private int rodajaTiempo;

    public Planificador(List<Proceso> procesos, int rodajaTiempo) {
        this.rodajaTiempo = rodajaTiempo;
        colaPrioridades = new ColaConPrioridades<>(5); // Asumiendo 5 niveles de prioridad
        for (Proceso proceso : procesos) {
            colaPrioridades.anadir(proceso, proceso.getPrioridad());
        }
    }

    public void ejecutar() {
        int tiempoActual = 0;
        while (!colaPrioridades.estaVacia()) {
            Proceso proceso = colaPrioridades.sacar();
            int tiempoEjecucion = Math.min(proceso.getTiempoEjecucion(), rodajaTiempo);
            System.out.println("dataclases.Proceso " + proceso + " ejecutando desde " + tiempoActual + " hasta " + (tiempoActual + tiempoEjecucion));
            tiempoActual += tiempoEjecucion;
            proceso.setTiempoEjecucion(proceso.getTiempoEjecucion() - tiempoEjecucion);
            if (proceso.getTiempoEjecucion() > 0) {
                colaPrioridades.anadir(proceso, proceso.getPrioridad());
            } else {
                System.out.println("FIN " + proceso.getId());
            }
        }
    }
}