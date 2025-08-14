package ejercicio3hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 03 diciembre, 2024
 */
public class Ejer3Logica {
    public void ejecutarMenu(SessionFactory factory, Scanner scanner) {
        while (true) {
            String opcion = mostrarMenu(scanner);
            switch (opcion) {
                case "1":
                    try (Session session = factory.getCurrentSession()) {
                        session.beginTransaction();
                        consultarProfesoresHTML(session);
                        session.getTransaction().commit();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "2":
                    try (Session session = factory.getCurrentSession()) {
                        session.beginTransaction();
                        consultarDireccionesHTML(session);
                        session.getTransaction().commit();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "3":
                    try (Session session = factory.getCurrentSession()) {
                        session.beginTransaction();
                        insertarDireccion(session, scanner);
                        session.getTransaction().commit();
                    }
                    break;
                case "4":
                    try (Session session = factory.getCurrentSession()) {
                        session.beginTransaction();
                        insertarProfesor(session, scanner);
                        session.getTransaction().commit();
                    }
                    break;
                case "5":
                    try (Session session = factory.getCurrentSession()) {
                        session.beginTransaction();
                        modificarDireccionId(session, scanner);
                        session.getTransaction().commit();
                    }
                    break;
                case "6":
                    try (Session session = factory.getCurrentSession()) {
                        session.beginTransaction();
                        modificarProfesorId(session, scanner);
                        session.getTransaction().commit();
                    }
                    break;
                case "7":
                    try (Session session = factory.getCurrentSession()) {
                        session.beginTransaction();
                        borrarDireccionId(session, scanner);
                        session.getTransaction().commit();
                    }
                    break;
                case "8":
                    try (Session session = factory.getCurrentSession()) {
                        session.beginTransaction();
                        borrarProfesorId(session, scanner);
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

    private void borrarProfesorId(Session session, Scanner scanner) {
        int id = -1;
        System.out.println("Inserta el ID del profesor: ");
        try {
            id = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println(e);
            System.err.println("No has introducido un número válido");
            return;
        }
        Profesor profesor = buscarProfesor(session, id);
        if (profesor != null){
            session.delete(profesor);
            System.out.println("El profesor " + profesor.getId() + " se ha borrado");
        }else System.out.println("Ese profesor no existe");

    }

    private void borrarDireccionId(Session session, Scanner scanner) {
        int id = -1;
        System.out.println("Inserta la ID de la direccion: ");
        try {
            id = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println(e);
            System.err.println("No has introducido un número válido");
            return;
        }
        Direccion direccion = buscarDireccion(session, id);
        if (direccion != null){
            session.delete(direccion);
            System.out.println("La direccion " + direccion.getId() + " se ha borrado");
        }else System.out.println("Esa direccion no existe");

    }

    private void modificarProfesorId(Session session, Scanner scanner) {
        int id = -1;
        System.out.println("Inserta el ID del profesor: ");
        try {
            id = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println(e);
            System.err.println("No has introducido un número válido");
            return;
        }
        Profesor profesor = buscarProfesor(session, id);
        if (profesor != null) {
            System.out.println("Inserta el nombre: ");
            profesor.setNombre(scanner.next());
            System.out.println("Inserta el apellido1: ");
            profesor.setApe1(scanner.next());
            System.out.println("Inserta el apellido2: ");
            profesor.setApe2(scanner.next());


            session.update(profesor);
            System.out.println("El profesor " + profesor.getId() + " se ha modificado");
        } else System.out.println("Ese profesor no existe");

    }

    private Profesor buscarProfesor(Session session, int id) {
        Profesor profesor = session.get(Profesor.class, id);
        return profesor;
    }

    private void modificarDireccionId(Session session, Scanner scanner) {
        int id = -1;
        System.out.println("Inserta el ID de la direccion: ");
        try {
            id = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println(e);
            System.err.println("No has introducido un número válido");
            return;
        }
        Direccion direccion = buscarDireccion(session, id);
        if (direccion != null) {
            int numero = -1;
            System.out.println("Inserta la calle: ");
            direccion.setCalle(scanner.next());
            System.out.println("Inserta el número: ");
            try {
                direccion.setNumero(scanner.nextInt());
            } catch (InputMismatchException e) {
                System.err.println(e);
                System.err.println("No has introducido un número válido");
                return;
            }

            System.out.println("Inserta la población ");
            direccion.setPoblacion(scanner.next());
            System.out.println("Inserta la provincia ");
            direccion.setProvincia(scanner.next());

            session.update(direccion);
            System.out.println("La direccion " + direccion.getId() + " se ha modificado");
        } else System.out.println("Esa direccion no existe");

    }

    private Direccion buscarDireccion(Session session, int id) {
        Direccion direccion = session.get(Direccion.class, id);
        return direccion;
    }

    private void insertarProfesor(Session session, Scanner scanner) {
        System.out.println("Inserta el nombre del profesor: ");
        String nombre = scanner.next();
        System.out.println("Inserta el ape1 del profesor: ");
        String ape1 = scanner.next();
        System.out.println("Inserta el ape2 del profesor: ");
        String ape2 = scanner.next();

        Profesor prof = new Profesor(nombre, ape1, ape2);
        session.save(prof);
        System.out.println("El profesor con ID " + prof.getId() + " se ha guardado.");
    }

    private void insertarDireccion(Session session, Scanner scanner) {
        int numero = -1;
        System.out.println("Inserta la calle: ");
        String calle = scanner.next();
        System.out.println("Inserta el número: ");
        try {
            numero = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println(e);
            System.err.println("No has introducido un número válido");
            return;
        }

        System.out.println("Inserta la población ");
        String poblacion = scanner.next();
        System.out.println("Inserta la provincia ");
        String provincia = scanner.next();

        Direccion dir = new Direccion(calle, numero, poblacion, provincia);
        session.save(dir);
        System.out.println("La dirección con ID " + dir.getId() + " se ha guardado.");
    }

    private void consultarDireccionesHTML(Session session) throws IOException {

        //Crear HTMl
        StringBuilder html = new StringBuilder();
        html.append("<html>\n")
                .append("<head><title>Lista de Direcciones</title></head>\n")
                .append("<body>\n")
                .append("<h1>Lista de Direcciones</h1>");

        List<Direccion> direcciones = session.createQuery(
                "FROM Direccion d ORDER BY d.id ASC ", Direccion.class
        ).list();


        if (direcciones != null) {
            html.append("<table border=1>");

            html.append("<tr>" +
                    "<th>ID</th>" +
                    "<th>Calle</th>" +
                    "<th>Número</th>" +
                    "<th>Población</th>" +
                    "<th>Provincia</th>" +
                    "</tr>");

            for (int i = 0; i < direcciones.size(); i++) {
                html.append("<tr>")
                        .append("<td>").append(direcciones.get(i).getId()).append("</td>")
                        .append("<td>").append(direcciones.get(i).getCalle()).append("</td>")
                        .append("<td>").append(direcciones.get(i).getNumero()).append("</td>")
                        .append("<td>").append(direcciones.get(i).getPoblacion()).append("</td>")
                        .append("<td>").append(direcciones.get(i).getProvincia()).append("</td>")
                        .append("</tr>");

            }

        } else {
            System.out.println("No se encontraron direcciones.");
            html.append("<h1>No Hay direcciones</h1>");
        }
        html.append("</body>\n</html>");
        File file = new File("tabla_ListaDirecciones.html");
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

    private void consultarProfesoresHTML(Session session) throws IOException {
        //Crear HTMl
        StringBuilder html = new StringBuilder();
        html.append("<html>\n")
                .append("<head><title>Lista de Profesores</title></head>\n")
                .append("<body>\n")
                .append("<h1>Lista de Profesores</h1>");

        List<Profesor> profesores = session.createQuery(
                "FROM Profesor d ORDER BY d.id ASC ", Profesor.class
        ).list();


        if (profesores != null) {
            html.append("<table border=1>");

            html.append("<tr>" +
                    "<th>ID</th>" +
                    "<th>Nombre</th>" +
                    "<th>Apellido 1</th>" +
                    "<th>Apellido 2</th>" +
                    "</tr>");

            for (int i = 0; i < profesores.size(); i++) {
                html.append("<tr>")
                        .append("<td>").append(profesores.get(i).getId()).append("</td>")
                        .append("<td>").append(profesores.get(i).getNombre()).append("</td>")
                        .append("<td>").append(profesores.get(i).getApe1()).append("</td>")
                        .append("<td>").append(profesores.get(i).getApe2()).append("</td>")
                        .append("</tr>");

            }

        } else {
            System.out.println("No se encontraron profesores.");
            html.append("<h1>No Hay profesores</h1>");
        }
        html.append("</body>\n</html>");
        File file = new File("tabla_ListaProfesores.html");
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

    private String mostrarMenu(Scanner scanner) {
        System.out.println("Menu de opciones:");
        System.out.println("1. Consultar profesores en html");
        System.out.println("2. Consultar direcciones en html");
        System.out.println("3. Insertar direccion");
        System.out.println("4. Insertar profesor");
        System.out.println("5. Modificar direccion por id");
        System.out.println("6. Modificar profesor por id");
        System.out.println("7. Borrar direccion por id");
        System.out.println("8. Borrar profesor por id");
        System.out.println("0. salir");
        return scanner.next();
    }
}
