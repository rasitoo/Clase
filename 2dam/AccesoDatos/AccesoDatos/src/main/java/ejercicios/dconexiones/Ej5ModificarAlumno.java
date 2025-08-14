package ejercicios.dconexiones;

import java.sql.*;
import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 05 noviembre, 2024
 */
public class Ej5ModificarAlumno {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Conectar y pedir datos
            try (Connection conexion = conectar()) {
                pedirDatos(conexion, scanner);
            } catch (SQLException e) {
                System.out.println("Error al conectar o insertar en la base de datos:");
                e.printStackTrace();
            }
        }
    }

    public static Connection conectar() throws SQLException {
        // Paso 1: Definir la URL de conexión de la base de datos
        String url = "jdbc:mysql://localhost:3306/ejemplos";
        // Paso 2: Definir usuario y contraseña de la base de datos
        String usuario = "root";
        String contrasena = "";
        // Paso 3: Establecer la conexión
        Connection conexion = DriverManager.getConnection(url, usuario, contrasena);
        System.out.println("Conexión CORRECTA a la base de datos.");
        return conexion;
    }

    public static void pedirDatos(Connection conexion, Scanner scanner) throws SQLException {
        System.out.print("Ingrese el ID del alumno: ");
        int id = scanner.nextInt();
        if (!existeId(conexion, id)) {
            System.out.println("El ID no existe. Por favor, ingrese un ID diferente.");
            return;
        }
        String sql = "UPDATE alumnos SET nota = ? WHERE id = id";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            System.out.print("Ingrese la nota del alumno: ");
            double nota = scanner.nextDouble();
            if (nota > 10 || nota < 0) {
                System.out.println("La nota no puede ser mayor de 10 o menor que 0.");
                return;
            }
            preparedStatement.setDouble(1, nota);

            int filasInsertadas = preparedStatement.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Se ha modificado correctamente el alumno.");
            }
        }
    }

    private static boolean existeId(Connection conexion, int id) throws SQLException {
        String sql = "SELECT COUNT(*) FROM alumnos WHERE id = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                return resultSet.getInt(1) > 0;
            }
        }
    }
}
