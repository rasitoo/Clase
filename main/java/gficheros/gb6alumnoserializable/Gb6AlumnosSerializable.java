package gficheros.gb6alumnoserializable;

import java.io.*;
import java.util.Scanner;

/**
 * @author Rodrigo🦖
 * @date 09 febrero, 2024
 */
public class Gb6AlumnosSerializable {
    static final String PATH = "." + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "gficheros" + File.separator + "gb6alumnoserializable" + File.separator + "data" + File.separator + "Alumnos.dat";

    public void guardarAlumno(Alumno a) {

    }

    public void mostrarAlumno() {
        try (ObjectInputStream f = new ObjectInputStream(new FileInputStream(PATH))) {
            boolean fin = false;
            while (!fin) {
                try {
                    Alumno a = (Alumno) f.readObject();
                    System.out.println(a);
                } catch (EOFException e) {
                    System.out.println("Fin");
                    fin = true;
                }
            }
        } catch (StreamCorruptedException e){
            System.err.println("Fichero corrupto porque el Object stream se vuelve a crear y lo corrompe");
        }catch (FileNotFoundException e) {
            System.err.println("El fichero no existe");
        } catch (IOException e) {
            System.err.println("Error en el fichero");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    Alumno crearAlumno(Scanner sc) {
        Alumno a = new Alumno();
        System.out.print("Nombre del alumno: ");
        a.setNombre(sc.next());
        System.out.print("Número de notas: ");
        int numNotas = sc.nextInt();
        if (numNotas >= 1 && numNotas <= 5) {
            double nota;
            a.setNotas(new double[numNotas]);
            for (int i = 0; i < numNotas; ) {
                System.out.print("Nota " + (i + 1) + ": ");
                nota = sc.nextDouble();
                if (nota >= 0 && nota <= 10) {
                    a.getNotas()[i++] = nota;
                } else {
                    System.err.println("Error la nota debe estar entre 0 y 10");
                }
            }
        } else System.err.println("Error, debe tener entre 1 y 5 notas");
        return a;
    }

    public static void main(String[] args) {
        Gb6AlumnosSerializable ej = new Gb6AlumnosSerializable();
        Scanner scanner = new Scanner(System.in);
        int opcion = 5;

        while (opcion != 0) {
            System.out.println("1. Añadir alumno");
            System.out.println("2. Mostrar lista de alumnos");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ej.guardarAlumno(ej.crearAlumno(scanner));
                    break;
                case 2:
                    ej.mostrarAlumno();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.err.println("Opción inválida. Inténtalo de nuevo.");
            }
        }
    }
}
