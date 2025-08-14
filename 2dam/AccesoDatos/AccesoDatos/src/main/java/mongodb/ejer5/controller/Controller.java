package mongodb.ejer5.controller;

import com.mongodb.client.MongoCursor;
import mongodb.ejer5.model.Model;
import mongodb.ejer5.view.View;
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

    public void mostrarAmigosOrdenados() throws Exception {
        List<Document> productos = model.getAmigosOrdenados();
        view.showAmigosOrdenados(productos);

    }

    public void mostrarIgual18Cursor() throws Exception {
        MongoCursor<Document> productos = model.getIgual18Cursor();
        view.showCursor(productos);
    }

    public void mostrarIgual18SinCursor() throws Exception {
        List<Document> productos = model.getIgual18SinCursor();
        view.showDocuments(productos);

    }

    public void mostrarEdad18Recortado() throws Exception {
        List<Document> productos = model.getEdad18Recortado();
        view.showDocuments(productos);

    }

    public void mostrarTodosAmigos() throws Exception {
        List<Document> productos = model.getTodosAmigos();
        view.showDocuments(productos);

    }

    public void modificarNombreCarlos() throws Exception {
        model.modifyNombreCarlos();
    }

    public void eliminarTodo() throws Exception {
        model.deleteTodo();
    }

    public void mostrarPersonasPorAficionCursor() throws Exception {
        MongoCursor<Document> productos = model.getPersonasPorAficionCursor();
        view.showCursor(productos);

    }

    public void mostrarPersonasPorAficionSinCursor() throws Exception {
        List<Document> productos = model.getPersonasPorAficionSinCursor();
        view.showDocuments(productos);

    }
}

