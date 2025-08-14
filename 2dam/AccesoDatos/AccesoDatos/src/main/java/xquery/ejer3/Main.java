package xquery.ejer3;

import xquery.ejer3.controlador.Controller;
import xquery.ejer3.modelo.Model;

import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 24 febrero, 2025
 */
public class Main {
    public static void main(String[] args) {
        Model modelo = new Model("./src/main/java/productos.xml");

        View vista = new View();

        Controller controlador = new Controller(modelo, vista);

        try(Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;

            while (!exit) {
                System.out.println("Menu de opciones:");
                System.out.println("1. Contar productos que sean memorias y estén en la zona 10");
                System.out.println("2. Obtener todos los productos que sean 'Placa Base'");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                String option = scanner.nextLine();

                switch (option) {
                    case "1":
                        controlador.evaluateExpression("count(/productos/produc[contains(denominacion,'Memoria') and cod_zona = 10])");
                        controlador.showResult();
                        break;
                    case "2":

                        controlador.evaluateExpression("/productos/produc[contains(denominacion, 'Placa Base')]");
                        controlador.showResult();
                        break;
                    case "0":
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }

        } catch (javax.xml.xpath.XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}
