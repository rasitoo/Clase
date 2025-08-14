package org.example.DAO;

import org.example.modelo.Compra;
import org.example.modelo.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOCompras {
    private  Connection conexion;
    public DAOCompras (Connection con){
        this.conexion=con;
    }
    public boolean anadir(Compra p) {
        try{
            PreparedStatement ps=conexion.prepareStatement("INSERT INTO BDMERCADO.COMPRAS (idcliente, idproducto,cantidad) VALUES (?,?,?)");
            ps.setInt(1,p.getIdUusario());
            ps.setInt(2,p.getIdProducto());
            ps.setInt(3,p.getCantidad());
            ps.executeUpdate();
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean modificar(Compra p) {
        try{
            PreparedStatement ps=conexion.prepareStatement("UPDATE BDMERCADO.COMPRAS SET cantidad=? WHERE idcliente=? and idproducto=?");
            ps.setInt(1,p.getCantidad());
            ps.setInt(2,p.getIdUusario());
            ps.setInt(3,p.getIdProducto());
            ps.executeUpdate();
            return true;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public List<Compra> buscarComprasCliente (int idcliente) {
        List<Compra> compras=new ArrayList<>();
        try{
            PreparedStatement ps=conexion.prepareStatement("SELECT * FROM BDMERCADO.COMPRAS WHERE idcliente=?");
            ps.setInt(1,idcliente);
            ps.executeQuery();
            ResultSet personaAux=ps.executeQuery();
            if (personaAux.next()) {
                int idU=personaAux.getInt("idcliente");
                int idP=personaAux.getInt("idproducto");
                int cantidad=personaAux.getInt("cantidad");
                Compra p= new Compra(idU,idP,cantidad);
                compras.add(p);
            }
            return compras;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Compra buscarCompra (Compra p) {
        Compra hecha;
        try{
            PreparedStatement ps=conexion.prepareStatement("SELECT * FROM BDMERCADO.COMPRAS WHERE idcliente=? and idproducto=?");
            ps.setInt(1,p.getIdUusario());
            ps.setInt(2,p.getIdProducto());
            ps.executeQuery();
            ResultSet personaAux=ps.executeQuery();
            if (personaAux.next()) {
                int idU=personaAux.getInt("idcliente");
                int idP=personaAux.getInt("idproducto");
                int cantidad=personaAux.getInt("cantidad");
               hecha= new Compra(idU,idP,cantidad);
                return hecha;
            }
            else { return null;}
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<Compra> obtenerTodasCompras() {
        List<Compra> compras=new ArrayList<>();
        try{
            PreparedStatement ps=conexion.prepareStatement("SELECT * FROM BDMERCADO.COMPRAS ");
            ResultSet personaAux=ps.executeQuery();
            while (personaAux.next()) {
                int idU=personaAux.getInt("idcliente");
                int idP=personaAux.getInt("idproducto");
                int cantidad=personaAux.getInt("cantidad");
                Compra p= new Compra(idU,idP,cantidad);
                compras.add(p);
            }
            return compras;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
