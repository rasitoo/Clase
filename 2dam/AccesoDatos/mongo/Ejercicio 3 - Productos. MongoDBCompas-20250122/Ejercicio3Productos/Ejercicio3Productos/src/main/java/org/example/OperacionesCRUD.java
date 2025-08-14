package org.example;

import com.mongodb.client.*;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.AggregateIterable;
import java.util.Arrays;

public class OperacionesCRUD {

    private MongoCollection<Document> coleccionproductos;

    public OperacionesCRUD(MongoCollection<Document> coleccionproductos) {
        this.coleccionproductos = coleccionproductos;
    }

    public void mostrarPorDescripcion() {
        /* a implementar por el alumno */

    }

    public void mostrarPorInventario() {
        /* a implementar por el alumno */

    }

    public void mostrarPrecioMasAlto() {
        /* a implementar por el alumno */

    }

    public void insertarProducto(String nombre, String descripcion, double precio, int inventario) {
        /* a implementar por el alumno */

    }

    public void actualizarInventario(String nombre, int Inventarioactual) {
        /* a implementar por el alumno */

    }

    public void eliminarProducto(String nombre) {
        /* a implementar por el alumno */

    }

}


