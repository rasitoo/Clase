package org.example;

import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Main {
    public static void main(String argv[]) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("c:\\ejercicios\\Departamentos.xml"));
            document.getDocumentElement().normalize();

            System.out.println("Elemento raíz: " + document.getDocumentElement().getNodeName());
            NodeList departamentos = document.getElementsByTagName("departamento");

            for (int i = 0; i < departamentos.getLength(); i ++) {

                Node depar = departamentos.item(i);

                if (depar.getNodeType() == Node.ELEMENT_NODE) {

                    Element elemento = (Element) depar;

                    System.out.println("Numero: " + getNodo("numero", elemento));
                    System.out.println("Nombre: " + getNodo("nombre", elemento));
                    System.out.println("Localidad: " + getNodo("localidad", elemento));

                }
            }
        } catch (Exception e) { e.printStackTrace();}
    }//fin de main

    //obtener la información de un nodo
    private static String getNodo(String etiqueta, Element elem)
    {
        NodeList nodo= elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node valornodo = (Node) nodo.item(0);
        return valornodo.getNodeValue();
    }
}//fin de la clase