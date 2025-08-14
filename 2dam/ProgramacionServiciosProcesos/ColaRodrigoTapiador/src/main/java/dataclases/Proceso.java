package dataclases;

public class Proceso {
    private int id;
    private int tiempoEjecucion;
    private int tiempoEntrada;
    private int prioridad;

    public Proceso(int id, int tiempoEjecucion, int tiempoEntrada, int prioridad) {
        this.id = id;
        this.tiempoEjecucion = tiempoEjecucion;
        this.tiempoEntrada = tiempoEntrada;
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "dataclases.Proceso{" +
                "id=" + id +
                ", tiempoEjecucion=" + tiempoEjecucion +
                ", tiempoEntrada=" + tiempoEntrada +
                ", prioridad=" + prioridad +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public int getTiempoEntrada() {
        return tiempoEntrada;
    }

    public int getPrioridad() {
        return prioridad;
    }
}