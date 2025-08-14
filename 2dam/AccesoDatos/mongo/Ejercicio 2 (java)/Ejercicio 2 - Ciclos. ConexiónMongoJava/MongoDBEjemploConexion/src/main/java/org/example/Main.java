package org.example;

import com.mongodb.client.*;
import org.bson.Document;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("Personas");
        MongoCollection<Document> coleccionciclos = database.getCollection("ciclos");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecciona una opción:");
        System.out.println("1.- Primer registro");
        System.out.println("2.- Ciclos de 1º con Nombre y Grupo");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                MostrarPrimerRegistro(coleccionciclos);
                break;
            case 2:
                MostrarCiclos1(coleccionciclos);
                break;
            default:
                System.out.println("OPCION ERRONEA.");
        }

        mongoClient.close();
    }

    private static void MostrarPrimerRegistro(MongoCollection<Document> coleccionciclos) {

        Document Registro1 = coleccionciclos.find().first();

        if (Registro1 != null) {
            System.out.println("EL PRIMER REGISTRO ES:");
            System.out.println(Registro1.toJson());
        } else {
            System.out.println("NO HAY NINGUN REGISTRO EN LA COLECCION.");
        }
    }

    private static void MostrarCiclos1(MongoCollection<Document> coleccionciclos) {

        FindIterable<Document> result = coleccionciclos.find(new Document("Grupo", 1))
                .projection(new Document("Nombre", 1).append("Grupo", 1));

        System.out.println("LOS CICLOS DE 1º SON:");
        for (Document doc : result) {
            System.out.println(doc.toJson());
        }
    }
}