package Aparcamiento.DAO;

import Aparcamiento.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public interface DAOCliente {

    boolean anadirCliente(Cliente c);
    boolean borrarCliente(String dni);
    boolean modificarCliente(String dni, Cliente c);
    Cliente buscarCliente(String dni);
    List<Cliente> obtenerTodosClientes();
}
