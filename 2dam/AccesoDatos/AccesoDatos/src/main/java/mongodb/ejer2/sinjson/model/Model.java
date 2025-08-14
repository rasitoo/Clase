package mongodb.ejer2.sinjson.model;

import com.mongodb.client.MongoCollection;
import mongodb.ejer2.sinjson.model.dataclass.Ciclo;
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

    public Ciclo getFirstRecord() {
        Document registro1 = collection.find().first();
        try {
            return new Ciclo(registro1.getString("Nombre"), registro1.getInteger("Grupo"));
        } catch (Exception e) {
            System.err.println("Error al obtener el primer registro: " + e.getMessage());
            return null;
        }
    }

public List<Ciclo> getFirstCycle() {
    List<Ciclo> ciclos = new ArrayList<>();
    try {
        List<Document> documents = collection.find(new Document("Grupo", 1))
                .projection(new Document("Nombre", 1).append("Grupo", 1))
                .into(new ArrayList<>());
        for (Document doc : documents) {
            ciclos.add(new Ciclo(doc.getString("Nombre"), doc.getInteger("Grupo")));
        }
    } catch (Exception e) {
        System.err.println("Error al obtener los ciclos ciclo: " + e.getMessage());
    }
    return ciclos;
}
}