import java.util.LinkedList;

/**
 * Created by desir 🥑on 27  abril, 2024
 */
public class Pila<T> {
    private LinkedList<T> elementos = new LinkedList<>();
    public void anadir(T item) { // no sabemos que tipo de parametro le pasamos
        elementos.addFirst(item); // Guardamos el primer elemento en la lista
    }
    public T sacar() {
        if (elementos.isEmpty()) { // Devuelve null si la pila esta vacia
            return null;
        } else {// Accede al ultimo elemento, lo elimina de la lista y lo devuelve
            return elementos.removeFirst();
        }
    }

    public T buscar() {
        return elementos.isEmpty() ? null : elementos.getFirst();
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }
}
