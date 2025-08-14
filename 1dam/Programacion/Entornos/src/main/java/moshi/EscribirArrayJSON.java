package moshi;


import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.FileWriter;
import java.io.IOException;

public class EscribirArrayJSON {
    public static void main(String[] args) {


        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<Personaa[]> jsonAdapter = moshi.adapter(Personaa[].class);

        Personaa pv[] = new Personaa[2];
        pv[0] = new Personaa("Jose Manuelxxx", "Perez", 20);
        pv[1] = new Personaa("Ana", "Gomez", 30);
        try (FileWriter f = new FileWriter("personamoshi2.json")) {
            String json = jsonAdapter.toJson(pv);
            f.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
