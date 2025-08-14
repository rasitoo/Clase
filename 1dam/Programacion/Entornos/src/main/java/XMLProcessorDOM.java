/**
 * @author Rodrigo
 * @date 22 mayo, 2024
 */
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class XMLProcessorDOM {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        // Cargar o crear el documento XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("personas.xml"));

        // Procesar la lista de personas
        NodeList personas = document.getElementsByTagName("persona");
        for (int i = 0; i < personas.getLength(); i++) {
            Node persona = personas.item(i);
            if (persona.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) persona;
                String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                int edad = Integer.parseInt(elemento.getElementsByTagName("edad").item(0).getTextContent());
                System.out.println("Nombre: " + nombre + ", Edad: " + edad);

                // Procesar la lista de hijos
                NodeList hijos = elemento.getElementsByTagName("hijo");
                for (int j = 0; j < hijos.getLength(); j++) {
                    String hijo = hijos.item(j).getTextContent();
                    System.out.println("Hijo: " + hijo);
                }

                // Procesar la lista de direcciones
                NodeList direcciones = elemento.getElementsByTagName("direccion");
                for (int k = 0; k < direcciones.getLength(); k++) {
                    Node direccion = direcciones.item(k);
                    if (direccion.getNodeType() == Node.ELEMENT_NODE) {
                        Element dirElemento = (Element) direccion;
                        String calle = dirElemento.getElementsByTagName("calle").item(0).getTextContent();
                        String numero = dirElemento.getElementsByTagName("numero").item(0).getTextContent();
                        String ciudad = dirElemento.getElementsByTagName("ciudad").item(0).getTextContent();
                        System.out.println("Dirección: Calle " + calle + ", Número " + numero + ", Ciudad " + ciudad);
                    }
                }
            }
        }

        // Escribir cambios en el documento XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File("personas_modificado.xml"));
        transformer.transform(source, result);
    }
}
