package mongodb.ejer3;

import com.mongodb.client.MongoCollection;
import mongodb.ejer3.controller.Controller;
import mongodb.ejer3.model.Model;
import mongodb.ejer3.view.View;
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
            MongoCollection<Document> collection = connection.getCollection("productos");

            Model model = new Model(collection);
            View view = new View();
            Controller controller = new Controller(model, view);

            int opcion;

            do {
                System.out.println("\n Menu de Opciones:");
                System.out.println("1. Mostrar los productos que tienen 'mezclilla'");
                System.out.println("2. Mostrar los productos que tenga más de 15 unidades");
                System.out.println("3. Mostrar el producto con el precio más alto");
                System.out.println("4. Insertar un nuevo producto");
                System.out.println("5. Actualizar el inventario de un producto");
                System.out.println("6. Eliminar un producto determinado");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();

                try {
                    switch (opcion) {
                        case 1:
                            controller.mostrarPorDescripcion();
                            break;
                        case 2:
                            controller.mostrarPorInventario();
                            break;
                        case 3:
                            controller.mostrarPrecioMasAlto();
                            break;
                        case 4:
                            controller.insertarProducto("Sudadera", "Sudadera de algodón", 20.99, 30);
                            break;
                        case 5:
                            controller.actualizarInventario("Camisa", 50);
                            break;
                        case 6:
                            controller.eliminarProducto("Pantalón");
                            break;
                        case 7:
                            System.out.println(" FIN DEL PROGRAMA. ");
                            break;
                        default:
                            System.out.println("OPCION ERRONEA.");
                            break;
                    }
                } catch (Exception e) {
                    System.err.println("Error: " + e);
                }
            } while (opcion != 7);
        }
    }
}
