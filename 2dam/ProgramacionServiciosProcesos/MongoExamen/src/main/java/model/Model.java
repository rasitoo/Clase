package model;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;

/**
 * @author Rodrigo
 * @date 25 febrero, 2025
 */
public class Model {
    private MongoCollection<Document> collectionprofesores;
    private MongoCollection<Document> collectionasignaturas;

    public Model(MongoCollection<Document> collectionprofesores,MongoCollection<Document> collectionasignaturas) {
        this.collectionprofesores = collectionprofesores;
        this.collectionasignaturas = collectionasignaturas;
    }

    public List<Document> getProfesoresDoctores() {
        FindIterable<Document> ciclos = collectionprofesores.find(regex("titulacion", "doctor", "i"));
        return ciclos.into(new ArrayList<>());
    }
    public List<Document> getAsignaturasAlumnos() {
        FindIterable<Document> ciclos = collectionasignaturas.find();
        return ciclos.into(new ArrayList<>());
    }
}
