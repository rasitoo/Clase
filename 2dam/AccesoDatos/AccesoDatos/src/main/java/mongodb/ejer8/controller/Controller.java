package mongodb.ejer8.controller;

import mongodb.ejer8.model.Model;
import mongodb.ejer8.view.View;
import org.bson.Document;

import java.util.List;

/**
 * @author Rodrigo
 * @date 24 febrero, 2025
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void mostrarCiclo(String ciclo) {
        List<Document> ciclos = model.buscarCicloNombre(ciclo);
        view.showDocuments(ciclos);
    }

    public void mostrarCiclos() {
        List<Document> ciclos = model.buscarCiclos();
        view.showDocuments(ciclos);
    }

    public void insertarCiclos(int id, String nombre, int grupo, int alumnos, String nivel) {
        model.insertarCiclo(id, nombre, grupo, alumnos, nivel);

    }

    public void anadirAlumno(String nombreCiclo, String nombreAlumno, int edadAlumno) {
        model.anadirAlumno(nombreCiclo, nombreAlumno, edadAlumno);
    }
}

