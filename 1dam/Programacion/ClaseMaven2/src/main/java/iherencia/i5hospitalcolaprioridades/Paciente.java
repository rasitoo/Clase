package iherencia.i5hospitalcolaprioridades;

public class Paciente {
    int edad;
    String nombre;
    int prioridad;
    int orden;


    public Paciente(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }
    public Paciente(int edad, String nombre, int prioridad) {
        this.edad = edad;
        this.nombre = nombre;
        this.prioridad = prioridad;
    }
    public Paciente(int edad, String nombre, int prioridad, int orden) {
        this.edad = edad;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.orden = orden;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "edad=" + edad +
                ", nombre='" + nombre + '\'' +
                ", prioridad=" + prioridad +
                ", orden=" + orden +
                '}';
    }
}
