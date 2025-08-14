package mongodb.ejer5;

import com.mongodb.client.MongoCollection;
import mongodb.ejer5.controller.Controller;
import mongodb.ejer5.model.Model;
import mongodb.ejer5.view.View;
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
            MongoCollection<Document> collection = connection.getCollection("amigos");

            Model model = new Model(collection);
            View view = new View();
            Controller controller = new Controller(model, view);

            int opcion;

            do {
                System.out.println("\n Menu de Opciones:");
                System.out.println("1. Mostrar las personas de 18 años ordenando sus amigos de modo descendente por edad. ");
                System.out.println("2. Edad igual a 18 usando cursor");
                System.out.println("3. Edad igual a 18 sin usar cursor");
                System.out.println("4. Mostrar los alumnos con edad igual a 18 pero solo mostrar el nombre, apellido y edad");
                System.out.println("5. Mostrar el nombre de todos los amigos de todas las personas");
                System.out.println("6. Modificar el nombre de Carlos por el de José Carlos");
                System.out.println("7. Eliminar todo el registro");
                System.out.println("8. Contar cuantas personas tienen cada afición agrupando las personas por sus aficiones USANDO CURSOR");
                System.out.println("9. Contar cuantas personas tienen cada afición agrupando las personas por sus aficiones SIN USAR CURSOR");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();

                try {
                    switch (opcion) {
                        case 1:
                            controller.mostrarAmigosOrdenados();
                            break;
                        case 2:
                            controller.mostrarIgual18Cursor();
                            break;
                        case 3:
                            controller.mostrarIgual18SinCursor();
                            break;
                        case 4:
                            controller.mostrarEdad18Recortado();
                            break;
                        case 5:
                            controller.mostrarTodosAmigos();
                            break;
                        case 6:
                            controller.modificarNombreCarlos();
                            break;
                        case 7:
                            controller.eliminarTodo();
                            break;
                        case 8:
                            controller.mostrarPersonasPorAficionCursor();
                            break;
                        case 9:
                            controller.mostrarPersonasPorAficionSinCursor();
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
