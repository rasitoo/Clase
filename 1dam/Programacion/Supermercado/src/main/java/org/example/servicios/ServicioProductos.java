package org.example.servicios;

import lombok.Data;
import org.example.DAO.DAOBase;
import org.example.DAO.DAOProductos;
import org.example.modelo.Producto;

import java.util.List;

public class ServicioProductos {
    DAOProductos daoProductos= new DAOProductos();
    public static final int ServicioProductos=1;

    public  boolean darAltaProducto(String nombre, double precio, int cantidad) {
        int id=daoProductos.maximoId()+1;
        Producto p= new Producto(id,nombre, precio, cantidad);
        daoProductos.anadir(p);
        return false;

    }

    public  List<Producto>  obtenerListadoProductos() {
        List<Producto>  listaProds= daoProductos.listar();
        return listaProds;
    }

    public boolean existeProducto(int id) {
        Producto p=daoProductos.recuperarPorId(id);
        if (p!=null)
            return true;
        else
            return false;
    }

    public boolean verificarStock(int id, int cant) {
        Producto p=daoProductos.recuperarPorId(id);
        if (p.getCantidad()>=cant)
            return true;
        else
            return false;
    }

    public double comprar(int id, int cant) {
        Producto p=daoProductos.recuperarPorId(id);
        double precioTotal=p.getPrecio() * cant;
        p.setCantidad(p.getCantidad()-cant);
        daoProductos.modificar(p);
        return precioTotal;
    }
}
