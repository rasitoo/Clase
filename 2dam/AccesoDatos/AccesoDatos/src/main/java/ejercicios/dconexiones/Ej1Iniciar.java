package ejercicios.dconexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ej1Iniciar {
    public static void main(String[] args) {
// Paso 1: Definir la URL de conexión de la base de datos
        String url = "jdbc:mysql://localhost:3306/ejemplos";
// Paso 2: Definir usuario y contrasena de la base de datos
        String usuario = "root";
        String contrasena = "";
// Paso 3: Establecer la conexión
        try (Connection conexion = DriverManager.getConnection(url, usuario, contrasena);){
            System.out.println("Conexión CORRECTA a la base de datos.");
            System.out.println(" Ya puedes seguir realizados las operaciones de consulta, modificar, borrar o insertar");
// Aquí puedes realizar operaciones con la base de datos
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos:");
            e.printStackTrace();
        }
    }
}