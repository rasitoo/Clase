package mongodb.ejer2.sinjson.view;

import mongodb.ejer2.sinjson.model.dataclass.Ciclo;

import java.util.List;

/**
 * @author Rodrigo
 * @date 24 febrero, 2025
 */
public class View {
    public void showRecord(Ciclo record) {
        if (record != null) {
            System.out.println(record.toString());
        } else {
            System.out.println("No records found.");
        }
    }

    public void showCycle(List<Ciclo> cycles) {
        for (Ciclo cycle : cycles) {
            System.out.println(cycle.toString());
        }
    }
}

