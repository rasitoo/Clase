package org.example;

import com.mongodb.client.*;
import org.bson.Document;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String direccion = "mongodb://localhost:27017";

        try (MongoClient mongoClient = MongoClients.create(direccion)) {
            MongoDatabase basedatos = mongoClient.getDatabase("pruebas");
            MongoCollection<Document> coleccionproductos = basedatos.getCollection("productos");

            OperacionesCRUD operaciones = new OperacionesCRUD(coleccionproductos);

            Scanner scanner = new Scanner(System.in);
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

                switch (opcion) {
                    case 1:
                        operaciones.mostrarPorDescripcion();
                        break;
                    case 2:
                        operaciones.mostrarPorInventario();
                        break;
                    case 3:
                        operaciones.mostrarPrecioMasAlto();
                        break;
                    case 4:
                        operaciones.insertarProducto("Sudadera", "Sudadera de algodón", 20.99, 30);
                        break;
                    case 5:
                        operaciones.actualizarInventario("Camisa", 50);
                        break;
                    case 6:
                        operaciones.eliminarProducto("Pantalón");
                        break;
                    case 7:
                        System.out.println(" FIN DEL PROGRAMA. ");
                        break;
                    default:
                        System.out.println("OPCION ERRONEA.");
                        break;
                }
            } while (opcion != 7);
        }
    }
}
