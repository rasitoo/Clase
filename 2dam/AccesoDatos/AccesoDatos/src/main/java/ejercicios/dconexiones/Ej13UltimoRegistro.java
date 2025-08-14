package ejercicios.dconexiones;

import java.sql.*;
import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 05 noviembre, 2024
 */
public class Ej13UltimoRegistro {

    public static void main(String[] args) {
        Ej13UltimoRegistro ej = new Ej13UltimoRegistro();
        // Conectar y pedir datos
        try (Connection conexion = ej.conectar()) {
            ej.mostrarUltimoPrimeraOpcion(conexion);
            ej.mostrarUltimoSegundaOpcion(conexion);
        } catch (SQLException e) {
            System.out.println("Error al conectar o insertar en la base de datos:");
            e.printStackTrace();
        }

    }

    private void mostrarUltimoSegundaOpcion(Connection conexion) {
        String sql = "SELECT * FROM alumnos";
        try (Statement statement = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); ResultSet resultSet = statement.executeQuery(sql);) {
            if (resultSet.first()) { //falla mas que el otro, no se por que
                int ide = resultSet.getInt("id");
                String nom = resultSet.getString("nombre");
                String ape = resultSet.getString("apellido");
                int ed = resultSet.getInt("edad");
                int no = resultSet.getInt("nota");
                System.out.println("Identificador : " + ide);
                System.out.println("Nombre        : " + nom);
                System.out.println("Apellido      : " + ape);
                System.out.println("Edad          : " + ed);
                System.out.println("Nota          : " + no);
                System.out.println();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void mostrarUltimoPrimeraOpcion(Connection conexion) {
        String sql = "SELECT * FROM alumnos ORDER BY id DESC limit 1";
        try (Statement statement = conexion.createStatement(); ResultSet resultSet = statement.executeQuery(sql);) {
            while (resultSet.next()) {
                int ide = resultSet.getInt("id");
                String nom = resultSet.getString("nombre");
                String ape = resultSet.getString("apellido");
                int ed = resultSet.getInt("edad");
                int no = resultSet.getInt("nota");
                System.out.println("Identificador : " + ide);
                System.out.println("Nombre        : " + nom);
                System.out.println("Apellido      : " + ape);
                System.out.println("Edad          : " + ed);
                System.out.println("Nota          : " + no);
                System.out.println();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
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
}
