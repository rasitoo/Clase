package controller;

import model.Hospital;
import model.Medico;
import model.Paciente;
import model.Repository;
import view.View;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * @author Rodrigo
 * @date 25 febrero, 2025
 */
public class GestionHospital {
    private Repository model;
    private View view;

    public GestionHospital(Repository model, View view) {
        this.model = model;
        this.view = view;
    }

    public void insertarHospital(int idHospital, String nombreHospital, String direccionHospital)  throws Exception{
        model.insertHospital(new Hospital(idHospital, nombreHospital, direccionHospital));
        view.mostrarMensaje("Se ha introducido el hospital exitosamente");
    }

    public void insertarMedicoConString(int idMedicoString, String nombreMedicoString, String especialidadesString, int hospitalIdString)throws Exception {
        ArrayList<String> especialidades = new ArrayList<>(List.of(especialidadesString.split("-")));
        model.insertMedico(new Medico(idMedicoString, nombreMedicoString, especialidades,especialidadesString, hospitalIdString));
        view.mostrarMensaje("Se ha introducido el medico exitosamente");
    }

    public void insertarMedicoConArrayList(int idMedicoArrayList, String nombreMedicoArrayList, ArrayList<String> especialidadesArrayList, int hospitalIdArrayList)throws Exception {
        StringBuilder especialidades = new StringBuilder();
        for (String especialidad: especialidadesArrayList){
            especialidades.append(especialidad).append("-");
        }
        model.insertMedico(new Medico(idMedicoArrayList, nombreMedicoArrayList, especialidadesArrayList, especialidades.toString(), hospitalIdArrayList));
        view.mostrarMensaje("Se ha introducido el medico exitosamente");
    }

    public void insertarPaciente(int idPaciente, String nombrePaciente, int edadPaciente, int medicoIdPaciente)throws Exception {
        model.insertPaciente(new Paciente(idPaciente, nombrePaciente, edadPaciente, medicoIdPaciente));
        view.mostrarMensaje("Se ha introducido el paciente exitosamente");
    }

    public void mostrarHospitales()throws Exception {
        for (Hospital hospital : model.getHospitales()) {
            view.mostrarMensaje("Hospital ID: " + hospital.getId());
            view.mostrarMensaje("Nombre: " + hospital.getNombre());
            view.mostrarMensaje("Direccion: " + hospital.getDireccion());
        }
    }

    public void mostrarMedicos()throws Exception {
        for (Medico medico : model.getMedicos()) {
            view.mostrarMensaje("Medico ID: " + medico.getId());
            view.mostrarMensaje("Nombre: " + medico.getNombre());
            view.mostrarMensaje("Especialidades: ");
            for (String especialiad : medico.getEspecialidades())
                view.mostrarMensaje("\t" + especialiad);
            view.mostrarMensaje("Hospital: " + medico.getHospital_id());
        }
    }

    public void mostrarPacientes() throws Exception{
        for (Paciente paciente : model.getPacientes()) {
            view.mostrarMensaje("ID: " + paciente.getId());
            view.mostrarMensaje("Nombre: " + paciente.getNombre());
            view.mostrarMensaje("Edad: " + paciente.getEdad());
            view.mostrarMensaje("Medico: " + paciente.getMedico_id());
        }
    }

    public void PacienteMasJoven() throws Exception{
        Paciente masjoven = model.getPacientes().stream().min(Comparator.comparingInt(c -> c.getEdad())).orElse(null);
        if (masjoven != null) {
            System.out.println("El paciente mas joven: ");
            view.mostrarMensaje("ID: " + masjoven.getId());
            view.mostrarMensaje("Nombre: " + masjoven.getNombre());
            view.mostrarMensaje("Edad: " + masjoven.getEdad());
            view.mostrarMensaje("Medico: " + masjoven.getMedico_id());
        }else view.mostrarMensaje("No se han encontrado pacientes");
    }

    public void PacienteMasViejo() throws Exception{
        Paciente masviejo = model.getPacientes().stream().max(Comparator.comparingInt(c -> c.getEdad())).orElse(null);
        if (masviejo != null) {
            System.out.println("El paciente mas viejo: ");
            view.mostrarMensaje("ID: " + masviejo.getId());
            view.mostrarMensaje("Nombre: " + masviejo.getNombre());
            view.mostrarMensaje("Edad: " + masviejo.getEdad());
            view.mostrarMensaje("Medico: " + masviejo.getMedico_id());
        }else view.mostrarMensaje("No se han encontrado pacientes");
    }

    public void SegundoPaciente() throws Exception{
        System.out.println("El segundo paciente: ");
        Paciente segundo = model.getPacientes().get(1);
        view.mostrarMensaje("ID: " + segundo.getId());
        view.mostrarMensaje("Nombre: " + segundo.getNombre());
        view.mostrarMensaje("Edad: " + segundo.getEdad());
        view.mostrarMensaje("Medico: " + segundo.getMedico_id());
    }

    public void UltimoPaciente() throws Exception{
        System.out.println("El ultimo paciente: ");
        List<Paciente> pacientes = model.getPacientes();
        Paciente ultimo = pacientes.get(pacientes.size()-1);
        view.mostrarMensaje("ID: " + ultimo.getId());
        view.mostrarMensaje("Nombre: " + ultimo.getNombre());
        view.mostrarMensaje("Edad: " + ultimo.getEdad());
        view.mostrarMensaje("Medico: " + ultimo.getMedico_id());
    }

    public void MedicosMasDeDosSinArraysList() throws Exception{
        for (Medico medico: model.getMedicos()){
            if (medico.getEspecialidadesString().split("-").length>2){
                view.mostrarMensaje("Medico ID: " + medico.getId());
                view.mostrarMensaje("Nombre: " + medico.getNombre());
                view.mostrarMensaje("Especialidades: ");
                for (String especialiad : medico.getEspecialidades())
                    view.mostrarMensaje("\t" + especialiad);
                view.mostrarMensaje("Hospital: " + medico.getHospital_id());
            }
        }
    }

    public void MedicosMasDeDosConArrayList() throws Exception{
        for (Medico medico: model.getMedicos()){
            if (medico.getEspecialidades().size()>2){
                view.mostrarMensaje("Medico ID: " + medico.getId());
                view.mostrarMensaje("Nombre: " + medico.getNombre());
                view.mostrarMensaje("Especialidades: ");
                for (String especialiad : medico.getEspecialidades())
                    view.mostrarMensaje("\t" + especialiad);
                view.mostrarMensaje("Hospital: " + medico.getHospital_id());
            }
        }
    }
}
