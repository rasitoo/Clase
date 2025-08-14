package solucionesfede.ej1;

import java.util.ArrayList;
import java.util.List;

public class GestorDatos {
    private List<Cliente> clientes;
    private List<Producto> productos;

    public GestorDatos() {
        clientes = new ArrayList<>();
        productos = new ArrayList<>();
    }

    public List<Cliente> obtenerClientes() {
        return clientes;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Producto> obtenerProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
}

