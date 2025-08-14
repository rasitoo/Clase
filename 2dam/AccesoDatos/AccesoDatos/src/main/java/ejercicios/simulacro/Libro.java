package ejercicios.simulacro;

/**
 * @author Rodrigo
 * @date 04 noviembre, 2024
 */
public class Libro {
    private String autor;
    private String editorial;
    private String codigo;
    private double precio;

    public Libro(String autor, String editorial, String codigo, double precio) {
        this.autor = autor;
        this.editorial = editorial;
        this.codigo = codigo;
        this.precio = precio;
    }

    public static void LibrosPorAutor(Libro[] libros, String autor) {
        for (Libro libro : libros) {
            if (libro.autor.equalsIgnoreCase(autor)) {
                System.out.println(libro);
            }
        }
    }

    public static Libro MenosPrecio(Libro[] libros) {
        Libro menorPrecio = libros[0];
        for (Libro libro : libros) {
            if (libro.precio < menorPrecio.precio) {
                menorPrecio = libro;
            }
        }
        return menorPrecio;
    }

    @Override
    public String toString() {
        return "Libro [Autor=" + autor + ", Editorial=" + editorial + ", Código=" + codigo + ", Precio=" + precio + "]";
    }
}
