package mongodb.ejer8;

/**
 * @author Rodrigo
 * @date 24 febrero, 2025
 */
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBConnection implements AutoCloseable {
    private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoDBConnection(String uri, String dbName) {
        mongoClient = MongoClients.create(uri);
        database = mongoClient.getDatabase(dbName);
    }

    public MongoCollection<Document> getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }

    public void close() {
        mongoClient.close();
    }
}

