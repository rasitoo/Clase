package ejercicio1ficheros;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @author Rodrigo
 * @date 03 diciembre, 2024
 */
public class OperacionesXML {
    public static void main(String[] args) {
        leer();
    }

    private static void leer() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        double maxBeneficios = 0;
        String nombreMasBeneficio = "";
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(".\\tienda.xml"));
            document.getDocumentElement().normalize();

            NodeList tiendas = document.getElementsByTagName("Tiendas");
            for (int i = 0; i < tiendas.getLength(); i ++) {

                Node tienda = tiendas.item(i);

                if (tienda.getNodeType() == Node.ELEMENT_NODE) {

                    Element elemento = (Element) tienda;

                    double beneficios = 0;
                    String localidad = getNodo("localidad", elemento);
                    if (localidad.equalsIgnoreCase("madrid")){
                        beneficios = Double.parseDouble(getNodo("beneficiosAnuales", elemento));
                        if (beneficios > maxBeneficios){
                            maxBeneficios = beneficios;
                            nombreMasBeneficio = getNodo("nombre", elemento);
                        }
                    }
                }
            }

        } catch (Exception e) { e.printStackTrace();}
        System.out.println("La tienda de Madrid con más beneficios anuales es: " + nombreMasBeneficio + " con " + maxBeneficios);

    }
    private static String getNodo(String etiqueta, Element elem)
    {
        NodeList nodo= elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node valornodo = (Node) nodo.item(0);
        return valornodo.getNodeValue();
    }

}
