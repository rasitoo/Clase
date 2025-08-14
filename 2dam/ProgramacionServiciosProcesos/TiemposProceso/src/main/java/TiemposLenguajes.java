import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Rodrigo
 * @date 17 enero, 2025
 */
public class TiemposLenguajes {
    //List de procesos hijo
    List<Proceso> processes = new ArrayList<>();
    //Número de procesos hijo por lenguaje
    int numChildProcesses = 6;
    ExecutorService executor = Executors.newFixedThreadPool(numChildProcesses);
    int resultadoPython = 1;
    int resultadoC = 1;
    long tiempoPython = 0;
    long tiempoC = 0;

    public void ejecutarProcesos() throws IOException {
        for (int i = 0; i < numChildProcesses; i++) {
            long startTime = System.currentTimeMillis();
            ProcessBuilder pb;
            String lenguaje;
            if (i % 2 == 0) {
                pb = new ProcessBuilder("..\\TiemposProcesoC\\x64\\Debug\\TiemposProcesoC.exe");
                lenguaje = "C++";
            } else {
                pb = new ProcessBuilder("py", "..\\TiemposProcesoPython\\randomNum.py");
                lenguaje = "Python";
            }
            Proceso process = new Proceso(startTime, lenguaje, pb.start());
            processes.add(process);
        }
    }

    public void leerProcesos() throws IOException, InterruptedException {
        for (Proceso process : processes) {
            long startTime = process.getInicio();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getProcess().getInputStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(process.getLenguaje() + " número: " + line);
                    if (process.getLenguaje().equalsIgnoreCase("Python")) {
                        try {
                            resultadoPython *= Integer.parseInt(line);

                        } catch (NumberFormatException e) {
                            System.out.println(e);
                        }
                    }
                    else  {
                        try {
                            resultadoC *= Integer.parseInt(line);

                        } catch (NumberFormatException e) {
                            System.out.println(e);
                        }
                    }
                }
            }
            process.getProcess().waitFor();
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            System.out.println(process.getLenguaje() + " tardó " + duration + " ms");
            if (process.getLenguaje().equalsIgnoreCase("Python")) {
                if (tiempoPython < duration)
                    tiempoPython = duration;
            }
            else  {
                if (tiempoC < duration)
                    tiempoC = duration;
            }
        }
        System.out.println("El resultado de Python es " + resultadoPython + " ha tardado " + tiempoPython);
        System.out.println("El resultado de C es " + resultadoC + " ha tardado " + tiempoC);
        if (tiempoC > tiempoPython)
            System.out.println("Ha tardado más C");
        else if (tiempoPython > tiempoC)
            System.out.println("Ha tardado más Python");
        else
            System.out.println("Han tardado lo mismo los dos lenguajes");
    }
}



