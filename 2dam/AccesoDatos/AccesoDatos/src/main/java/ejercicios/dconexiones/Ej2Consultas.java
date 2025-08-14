package ejercicios.dconexiones;

/**
 * @author Rodrigo
 * @date 29 octubre, 2024
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ej2Consultas {
    public static void main(String[] args) {
// Paso 1: Definir la URL de conexión de la base de datos
        String url = "jdbc:mysql://localhost:3306/ejemplos"; // Cambia "ejemplos" por tubase de datos
// Paso 2: Definir usuario y contraseña de la base de datos
        String usuario = "root";
        String contraseña = "";
// Paso 3: Establecer la conexión
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
// En la variable connection guardamos la conexion a la base de datos
            connection = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión CORRECTA a la base de datos MYSQL.");
            System.out.println("Ya puedes seguir realizando las operaciones de consulta, modificar, borrar o insertar.");
// Paso 4. Proceso de Consulta
            statement = connection.createStatement();  // Crear el statement
            String sql = "SELECT * FROM alumnos";
// Ejecutar la consulta
            resultSet = statement.executeQuery(sql);   // Utilizar executeQuery
// Paso 5. Procesar los resultados. SOLO queremos sacar el id y el nombre.
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
            }

// Paso 6: Cerrar los recursos
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos:");
            e.printStackTrace();
        } finally {
// Paso 7: Asegurar el cierre de recursos en caso de error
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
