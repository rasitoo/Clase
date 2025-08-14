package ejercicios.dconexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 05 noviembre, 2024
 */
public class Ej3Tabla {
    public static void main(String[] args) {
// Paso 1: Definir la URL de la base de datos, usuario y contrasena
        String url = "jdbc:mysql://localhost:3306/ejemplos";
        String usuario = "root";
        String contrasena = "";
// Paso 2: Variables de conexión
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
// Paso 3: Establecer la conexión a la base de datos
            connection = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexión establecida correctamente a la base de datos.");
// Paso 4: Crear una consulta SQL para insertar registros
            String sql = "INSERT INTO alumnos (id, nombre, apellido, edad, nota) VALUES( ?,?,?,?,?)";
// Paso 5: Preparar el PreparedStatement
            preparedStatement = connection.prepareStatement(sql);
// Paso 6: Pedir los datos del alumno por teclado
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el ID del alumno: ");
            int id = scanner.nextInt();
            System.out.print("Ingrese el nombre del alumno: ");
            String nombre = scanner.next();
            System.out.print("Ingrese los apellidos del alumno: ");
            String apellido = scanner.next();
            System.out.print("Ingrese la edad del alumno: ");
            int edad = scanner.nextInt();
            System.out.print("Ingrese la nota del alumno: ");
            double nota = scanner.nextDouble();
// Paso 7: Asignar los valores a la consulta SQL
            preparedStatement.setInt(1, id);
// Primer parámetro es "id"
            preparedStatement.setString(2, nombre);
// Segundo parámetro es "nombre"
            preparedStatement.setString(3, apellido);  // Tercer parámetro es "apellidos"
            preparedStatement.setInt(4, edad);
// Cuarto parámetro es "edad"
            preparedStatement.setDouble(5, nota);
// Paso 8: Ejecutar la consulta
// Quinto parámetro es "nota"
            int filasInsertadas = preparedStatement.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Se ha insertado correctamente un nuevo alumno.");
            }
// Cerrar el scanner
            scanner.close();
        } catch (SQLException e) {
            System.out.println("Error al conectar o insertar en la base de datos:");
            e.printStackTrace();
        } finally {
// Paso 9: Cerrar recursos
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
