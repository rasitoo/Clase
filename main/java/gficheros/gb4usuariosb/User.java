package gficheros.gb4usuariosb;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rodrigo🦖
 * @date 11 febrero, 2024
 */
public class User {
    //Esta clase solo la he creado para usar el toString en la lectura, nada mas
    private String nombre;
    private double[] notas;

    public User() {
    }

    public User(String nombre, double[] notas) {
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

    User crearAlumno(Scanner sc) {
        User a = null;
        System.out.print("Nombre del alumno: ");
        nombre = sc.next();
        System.out.print("Número de notas: ");
        int numNotas = sc.nextInt();
        if (numNotas >= 1 && numNotas <= 5) {
            double nota;
            notas = new double[numNotas];
            for (int i = 0; i < numNotas;) {
                System.out.print("Nota " + (i + 1) + ": ");
                nota = sc.nextDouble();
                if (nota >= 0 && nota <= 10) {
                    notas[i++] = nota;
                } else {
                    System.err.println("Error la nota debe estar entre 0 y 10");
                }
            }
            a = new User(nombre, notas);
        } else System.err.println("Error, debe tener entre 1 y 5 notas");
        return a;
    }

    void guardarAlumnoFich(DataOutputStream f, User a) throws IOException {
        f.writeUTF(a.getNombre());
        f.writeInt(a.getNotas().length);
        for (int i = 0; i < a.getNotas().length; i++) {
            f.writeDouble(a.getNotas()[i]);
        }
    }

    User leerAlumno(DataInputStream in) throws IOException {
        nombre = in.readUTF();
        int len = in.readInt();
        notas = new double[len];
        for (int i = 0; i < len; i++) {
            notas[i] = in.readDouble();
        }
        return new User(nombre, notas);
    }

    @Override
    public String toString() {
        return "User{" +
                "nombre='" + nombre + '\'' +
                ", notas=" + Arrays.toString(notas) +
                '}';
    }
}
