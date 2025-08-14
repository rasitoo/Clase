package ejercicios.cxml.xml6;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * @author Rodrigo
 * @date 23 octubre, 2024
 */
public class Main {
    public static void main(String argv[]) {
        listadoCiclos();
        anadirCiclo();
        modificarNumAlumnos("3","20");


    }//fin de main
    private static void modificarNumAlumnos(String id, String nuevoNumAlumnos) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(".\\ciclosformativos_modificado.xml"));
            document.getDocumentElement().normalize();

            NodeList ciclos = document.getElementsByTagName("cicloformativo");

            for (int i = 0; i < ciclos.getLength(); i++) {
                Node ciclo = ciclos.item(i);

                if (ciclo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) ciclo;

                    if (elemento.getAttribute("id").equals(id)) {
                        elemento.getElementsByTagName("numalumnos").item(0).setTextContent(nuevoNumAlumnos);
                        break;
                    }
                }
            }

            // Guardar el documento actualizado
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(".\\ciclosformativos_modificado.xml"));
            transformer.transform(source, result);

            System.out.println("Número de alumnos actualizado con éxito.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void anadirCiclo() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(".\\ciclosformativos_modificado.xml"));
            document.getDocumentElement().normalize();

            // Crear nuevo ciclo formativo
            Element nuevoCiclo = document.createElement("cicloformativo");
            nuevoCiclo.setAttribute("id", "5");

            Element nombre = document.createElement("nombre");
            nombre.appendChild(document.createTextNode("Nuevo Ciclo"));
            nuevoCiclo.appendChild(nombre);

            Element instituto = document.createElement("instituto");
            instituto.appendChild(document.createTextNode("Nuevo Instituto"));
            nuevoCiclo.appendChild(instituto);

            Element curso = document.createElement("curso");
            curso.appendChild(document.createTextNode("1º"));
            nuevoCiclo.appendChild(curso);

            Element localidad = document.createElement("localidad");
            localidad.appendChild(document.createTextNode("Nueva Localidad"));
            nuevoCiclo.appendChild(localidad);

            Element numalumnos = document.createElement("numalumnos");
            numalumnos.appendChild(document.createTextNode("35"));
            nuevoCiclo.appendChild(numalumnos);

            // Añadir el nuevo ciclo al documento
            document.getDocumentElement().appendChild(nuevoCiclo);

            // Guardar el documento actualizado
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(".\\ciclosformativos_modificado.xml"));
            transformer.transform(source, result);

            System.out.println("Nuevo ciclo formativo añadido con éxito.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void listadoCiclos() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(".\\ciclos_formativos.xml"));
            document.getDocumentElement().normalize();

            NodeList departamentos = document.getElementsByTagName("cicloformativo");

            System.out.println("Listado de ciclos");
            for (int i = 0; i < departamentos.getLength(); i ++) {

                Node depar = departamentos.item(i);

                if (depar.getNodeType() == Node.ELEMENT_NODE) {

                    Element elemento = (Element) depar;

                    System.out.print("ID: "+elemento.getAttribute("id") +" ");
                    System.out.print("nombre: "+getNodo("nombre", elemento));
                    System.out.print(", instituto: "+getNodo("instituto", elemento));
                    System.out.print(", curso: "+getNodo("curso", elemento));
                    System.out.print(", localidad: "+getNodo("localidad", elemento));
                    System.out.println(", numalumnos: "+getNodo("numalumnos", elemento));
                }
            }

        } catch (Exception e) { e.printStackTrace();}
    }

    //obtener la información de un nodo
    private static String getNodo(String etiqueta, Element elem)
    {
        NodeList nodo= elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node valornodo = (Node) nodo.item(0);
        return valornodo.getNodeValue();
    }
}
