package jackson;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EscribirArrayJSON {
	 public static void main(String[] args) throws URISyntaxException {

	        ObjectMapper mapper = new ObjectMapper();
	        Persona pv[]=new Persona[2];
	        pv[0] = new Persona("Jose Manuelxxx", "Perez", 20);
	        pv[1] = new Persona("Ana", "Gomez", 30);
	        try {
	            File fichero = new File("persona2.json");
	            fichero.createNewFile();
	            mapper.writeValue(fichero, pv);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
