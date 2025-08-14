package iherencia.i1supermercado.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Rodrigo
 * @date 09 abril, 2024
 */
@Data
@AllArgsConstructor
public class Producto {
    int id;
    String nombre;
    private double preciooriginal;
    private int stock;
    private LocalDate fechacaducidad;
    private double preciooferta;
    private LocalDate findescuento;

    public Producto(int id, String nombre, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.preciooriginal = precio;
        this.stock = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id == producto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
