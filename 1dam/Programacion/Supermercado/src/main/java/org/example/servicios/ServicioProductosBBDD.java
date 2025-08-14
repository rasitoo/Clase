package org.example.servicios;

import BBDD.example.Configuracion.ConexionBD;
import lombok.Data;
import org.example.DAO.DAOClientes;
import org.example.DAO.DAOProductosBBDD;
import org.example.modelo.Cliente;
import org.example.modelo.Producto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
@Data
public class ServicioProductosBBDD {
    private Connection con;
    public ServicioProductosBBDD(ConexionBD conexion) throws SQLException, ClassNotFoundException {
        con=conexion.getConexionBD();
    }

    public boolean anadirProducto(String nombre, double precio, int cantidad) throws Exception {
        int id=0;
        try {
            DAOProductosBBDD actual=new DAOProductosBBDD(con);
            List<Producto> sacarUltimo = actual.obtenerTodosProductos();
            if (!sacarUltimo.isEmpty()){
            id= sacarUltimo.get(sacarUltimo.size()-1).getId()+1;
            Producto p= new Producto(id,nombre, precio, cantidad);
            actual.anadir(p);
            }
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;}
    }
    public double modificarProducto(Producto p, int cantidad){
        double gastoTotal=0;
        try {
            DAOProductosBBDD actual=new DAOProductosBBDD(con);
            Producto aModificar= actual.buscarProducto(p.getNombre());
                aModificar.setCantidad(aModificar.getCantidad() - cantidad);
                actual.modificar(aModificar);
                gastoTotal=aModificar.getPrecio()*aModificar.getCantidad();
                return  gastoTotal;
            }
        catch (Exception e){
            System.out.println(e.getMessage());
            return 0;}
    }
    public Producto comprarProducto(String nombre ){
        try {
            DAOProductosBBDD actual=new DAOProductosBBDD(con);
            Producto aComprar= actual.buscarProducto(nombre);
            return aComprar;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;}
    }
    public List<Producto> obtenerTodosProductos(){
        try {
            DAOProductosBBDD actual=new DAOProductosBBDD(con);
            List<Producto> sacarTodos = actual.obtenerTodosProductos();
            return sacarTodos;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;}
    }
    public boolean verificarStock(Producto p, int cant) {
        if (p.getCantidad()>=cant)
            return true;
        else
            return false;
    }
}
