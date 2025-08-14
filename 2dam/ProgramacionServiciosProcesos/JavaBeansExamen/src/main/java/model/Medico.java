package model;

import java.util.ArrayList;

/**
 * @author Rodrigo
 * @date 25 febrero, 2025
 */
public class Medico {
    private int id;
    private String nombre;
    private ArrayList<String> especialidades;
    private String especialidadesString;
    private int hospital_id;

    public Medico() {
    }

    public Medico(int id, String nombre, ArrayList<String> especialidades, String especialidadesString, int hospital_id) {
        this.id = id;
        this.nombre = nombre;
        this.especialidades = especialidades;
        this.especialidadesString = especialidadesString;
        this.hospital_id = hospital_id;
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

    public ArrayList<String> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(ArrayList<String> especialidades) {
        this.especialidades = especialidades;
    }

    public int getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(int hospital_id) {
        this.hospital_id = hospital_id;
    }

    public String getEspecialidadesString() {
        return especialidadesString;
    }

    public void setEspecialidadesString(String especialidadesString) {
        this.especialidadesString = especialidadesString;
    }
}
