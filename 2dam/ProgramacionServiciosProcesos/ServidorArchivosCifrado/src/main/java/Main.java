import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Clase principal que inicia múltiples clientes para conectarse al servidor.
 */
public class Main {

    /**
     * Método principal que crea un pool de hilos y ejecuta múltiples instancias del cliente.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        ExecutorService clientPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            clientPool.execute(() -> {
                try {
                    Client.main(new String[]{});
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        // Cerrar el pool de hilos
        clientPool.shutdown();
    }
}
