package jackson;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Leer2JSON {
    public static void main(String[] args) throws URISyntaxException {
        LectorJSON lector = new LectorJSON();
        File fichero = new File("persona2.json");

        System.out.println(fichero);
        ObjectMapper mapper = new ObjectMapper();
        try {
            ArrayList<Persona> personas = mapper.readValue(fichero,
                    mapper.getTypeFactory().constructCollectionType(
                            ArrayList.class, Persona.class));
            System.out.println("persona 1");
            System.out.println(personas.get(0).getNombre());
            System.out.println(personas.get(0).getApellidos());
            System.out.println(personas.get(0).getEdad());

            System.out.println("persona 2");
            System.out.println(personas.get(1).getNombre());
            System.out.println(personas.get(1).getApellidos());
            System.out.println(personas.get(1).getEdad());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
