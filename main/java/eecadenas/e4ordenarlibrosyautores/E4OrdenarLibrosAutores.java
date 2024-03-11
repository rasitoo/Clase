package eecadenas.e4ordenarlibrosyautores;


/**
 * @author Rodrigo🦖
 * @date 18 enero, 2024
 */
public class E4OrdenarLibrosAutores {
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
    Libro[] ordenarAutor() { //tenemos que comparar usando el compare to, si el numero es mayor significa que está antes, si es menor que 0 es que va despues, buscamos el numero mas cercano a 1 posible para que sea el inmediatamente anterior, el codigo lo que hace es coger el mayor numero y ese compararlo, si sale de nuevo un numero positivo entonces compara de nuevo usando ese nuevo nombre
        Libro[] lista = new Libro[archivo.length];
        Libro anterior = new Libro("aaaaaaaaaa", "aaaaaaaaaa");
        int menor = -9999999;
        int comp;
        for (int k = 0; k < lista.length; k++) { //buscamos el primero que va a entrar en la lista ordenada
            for (int i = 0; i < archivo.length; i++) { //cogemos autores del archivo
                comp = anterior.autor.compareToIgnoreCase(archivo[i].autor); //se comparan
                if (comp >= menor) {//averiguamos que autor esta mas cerca del anterior, si es un nume
                    if (!buscar(lista, archivo[i])) { //si ya esta anadido no lo volvemos a anadir
                        anterior = archivo[i];
                        menor = comp;
                    }
                }
            }
            lista[k] = anterior;//cuando hemos mirado todos los autores lo guardamos y pasamos al siguiente
            menor = -999999999;
        }
        return lista;
    }

    boolean buscar(Libro[] libros, Libro libro) {
        boolean anadido = false;
        for (int x = 0; x < libros.length; x++){
            if (libros[x] != null && libros[x].autor.equalsIgnoreCase(libro.autor)){ //si ya esta en la lista no lo volvemos a añadir, falla al diferencia albert y aldous
                anadido = true;
                break;
            }
        }
        return anadido;
    }

    void mostrar(Libro[] libros) {
        for (int i = 0; i < libros.length; i++) {
            System.out.println(libros[i].autor + "-->" + libros[i].titulo);
        }
    }

    public static void main(String[] args) {
        E4OrdenarLibrosAutores ej = new E4OrdenarLibrosAutores();

        ej.mostrar(ej.ordenarAutor());

    }
}
