package hexprlambda.h3productos;

import hexprlambda.ejemprofe.Persona;
import lombok.Data;

/**
 * @author Rodrigo
 * @date 31 marzo, 2024
 */
@Data
public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int cantidad;

    Producto(int id, String nombre, double precio, int cantidad){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    Producto(String nombre){
        this.nombre = nombre;
    }

    public static Producto crearDesdeArray(String []datos) {
        return new Producto(Integer.parseInt(datos[0]),datos[1],Double.parseDouble(datos[2]),Integer.parseInt(datos[3]));
    }
}
