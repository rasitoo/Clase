/**
 * La clase `Bar` representa el punto de entrada principal del programa.
 * En esta clase se crean y gestionan los hilos que simulan la interacción
 * entre un camarero y un cliente con un vaso compartido.
 *
 * El camarero llena el vaso y el cliente lo vacía, repitiendo este proceso
 * un número determinado de veces.
 *
 * El método `main` es el encargado de iniciar y coordinar estos hilos.
 *
 * @author Chema y Rodrigo
 * @date 11 febrero, 2025
 */
public class Bar {


    /**
     * El método principal del programa. Crea el recurso compartido (vaso)
     * y los hilos (camarero y cliente), y los inicia.
     *
     * @param args los argumentos de la línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        // Creación del recurso compartido.
        Vaso vaso = new Vaso();

        // Creación de los hilos:

        // EL PRODUCTOR.
        HiloCamarero camarero = new HiloCamarero(vaso);

        // EL CONSUMIDOR.
        HiloCliente cliente = new HiloCliente(vaso);

        // Arranque de los hilos (no importa el orden).
        cliente.start();
        camarero.start();

        // Encolamiento de ambos con respecto al main.
        try {
            cliente.join();
            camarero.join();
        } catch (InterruptedException ie) {
            System.out.println("ERROR DE ENCOLAMIENTO");
            ie.printStackTrace();
        }

        System.out.println("\n\n --- MAIN DICE QUE SE TERMINO --- \n");
    }
}
