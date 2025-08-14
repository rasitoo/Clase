package ejercicios.dconexiones;

import java.sql.*;
import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 05 noviembre, 2024
 */
public class Ej4TablaValidando {

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
        // Paso 4: Crear una consulta SQL para insertar registros
        String sql = "INSERT INTO alumnos (id, nombre, apellido, edad, nota) VALUES( ?,?,?,?,?)";
        // Paso 5: Preparar el PreparedStatement
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            // Validar si el ID ya existe
            System.out.print("Ingrese el ID del alumno: ");
            int id = scanner.nextInt();
            if (existeId(conexion, id)) {
                System.out.println("El ID ya existe. Por favor, ingrese un ID diferente.");
                return;
            }

            // Validar la edad
            System.out.print("Ingrese la edad del alumno: ");
            int edad = scanner.nextInt();
            if (edad < 0 || edad > 99) {
                System.out.println("La edad debe ser un número de uno o dos dígitos.");
                return;
            }

            // Pedir el resto de los datos
            System.out.print("Ingrese el nombre del alumno: ");
            String nombre = scanner.next();
            System.out.print("Ingrese los apellidos del alumno: ");
            String apellido = scanner.next();
            System.out.print("Ingrese la nota del alumno: ");
            double nota = scanner.nextDouble();
            if (nota > 10) {
                System.out.println("La nota no puede ser mayor de 10.");
                return;
            }

            // Paso 7: Asignar los valores a la consulta SQL
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, apellido);
            preparedStatement.setInt(4, edad);
            preparedStatement.setDouble(5, nota);

            // Paso 8: Ejecutar la consulta
            int filasInsertadas = preparedStatement.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Se ha insertado correctamente un nuevo alumno.");
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
