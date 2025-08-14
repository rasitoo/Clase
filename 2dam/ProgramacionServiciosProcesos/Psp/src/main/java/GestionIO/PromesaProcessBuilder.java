package GestionIO;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class PromesaProcessBuilder {

    public static void main(String[] args) {

        System.out.println("Promesa con ProcessBuilder");
        ExecutorService pool = Executors.newSingleThreadExecutor();

        ProcessBuilder processBuilder = new ProcessBuilder();

        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            processBuilder.command("cmd.exe", "/C", "ping google.com");  //puede requerir privilegios
            System.out.println("En windows");
        } else {
            processBuilder.command("bash", "-c", "ping -c 4 google.com");
            System.out.println("En unix");
        }

        try {

            Process process = processBuilder.start();

            System.out.println("process ping...");
            MiProcesoParaLectura miTarea = new MiProcesoParaLectura(process.getInputStream());

            // Esperamos porque recibimos una promesa, es asíncrono
            // Le decimos que se ejecute una tarea como hilo
            Future<List<String>> future = pool.submit(miTarea);

            // no bloqueo, se puede usar otras tareas aquí
            int i=0;
            while(!future.isDone()) {
                System.out.println("Esperando..."+i++);
                Thread.sleep(300);
            }
            System.out.println("Fin espera futuro, espero un poco más sino está finalizado");
            // Esperamos que se cumpla la tarea 5 segundos
            List<String> resultado = future.get(4, TimeUnit.SECONDS);
            resultado.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }

    private static class MiProcesoParaLectura implements Callable<List<String>> {

        private final InputStream inputStream;

        public MiProcesoParaLectura(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        @Override
        public List<String> call() {
            return new BufferedReader(new InputStreamReader(inputStream))
                    .lines()
                    .collect(Collectors.toList());
        }
    }
}
