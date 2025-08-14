package ejercicios.dconexiones;

import java.sql.*;
import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 05 noviembre, 2024
 */
public class Ej7Menu {

    public static void main(String[] args) {
        Ej7Menu ej = new Ej7Menu();
        try (Scanner scanner = new Scanner(System.in)) {
            // Conectar y pedir datos
            try (Connection conexion = ej.conectar()) {
                ej.ejecutarOpcion(conexion, scanner);
            } catch (SQLException e) {
                System.out.println("Error al conectar o insertar en la base de datos:");
                e.printStackTrace();
            }
        }
    }

    private void ejecutarOpcion(Connection conexion, Scanner scanner) {
        while (true){
            mostrarMenu();
            switch (scanner.next()){
                case "1":
                    mostrarTodos(conexion);
                    break;
                case "2":
                    insertar(conexion, scanner);
                    break;
                case "3":
                    modificarNotaPorId(conexion, scanner);
                    break;
                case "4":
                    borrarPorId(conexion, scanner);
                    break;
                case "5":
                    System.out.println("Cerrando...");
                    return;
                default:
                    System.out.println("Opción incorrecta");
            }
        }
    }

    private void borrarPorId(Connection conexion, Scanner scanner) {
        String sql = "delete from alumnos WHERE id = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            System.out.print("Ingrese el ID del alumno: ");
            int id = scanner.nextInt();
            if (!existeId(conexion, id)) {
                System.out.println("El ID no existe. Por favor, ingrese un ID diferente.");
                return;
            }
            preparedStatement.setInt(1, id);

            int filasModificadas = preparedStatement.executeUpdate();
            if (filasModificadas > 0) {
                System.out.println("Se ha borrado correctamente el alumno.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void modificarNotaPorId(Connection conexion, Scanner scanner) {
        System.out.print("Ingrese el ID del alumno: ");
        int id = scanner.nextInt();
        if (!existeId(conexion, id)) {
            System.out.println("El ID no existe. Por favor, ingrese un ID diferente.");
            return;
        }
        String sql = "UPDATE alumnos SET nota = ? WHERE id = id";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            System.out.print("Ingrese la nota del alumno: ");
            double nota = scanner.nextDouble();
            if (nota > 10 || nota < 0) {
                System.out.println("La nota no puede ser mayor de 10 o menor que 0.");
                return;
            }
            preparedStatement.setDouble(1, nota);

            int filasInsertadas = preparedStatement.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Se ha modificado correctamente el alumno.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void insertar(Connection conexion, Scanner scanner) {
        String sql = "INSERT INTO alumnos (id, nombre, apellido, edad, nota) VALUES( ?,?,?,?,?)";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            System.out.print("Ingrese el ID del alumno: ");
            int id = scanner.nextInt();
            if (existeId(conexion, id)) {
                System.out.println("El ID ya existe. Por favor, ingrese un ID diferente.");
                return;
            }

            System.out.print("Ingrese la edad del alumno: ");
            int edad = scanner.nextInt();
            if (edad < 0 || edad > 99) {
                System.out.println("La edad debe ser un número de uno o dos dígitos.");
                return;
            }

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

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, apellido);
            preparedStatement.setInt(4, edad);
            preparedStatement.setDouble(5, nota);

            int filasInsertadas = preparedStatement.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Se ha insertado correctamente un nuevo alumno.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void mostrarTodos(Connection conexion) {
        String sql = "SELECT * FROM alumnos";
        try (Statement statement = conexion.createStatement(); ResultSet resultSet = statement.executeQuery(sql);) {
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
                System.out.println();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void mostrarMenu() {
        System.out.println("Menú de operaciones con alumnos");
        System.out.println("1. Consultar todos los alumnos");
        System.out.println("2. Insertar un alumno");
        System.out.println("3. Modificar la nota de un alumno por el identificador");
        System.out.println("4. Borrar un alumno por el identificador");
        System.out.println("5. Salir");
    }

    public Connection conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ejemplos";
        String usuario = "root";
        String contrasena = "";
        Connection conexion = DriverManager.getConnection(url, usuario, contrasena);
        System.out.println("Conexión CORRECTA a la base de datos.");
        return conexion;
    }
    private boolean existeId(Connection conexion, int id){
        String sql = "SELECT COUNT(*) FROM alumnos WHERE id = ?";
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
