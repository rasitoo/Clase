package org.example.servicios;

import BBDD.example.Configuracion.ConexionBD;
import org.example.DAO.DAOCompras;
import org.example.modelo.Cliente;
import org.example.modelo.Compra;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ServicioCompra {
    Connection con;
    public ServicioCompra(ConexionBD conexion) throws SQLException, ClassNotFoundException {
        con=conexion.getConexionBD();
    }
    public boolean anadirCompra(Compra p) throws Exception {
        try {
            DAOCompras actual=new DAOCompras(con);
            actual.anadir(p);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;}

    }
    public boolean modificarCompra(Compra p){
        try {
            DAOCompras actual=new DAOCompras(con);
            Compra aModificar= actual.buscarCompra(p);
            aModificar.setCantidad(aModificar.getCantidad()+p.getCantidad());
            actual.modificar(aModificar);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;}
    }
    public Compra sacarCompra(Compra p){
        try {
            DAOCompras actual=new DAOCompras(con);
            Compra aBuscar=actual.buscarCompra(p);
            return aBuscar;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;}
    }

    public List<Compra> sacarCompras(Cliente c){
        try {
            DAOCompras actual=new DAOCompras(con);
            List<Compra> sacarCompras = actual.buscarComprasCliente(c.getId());
            return sacarCompras;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;}
    }

}
