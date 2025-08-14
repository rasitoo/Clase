package ejercicios.simulacro;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 04 noviembre, 2024
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Libro[] libros = {
                new Libro("Gabriel Garcia Marquez", "Mac Graw Hill", "111", 21.97),
                new Libro("Gabriel Garcia Marquez", "Editorial Alianza", "112", 14.25),
                new Libro("Camilo Jose Cela", "Mac Graw Hill", "113", 20.50),
                new Libro("Camilo Jose Cela", "Editorial Alianza", "114", 12.00),
                new Libro("George Orwell", "Planeta", "115", 15.00),
                new Libro("George Orwell", "Editorial CICS", "116", 15.00),
                new Libro("Edurne Portela", "Planeta", "117", 40.00),
                new Libro("Edurne Portela", "Editorial Dilema", "118", 30.00),
                new Libro("Arturo Perez Reverte", "Planeta", "119", 20.00),
                new Libro("Arturo Perez Reverte", "Editorial Dilema", "120", 10.00),
        };

        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Imprimir libros por autor");
            System.out.println("2. Imprimir el libro con menos precio");
            System.out.println("3. Contar líneas pares, impares y con más de 5 palabras en un fichero");
            System.out.println("4. Procesar XML para departamentos de Guadalajara y mayor departamento");
            System.out.println("5. Salir");

            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el autor: ");
                    String autor = scanner.nextLine();
                    Libro.LibrosPorAutor(libros, autor);
                    break;

                case 2:
                    Libro menosPrecio = Libro.MenosPrecio(libros);
                    if (menosPrecio != null) {
                        System.out.println("El libro que tiene el menor precio es: " + menosPrecio);
                    } else {
                        System.out.println("No hay libros disponibles.");
                    }
                    break;

                case 3:
                    System.out.print("Introduce el nombre del fichero: ");
                    String nombreFichero = scanner.nextLine();
                    try {
                        Utilidades.contarLineas(nombreFichero);
                    } catch (IOException e) {
                        System.out.println("Error al leer el fichero: " + e.getMessage());
                    }
                    break;

                case 4:
                    XmlCiclosFormativos.MayorGuadalajara();
                    break;

                case 5:
                    System.out.println("Saliendo de la aplicación...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
}
