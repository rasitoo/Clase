/**
 * @author Rodrigo
 * @date 22 mayo, 2024
 */
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLProcessorSAX {

    public static void main(String[] args) {
        try {
            File inputFile = new File("personas.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            CustomHandler handler = new CustomHandler();
            saxParser.parse(inputFile, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class CustomHandler extends DefaultHandler {
    private String currentElement;
    private String nombre;
    private String edad;
    private List<String> hijos;
    private String calle;
    private String numero;
    private String ciudad;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if ("persona".equals(currentElement)) {
            System.out.println("***** Persona *****");
            hijos = new ArrayList<>();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("nombre".equals(currentElement)) {
            System.out.println("Nombre: " + nombre);
        } else if ("edad".equals(currentElement)) {
            System.out.println("Edad: " + edad);
        } else if ("calle".equals(currentElement)) {
            System.out.println("Calle: " + calle);
        } else if ("numero".equals(currentElement)) {
            System.out.println("Número: " + numero);
        } else if ("ciudad".equals(currentElement)) {
            System.out.println("Ciudad: " + ciudad);
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length).trim();
        if ("nombre".equals(currentElement)) {
            nombre = content;
        } else if ("edad".equals(currentElement)) {
            edad = content;
        } else if ("hijo".equals(currentElement)) {
            hijos.add(content);
        } else if ("calle".equals(currentElement)) {
            calle = content;
        } else if ("numero".equals(currentElement)) {
            numero = content;
        } else if ("ciudad".equals(currentElement)) {
            ciudad = content;
        }
    }
}
