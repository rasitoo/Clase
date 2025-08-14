package ejercicios.simulacro;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @author Rodrigo
 * @date 04 noviembre, 2024
 */

public class XmlCiclosFormativos {

    public static void MayorGuadalajara() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            File archivoXML = new File("ciclos_formativos.xml");
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(archivoXML);
            document.getDocumentElement().normalize();


            NodeList listaDepartamentos = document.getElementsByTagName("departamento");

            String nombreMayorDepartamento = "";
            int maxEmpleados = 0;

            System.out.println("Departamentos en Guadalajara:");

            for (int i = 0; i < listaDepartamentos.getLength(); i++) {
                Node nodo = listaDepartamentos.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                    String localidad = elemento.getElementsByTagName("localidad").item(0).getTextContent();
                    int empleados = Integer.parseInt(elemento.getElementsByTagName("empleados").item(0).getTextContent());

                    if (empleados > maxEmpleados) {
                        maxEmpleados = empleados;
                        nombreMayorDepartamento = nombre;
                    }

                    if ("GUADALAJARA".equalsIgnoreCase(localidad)) {
                        System.out.println(" - " + nombre);
                    }
                }
            }

            System.out.println("El departamento con más empleados es: " + nombreMayorDepartamento + " con " + maxEmpleados + " empleados.");

        } catch (Exception e) {
            System.out.println("Error al procesar el archivo XML: " + e.getMessage());
        }
    }
}
