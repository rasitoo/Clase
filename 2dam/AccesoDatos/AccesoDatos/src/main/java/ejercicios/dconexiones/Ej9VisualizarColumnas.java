package ejercicios.dconexiones;

import java.sql.*;
import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 06 noviembre, 2024
 */
public class Ej9VisualizarColumnas {
    public static void main(String[] args) {
        Ej9VisualizarColumnas ej = new Ej9VisualizarColumnas();
        // Conectar y pedir datos
        try (Connection conexion = ej.conectar()) {
            ej.leerDatos(conexion);
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
        String sql = "SELECT * FROM empleados";

        try (Statement statement = conexion.createStatement(); ResultSet resultSet = statement.executeQuery(sql);) {
            ResultSetMetaData resultado = resultSet.getMetaData();
            int numerocolumnas = resultado.getColumnCount();
            System.out.println("Número de columnas recuperadas: " + numerocolumnas);
            for (int i = 1; i <= numerocolumnas; i++) {
                System.out.println("columna " + i + ":");
                System.out.println("\tNombre : " + resultado.getColumnName(i));
                System.out.println("\tTipo : " + resultado.getColumnTypeName(i));
                System.out.println("\tPuede ser nula? : " + resultado.isNullable(i));
                System.out.println("\tMáximo ancho de la columna : " + resultado.getColumnDisplaySize(i));
            }
        }
    }
}
