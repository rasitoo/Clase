package xquery.ejer1.controlador;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import xquery.ejer1.modelo.Model;
import xquery.ejer1.vista.View;

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
        NodeList nodeList = (NodeList) xpath.evaluate(expression, modelo.getXml(), XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            resultados.add(node.getTextContent());
        }
    }


    public void showResult() {
        vista.mostrarResultado(resultados);
    }
}
