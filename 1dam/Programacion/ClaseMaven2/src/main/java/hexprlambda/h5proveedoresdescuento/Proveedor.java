package hexprlambda.h5proveedoresdescuento;

import lombok.Data;

import java.util.ArrayList;

/**
 * @author Rodrigo
 * @date 04 abril, 2024
 */
@Data
public class Proveedor {
    private String nombre;
    private double descuento;

    Proveedor(String nombre){
        this.nombre = nombre;
    }
    Proveedor(String nombre, double descuento){
        this.nombre = nombre;
        this.descuento = descuento;
    }
    public static Proveedor crearDesdeArray(String []datos) {//Suponemos que nunca acabará la linea del txt con un ;
        return new Proveedor(datos[0],Double.parseDouble(datos[1]));
    }
}

