package xquery.ejer1;

import xquery.ejer1.controlador.Controller;
import xquery.ejer1.modelo.Model;
import xquery.ejer1.vista.View;

/**
 * @author Rodrigo
 * @date 24 febrero, 2025
 */
public class Main {
    public static void main(String[] args) {
        Model modelo = new Model("./src/main/java/productos.xml");

        View vista = new View();

        Controller controlador = new Controller(modelo, vista);

        try {
            controlador.evaluateExpression("/productos/produc[contains(denominacion, 'Placa Base')]");

            controlador.showResult();
        } catch (javax.xml.xpath.XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}
