package org.example;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
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
            Ciclo ciclo = new Ciclo(Registro1.getString("Nombre"), Registro1.getInteger("Grupo"));
            System.out.println("Primer registro de la colección ciclos:");
            System.out.println(ciclo);
        } else {
            System.out.println("No se encontró ningún registro.");
        }

    }

    private static void MostrarCiclos1(MongoCollection<Document> coleccionciclos) {

        FindIterable<Document> result = coleccionciclos.find(Filters.eq("Grupo", 1));

        System.out.println("Ciclos de 1º con solo Nombre y Grupo:");
        for (Document doc : result) {
            Ciclo ciclo = new Ciclo(doc.getString("Nombre"), doc.getInteger("Grupo"));
            System.out.println(ciclo);
        }


    }
}