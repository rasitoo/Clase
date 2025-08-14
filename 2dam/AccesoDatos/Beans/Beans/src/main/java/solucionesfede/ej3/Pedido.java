package solucionesfede.ej3;

import java.io.Serializable;

public class Pedido implements Serializable {
    private int id;
    private int clienteId;
    private int productoId;
    private int cantidad;

    public Pedido() {}

    public Pedido(int id, int clienteId, int productoId, int cantidad) {
        this.id = id;
        this.clienteId = clienteId;
        this.productoId = productoId;
        this.cantidad = cantidad;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }

    public int getProductoId() { return productoId; }
    public void setProductoId(int productoId) { this.productoId = productoId; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}

