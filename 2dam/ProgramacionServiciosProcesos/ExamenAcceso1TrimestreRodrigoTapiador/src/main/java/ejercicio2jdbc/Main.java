package ejercicio2jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 03 diciembre, 2024
 */
public class Main {
    public static void main(String[] args) {
        Ejer2Logica ej = new Ejer2Logica();
        try (Scanner scanner = new Scanner(System.in)) {
            try (Connection conexion = ej.conectar()) {
                ej.ejecutarOpcion(conexion, scanner);
            } catch (SQLException e) {
                System.out.println("Error al conectar o insertar en la base de datos:");
                e.printStackTrace();
            }
        }
    }
}
