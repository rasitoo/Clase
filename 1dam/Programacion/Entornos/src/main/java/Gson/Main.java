package Gson;

/**
 * @author Rodrigo
 * @date 22 mayo, 2024
 */
import com.

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de Gson
        Gson gson = new Gson();

        // Crear un objeto de ejemplo
        Cliente cliente = new Cliente("Acer SA", "5664332");

        // Serializar - Convertir el objeto a JSON
        String json = gson.toJson(cliente);
        System.out.println("Objeto a JSON: " + json);

        // Deserializar - Convertir JSON a objeto
        Cliente clienteDesdeJson = gson.fromJson(json, Cliente.class);
        System.out.println("JSON a Objeto: " + clienteDesdeJson.getNombre());
    }
}

class Cliente {
    private String nombre;
    private String cif;

    // Constructor
    public Cliente(String nombre, String cif) {
        this.nombre = nombre;
        this.cif = cif;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }
}
