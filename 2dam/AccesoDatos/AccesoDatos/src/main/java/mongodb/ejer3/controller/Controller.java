package mongodb.ejer3.controller;

import mongodb.ejer3.model.Model;
import mongodb.ejer3.view.View;
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
    public void mostrarPorDescripcion() throws Exception {
        List<Document> productos = model.getPorDescripcion();
        view.showDocuments(productos);
    }

    public void mostrarPorInventario() throws Exception {
        List<Document> productos = model.getPorInventario();
        view.showDocuments(productos);
    }

    public void mostrarPrecioMasAlto() throws Exception {
        Document producto = model.getPrecioMasAlto();
        view.showDocument(producto);
    }

    public void insertarProducto(String sudadera, String sudaderaDeAlgodón, double v, int i) throws Exception {
        model.insertarProducto(sudadera,sudaderaDeAlgodón,v,i);
    }

    public void actualizarInventario(String camisa, int i) throws Exception {
        model.actualizarInventario(camisa,i);
    }

    public void eliminarProducto(String pantalón) throws Exception {
        model.eliminarProducto(pantalón);
    }
}

