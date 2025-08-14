package ejercicios.dconexiones;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 05 noviembre, 2024
 */
public class Ej16TablaHtml2 {

    public static void main(String[] args) {
        Ej16TablaHtml2 ej = new Ej16TablaHtml2();
        try (Scanner scanner = new Scanner(System.in)) {
            // Conectar y pedir datos
            try (Connection conexion = ej.conectar()) {
                ej.crearTabla(conexion);
            } catch (SQLException e) {
                System.out.println("Error al conectar o insertar en la base de datos:");
                e.printStackTrace();
            }
        }
    }

    private void crearTabla(Connection conexion) {
        String sql = "SELECT * FROM empleados";
        float cont = 0;
        float suma = 0;

        try (Statement statement = conexion.createStatement(); ResultSet resultSet = statement.executeQuery(sql);) {
            // Construcción del HTML para la tabla
            StringBuilder html = new StringBuilder();
            html.append("<html>\n<head>\n<title>Tabla de Alumnos</title>\n</head>\n<body>\n");
            html.append("<table border='1' style='border-collapse: collapse;'>\n");

            // Imprimir la cabecera de la tabla
            html.append("<tr><th style='padding: 15px; text-align: left;'>apellido</th><th style='padding: 15px; text-align: left;'>oficio</th><th style='padding: 15px; text-align: left;'>salario</th>\n");

            // Agregar filas de datos
            while (resultSet.next()) {
                String ape = resultSet.getString("apellido");
                String ofi = resultSet.getString("oficio");
                float sal = resultSet.getInt("salario");
                cont++;
                suma += sal;
                System.out.println(ape + " " + ofi + " " + sal + "€");

                html.append("<tr>")
                        .append("<td style='padding: 15px;'>").append(ape).append("</td>")
                        .append("<td style='padding: 15px;'>").append(ofi).append("</td>")
                        .append("<td style='padding: 15px;'>").append(sal).append("</td>")
                        .append("</tr>\n");
            }

            // Cierre de la tabla y el HTML
            html.append("</table>\n<h3>El salario promedio es: " + suma / cont + "€</h3></body>\n</html>");

            // Crear un archivo HTML
            File file = new File("tabla_empleados_generada.html");
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(html.toString());
            }

            // Abrir el archivo HTML en el navegador predeterminado
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(file.toURI());
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
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
