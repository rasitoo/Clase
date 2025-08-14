package xquery.ejer2.sinmvc;

/**
 * @author Rodrigo
 * @date 24 febrero, 2025
 */
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        try {
            File inputFile = new File("./src/main/java/productos.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();

            String expression = "count(/productos/produc[contains(denominacion,\"Memoria\") and cod_zona = 10])";

            XPathExpression xPathExpression = xPath.compile(expression);
            Double count = (Double) xPathExpression.evaluate(doc, XPathConstants.NUMBER);

            System.out.println("Hay " + count.intValue() + " productos que son memorias y están en la zona 10:");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
