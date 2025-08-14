package ejercicios.ehibernate.apartadoa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 20 noviembre, 2024
 */

public class Ej1Alumnos {
    public static void main(String[] args) {
        Ej1Alumnos ej = new Ej1Alumnos();
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuarios.class).buildSessionFactory(); Scanner scanner = new Scanner(System.in)) {
            ej.ejecutarMenu(factory, scanner);
        }
    }

    private  void ejecutarMenu(SessionFactory factory, Scanner scanner) {
        while (true) {
            String opcion = mostrarMenu(scanner);
            switch (opcion) {
                case "1":
                    try (Session session = factory.getCurrentSession()) {
                        session.beginTransaction();
                        mostrarAlumnos(session);
                        session.getTransaction().commit();
                    }
                    break;
                case "2":
                    try (Session session = factory.getCurrentSession()) {
                        session.beginTransaction();
                        insertarAlumno(session, scanner);
                        session.getTransaction().commit();
                    }
                    break;
                case "3":
                    try (Session session = factory.getCurrentSession()) {
                        session.beginTransaction();
                        ModificarAlumno(session, scanner);
                        session.getTransaction().commit();
                    }
                    break;
                case "4":
                    try (Session session = factory.getCurrentSession()) {
                        session.beginTransaction();
                        BorrarAlumno(session, scanner);
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

    private  void BorrarAlumno(Session session, Scanner scanner) {
        System.out.println("Inserta el ID del alumno: ");
        int id = scanner.nextInt();
        Alumno alumno = buscarAlumno(session, id);
        if (alumno != null){
            session.delete(alumno);
            System.out.println("El alumno " + alumno + " se ha borrado");
        }else System.out.println("Ese alumno no existe");
    }

    private  void ModificarAlumno(Session session, Scanner scanner) {
        System.out.println("Inserta el ID del alumno: ");
        int id = scanner.nextInt();
        Alumno alumno = buscarAlumno(session, id);
        if (alumno != null){
            System.out.println("introduce la nueva edad:");
            alumno.setEdad(scanner.nextInt());
            session.update(alumno);
            System.out.println("El alumno " + alumno + " se ha modificado");
        }else System.out.println("Ese alumno no existe");
    }

    private  void insertarAlumno(Session session, Scanner scanner) {
        System.out.println("Inserta el nombre del alumno: ");
        String nombre = scanner.next();
        System.out.println("Inserta el apellido del alumno: ");
        String apellido = scanner.next();
        System.out.println("Inserta la edad del alumno: ");
        int edad = scanner.nextInt();
        System.out.println("Inserta la nota del alumno: ");
        double nota = scanner.nextDouble();

        Alumno alumno = new Alumno(nombre, apellido, edad, nota);
        if (!existeAlumno(session, alumno.getId())) {
            session.save(alumno);
            System.out.println("El Usuario con ID " + alumno.getId() + " se ha guardado.");
        } else {
            System.out.println("El alumno con ID " + alumno.getId() + " ya existe.");
        }

    }

    private  String mostrarMenu(Scanner scanner) {
        System.out.println("Menu de opciones:");
        System.out.println("1. Consultar todos los alumnos");
        System.out.println("2. Insertar un alumno");
        System.out.println("3. Modificar un alumno");
        System.out.println("4. Borrar un alumno");
        System.out.println("0. salir");
        return scanner.next();
    }

    private  void mostrarAlumnos(Session session) {
        List<Alumno> alumnos = listarAlumnos(session);
        for (Alumno alumno : alumnos) {
            System.out.println("ID: " + alumno.getId() +
                    ", Nombre: " + alumno.getNombre() +
                    ", Apellido: " + alumno.getApellido() +
                    ", Edad: " + alumno.getEdad() +
                    ", Nota: " + alumno.getNota());
        }
    }

    private  List<Alumno> listarAlumnos(Session session) {
        Query<Alumno> query = session.createQuery("from Alumno ", Alumno.class);
        return query.getResultList();
    }

    private  boolean existeAlumno(Session session, int id) {
        Alumno alumno = session.get(Alumno.class, id);
        return alumno != null;
    }    private  Alumno buscarAlumno(Session session, int id) {
        Alumno alumno = session.get(Alumno.class, id);
        return alumno;
    }
}