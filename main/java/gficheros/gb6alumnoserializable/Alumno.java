package gficheros.gb6alumnoserializable;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rodrigo🦖
 * @date 11 febrero, 2024
 */
public class Alumno  implements Serializable{
    //Esta clase solo la he creado para usar el toString en la lectura, nada mas
    private String nombre;
    private double[] notas;

    public Alumno() {
    }

    public Alumno(String nombre, double[] notas) {
        this.nombre = nombre;
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "User{" +
                "nombre='" + nombre + '\'' +
                ", notas=" + Arrays.toString(notas) +
                '}';
    }
}
