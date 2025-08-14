/**
 * @author Chema y Rodrigo
 * @date 11 febrero, 2025
 */
public class CuentaBancaria {
    /**
     * Saldo actual de la cuenta.
     */
    private int saldo;

    /**
     * Constructor que inicializa la cuenta con un saldo inicial.
     *
     * @param s saldo inicial de la cuenta
     */
    CuentaBancaria(int s) {
        saldo = s;
    }

    /**
     * Devuelve el saldo actual de la cuenta.
     *
     * @return saldo actual de la cuenta
     */
    int getSaldo() {
        return saldo;
    }

    /**
     * Retira una cantidad de dinero de la cuenta.
     *
     * @param cantidad cantidad de dinero a retirar
     */
    void retirar(int cantidad) {
        // Se resta la cantidad al saldo
        saldo = saldo - cantidad;
    }

    /**
     * Retira dinero de la cuenta de manera sincronizada.
     *
     * @param cant cantidad de dinero a retirar
     * @param nom nombre de la persona que retira el dinero
     */
    synchronized void RetirarDinero(int cant, String nom, int repeticiones) {
        // Verifica si hay saldo suficiente para realizar la retirada
        for (int i = 0; i <= repeticiones; i++){
            if (getSaldo() >= cant) {
                System.out.println("SE VA A RETIRAR SALDO (ACTUAL ES: " + getSaldo() + ")");
                try {
                    // Simula un retardo en la operación de retirada
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    System.err.println(ex);
                }
                // Realiza la retirada del dinero
                retirar(cant);
                System.out.println(nom + " retira => " + cant + " ACTUAL(" + getSaldo() + ")");
            } else {
                // Imprime el mensaje de error en caso de que no haya saldo suficiente
                System.out.println(nom + " No puede retirar dinero, NO HAY SALDO (" + getSaldo() + ")");
            }
            // Verifica si el saldo es negativo después de la operación
            if (getSaldo() < 0) {
                System.out.println("SALDO NEGATIVO => " + getSaldo());
            }
        }
    }
}
