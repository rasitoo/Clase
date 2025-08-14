package mongodb.ejer8;

import com.mongodb.client.MongoCollection;
import mongodb.ejer8.controller.Controller;
import mongodb.ejer8.model.Model;
import mongodb.ejer8.view.View;
import org.bson.Document;

import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 24 febrero, 2025
 */
public class Main {
    public static void main(String[] args) {
        try (MongoDBConnection connection = new MongoDBConnection("mongodb://localhost:27017", "test");
             Scanner scanner = new Scanner(System.in)) {
            MongoCollection<Document> collection = connection.getCollection("ciclos");

            Model model = new Model(collection);
            View view = new View();
            Controller controller = new Controller(model, view);

            int opcion;

            do {
                System.out.println("\n Menu de Opciones:");
                System.out.println("1. Insertar Ciclos ");
                System.out.println("2. Consultar todos los ciclos");
                System.out.println("3. Buscar ciclo por nombre");
                System.out.println("4. Añadir alumno a un ciclo");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();

                try {
                    switch (opcion) {
                        case 1:
                            System.out.print("Introduce el ID del ciclo: ");
                            int id = scanner.nextInt();
                            System.out.print("Introduce el nombre del ciclo: ");
                            String nombre = scanner.next();
                            System.out.print("Introduce el grupo del ciclo: ");
                            int grupo = scanner.nextInt();
                            System.out.print("Introduce el número de alumnos del ciclo: ");
                            int alumnos = scanner.nextInt();
                            System.out.print("Introduce el nivel del ciclo: ");
                            String nivel = scanner.next();
                            controller.insertarCiclos(id, nombre, grupo, alumnos, nivel);
                            break;
                        case 2:
                            controller.mostrarCiclos();
                            break;
                        case 3:
                            System.out.print("Introduce el nombre del ciclo: ");
                            String ciclo = scanner.next();
                            controller.mostrarCiclo(ciclo);
                            break;
                        case 4:
                            System.out.print("Introduce el nombre del ciclo: ");
                            String nombreCiclo = scanner.next();
                            System.out.print("Introduce el nombre del alumno: ");
                            String nombreAlumno = scanner.next();
                            System.out.print("Introduce la edad del alumno: ");
                            int edadAlumno = scanner.nextInt();
                            controller.anadirAlumno(nombreCiclo, nombreAlumno, edadAlumno);
                            break;
                        case 0:
                            System.out.println(" FIN DEL PROGRAMA. ");
                            break;
                        default:
                            System.out.println("OPCION ERRONEA.");
                            break;
                    }
                } catch (Exception e) {
                    System.err.println("Error: " + e);
                }
            } while (opcion != 0);
        }
    }
}
