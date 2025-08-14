package ejercicios.cxml.xml5;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Rodrigo
 * @date 23 octubre, 2024
 */
public class Main {
    public static void main(String argv[]) throws IOException {
        String hojaEstilo = ".\\Ejercicio5.xsl";
        String datospdepar = ".\\Departamentos.xml";
        File pagHTMLdepar = new File(".\\Ejercicio5.html");
        FileOutputStream paginhtml = new FileOutputStream(pagHTMLdepar); //crear fichero HTML

        Source estilos = new StreamSource(hojaEstilo); //fuente XSL
        Source datos = new StreamSource(datospdepar); //fuente XML
        Result result = new StreamResult(paginhtml); //resultado de la transformación

        try{
            Transformer transformer =
                    TransformerFactory.newInstance().newTransformer(estilos);
            transformer.transform(datos, result); //obtiene el HTML
        }
        catch(Exception e){System.err.println("Error en la entrada de datos: " + e);}
        System.out.println("PAGINA DE LOS DEPARTAMENTOS GENERADA CORRECTAMENTE");
        paginhtml.close(); //cerrar fichero
    }
} //de main
//de la clase
