package ejemplo2;

/**
 * @author Rodrigo
 * @date 12 febrero, 2025
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String url = "jdbc:mysql://localhost:3306/ejemplos";
    private static final String usuario = "root";
    private static final String contrasena = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, usuario, contrasena);
    }
}
