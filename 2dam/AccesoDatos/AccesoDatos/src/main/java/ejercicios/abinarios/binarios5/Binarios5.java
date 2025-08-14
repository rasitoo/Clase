package ejercicios.abinarios.binarios5;

import java.io.*;

/**
 * @author Rodrigo
 * @date 15 octubre, 2024
 */
public class Binarios5 {
    private static final String PATH = ".\\src\\main\\resources\\Bin5.txt";

    public static void main(String[] args) {
        Libro libro;
        Libro libroMayorPrecio = new Libro();

        File origen = new File(PATH);
        try {
            if (!origen.exists())
                origen.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File destino = new File(PATH);

        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(origen)); DataOutputStream fsalida = new DataOutputStream(new FileOutputStream(destino))) {
            libro = new Libro("0100", "Largo Pétalo de Mar", "Isabel Allende", "Plaza & Janes", 21.76);
            libro.grabarLibro(fsalida);
            libro = new Libro("0200", "Come comida Real", "Carlos Rios", "Paidos", 16.15);
            libro.grabarLibro(fsalida);
            libro = new Libro("0300", "Los asquerosos", "Santiago Lorenzo", "Blackie Books", 19.95);
            libro.grabarLibro(fsalida);
            libro = new Libro("0400", "Lo mejor de ir es volver", "Albert Espinosa", "Grijalbo", 17.00);
            libro.grabarLibro(fsalida);
            libro = new Libro("0500", "Una historia de Epaña", "Arturo Perez-Reverte", "Alfaguara", 17.95);
            libro.grabarLibro(fsalida);
            libro = new Libro("0600", "Toda la verdad de mis mentiras", "Elisabet Benavent", "Suma", 17.00);
            libro.grabarLibro(fsalida);
            libro = new Libro("0700", "La novia gitana", "Carmen Mola", "Alfaguara", 18.90);
            libro.grabarLibro(fsalida);
            libro = new Libro("0800", "El viento me lleva", "Ismael Serrano", "Grijalbo", 15.11);
            libro.grabarLibro(fsalida);
            libro = new Libro("0900", "Reina Roja", "Juan Gomez-Jurado", "Libro B", 19.85);
            libro.grabarLibro(fsalida);
            libro = new Libro("1000", "Malaherba", "Manuel Jabois", "Alfaguara", 17.00);
            libro.grabarLibro(fsalida);


            System.out.println("LIBROS CON CODIGO 0100 O CON PRECIO IGUAL A 17");
            System.out.println("-----------------------------------------------");
            while (inputStream.available() > 0) {
                Libro l = libro.leer(inputStream);

                if (Double.compare(l.getPrecio(), libroMayorPrecio.getPrecio()) > 0) {
                    libroMayorPrecio = new Libro(l.getCodigo(),l.getTitulo(),l.getAutor(),l.getEditorial(),l.getPrecio());
                }
                if (l.getCodigo().equals("0100") || Double.compare(l.getPrecio(), 17) == 0) {
                    System.out.println(l);
                }
            }
            System.out.println("EL LIBRO QUE MAS CUESTA ES...");
            System.out.println("------------------------------");
            System.out.println("El libro que tiene mas precio cuesta " + libroMayorPrecio.getPrecio() + " su titulo es " + libroMayorPrecio.getTitulo() + " de la editorial " + libroMayorPrecio.getEditorial());

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
