package ejercicios.cxml.xml4;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @author Rodrigo
 * @date 23 octubre, 2024
 */
public class Main {
    /*The provided code reads an XML file named Departamentos.xml and prints out the details of each department. Here's a step-by-step explanation:
Setup and Initialization:
The DocumentBuilderFactory is created to obtain a DocumentBuilder.
The DocumentBuilder is used to parse the XML file into a Document object.
Normalization:
The document is normalized to combine adjacent text nodes and ensure a consistent structure.
Root Element:
The root element of the XML document is printed.
Processing Each Department:
The code retrieves all elements with the tag name departamento.
It iterates over each departamento element.
For each departamento, it checks if the node is an element node.
It then extracts and prints the numero, nombre, and localidad of each department using the getNodo method.
Helper Method:
The getNodo method retrieves the text content of a specified child element of a given element.*/
    public static void main(String argv[]) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        int mayor = 0;
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(".\\Departamentos.xml"));
//            document.getDocumentElement().normalize();

            System.out.println("Elemento raíz: " + document.getDocumentElement().getNodeName());
            NodeList departamentos = document.getElementsByTagName("departamento");

            for (int i = 0; i < departamentos.getLength(); i++) {

                Node depar = departamentos.item(i);

                if (depar.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) depar;
                    if (Integer.parseInt(getNodo("numero", elemento)) > mayor)
                        mayor = Integer.parseInt(getNodo("numero", elemento));
                    if (getNodo("localidad", elemento).equalsIgnoreCase("guadalajara")) {
                        System.out.println("numero: " + getNodo("numero", elemento));
                        System.out.println("nombre: " + getNodo("nombre", elemento));
                        System.out.println("localidad: " + getNodo("localidad", elemento));
                    }

                }
            }
            System.out.println("El número mayor es: " + mayor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //obtener la información de un nodo
    private static String getNodo(String etiqueta, Element elem) {
        NodeList nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node valornodo = (Node) nodo.item(0);
        return valornodo.getNodeValue();
    }
}
