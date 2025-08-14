package org.example;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class Main {
    public static void main(String argv[]) throws IOException {
        Departamento depart;
        File fichero = new File(".\\Departamentos.dat");
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream dataIS = new ObjectInputStream(filein);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null,
                    "Departamentos", null);
            document.setXmlVersion("1.0"); // asignamos la version de nuestro
            // XML
            try {
                while (true) { // lectura del fichero
                    depart = (Departamento) dataIS.readObject();
                    System.out.println("Departamento: " + depart.getDep()
                            + ", Nombre: " + depart.getNombre()
                            + ", Localidad: " + depart.getLoc());
                    Element raiz = document.createElement("departamento");
                    document.getDocumentElement().appendChild(raiz);
                    CrearElemento("numero", Integer.toString(depart.getDep()),
                            raiz, document);
                    CrearElemento("nombre", depart.getNombre(), raiz, document);
                    CrearElemento("localidad", depart.getLoc(), raiz, document);
                }
            } catch (Exception e) {
                // Se produce EOFException al finalizar la lectura
                if (e.toString() == "java.io.EOFException")
                    System.err.println("Final de Lectura con los cambios...");
                else
                    System.err.println("Error al leer fichero: " +
                            e.toString());
            }
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File(
                    ".\\Departamentos.xml"));
            Transformer transformer = TransformerFactory.newInstance()
                    .newTransformer();
            transformer.transform(source, result);
        } catch (Exception ee) {
            System.err.println("Error: " + ee);
        }
        filein.close(); // cerrar fichero
    }// fin de main

    // Inserción de los datos del empleado
    static void CrearElemento(String datoEmple, String valor, Element raiz,
                              Document document) {
        Element elem = document.createElement(datoEmple); // creamos hijo
        Text text = document.createTextNode(valor); // damos valor
        raiz.appendChild(elem); // pegamos el elemento hijo a la raiz
        elem.appendChild(text); // pegamos el valor
    }
}// fin de la clase