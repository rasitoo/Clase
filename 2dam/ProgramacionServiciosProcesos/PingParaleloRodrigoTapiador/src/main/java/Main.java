import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String ipBase = "192.168.1.";
        int numProcesosSimultaneos = 10;
        List<ProcessBuilder> processBuilders = new ArrayList<>();
        List<Process> procesos = new ArrayList<>();

        //Generamos todos los ProcessBuilder con cada ip
        for (int i = 1; i <= 254; i++) {
            String ip = ipBase + i;
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C", "ping -n 6 " + ip);
            pb.redirectErrorStream(true);
            processBuilders.add(pb);
        }

        for (int i = 0; i < processBuilders.size(); i++) {
            //Si hay mas de 10 procesos entonces se termina uno de ellos
            if (procesos.size() >= numProcesosSimultaneos) {
                Process procesoTerminar = procesos.remove(0);
                procesoTerminar.waitFor();
            }
            //Se coge un processbuilder, se inicia y se añade a la lista de procesos
            ProcessBuilder pb = processBuilders.get(i);
            Process process = pb.start();
            procesos.add(process);

            //Lectura en un thread a parte
            new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String line;
                    boolean receivedResponse = false;
                    while ((line = reader.readLine()) != null) {
                        if (line.contains("TTL=")) {
                            receivedResponse = true;
                        }
                        if (line.contains("perdidos = ")) {
                            int perdidos = Integer.parseInt(line.split(" ")[13]);
                            if (perdidos > 0)
                                System.out.println(perdidos + " paquetes perdidos desde " + pb.command().get(2).split(" ")[3]);
                        }
                    }
                    if (receivedResponse) {
                        System.out.println("Respuesta desde: " + pb.command().get(2).split(" ")[3]);
                    } else {
                        //System.out.println("Sin espuesta desde: " + pb.command().get(2).split(" ")[2]);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}