package gficheros.gb4usuariosb;

import java.io.*;
import java.util.Scanner;

/**
 * @author Rodrigo🦖
 * @date 09 febrero, 2024
 */
public class Gb4UsuariosB {
    static final String PATH ="." + File.separator + "src" + File.separator + "gficheros" + File.separator + "gb4UsuariosB" + File.separator + "data"+ File.separator + "Alumnos.dat";
    public void guardarAlumno(String nom, double[] notas) {
        try (DataOutputStream f = new DataOutputStream(
                new FileOutputStream(PATH, true))) {
            f.writeUTF(nom);
            f.writeInt(notas.length);
            for (int i = 0; i < notas.length; i++) {
                f.writeDouble(notas[i]);
            }
        } catch (IOException e) {
            System.err.println("Error en el fichero ");
        }
    }

    public void mostrarAlumno() {
        try (DataInputStream f = new DataInputStream(new FileInputStream(PATH))) {
            String nom = null;
            int lngth;
            double[] notas = null;
            while (f.available() > 0) {
                nom = f.readUTF();
                lngth = f.readInt();
                notas = new double[lngth];
                for (int i = 0; i < lngth; i++) {
                    notas[i] = f.readDouble();
                }
                System.out.println(new User(nom, notas));
            }

        } catch (IOException e) {
            System.err.println("Error en el fichero");
        }
    }

    public static void main(String[] args) {
        Gb4UsuariosB ej = new Gb4UsuariosB();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 3) {
            System.out.println("1. Añadir alumno");
            System.out.println("2. Mostrar lista de alumnos");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del alumno: ");
                    String nombre = scanner.next();
                    System.out.print("Número de notas: ");
                    int numNotas = scanner.nextInt();
                    if (numNotas >= 1 && numNotas <= 5) {
                        double nota;
                        double[] notas = new double[numNotas];
                        for (int i = 0; i < numNotas; i++) {
                            System.out.print("Nota " + (i + 1) + ": ");
                            nota = scanner.nextDouble();
                            if (nota >= 0 && nota <= 10) {
                                notas[i] = nota;
                            } else {
                                System.err.println("Error la nota debe estar entre 0 y 10");
                                i--;
                            }
                        }
                        ej.guardarAlumno(nombre, notas);
                    } else System.err.println("Error, debe tener entre 1 y 5 notas");
                    break;
                case 2:
                    ej.mostrarAlumno();
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.err.println("Opción inválida. Inténtalo de nuevo.");
            }
        }
    }
}
