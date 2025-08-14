package xquery.ejer3.controlador;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import xquery.ejer3.View;
import xquery.ejer3.modelo.Model;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rodrigo
 * @date 24 febrero, 2025
 */
public class Controller {
    private Model modelo;
    private View vista;
    XPathFactory xPathFactory = XPathFactory.newInstance();
    XPath xpath = xPathFactory.newXPath();
    List<String> resultados = new ArrayList<>();


    public Controller(Model modelo, View vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void evaluateExpression(String expression) throws XPathExpressionException {
        resultados.clear();
        try {
            Object result = xpath.evaluate(expression, modelo.getXml(), XPathConstants.NODESET);
            if (result instanceof NodeList) {
                NodeList nodeList = (NodeList) result;
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    resultados.add(node.getTextContent());
                }
            } else if (result instanceof Number) {
                resultados.add(result.toString());
            } else {
                System.err.println("La expresión XPath no devolvió un conjunto de nodos ni un número.");
            }
        } catch (XPathExpressionException e) {
            System.err.println("Error en la expresión XPath: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassCastException e) {
            System.err.println("La expresión XPath no devolvió un conjunto de nodos: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void showResult() {
        vista.mostrarResultado(resultados);
    }
}
