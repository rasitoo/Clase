package org.example;

public class Ciclo {
    private String nombre;
    private int grupo;

    // Constructor
    public Ciclo(String nombre, int grupo) {
        this.nombre = nombre;
        this.grupo = grupo;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "Ciclo [Nombre=" + nombre + ", Grupo=" + grupo + "]";
    }
}

