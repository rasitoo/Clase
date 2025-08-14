package ejercicios.dconexiones;

import java.sql.*;
import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 05 noviembre, 2024
 */
public class Ej8ConsultarEmpleados {

    public static void main(String[] args) {
        Ej8ConsultarEmpleados ej = new Ej8ConsultarEmpleados();
        // Conectar y pedir datos
        try (Connection conexion = ej.conectar()) {
            ej.leerDatos(conexion);
            ej.mayorSalario(conexion);
        } catch (SQLException e) {
            System.out.println("Error al conectar o insertar en la base de datos:");
            e.printStackTrace();
        }
    }

    public Connection conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ejemplos";
        String usuario = "root";
        String contrasena = "";
        Connection conexion = DriverManager.getConnection(url, usuario, contrasena);
        System.out.println("Conexión CORRECTA a la base de datos.");
        return conexion;
    }

    public void leerDatos(Connection conexion) throws SQLException {
        float cont = 0;
        float suma = 0;
        String sql = "SELECT em.apellido, em.oficio, em.salario FROM empleados em, departamentos dep where dep.dept_no = em.dept_no and dep.dept_no = 10";
        try (Statement statement = conexion.createStatement(); ResultSet resultSet = statement.executeQuery(sql);) {
            while (resultSet.next()) {
                String ape = resultSet.getString("apellido");
                String ofi = resultSet.getString("oficio");
                float sal = resultSet.getInt("salario");
                cont++;
                suma += sal;
                System.out.println(ape + " " + ofi + " " + sal + "€");
            }
            System.out.println("El salario promedio es: " + suma / cont + "€");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void mayorSalario(Connection conexion) throws SQLException {
        String sql = "SELECT apellido, salario FROM empleados where salario = (SELECT MAX(salario) FROM empleados)";

        try (Statement statement = conexion.createStatement(); ResultSet resultSet = statement.executeQuery(sql);) {
            while (resultSet.next()) {
                String ape = resultSet.getString("apellido");
                float sal = resultSet.getInt("salario");
                System.out.println("EMPLEADO CON MAS SALARIO: " + ape + " " + sal + "€");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
