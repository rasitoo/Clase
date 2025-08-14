/**
 * @author Rodrigo
 * @date 22 mayo, 2024
 */

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import java.util.ArrayList;
import java.util.List;

public class SAXParserHandler extends DefaultHandler {
    private List<Persona> personas; // Lista para almacenar objetos Persona
    private Persona personaActual; // Objeto Persona actual

    @Override
    public void startDocument() throws SAXException {
        personas = new ArrayList<>(); // Inicializa la lista de personas al comenzar el documento
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("persona")) {
            // Comienza un nuevo objeto Persona
            personaActual = new Persona();
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        String contenido = new String(ch, start, length).trim();
        if (!contenido.isEmpty()) {
            // Asigna el contenido al objeto Persona actual
            if (personaActual != null) {
                if (qName.equalsIgnoreCase("nombre")) {
                    personaActual.setNombre(contenido);
                } else if (qName.equalsIgnoreCase("edad")) {
                    personaActual.setEdad(Integer.parseInt(contenido));
                }
                // Agrega más atributos según tu XML
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("persona")) {
            // Agrega el objeto Persona actual a la lista
            if (personaActual != null) {
                personas.add(personaActual);
                personaActual = null; // Reinicia el objeto actual
            }
        }
    }

    // Métodos adicionales para manejar otros eventos como endDocument, etc.

    // Clase interna para representar una persona
    private static class Persona {
        private String nombre;
        private int edad;

        // Getters y setters para atributos (nombre, edad, etc.)
    }
}

// En tu método principal, usarías un SAXParser para analizar tu archivo XML


