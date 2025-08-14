package org.example.servicios;

import BBDD.example.Configuracion.ConexionBD;
import org.example.DAO.DAOClientes;
import org.example.modelo.Cliente;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ServicioClientes {
    Connection con;
    public ServicioClientes(ConexionBD conexion) throws SQLException, ClassNotFoundException {
        con=conexion.getConexionBD();
    }
    public boolean anadirCliente(String nombre) throws Exception {
        try {
            DAOClientes actual=new DAOClientes(con);
            int id= actual.obtenerUltimaId()+1;
            Cliente p=new Cliente(id,nombre,0);
            actual.anadir(p);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;}
    }
    public boolean eliminarCliente(Cliente p){
        try {
            DAOClientes actual=new DAOClientes(con);
            actual.borrar(p.getId());
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;}
    }
    public boolean modificarCliente(Cliente p, double dineroGastado){
        try {
            DAOClientes actual=new DAOClientes(con);
            Cliente aModificar= actual.buscarCliente(p.getId());
            aModificar.setDineroGastado(aModificar.getDineroGastado()+dineroGastado);
            actual.modificar(aModificar);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;}
    }
    public Cliente UsuarioCliente(int id) {
        try {
            DAOClientes actual=new DAOClientes(con);
            Cliente aMeterse= actual.buscarCliente(id);
            return aMeterse;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;}
    }
    public List<Cliente> obtenerTodosClientes(){
        try {
            DAOClientes actual=new DAOClientes(con);
            List<Cliente> sacarTodos = actual.obtenerTodosClientes();
            return sacarTodos;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;}
    }
}


