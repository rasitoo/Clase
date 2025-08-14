package mongodb.ejer8.model;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

/**
 * @author Rodrigo
 * @date 24 febrero, 2025
 */

public class Model {
    private MongoCollection<Document> collection;

    public Model(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public List<Document> buscarCicloNombre(String ciclo) {
        FindIterable<Document> ciclos = collection.find(eq("Nombre", ciclo));
        return ciclos.into(new ArrayList<>());
    }

    public List<Document> buscarCiclos() {
        FindIterable<Document> ciclos = collection.find();
        return ciclos.into(new ArrayList<>());
    }

    public void insertarCiclo(int id, String nombre, int grupo, int alumnos, String nivel) {
        Document ciclo1 = new Document("_id", id)
                .append("Nombre", nombre)
                .append("Grupo", grupo)
                .append("NumAlumnos", alumnos)
                .append("Nivel", nivel)
                .append("Alumnos", List.of());
        collection.insertOne(ciclo1);
    }
    public void anadirAlumno(String nombreCiclo, String nombreAlumno, int edadAlumno) {
        Document nuevoAmigo = new Document("Nombre", nombreAlumno).append("Edad", edadAlumno);
        collection.updateOne(eq("Nombre", nombreCiclo), new Document("$push", new Document("Amigos", nuevoAmigo)));
    }
}