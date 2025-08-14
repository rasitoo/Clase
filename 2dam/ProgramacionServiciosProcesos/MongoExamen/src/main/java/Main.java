import com.mongodb.client.MongoCollection;
import controller.Controller;
import model.Model;
import org.bson.Document;
import view.View;

import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 25 febrero, 2025
 */
public class Main {
    public static void main(String[] args) {
        try (MongoDBConnection connection = new MongoDBConnection("mongodb://localhost:27017", "test");
             Scanner scanner = new Scanner(System.in)) {
            MongoCollection<Document> collectionprofesores = connection.getCollection("profesores");
            MongoCollection<Document> collectionasignaturas = connection.getCollection("asignaturas");

            Model model = new Model(collectionprofesores,collectionasignaturas);
            View view = new View();
            Controller controller = new Controller(model, view);

            int opcion;

            do {
                System.out.println("\n Menu de Opciones:");
                System.out.println("1. Mostrar profesores doctores ");
                System.out.println("2. Mostrar asignaturas y número de alumnos");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();

                try {
                    switch (opcion) {
                        case 1:
                            controller.mostrarProfesoresDoctores();
                            break;
                        case 2:
                            controller.mostrarAsignaturasAlumnos();
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

