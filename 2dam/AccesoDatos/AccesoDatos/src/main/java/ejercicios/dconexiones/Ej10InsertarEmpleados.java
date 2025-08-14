package ejercicios.dconexiones;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 06 noviembre, 2024
 */
public class Ej10InsertarEmpleados {
    public static void main(String[] args) {
        Ej10InsertarEmpleados ej = new Ej10InsertarEmpleados();
        try (Scanner sc = new Scanner(System.in)) {
            // Conectar y pedir datos
            try (Connection conexion = ej.conectar()) {
                ej.insertar(conexion, sc);
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

    private void insertar(Connection conexion, Scanner scanner) {
        String sql = "INSERT INTO empleados (emp_no, apellido, oficio, dir,fecha_alt, salario, comision, dept_no) VALUES( ?,?,?,?,?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            System.out.print("Ingrese el numero de empleado ");
            int id = scanner.nextInt();
            if (existeEmpleado(conexion, id)) {
                System.out.println("El numero de empleado ya existe. Por favor, ingrese un numero de empleado diferente.");
                return;
            }

            System.out.print("Ingrese el apellido del empleado: ");
            String apellido = scanner.next();

            System.out.print("Ingrese el oficio del empleado: ");
            String oficio = scanner.next();

            System.out.print("Ingrese el numero del director ");
            int dir = scanner.nextInt();
            if (existeEmpleado(conexion, id)) {
                System.out.println("El numero de empleado ya existe. Por favor, ingrese un numero de empleado diferente.");
                return;
            }

            System.out.print("Ingrese el salario ");
            float sal = scanner.nextFloat();
            if (sal <= 0) {
                System.out.println("El numero de departamento no existe. Por favor, ingrese un numero de departamento diferente.");
                return;
            }

            System.out.print("Ingrese la comision ");
            float com = scanner.nextFloat();

            System.out.print("Ingrese el numero de departamento ");
            int numdep = scanner.nextInt();
            if (!existeDept(conexion, numdep)) {
                System.out.println("El numero de departamento no existe. Por favor, ingrese un numero de departamento diferente.");
                return;
            }

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, apellido);
            preparedStatement.setString(3, oficio);
            preparedStatement.setInt(4, dir);
            preparedStatement.setDate(5, Date.valueOf(LocalDate.now()));
            preparedStatement.setDouble(6, sal);
            preparedStatement.setDouble(7, com);
            preparedStatement.setDouble(8, numdep);

            int filasInsertadas = preparedStatement.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Se ha insertado correctamente un nuevo empleado.");
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

    private boolean existeEmpleado(Connection conexion, int id){
        String sql = "SELECT COUNT(*) FROM empleados WHERE emp_no = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
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
