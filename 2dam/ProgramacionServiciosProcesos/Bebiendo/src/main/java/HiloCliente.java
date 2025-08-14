/**
 * La clase `HiloCliente` representa un hilo que simula a un cliente bebiendo de un vaso.
 * El cliente espera a que el vaso esté lleno antes de vaciarlo.
 * Este proceso se repite un número especificado de veces.
 *
 * @author Chema y Rodrigo
 * @date 11 febrero, 2025
 */
public class HiloCliente extends Thread {
    private Vaso v;

    /**
     * Construye un nuevo `HiloCliente` con el vaso especificado.
     *
     * @param vaso el vaso que será vaciado por el cliente
     */
    public HiloCliente(Vaso vaso) {
        this.v = vaso;
    }

    /**
     * La lógica principal del hilo del cliente.
     * El cliente espera a que el vaso esté lleno antes de vaciarlo.
     * Este proceso se repite hasta que el vaso se haya vaciado un número especificado de veces.
     */
    public void run() {
        while (v.consultarVeces() <= 3) {
            synchronized (v) {
                while (!v.estaLLeno()) {
                    try {
                        System.out.println("No puedes beber, el vaso está vacío");
                        v.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                v.retardar();
                v.vaciarVaso();
                v.incrementarVeces();
                System.out.println("El cliente se ha bebido el vaso");
                v.notifyAll();
            }
        }
        System.out.println("El cliente ya ha bebido 3 veces");
    }
}