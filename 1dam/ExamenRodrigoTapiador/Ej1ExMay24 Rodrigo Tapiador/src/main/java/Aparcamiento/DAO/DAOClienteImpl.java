package Aparcamiento.DAO;

import Aparcamiento.DAO.Configuracion.ConexionBD;
import Aparcamiento.modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class DAOClienteImpl implements DAOCliente{
    private Map<String,Cliente> clientes = new Hashtable<String,Cliente>();
    public DAOClienteImpl(){
        clientes= new Hashtable();
    }

    @Override
    public boolean anadirCliente(Cliente c) {
        if(c==null) return false;
        clientes.put(c.getDni(), c);
        return true;
    }

    @Override
    public boolean borrarCliente(String dni) {
        return false;
    }

    @Override
    public boolean modificarCliente(String dni, Cliente c) {
        return false;
    }

    @Override
    public Cliente buscarCliente(String dni) {
        return clientes.get(dni);
    }

    @Override
    public List<Cliente> obtenerTodosClientes() {
        return null;
    }

}
