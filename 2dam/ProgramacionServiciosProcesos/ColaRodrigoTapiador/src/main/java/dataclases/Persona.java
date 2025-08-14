package dataclases;

public class Persona {
    int edad;
    String nombre;
    int prioridad;
    int orden;


    public Persona(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }
    public Persona(int edad, String nombre, int prioridad) {
        this.edad = edad;
        this.nombre = nombre;
        this.prioridad = prioridad;
    }
    public Persona(int edad, String nombre, int prioridad, int orden) {
        this.edad = edad;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.orden = orden;
    }

    @Override
    public String toString() {
        return "dataclases.Persona{" +
                "edad=" + edad +
                ", nombre='" + nombre + '\'' +
                ", prioridad=" + prioridad +
                ", orden=" + orden +
                '}';
    }
}
