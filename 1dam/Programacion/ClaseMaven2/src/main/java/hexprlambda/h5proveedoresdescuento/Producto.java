package hexprlambda.h5proveedoresdescuento;

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

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
    private ArrayList<Proveedor> proveedorArrayList;

    Producto(int id, String nombre, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    Producto(int id, String nombre, double precio, int cantidad, ArrayList<Proveedor> proveedorArrayList) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.proveedorArrayList = proveedorArrayList;
    }

    Producto(String nombre) {
        this.nombre = nombre;
    }

    public static Producto crearDesdeArray(String[] datos) {//Suponemos que nunca acabará la linea del txt con un ;
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        for (int i = 4; i < datos.length; i++) {
            if (datos[i] != null)
                proveedores.add(new Proveedor(datos[i]));
        }
        return new Producto(Integer.parseInt(datos[0]), datos[1], Double.parseDouble(datos[2]), Integer.parseInt(datos[3]), proveedores);
    }

    public double mayorDescuento(ArrayList<Proveedor> proveedores) {
        Optional<Proveedor> maxDesc = proveedores.stream()
                .max(Comparator.comparingDouble(Proveedor::getDescuento));

        return maxDesc.map(Proveedor::getDescuento).orElse(0.0);

    }
}
