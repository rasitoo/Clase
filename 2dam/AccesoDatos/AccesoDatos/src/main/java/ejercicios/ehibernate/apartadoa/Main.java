package ejercicios.ehibernate.apartadoa;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * @author Rodrigo
 * @date 20 noviembre, 2024
 */

public class Main {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuarios.class).buildSessionFactory(); Scanner scanner = new Scanner(System.in)) {
            ejecutarMenu(factory, scanner);
        }
    }

    private static void ejecutarMenu(SessionFactory factory, Scanner scanner) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
//            anadirUsuarios(session);
            session.getTransaction().commit();
        }

        while (true) {
            String opcion = mostrarMenu(scanner);
            switch (opcion) {
                case "1":
                    mostrarUsuarios(factory);
                    break;
                case "2":
                    mostrarUsuariosPorCategoria(factory, scanner);
                    break;
                case  "0":
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static String mostrarMenu(Scanner scanner) {
        System.out.println("Menu de opciones:");
        System.out.println("1. Consultar todos los usuarios");
        System.out.println("2. Consultar usuarios por categoría");
        System.out.println("0. salir");
        return scanner.next();
    }

    private static void mostrarUsuarios(SessionFactory factory) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Usuarios> users = listarUsuarios(session);
            for (Usuarios user : users) {
                System.out.println("ID: " + user.getId() +
                        ", Nombre: " + user.getNombre() +
                        ", Categoria: " + user.getCategoria() +
                        ", Permiso: " + user.getPermiso());
            }
            session.getTransaction().commit();
        }
    }

    private static void mostrarUsuariosPorCategoria(SessionFactory factory, Scanner scanner) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Usuarios> usuarios = listarUsuarios(session);
            System.out.println("Introduce la categoría de usuarios que deseas consultar:");
            String categoria = scanner.next();
            for (Usuarios user : usuarios) {
                if (user.getCategoria().equalsIgnoreCase(categoria)) {
                    System.out.println("ID: " + user.getId() +
                            ", Nombre: " + user.getNombre() +
                            ", Categoria: " + user.getCategoria() +
                            ", Permiso: " + user.getPermiso());
                }
            }            session.getTransaction().commit();
        }
    }

    private static List<Usuarios> listarUsuarios(Session session) {
        Query<Usuarios> query = session.createQuery("from Usuarios", Usuarios.class);
        return query.getResultList();
    }



//    private static void anadirUsuarios(Session session) {
////        List<Usuarios> nuevosUsuarios = List.of(
////                new Usuarios(1, "Carlos Diaz", "Basico", "Usuario Invitado"),
////                new Usuarios(2, "Luis Ruiz", "Basico", "Usuario Invitado"),
////                new Usuarios(3, "Carlos Diaz", "Jefe", "Usuario Administrador"),
////                new Usuarios(4, "Kevin Manzano", "Administrador", "Super Usuario")
////        );
//
//        for (Usuarios usuario : nuevosUsuarios) {
//            if (!existeUsuario(session, usuario.getId())) {
//                session.save(usuario);
//                System.out.println("El Usuario con ID " + usuario.getId() + " se ha guardado.");
//            } else {
//                System.out.println("El usuario con ID " + usuario.getId() + " ya existe.");
//            }
//        }
//    }

    private static boolean existeUsuario(Session session, int id) {
        Usuarios user = session.get(Usuarios.class, id);
        return user != null;
    }
}