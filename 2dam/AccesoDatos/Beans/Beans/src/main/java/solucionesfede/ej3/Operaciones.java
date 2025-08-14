package solucionesfede.ej3;

import java.util.ArrayList;
import java.util.List;

public class Operaciones {
    private List<Cliente> clientes;
    private List<Producto> productos;
    private List<Pedido> pedidos;

    public Operaciones() {
        clientes = new ArrayList<>();
        productos = new ArrayList<>();
        pedidos = new ArrayList<>();
        inicializarDatos();
    }

    private void inicializarDatos() {
        clientes.add(new Cliente(1, "Carlos Ruiz", "carlosruiz@gmail.com"));
        clientes.add(new Cliente(2, "josefa diaz", "josefadiaz@gmail.com"));

        productos.add(new Producto(1, "Portatiles", 800.00));
        productos.add(new Producto(2, "Ratones", 500.00));

        pedidos.add(new Pedido(1, 1, 1, 2));
        pedidos.add(new Pedido(2, 2, 2, 1));
    }

    public List<Cliente> GuardarClientes() {
        return clientes;
    }

    public void InsertarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Producto> GuardarProductos() {
        return productos;
    }

    public void InsertarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Pedido> GuardarPedidos() {
        return pedidos;
    }

    public void InsertarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
}

