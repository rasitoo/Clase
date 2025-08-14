package org.example.DAO;

import org.example.modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOClientes {
    private Connection conexion;

    public DAOClientes(Connection con) {
        this.conexion = con;
    }

    public boolean anadir(Cliente p) {
        try {
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO BDMERCADO.CLIENTES (id, nombre, dinerogastado) VALUES (?,?,?)");
            ps.setInt(1, p.getId());
            ps.setString(2, p.getNombre());
            ps.setDouble(3, p.getDineroGastado());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean borrar(int id) {
        try {
            PreparedStatement ps = conexion.prepareStatement("DELETE FROM BDMERCADO.CLIENTES WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean modificar(Cliente p) {
        try {
            PreparedStatement ps = conexion.prepareStatement("UPDATE BDMERCADO.CLIENTES SET nombre=?, dinerogastado=? WHERE id=?");
            ps.setInt(2, p.getId());
            ps.setString(1, p.getNombre());
            ps.setDouble(3, p.getDineroGastado());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Cliente buscarCliente(int id) {
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM BDMERCADO.CLIENTES WHERE id=?");
            ps.setInt(1, id);
            ps.executeQuery();
            ResultSet personaAux = ps.executeQuery();
            if (personaAux.next()) {
                String nombre = personaAux.getString("nombre");
                double dinero = personaAux.getDouble("dinerogastado");
                Cliente p = new Cliente(id, nombre, dinero);
                return p;
            } else
                return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Cliente> obtenerTodosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM BDMERCADO.CLIENTES ");
            ResultSet personaAux = ps.executeQuery();
            while (personaAux.next()) {
                String nombre = personaAux.getString("nombre");
                double dinero = personaAux.getInt("dinerogastado");
                int id = personaAux.getInt("id");
                Cliente p = new Cliente(id, nombre, dinero);
                clientes.add(p);
            }
            return clientes;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int obtenerUltimaId() {
        int id = -1;
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT max(id) FROM BDMERCADO.CLIENTES");
            ResultSet personaAux = ps.executeQuery();
            if (personaAux.next()) {
                id = personaAux.getInt("max(id)");
            }
            return id;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return id;
        }
    }

    public static void main(String[] args) {

    }
}
