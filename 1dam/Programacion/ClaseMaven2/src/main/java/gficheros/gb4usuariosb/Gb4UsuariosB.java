package gficheros.gb4usuariosb;

import java.io.*;
import java.util.Scanner;

/**
 * @author Rodrigo🦖
 * @date 09 febrero, 2024
 */
public class Gb4UsuariosB {
    static final String PATH = "." + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "gficheros" + File.separator + "gb4UsuariosB" + File.separator + "data" + File.separator + "Alumnos.dat";

    public void guardarAlumno(User a) {
        try (DataOutputStream f = new DataOutputStream(
                new FileOutputStream(PATH, true))) {
            a.guardarAlumnoFich(f, a);
        } catch (IOException e) {
            System.err.println("Error en el fichero ");
        }
    }

    public void mostrarAlumnos() {
        try (DataInputStream f = new DataInputStream(new FileInputStream(PATH))) {
            if (f.available() == 0)
                System.err.println("El archivo esta vacio");
            while (f.available() > 0) {
                User a = new User();
                System.out.println(a.leerAlumno(f));
            }
        } catch (FileNotFoundException e) {
            System.err.println("El fichero no existe");
        } catch (IOException e) {
            System.err.println("Error en el fichero");
        }
    }

    public static void main(String[] args) {
        Gb4UsuariosB ej = new Gb4UsuariosB();
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
                    User a = new User();
                    ej.guardarAlumno(a.crearAlumno(scanner));
                    break;
                case 2:
                    ej.mostrarAlumnos();
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
