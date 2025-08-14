package ejercicios.ehibernate.apartadoa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 20 noviembre, 2024
 */

public class Ej3ProfAsig {
    public static void main(String[] args) {
        Ej3ProfAsig ej = new Ej3ProfAsig();
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); Scanner scanner = new Scanner(System.in)) {
            ej.ejecutarMenu(factory, scanner);
        }
    }

    private void ejecutarMenu(SessionFactory factory, Scanner scanner) {
        while (true) {
            String opcion = mostrarMenu(scanner);
            switch (opcion) {
                case "1":
                    try (Session session = factory.getCurrentSession()) {
                        session.beginTransaction();
                        insertarProfesor(session, scanner);
                        session.getTransaction().commit();
                    }
                    break;
                case "2":
                    try (Session session = factory.getCurrentSession()) {
                        session.beginTransaction();
                        insertarAsignatura(session, scanner);
                        session.getTransaction().commit();
                    }
                    break;
                case "3":
                    try (Session session = factory.getCurrentSession()) {
                        session.beginTransaction();
                        mostrarProfesores(session);
                        session.getTransaction().commit();
                    }
                    break;
                case "4":
                    try (Session session = factory.getCurrentSession()) {
                        session.beginTransaction();
                        mostrarAsignaturas(session);
                        session.getTransaction().commit();
                    }
                    break;
                case "5":
                    try (Session session = factory.getCurrentSession()) {
                        session.beginTransaction();
                        asignaturaConMasAlumnosHTML(session);
                        session.getTransaction().commit();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "6":
                    try (Session session = factory.getCurrentSession()) {
                        session.beginTransaction();
                        asignaturaConMasAlumnos(session);
                        session.getTransaction().commit();
                    }
                    break;

                case "0":
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void mostrarAsignaturas(Session session) {
        List<Asignatura> asignaturas = listarAsignaturas(session);
        for (Asignatura asignatura : asignaturas) {
            System.out.println("ID: " + asignatura.getId() +
                    ", Nombre: " + asignatura.getNombre() +
                    ", NºAlumnos: " + asignatura.getNumero_alumnos());
        }
    }

    private List<Asignatura> listarAsignaturas(Session session) {
        Query<Asignatura> query = session.createQuery("from Asignatura ", Asignatura.class);
        return query.getResultList();
    }

    private void mostrarProfesores(Session session) {
        List<Profesor> profesores = listarProfesores(session);
        for (Profesor profesor : profesores) {
            System.out.println("ID: " + profesor.getId() +
                    ", Nombre: " + profesor.getNombre() +
                    ", Categoria: " + profesor.getCategoria() +
                    ", Salario: " + profesor.getSalario());
        }
    }

    private List<Profesor> listarProfesores(Session session) {
        Query<Profesor> query = session.createQuery("from Profesor ", Profesor.class);
        return query.getResultList();
    }

    private void insertarAsignatura(Session session, Scanner scanner) {
        System.out.println("Inserta el id de la asignatura: ");
        int id = scanner.nextInt();
        if (existeAsignatura(session, id)) {
            System.out.println("Ese id ya existe");
            return;
        }
        System.out.println("Inserta el nombre de la asignatura: ");
        String nombre = scanner.next();
        System.out.println("Inserta el numero de alumnos: ");
        int numAl = scanner.nextInt();

        Asignatura asignatura = new Asignatura(id, nombre, numAl);

        session.save(asignatura);
        System.out.println("El Usuario con ID " + asignatura.getId() + " se ha guardado.");


    }

    private boolean existeAsignatura(Session session, int id) {
        Asignatura asignatura = session.get(Asignatura.class, id);
        return asignatura != null;
    }


    private void insertarProfesor(Session session, Scanner scanner) {
        System.out.println("Inserta el id del profesor: ");
        int id = scanner.nextInt();
        if (existeProfesor(session, id)) {
            System.out.println("Ese id ya existe");
            return;
        }
        System.out.println("Inserta el nombre del profesor: ");
        String nombre = scanner.next();
        System.out.println("Inserta la categoria del profesor: ");
        String categoria = scanner.next();
        System.out.println("Inserta el salario del profesor: ");
        double salario = scanner.nextDouble();

        Profesor prof = new Profesor(id, nombre, categoria, salario);

        session.save(prof);
        System.out.println("El Usuario con ID " + prof.getId() + " se ha guardado.");


    }

    private String mostrarMenu(Scanner scanner) {
        System.out.println("Menu de opciones:");
        System.out.println("1. Insertar Profesor");
        System.out.println("2. Insertar una asignatura");
        System.out.println("3. Consultar profesores");
        System.out.println("4. Consultar asignaturas");
        System.out.println("5. Asignatura con mas alumnos html");
        System.out.println("6. Asignatura con mas alumnos");
        System.out.println("0. salir");
        return scanner.next();
    }

    private boolean existeProfesor(Session session, int id) {
        Profesor profesor = session.get(Profesor.class, id);
        return profesor != null;
    }

    void asignaturaConMasAlumnos(Session session) {
        Query<Asignatura> query = session.createQuery(
                "FROM Asignatura a ORDER BY a.numero_alumnos DESC", Asignatura.class
        );
        query.setMaxResults(1); // Limita el resultado a 1 fila

        Asignatura asignatura = query.uniqueResult(); // Obtiene el único resultado
        if (asignatura != null) {
            System.out.println("La asignatura con más alumnos es: ");
            System.out.println("ID: " + asignatura.getId() + "\nNombre: " + asignatura.getNombre() + "\nNúmero de alumnos: " + asignatura.getNumero_alumnos());
        } else {
            System.out.println("No se encontraron asignaturas.");
        }

    }

    void asignaturaConMasAlumnosHTML(Session session) throws IOException {

        //Crear HTMl
        StringBuilder html = new StringBuilder();
        html.append("<html>\n")
                .append("<head><title>Asignatura con más alumnos</title></head>\n")
                .append("<body>\n");

        Query<Asignatura> query = session.createQuery(
                "FROM Asignatura a ORDER BY a.numero_alumnos DESC", Asignatura.class
        );
        query.setMaxResults(1); // Limita el resultado a 1 fila

        Asignatura asignatura = query.uniqueResult(); // Obtiene el único resultado
        if (asignatura != null) {
            html.append("<table border=1>");

            html.append("<tr>" +
                    "<th>ID</th>" +
                    "<th>Nombre</th>" +
                    "<th>Numero de Alumnos</th>" +
                    "</tr>");

            html.append("<tr>")
                    .append("<td>").append(asignatura.getId()).append("</td>")
                    .append("<td>").append(asignatura.getNombre()).append("</td>")
                    .append("<td>").append(asignatura.getNumero_alumnos()).append("</td>")
                    .append("</tr>");

            System.out.println("La asignatura con más alumnos es: ");
            System.out.println("ID: " + asignatura.getId() + "\nNombre: " + asignatura.getNombre() + "\nNúmero de alumnos: " + asignatura.getNumero_alumnos());
        } else {
            System.out.println("No se encontraron asignaturas.");
            html.append("<h1>No Hay Asignaturas</h1>");
        }
        html.append("</body>\n</html>");
        File file = new File("tabla_AsignaturaConMasAlumnos.html");
        try (FileWriter escribir = new FileWriter(file)) {
            escribir.write(html.toString());
        } catch (IOException e) {
            System.out.println("Error de escritura: " + e.getCause());
        }

        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(file.toURI());
        }
        System.out.println("Tabla generada correctamente.");

    }
}