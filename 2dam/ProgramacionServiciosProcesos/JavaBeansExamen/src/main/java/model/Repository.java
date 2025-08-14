package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rodrigo
 * @date 25 febrero, 2025
 */
public class Repository {
    private List<Hospital> hospitales = new ArrayList<>();
    private List<Medico> medicos = new ArrayList<>();
    private List<Paciente> pacientes = new ArrayList<>();


    public List<Hospital> getHospitales() {
        return hospitales;
    }
    public void insertHospital(Hospital hospital){
        hospitales.add(hospital);
    }

    public void setHospitales(List<Hospital> hospitales) {
        this.hospitales = hospitales;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void insertMedico(Medico medico){
        medicos.add(medico);
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void insertPaciente(Paciente paciente){
        pacientes.add(paciente);
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
}
