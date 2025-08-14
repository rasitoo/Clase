/**
 *  La clase Suma extiende de Thread y se utiliza para realizar operaciones de suma en un objeto compartido.
 *  Cada instancia de Suma ejecuta un número específico de incrementos o decrementos en el valor compartido.
 *
 * @author Rodrigo
 * @date 31 enero, 2025
 */
public class Suma extends Thread {
    private final Compartido c;
    private final int paso;
    private final int veces;
    private int valor;

    /**
     * Obtiene el valor resultante después de ejecutar el hilo.
     *
     * @return el valor resultante
     */
    public int getValor() {
        return valor;
    }

    /**
     * Obtiene el paso de incremento o decremento.
     *
     * @return el paso
     */
    public int getPaso() {
        return paso;
    }

    /**
     * Obtiene el número de veces que se realizará la operación.
     *
     * @return el número de veces
     */
    public int getVeces() {
        return veces;
    }

    /**
     * Constructor de la clase Suma.
     *
     * @param nombre el nombre del hilo
     * @param objetoCompartido el objeto compartido en el que se realizarán las operaciones
     * @param paso el paso de incremento o decremento
     * @param veces el número de veces que se realizará la operación
     */
    public Suma(String nombre, Compartido objetoCompartido, int paso, int veces) {
        super(nombre);
        this.c = objetoCompartido;
        this.paso = paso;
        this.veces = veces;
    }

    /**
     * Método que se ejecuta cuando el hilo es iniciado.
     * Realiza la operación de suma o resta en el objeto compartido.
     */
    public void run() {
        valor = c.contador(getPaso(), getVeces());
    }
}
