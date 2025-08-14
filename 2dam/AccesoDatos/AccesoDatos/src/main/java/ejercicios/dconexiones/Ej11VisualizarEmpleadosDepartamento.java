package ejercicios.dconexiones;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 06 noviembre, 2024
 */
public class Ej11VisualizarEmpleadosDepartamento {
    public static void main(String[] args) {
        Ej11VisualizarEmpleadosDepartamento ej = new Ej11VisualizarEmpleadosDepartamento();
        try (Scanner sc = new Scanner(System.in)) {
            // Conectar y pedir datos
            try (Connection conexion = ej.conectar()) {
                ej.visualizarEmpPorDept(conexion, sc);
            } catch (SQLException e) {
                System.out.println("Error al conectar o insertar en la base de datos:");
                e.printStackTrace();
            }
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

    private void visualizarEmpPorDept(Connection conexion, Scanner scanner) {
        double salario = 0;
        double cont = 0;
        String sql = "select apellido, salario, oficio from empleados where dept_no = ?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            System.out.print("Ingrese el numero de departamento ");
            int numdep = scanner.nextInt();
            if (!existeDept(conexion, numdep)) {
                System.out.println("El numero de departamento no existe. Por favor, ingrese un numero de departamento diferente.");
                return;
            }

            preparedStatement.setInt(1, numdep);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                System.out.println("=============================================================");
                System.out.println("DEPARTAMENTO: "+ numdep +" ==> " + nombreDept(conexion, numdep));
                System.out.println("=============================================================");

                while (resultSet.next()) {
                    salario += resultSet.getFloat("salario");
                    cont++;
                    System.out.println("\t" + resultSet.getString("apellido") + " * " + resultSet.getFloat("salario") + " ** " + resultSet.getString("oficio"));
                }
                System.out.println("-------------------------------------------------------------");
                System.out.println("Salario Medio: " + salario / cont);
                System.out.println("Número de empleados: " + (int)cont);
                System.out.println("=============================================================");


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String nombreDept(Connection conexion, int numdep) {
    String sql = "select dnombre from departamentos where dept_no = ?";

    try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
        preparedStatement.setInt(1, numdep);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getString(1);
            } else {
                return null;
            }
        }

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}


    private boolean existeDept(Connection conexion, int numdep) {
        String sql = "SELECT COUNT(*) FROM departamentos WHERE dept_no = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, numdep);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                return resultSet.getInt(1) > 0;
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
