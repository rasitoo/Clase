package mongodb.ejer3.view;

import org.bson.Document;

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
}

