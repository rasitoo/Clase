package ejercicio2jdbc;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 03 diciembre, 2024
 */
public class Ejer2Logica {
    public Connection conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ejemplos";
        String usuario = "root";
        String contrasena = "";
        Connection conexion = DriverManager.getConnection(url, usuario, contrasena);
        System.out.println("Conexión CORRECTA a la base de datos.");
        return conexion;
    }

    public void ejecutarOpcion(Connection conexion, Scanner scanner) {
        while (true) {
            mostrarMenu();
            switch (scanner.next()) {
                case "1":
                    opcionUno(conexion);
                    break;
                case "2":
                    opcionDos(conexion);
                    break;
                case "3":
                    opcionTres(conexion);
                    break;
                case "4":
                    opcionCuatro(conexion);
                    break;
                case "5":
                    opcionCinco(conexion);
                    break;
                case "6":
                    opcionSeis(conexion);
                    break;
                case "7":
                    opcionSiete(conexion);
                    break;
                case "8":
                    opcionOcho(conexion);
                    break;

                case "0":
                    System.out.println("Cerrando...");
                    return;
                default:
                    System.out.println("Opción incorrecta");
            }
        }
    }

    private void opcionOcho(Connection conexion) {
    }

    private void opcionSiete(Connection conexion) {
    }

    private void opcionSeis(Connection conexion) {
    }

    private void opcionCinco(Connection conexion) {
    }

    private void opcionCuatro(Connection conexion) {
        String sql = "select hospitales.nombre from hospitales where num_plazas = (select max(num_plazas) from hospitales)";
        try (Statement statement = conexion.createStatement(); ResultSet resultSet = statement.executeQuery(sql);) {
            while (resultSet.next()) {
                String nombre = resultSet.getString(1);
                System.out.println("Hospital con mayor número de plazas: " + nombre);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void opcionTres(Connection conexion) {
        String sql = "select hospitales.cod_hospital,count(*) from hospitales join ejemplos.medicos m on hospitales.cod_hospital = m.cod_hospital where m.cod_hospital= hospitales.cod_hospital group by hospitales.cod_hospital;";
        try (Statement statement = conexion.createStatement(); ResultSet resultSet = statement.executeQuery(sql);) {
            while (resultSet.next()) {
                int cod_hospital = resultSet.getInt("cod_hospital");
                int num = resultSet.getInt(2);
                System.out.println("Código Hospital: " + cod_hospital + ", Número de Empleados: " + num);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void opcionDos(Connection conexion) {

        String sql = "SELECT * FROM hospitales order by cod_hospital asc ";
        try (Statement statement = conexion.createStatement(); ResultSet resultSet = statement.executeQuery(sql);) {
            StringBuilder html = new StringBuilder();
            html.append("<html>\n<head>\n<title>Tabla de hospitales</title>\n</head>\n<body>\n<h1>Listado de Hospitales</h1>\n");
            html.append("<table border='1' style='border-collapse: collapse;'>\n");

            html.append("<tr><th style='padding: 15px; text-align: left;'>Código Hospital</th><th style='padding: 15px; text-align: left;'>Nombre</th><th style='padding: 15px; text-align: left;'>Dirección</th><th style='padding: 15px; text-align: left;'>Número de plazas</th></tr>\n");

            while (resultSet.next()) {
                int codHospital = resultSet.getInt("cod_hospital");
                String nombre = resultSet.getString("nombre");
                String direccion = resultSet.getString("direccion");
                int numPlazas = resultSet.getInt("num_plazas");

                html.append("<tr>")
                        .append("<td style='padding: 15px;'>").append(codHospital).append("</td>")
                        .append("<td style='padding: 15px;'>").append(nombre).append("</td>")
                        .append("<td style='padding: 15px;'>").append(direccion).append("</td>")
                        .append("<td style='padding: 15px;'>").append(numPlazas).append("</td>")
                        .append("</tr>\n");
            }

            html.append("</table>\n</body>\n</html>");

            File file = new File("tabla_hospitales.html");
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(html.toString());
            }

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(file.toURI());
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void opcionUno(Connection conexion) {
        String sql = "SELECT * FROM medicos order by cod_hospital desc ";
        try (Statement statement = conexion.createStatement(); ResultSet resultSet = statement.executeQuery(sql);) {
            StringBuilder html = new StringBuilder();
            html.append("<html>\n<head>\n<title>Tabla de medicos</title>\n</head>\n<body>\n<h1>Listado de Médicos</h1>\n");
            html.append("<table border='1' style='border-collapse: collapse;'>\n");

            html.append("<tr><th style='padding: 15px; text-align: left;'>DNI</th><th style='padding: 15px; text-align: left;'>Apellidos</th><th style='padding: 15px; text-align: left;'>Especialidad</th><th style='padding: 15px; text-align: left;'>Código Hospital</th></tr>\n");

            while (resultSet.next()) {
                int dni = resultSet.getInt("dni");
                String ape = resultSet.getString("apellidos");
                String esp = resultSet.getString("especialidad");
                int codhosp = resultSet.getInt("cod_hospital");

                html.append("<tr>")
                        .append("<td style='padding: 15px;'>").append(dni).append("</td>")
                        .append("<td style='padding: 15px;'>").append(ape).append("</td>")
                        .append("<td style='padding: 15px;'>").append(esp).append("</td>")
                        .append("<td style='padding: 15px;'>").append(codhosp).append("</td>")
                        .append("</tr>\n");
            }

            html.append("</table>\n</body>\n</html>");

            File file = new File("tabla_medicos.html");
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(html.toString());
            }

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(file.toURI());
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void mostrarMenu() {
        System.out.println("Menú ");
        System.out.println("1. Consultar todos los medicos en html");
        System.out.println("2. Consultar todos los hospitales en html");
        System.out.println("3. Obtener empleados por hospital");
        System.out.println("4. Obtener hospital con mas plazas");
        System.out.println("5. Insertar hospital con mas de 250 plazas");
        System.out.println("6. Insertar medico (cirujano, psiquiatra o dermatologo)");
        System.out.println("7. Modificar plazas hospital");
        System.out.println("8. Borrar primer y ultimo registro");
        System.out.println("0. Salir");
    }
}
