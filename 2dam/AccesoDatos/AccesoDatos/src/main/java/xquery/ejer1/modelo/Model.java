package xquery.ejer1.modelo;


import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @author Rodrigo
 * @date 24 febrero, 2025
 */
public class Model {
    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    private Document xml;

    public Model(String xml) {
        try {
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            this.xml = builder.parse(new File(xml));
        } catch (javax.xml.parsers.ParserConfigurationException | org.xml.sax.SAXException | java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public Document getXml() {
        return xml;
    }

    public void setXml(String xml) {
        try {
            this.xml = builder.parse(new File(xml));
        } catch (org.xml.sax.SAXException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
