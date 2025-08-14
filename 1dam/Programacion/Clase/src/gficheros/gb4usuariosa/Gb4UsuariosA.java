package gficheros.gb4usuariosa;

import java.io.*;
import java.util.Scanner;

/**
 * @author Rodrigo🦖
 * @date 09 febrero, 2024
 */
public class Gb4UsuariosA {
    final static String PATH = "C:" + File.separator + "Users" + File.separator + "Rodrigo" + File.separator + "OneDrive" + File.separator + "Documents" + File.separator + "AAClase" + File.separator + "Programacion" + File.separator + "Clase" + File.separator + "src" + File.separator + "gficheros" + File.separator + "gb4UsuariosA" + File.separator + "data"+ File.separator + "Alumnos.dat";

    public void guardarAlumno(String nombre, double[] notas) {
        try (FileWriter fileWriter = new FileWriter(PATH, true)) { //si ponemos true entonces añade datos al archivo en lugar de borrarlos
            fileWriter.write((nombre + " "));
            for (int i = 0; i < notas.length; i++) {
                fileWriter.write((notas[i] + " "));
            }
            fileWriter.write('\n');
            System.out.println("Alumno guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el alumno.");
        }
    }

    public static void mostrarAlumnos() {
        try (FileReader fileReader = new FileReader(PATH); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] partes = linea.split(" ");
                System.out.println("Nombre: " + partes[0]);
                for (int i = 1; i < partes.length; i++) {
                    System.out.println("\t" + partes[i]);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Gb4UsuariosA ej = new Gb4UsuariosA();
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
                                System.out.println("Error la nota debe estar entre 0 y 10");
                                i--;
                            }
                        }
                        ej.guardarAlumno(nombre, notas);
                    } else System.out.println("Error, debe tener entre 1 y 5 notas");
                    break;
                case 2:
                    mostrarAlumnos();
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        }
    }
}
