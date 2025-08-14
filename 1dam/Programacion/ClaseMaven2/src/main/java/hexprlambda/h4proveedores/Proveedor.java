package hexprlambda.h4proveedores;

import lombok.Data;

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
}

