package Ia.copilot;

/**
 * @author Rodrigo
 * @date 12 febrero, 2025
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Clase principal que realiza el ping a las IPs en el rango especificado.
 * Realizada utilizando microsoft copilot, el codigo no es correcto y no funciona correctamnte, la peor respuesta de las tres ias
 */
public class PingNetwork {
    // Direcciones IP que responden
    private static List<String> responsiveIPs = new ArrayList<>();

    /**
     * Método principal que ejecuta el programa.
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Determinar la IP base a partir de la IP del sistema
        String baseIP = "192.168.16.";
        if (baseIP == null) {
            System.err.println("No se pudo determinar la IP base.");
            return;
        }

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 20; i++) {
            String ip = baseIP + i;
            executor.submit(new PingTask(ip));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Esperar a que todos los procesos terminen
        }

        System.out.println("IPs que respondieron:");
        for (String ip : responsiveIPs) {
            System.out.println(ip);
        }
    }


    /**
     * Tarea que realiza el ping a una dirección IP específica.
     */
    static class PingTask implements Runnable {
        private String ip;

        public PingTask(String ip) {
            this.ip = ip;
        }

        @Override
        public void run() {
            try {
                Process process = Runtime.getRuntime().exec("ping -n 6 " + ip);
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                boolean receivedReply = false;
                while ((line = reader.readLine()) != null) {
                    if (line.contains("Received = 0")) {
                        System.out.println("No se recibió respuesta de: " + ip);
                        return;
                    }
                    if (line.contains("Reply from")) {
                        receivedReply = true;
                    }
                }
                if (receivedReply) {
                    synchronized (responsiveIPs) {
                        responsiveIPs.add(ip);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
