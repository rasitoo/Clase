package moshi;

import com.squareup.moshi.Moshi;
import com.squareup.moshi.JsonAdapter;

import java.io.FileWriter;
import java.io.IOException;

public class EscritorJSON {
    public static void main(String[] args) {

        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<Personaa> jsonAdapter = moshi.adapter(Personaa.class);

        Personaa p = new Personaa("Jose Manuel", "Perez", 20);
        Personaa p2 = new Personaa("Ana", "Gomez", 20);
        try (FileWriter f = new FileWriter("personamoshi.json")) {
            String json = jsonAdapter.toJson(p);
            String json2 = jsonAdapter.toJson(p2);
            f.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
