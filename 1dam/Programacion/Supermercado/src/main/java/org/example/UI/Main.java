package org.example.UI;

import BBDD.example.Configuracion.ConexionBD;
import BBDD.example.Configuracion.DAOPersonaImpl;
import BBDD.example.Configuracion.Persona;
import org.example.DAO.DAOClientes;
import org.example.DAO.DAOProductos;
import org.example.DAO.DAOProductosBBDD;
import org.example.modelo.Cliente;
import org.example.modelo.Producto;
import org.example.servicios.ServicioProductosBBDD;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Prueba conexión BD");
        ConexionBD conexion=new ConexionBD();
        try(Connection con=conexion.getConexionBD()) {
            System.out.println(con);
            DAOProductosBBDD dao=new DAOProductosBBDD(con);
           // ServicioProductosBBDD services=new ServicioProductosBBDD();
            Producto p1=new Producto(1,"pp",27.5,50);
            Producto p2=new Producto(1,"pp",27.5,50);
            Producto p3=new Producto(1,"pp",27.5,50);
            Producto p4=new Producto(1,"pp",27.5,50);

            dao.obtenerTodosProductos().stream().forEach(System.out::println);
            dao.modificar( new Producto(5, "Pepe2", 33,66));
            dao.obtenerTodosProductos().stream().forEach(System.out::println);
            // System.out.println("Persona encontrada: "+dao.buscarPersona(1));

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conexion.getConexionBD() != null) {
                    conexion.getConexionBD().close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

