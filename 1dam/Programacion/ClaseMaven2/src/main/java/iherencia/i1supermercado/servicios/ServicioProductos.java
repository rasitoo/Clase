package iherencia.i1supermercado.servicios;

import iherencia.i1supermercado.*;
import iherencia.i1supermercado.DAO.DAOProductos;
import iherencia.i1supermercado.modelo.Producto;
import lombok.Data;

import java.util.List;

public class ServicioProductos {
    DAOProductos daoProductos = new DAOProductos();
    public static final int ServicioProductos = 1;

    public boolean darAltaProducto(String nombre, double precio, int cantidad) {
        int id = daoProductos.maximoId() + 1;
        Producto p = new Producto(id, nombre, precio, cantidad);
        daoProductos.anadir(p);
        return false;

    }

    public List<Producto> obtenerListadoProductos() {
        List<Producto> listaProds = daoProductos.listar();
        return listaProds;
    }

    public boolean existeProducto(int id) {
        Producto p = daoProductos.recuperarPorId(id);
        if (p != null)
            return true;
        else
            return false;
    }

    public boolean verificarStock(int id, int cant) {
        Producto p = daoProductos.recuperarPorId(id);
        if (p.getStock() >= cant)
            return true;
        else
            return false;
    }

    public double comprar(int id, int cant) {
        Producto p = daoProductos.recuperarPorId(id);
        double precioTotal = p.getPreciooriginal() * cant;
        p.setStock(p.getStock() - cant);
        daoProductos.modificar(p);
        return precioTotal;
    }
}
