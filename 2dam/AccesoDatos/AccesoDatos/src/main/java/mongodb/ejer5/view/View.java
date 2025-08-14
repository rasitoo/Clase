package mongodb.ejer5.view;

import com.mongodb.client.MongoCursor;
import org.bson.Document;

import javax.print.Doc;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rodrigo
 * @date 24 febrero, 2025
 */
public class View {
    public void showDocument(Document record) {
        if (record != null) {
            System.out.println(record.toJson());
        } else {
            System.out.println("No records found.");
        }
    }

    public void showDocuments(List<Document> documents) {
        for (Document document : documents) {
            System.out.println(document.toJson());
        }
    }

    public void showAmigosOrdenados(List<Document> productos) throws Exception {
        for (Document doc : productos) {
            // System.out.println("Documento encontrado: " + doc.toJson()); // Mostrar documento completo

            String nombre = doc.getString("Nombre");
            String apellidos = doc.getString("Apellidos");
            int edad = doc.getInteger("Edad");

            System.out.println("Nombre: " + nombre + " " + apellidos);
            System.out.println("Edad: " + edad);
            System.out.println("Los Amigos de " + nombre + " (ordenados por edad descendente):");

            // Obtener y ordenan los amigos por edad descendente
            Document[] amigos = doc.getList("Amigos", Document.class).toArray(new Document[0]);
            Arrays.sort(amigos, (a, b) -> b.getInteger("Edad") - a.getInteger("Edad"));

            for (Document amigo : amigos) {
                System.out.println(" - " + amigo.getString("Nombre") + " (" + amigo.getInteger("Edad") + ")");
            }
            System.out.println("----------------------------------------");
        }

    }

    public void showCursor(MongoCursor<Document> productos) {
        while (productos.hasNext()){
            Document document = productos.next();
            System.out.println(document.toJson());
        }
    }
}

