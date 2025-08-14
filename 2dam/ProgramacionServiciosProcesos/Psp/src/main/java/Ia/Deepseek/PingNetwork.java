package Ia.Deepseek;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Rodrigo
 * @date 12 febrero, 2025
 *
 * Esta clase realiza un ping a todas las direcciones IP en el rango x.y.z.1 hasta x.y.z.254,
 * donde x.y.z.p es la dirección IP del equipo en el que se ejecuta la aplicación.
 * Se crea un proceso separado para cada ping, y no se permiten más de 10 procesos en ejecución simultánea.
 * Se ocultan los mensajes del comando ping, pero se indica si algún paquete no ha llegado.
 *
 * Realizado con Deepseek, el codigo hace ping pero interpreta todas respuestas como validas, no funciona correctamente
 */
public class PingNetwork {

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        try {
            // Obtiene la dirección IP local del equipo
            InetAddress localHost = InetAddress.getLocalHost();
            String localIp = localHost.getHostAddress();
            String[] ipParts = localIp.split("\\.");

            // Construye el prefijo de la dirección IP (x.y.z.)
            String ipPrefix = ipParts[0] + "." + ipParts[1] + "." + ipParts[2] + ".";

            // Crea un pool de hilos con un máximo de 10 hilos simultáneos
            ExecutorService executor = Executors.newFixedThreadPool(10);

            // Itera sobre todas las direcciones IP en el rango 1-254
            for (int i = 1; i <= 254; i++) {
                String ip = ipPrefix + i;
                executor.execute(new PingTask(ip));
            }

            // Cierra el pool de hilos después de que todas las tareas se hayan completado
            executor.shutdown();
        } catch (UnknownHostException e) {
            System.err.println("No se pudo obtener la dirección IP local: " + e.getMessage());
        }
    }

    /**
     * Esta clase representa una tarea de ping a una dirección IP específica.
     */
    private static class PingTask implements Runnable {
        private final String ip;

        /**
         * Constructor de la tarea de ping.
         *
         * @param ip La dirección IP a la que se realizará el ping.
         */
        public PingTask(String ip) {
            this.ip = ip;
        }

        /**
         * Ejecuta el comando ping para la dirección IP especificada.
         * Si se recibe al menos una respuesta válida, se muestra la dirección IP.
         * Si algún paquete no llega, se indica en la salida.
         */
        @Override
        public void run() {
            try {
                // Ejecuta el comando ping con 6 paquetes
                Process process = Runtime.getRuntime().exec("ping -n 6 " + ip);
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                boolean receivedResponse = false;
                boolean packetLost = false;

                // Lee la salida del comando ping
                while ((line = reader.readLine()) != null) {
                    if (line.contains("Respuesta desde")) {
                        receivedResponse = true;
                    } else if (line.contains("Paquete perdido")) {
                        packetLost = true;
                    }
                }

                // Muestra la dirección IP si se recibió al menos una respuesta válida
                if (receivedResponse) {
                    System.out.println("Respuesta válida desde: " + ip);
                }

                // Indica si algún paquete no llegó
                if (packetLost) {
                    System.out.println("Algunos paquetes no llegaron a: " + ip);
                }

                // Espera a que el proceso de ping termine
                process.waitFor();
            } catch (IOException | InterruptedException e) {
                System.err.println("Error al ejecutar el ping a " + ip + ": " + e.getMessage());
            }
        }
    }
}