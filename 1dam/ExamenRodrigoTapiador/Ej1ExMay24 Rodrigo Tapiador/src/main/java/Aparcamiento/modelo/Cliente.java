package Aparcamiento.modelo;

import lombok.Data;

@Data
public class Cliente {
    private String dni;
    private String nombre;
    private String numCuenta;
    public Cliente(String dni, String nombre, String numCuenta) {
        this.dni = dni;
        this.nombre = nombre;
        this.numCuenta = numCuenta;
    }
    public Cliente(String dni) {
        this.dni = dni;
    }
    @Override
    public String toString() {
        return "Persona{" +
                "id=" + dni +
                ", nombre='" + nombre + '\'' +
                ", edad=" + numCuenta +
                '}';
    }
}