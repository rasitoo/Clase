package mongodb.ejer2.json.model;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rodrigo
 * @date 24 febrero, 2025
 */

public class Model {
    private MongoCollection<Document> collection;

    public Model(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public Document getFirstRecord() {
        try {
            return collection.find().first();
        } catch (Exception e) {
            System.err.println("Error al obtener el primer registro: " + e.getMessage());
            return null;
        }
    }

    public List<Document> getFirstCycle() {
        try {
            return collection.find(new Document("Grupo", 1))
                    .projection(new Document("Nombre", 1).append("Grupo", 1))
                    .into(new ArrayList<>());
        } catch (Exception e) {
            System.err.println("Error al obtener los ciclos ciclo: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}