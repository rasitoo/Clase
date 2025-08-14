/**
 * La clase Compartido representa un objeto compartido que mantiene un valor entero.
 * Proporciona métodos para sumar una cantidad al valor y para contar de manera sincronizada.
 *
 * @author Rodrigo
 * @date 04 febrero, 2025
 */
public class Compartido {
    private int valor;


    /**
     * Constructor de la clase Compartido.
     *
     * @param valor el valor inicial del objeto compartido
     */
    Compartido(int valor) {
        this.valor = valor;
    }

    /**
     * Suma una cantidad al valor actual.
     *
     * @param cantidad la cantidad a sumar
     */
    void sumar(int cantidad) {
        valor += cantidad;
    }

    /**
     * Realiza una operación de conteo sincronizada, sumando un paso un número de veces.
     * Al ser sincronizado la variable se bloquea al ser accedida por un hilo y no permite que sea accedida por el otro hasta que no termine
     *
     * @param paso el valor a sumar en cada iteración
     * @param veces el número de veces que se realizará la suma
     * @return el valor final después de realizar todas las sumas
     */
    synchronized int contador(int paso, int veces) {
        for (int i = 0; i < veces; i++) {
            sumar(paso);
        }
        return valor;
    }
}
