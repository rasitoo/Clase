package ecadenas.e1libros;

import java.util.Scanner;

/**
 * @author Rodrigo🦖
 * @date 18 enero, 2024
 */
public class E1LibrosAutores {
    Libro[] archivo = {new Libro("Gabriel García Márquez", "Cien años de soledad"),
            new Libro("Fiodor Dostoyevski", "Crimen y castigo"),
            new Libro("Jorge Luis Borges", "Ficciones"),
            new Libro("Franz Kafka", "La metamorfosis"),
            new Libro("Ernest Hemingway", "El viejo y el mar"),
            new Libro("William Faulkner", "El ruido y la furia"),
            new Libro("Albert Camus", "El extranjero"),
            new Libro("George Orwell", "1984"),
            new Libro("Aldous Huxley", "Un mundo feliz"),
            new Libro("Ray Bradbury", "Fahrenheit 451")};

    String buscarAutor(String titulo) {
        String autor = null;
        String[] palabrasarchivo;
        String[] palabrastitulo = titulo.split(" "); //separamos las palabras del titulo que buscamos

        for (int i = 0; i < archivo.length; i++) { //por cada libro en el archivo comprobamos
            palabrasarchivo = archivo[i].titulo.split(" "); //separamos las palabras del titulo con el que comparamos
            for (int j = 0; j < palabrasarchivo.length; j++) { //cogemos una palabra del archivo
                for (int k = 0; k < palabrastitulo.length; k++) { //cogemos otra palabra del titulo
                    if (palabrasarchivo[j].equalsIgnoreCase(palabrastitulo[k])) { //comparamos si son iguales
                        autor = archivo[i].autor;
                        break; //¿? Aún con el break sigue ejecutandose
                    }
                }
            }
        }

        return autor;
    }

    public static void main(String[] args) {
        E1LibrosAutores ej = new E1LibrosAutores();
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Qué libro quieres buscar?");
        String autor = ej.buscarAutor(sc.nextLine());
        if (autor == null)
            System.out.println("No encontrado");
        else System.out.println(autor);

    }
}
