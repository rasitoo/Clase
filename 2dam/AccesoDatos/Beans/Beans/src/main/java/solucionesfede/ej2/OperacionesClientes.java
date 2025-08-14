package solucionesfede.ej2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperacionesClientes {
    public List<Cliente> obtenerClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Connection conn = Conexion.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setEmail(rs.getString("correo"));
                cliente.setTelefono(rs.getString("telefono"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public void agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (id, nombre, correo, telefono) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getEmail());
            pstmt.setString(3, cliente.getTelefono());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

