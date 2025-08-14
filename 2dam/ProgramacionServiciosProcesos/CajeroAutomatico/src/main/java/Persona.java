/**
 * @author Chema y Rodrigo
 * @date 11 febrero, 2025
 */
public class Persona extends Thread {

    /**
     * Referencia a la cuenta bancaria desde la que se puede retirar dinero.
     */
    private CuentaBancaria c;

    /**
     * Cantidad de dinero que la persona quiere retirar.
     */
    private int cantidad;

    /**
     * Número de veces que la persona quiere retirar dinero.
     */
    private int repeticiones;

    /**
     * Constructor de la clase Persona.
     *
     * @param n Nombre de la persona.
     * @param c Cuenta bancaria desde la que se puede retirar dinero.
     * @param cantidad Cantidad de dinero que la persona quiere retirar.
     * @param repeticiones Número de veces que la persona quiere retirar dinero.
     */
    public Persona(String n, CuentaBancaria c, int cantidad, int repeticiones) {
        super(n);
        this.c = c;
        this.cantidad = cantidad;
        this.repeticiones = repeticiones;
    }

    /**
     * Método que se ejecuta cuando se inicia el hilo.
     * Retira dinero de la cuenta bancaria la cantidad de veces especificada.
     */
    public void run() {
        c.RetirarDinero(cantidad, getName(), repeticiones);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
