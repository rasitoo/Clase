package moshi;


import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Leer2JSON {
    public static void main(String[] args) throws URISyntaxException {
        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<Personaa[]> jsonAdapter = moshi.adapter(Personaa[].class);

        try (FileReader f = new FileReader("personamoshi2.json"); BufferedReader bufferedReader = new BufferedReader(f)) {
            Personaa[] json = jsonAdapter.fromJson(bufferedReader.readLine());
            for (int i = 0; i < json.length; i++) {
                System.out.println(json[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
