package model;

/**
 * @author Rodrigo
 * @date 25 febrero, 2025
 */
public class Paciente {
    private int id;
    private String nombre;
    private int edad;
    private int medico_id;

    public Paciente() {
    }

    public Paciente(int id, String nombre, int edad, int medico_id) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.medico_id = medico_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getMedico_id() {
        return medico_id;
    }

    public void setMedico_id(int medico_id) {
        this.medico_id = medico_id;
    }
}
