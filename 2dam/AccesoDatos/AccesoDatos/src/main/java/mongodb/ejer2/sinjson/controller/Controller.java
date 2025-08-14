package mongodb.ejer2.sinjson.controller;

import mongodb.ejer2.sinjson.model.dataclass.Ciclo;
import mongodb.ejer2.sinjson.model.Model;
import mongodb.ejer2.sinjson.view.View;

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
        Ciclo record = model.getFirstRecord();
        view.showRecord(record);
    }

    public void showFirstCycle() {
        List<Ciclo> cycles = model.getFirstCycle();
        view.showCycle(cycles);
    }
}

