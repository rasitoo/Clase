package Ia.ChatGPT;

/**
 * @author Rodrigo
 * @date 12 febrero, 2025
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Aplicación para realizar un ping a un rango de direcciones IP en la misma subred.
 * Ejecuta pings en paralelo con un máximo de 10 procesos simultáneos.
 *
 * Realizada con ChatGPT, el código funciona correctamente, es la ia que ha dado mejor resultado
 */
public class PingNetwork {
    private static final int MAX_THREADS = 10;
    private static final int PING_COUNT = 6;

    public static void main(String[] args) throws IOException {
        String localIp = InetAddress.getLocalHost().getHostAddress();
        String subnet = localIp.substring(0, localIp.lastIndexOf('.') + 1);
        ExecutorService executor = Executors.newFixedThreadPool(MAX_THREADS);
        List<Future<String>> results = new ArrayList<>();

        for (int i = 1; i <= 254; i++) {
            String ip = subnet + i;
            results.add(executor.submit(() -> ping(ip)));
        }

        executor.shutdown();

        for (Future<String> result : results) {
            try {
                String response = result.get();
                if (!response.isEmpty()) {
                    System.out.println(response);
                }
            } catch (Exception e) {
                System.err.println("Error obteniendo resultado: " + e.getMessage());
            }
        }
    }

    /**
     * Realiza un ping a la dirección IP especificada y devuelve un mensaje si hay respuesta.
     * @param ip Dirección IP a la que se hará el ping.
     * @return Mensaje con la IP si responde o si hay paquetes perdidos.
     */
    private static String ping(String ip) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("ping", "-n", String.valueOf(PING_COUNT), ip);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            int received = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("TTL=")) {
                    received++;
                }
            }
            process.waitFor();

            if (received > 0) {
                return "Respuesta válida de: " + ip + " (Paquetes recibidos: " + received + ")";
            } else {
                return "Paquetes perdidos para: " + ip;
            }
        } catch (Exception e) {
            return "Error al hacer ping a " + ip + ": " + e.getMessage();
        }
    }
}

