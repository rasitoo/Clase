package jackson;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EscritorJSON {
    public static void main(String[] args) throws URISyntaxException {

        ObjectMapper mapper = new ObjectMapper();
        Persona p = new Persona("Jose Manuel", "Perez", 20);
        Persona p2 = new Persona("Ana", "Gomez", 20);
        try {
            File fichero = new File("persona.json");
            fichero.createNewFile();
            mapper.writeValue(fichero, p);
            mapper.writeValue(fichero, p2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
