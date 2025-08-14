package ejercicio3hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 03 diciembre, 2024
 */
public class Main {
    public static void main(String[] args) {
        Ejer3Logica ej = new Ejer3Logica();
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(); Scanner scanner = new Scanner(System.in)) {
            ej.ejecutarMenu(factory, scanner);
        }
    }
}
