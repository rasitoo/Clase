package jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;

public class LectorJSON {
    public static void main(String[] args) throws URISyntaxException {
        File fichero = new File("persona.json");

        System.out.println(fichero);
        ObjectMapper mapper = new ObjectMapper();
        try {

            Persona persona = mapper.readValue(fichero, Persona.class);
            System.out.println("persona 1");
            System.out.println(persona.getNombre());
            System.out.println(persona.getApellidos());
            System.out.println(persona.getEdad());

            persona = mapper.readValue(fichero, Persona.class);
            System.out.println(persona.getNombre());
            System.out.println(persona.getApellidos());
            System.out.println(persona.getEdad());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
