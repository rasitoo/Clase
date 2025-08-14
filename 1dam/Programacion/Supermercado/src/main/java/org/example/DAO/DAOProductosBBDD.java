package org.example.DAO;

import org.example.modelo.Cliente;
import org.example.modelo.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOProductosBBDD {
    private Connection conexion;
    public DAOProductosBBDD (Connection con){
        this.conexion=con;
    }
    public boolean anadir(Producto p) {
        try{
            PreparedStatement ps=conexion.prepareStatement("INSERT INTO BDMERCADO.PRODUCTOS (id, nombre, precio,cantidad) VALUES (?,?,?,?)");
            ps.setInt(1,p.getId());
            ps.setString(2,p.getNombre());
            ps.setDouble(3,p.getPrecio());
            ps.setInt(4,p.getCantidad());
            ps.executeUpdate();
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean borrar(int id) {
        try{
            PreparedStatement ps=conexion.prepareStatement("DELETE FROM BDMERCADO.PRODUCTOS WHERE id=?");
            ps.setInt(1,id);
            ps.executeUpdate();
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean modificar(Producto p) {
        try{
            PreparedStatement ps=conexion.prepareStatement("UPDATE BDMERCADO.PRODUCTOS SET cantidad=? WHERE id=?");
            ps.setInt(2,p.getId());
            ps.setInt(1,p.getCantidad());
            ps.executeUpdate();
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Producto buscarProducto (String nombre) {
        try{
            PreparedStatement ps=conexion.prepareStatement("SELECT * FROM BDMERCADO.Productos WHERE nombre=?");
            ps.setString(1,nombre);
            ps.executeQuery();
            ResultSet personaAux=ps.executeQuery();
            if (personaAux.next()) {
                String nombreV=personaAux.getString("nombre");
                int id=personaAux.getInt("id");
                double dinero=personaAux.getDouble("precio");
                int cantidad=personaAux.getInt("cantidad");
                Producto p= new Producto(id,nombre,dinero,cantidad);
                return p;
            }
            else
                return null;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<Producto> obtenerTodosProductos() {
        List<Producto> productos=new ArrayList<>();
        try{
            PreparedStatement ps=conexion.prepareStatement("SELECT * FROM BDMERCADO.PRODUCTOS ");
            ResultSet personaAux=ps.executeQuery();
            while (personaAux.next()) {
                String nombre=personaAux.getString("nombre");
                double dinero=personaAux.getInt("precio");
                int id=personaAux.getInt("id");
                int cantidad=personaAux.getInt("cantidad");
                Producto p= new Producto(id,nombre,dinero,cantidad);
                productos.add(p);
            }
            return productos;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
