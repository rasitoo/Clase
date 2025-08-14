package mongodb.ejer3.model;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rodrigo
 * @date 24 febrero, 2025
 */

public class Model {
    private MongoCollection<Document> collection;

    public Model(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public List<Document> getPorDescripcion() throws Exception {
        FindIterable<Document> productosMezclilla = collection.find(regex("descripcion", "mezclilla", "i"));
        return productosMezclilla.into(new ArrayList<>());
    }

    public List<Document> getPorInventario() throws Exception {
        FindIterable<Document> productosInventarioAlto = collection.find(gt("inventario", 15));
        return productosInventarioAlto.into(new ArrayList<>());
//        System.out.println("Productos con inventario mayor a 15:");
//        for (Document doc : productosInventarioAlto) {
//            System.out.println(doc.toJson());
//        }
    }

    public Document getPrecioMasAlto() throws Exception {
        return collection.find().sort(new Document("precio", -1)).first();
//        if (productoMasCaro != null) {
//            System.out.println("Producto con el precio más alto: " + productoMasCaro.toJson());
//        } else {
//            System.out.println("No se encontraron productos.");
//        }
    }

    public void insertarProducto(String nombre, String descripcion, double precio, int inventario) throws Exception {
        Document nuevoProducto = new Document("nombre", nombre)
                .append("descripcion", descripcion)
                .append("precio", precio)
                .append("inventario", inventario);
        collection.insertOne(nuevoProducto);
    }

    public void actualizarInventario(String nombre, int inventarioActualizado) throws Exception {
        collection.updateOne(eq("nombre", nombre), new Document("$set", new Document("inventario", inventarioActualizado)));
    }

    public void eliminarProducto(String nombre) throws Exception {
        collection.deleteOne(eq("nombre", nombre));
    }
}