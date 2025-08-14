package mongodb.ejer2.json.controller;

import mongodb.ejer2.json.model.Model;
import mongodb.ejer2.json.view.View;
import org.bson.Document;

import java.util.List;

/**
 * @author Rodrigo
 * @date 24 febrero, 2025
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void showFirstRecord() {
        Document record = model.getFirstRecord();
        view.showRecord(record);
    }

    public void showFirstCycle() {
        List<Document> cycles = model.getFirstCycle();
        view.showCycle(cycles);
    }
}

