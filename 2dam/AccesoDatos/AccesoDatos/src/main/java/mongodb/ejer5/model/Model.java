package mongodb.ejer5.model;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;

/**
 * @author Rodrigo
 * @date 24 febrero, 2025
 */

public class Model {
    private MongoCollection<Document> collection;

    public Model(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public List<Document> getPersonasPorAficionSinCursor() {
        List<Document> amigos = collection.aggregate(Arrays.asList(
                new Document("$unwind", "$Aficiones"),
                new Document("$group", new Document("_id", "$Aficiones").append("total", new Document("$sum", 1)))
        )).into(new ArrayList<>());
        return amigos;
    }

    public MongoCursor<Document> getPersonasPorAficionCursor() {
        MongoCursor<Document> amigos = collection.aggregate(Arrays.asList(
                new Document("$unwind", "$Aficiones"),
                new Document("$group", new Document("_id", "$Aficiones").append("total", new Document("$sum", 1)))
        )).iterator();
        return amigos;
    }

    public void modifyNombreCarlos() {
        collection.updateOne(eq("Nombre", "Joaquin"), new Document("$set", new Document("Nombre", "Juan Carlos")));

    }

    public void deleteTodo() {
        collection.drop();
    }

    public List<Document> getTodosAmigos() {
        FindIterable<Document> amigos = collection.find(eq("Amigos", new Document("$exists", true))).projection(fields(include("Amigos"), excludeId()));
        return amigos.into(new ArrayList<>());
    }

    public List<Document> getEdad18Recortado() {
        FindIterable<Document> amigos = collection.find(eq("Edad", 18)).projection(fields(include("Nombre", "Apellidos", "Edad"), excludeId()));
        return amigos.into(new ArrayList<>());
    }

    public List<Document> getIgual18SinCursor() {
        FindIterable<Document> amigos = collection.find(eq("Edad", 18));
        return amigos.into(new ArrayList<>());
    }

    public MongoCursor<Document> getIgual18Cursor() {
        MongoCursor<Document> cursor = collection.find(eq("Edad", 18)).iterator();
        return cursor;
    }

    public List<Document> getAmigosOrdenados() {
        FindIterable<Document> amigos = collection.find(eq("Edad", 18));
        return amigos.into(new ArrayList<>());
    }
}