/**
 * La clase `HiloCamarero` representa un hilo que simula a un camarero llenando un vaso.
 * El camarero espera a que el vaso esté vacío antes de llenarlo.
 * Este proceso se repite un número especificado de veces.
 *
 * @author Chema y Rodrigo
 * @date 11 febrero, 2025
 */
public class HiloCamarero extends Thread {
    private Vaso v;

    /**
     * Construye un nuevo `HiloCamarero` con el vaso especificado.
     *
     * @param vaso el vaso que será llenado por el camarero
     */
    public HiloCamarero(Vaso vaso) {
        this.v = vaso;
    }

    /**
     * La lógica principal del hilo del camarero.
     * El camarero espera a que el vaso esté vacío antes de llenarlo.
     * Este proceso se repite hasta que el vaso se haya llenado un número especificado de veces.
     */
    public void run() {
        while (v.consultarVeces() < 3) {
            synchronized (v) {
                while (v.estaLLeno()) {
                    try {
                        System.out.println("No puedes llenar el vaso todavía");
                        v.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                v.llenarVaso();
                System.out.println("Se ha llenado el vaso");
                v.notifyAll();
            }
        }
    }
}