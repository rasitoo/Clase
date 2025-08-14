package ejercicios.dconexiones;

import java.sql.*;
import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 06 noviembre, 2024
 */
public class Ej12Funciones {
    public static void main(String[] args) {
        Ej12Funciones ej = new Ej12Funciones();
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

    private void visualizarEmpPorDept(Connection conexion, Scanner scanner) {;
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
                    System.out.println("\t" + resultSet.getString("apellido") + " * " + resultSet.getFloat("salario") + " ** " + resultSet.getString("oficio"));
                }
                visualizarMediaYEmpleados(conexion, numdep);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void visualizarMediaYEmpleados(Connection conexion, int dept_no) {
        double salario = 0;
        double cont = 0;
        String sql = "SELECT avg(salario), count(emp_no) FROM empleados WHERE dept_no = ? ";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, dept_no);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {

                resultSet.next();

                System.out.println("--------------------------------------");
                System.out.println("Salario Medio: " + resultSet.getFloat(1));
                System.out.println("N mero de empleados: " + resultSet.getInt(2));
                System.out.println("======================================");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String nombreDept(Connection conexion, int numdep) {
        String sql ="{ ? = call EJEMPLO12(?) } ";
        String nombre = "";

        try(CallableStatement llamada = conexion.prepareCall(sql);) {
            llamada.registerOutParameter(1, Types.VARCHAR); // valor devuelto
            llamada.setInt(2, numdep); // param de entrada

            llamada.executeUpdate(); // ejecutar el procedimiento
            nombre = llamada.getString(1);// recupero el nombre dep
        } catch (NumberFormatException nfe) {
            System.out.println("DEPARTAMENTO INCORRECTO...");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nombre;
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
