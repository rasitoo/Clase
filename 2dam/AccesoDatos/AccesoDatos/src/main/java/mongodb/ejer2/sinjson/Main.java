package mongodb.ejer2.sinjson;

import com.mongodb.client.MongoCollection;
import mongodb.ejer2.sinjson.controller.Controller;
import mongodb.ejer2.sinjson.model.Model;
import mongodb.ejer2.sinjson.view.View;
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

            boolean exit = false;

            while (!exit) {
                System.out.println("Menu de opciones:");
                System.out.println("1. Mostrar el primer registro");
                System.out.println("2.- Ciclos de 1º con Nombre y Grupo");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                String option = scanner.nextLine();

                switch (option) {
                    case "1":
                        controller.showFirstRecord();
                        break;
                    case "2":
                        controller.showFirstCycle();
                        break;
                    case "0":
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
        }
    }
}
