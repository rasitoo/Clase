package mongodb.ejer2.sinjson.model.dataclass;

/**
 * @author Rodrigo
 * @date 24 febrero, 2025
 */
public class Ciclo {
    private String nombre;
    private Integer grupo;

    public Ciclo(String nombre, Integer grupo) {
        this.nombre = nombre;
        this.grupo = grupo;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getGrupo() {
        return grupo;
    }

    public void setGrupo(Integer grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "Ciclo{" +
                "nombre='" + nombre + '\'' +
                ", grupo='" + grupo + '\'' +
                '}';
    }
}
