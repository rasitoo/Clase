package mongodb.ejer2.json.view;

import org.bson.Document;

import java.util.List;

/**
 * @author Rodrigo
 * @date 24 febrero, 2025
 */
public class View {
    public void showRecord(Document record) {
        if (record != null) {
            System.out.println(record.toJson());
        } else {
            System.out.println("No records found.");
        }
    }

    public void showCycle(List<Document> cycles) {
        for (Document cycle : cycles) {
            System.out.println(cycle.toJson());
        }
    }
}

