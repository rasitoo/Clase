package moshi;


import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LectorJSON {
    public static void main(String[] args)  {
        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<Personaa> jsonAdapter = moshi.adapter(Personaa.class);

        try (FileReader f = new FileReader("personamoshi.json"); BufferedReader bufferedReader = new BufferedReader(f)) {
            Personaa json = jsonAdapter.fromJson(bufferedReader.readLine());
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
