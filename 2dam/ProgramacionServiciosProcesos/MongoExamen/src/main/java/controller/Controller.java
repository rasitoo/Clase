package controller;

import model.Model;
import org.bson.Document;
import view.View;

import java.util.List;

/**
 * @author Rodrigo
 * @date 25 febrero, 2025
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void mostrarProfesoresDoctores() throws Exception {
        List<Document> result = model.getProfesoresDoctores();
        view.showProfesoresDoctores(result);
    }

    public void mostrarAsignaturasAlumnos() throws Exception {
        List<Document> result = model.getAsignaturasAlumnos();
        view.showAsignaturasAlumnos(result);
    }
}
