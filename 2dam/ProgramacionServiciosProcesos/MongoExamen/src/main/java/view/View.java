package view;

import org.bson.Document;

import java.util.Arrays;
import java.util.List;

/**
 * @author Rodrigo
 * @date 25 febrero, 2025
 */
public class View {
    public void showDocuments(List<Document> documents) {
        for (Document document : documents) {
            System.out.println(document.toJson());
        }
    }

    public void showProfesoresDoctores(List<Document> documents) throws Exception {
        System.out.println("Los profesores con titulacion DOCTOR son:");
        System.out.println("------------------------------------------");
        for (Document doc : documents) {

            String nombre = doc.getString("nombre");
            String titulacion = doc.getString("titulacion");

            System.out.println("Profesor: " + nombre + ", Titulación: " + titulacion);
        }

    }
    public void showAsignaturasAlumnos(List<Document> documents) throws Exception {
        System.out.println("Asignaturas y números de alumnos:");
        System.out.println("------------------------------------------");
        for (Document doc : documents) {

            String nombre = doc.getString("nombre");
            int num = doc.getInteger("numero_alumnos");


            System.out.println("Profesor: " + nombre + ", Número de alumnos: " + num);
        }

    }
}
