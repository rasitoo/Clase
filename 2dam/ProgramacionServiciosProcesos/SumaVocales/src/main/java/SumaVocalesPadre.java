import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase SumaVocalesPadre se encarga de iniciar procesos hijo para contar las vocales en un archivo de entrada.
 * <p>
 * La clase lanza cinco procesos hijo, cada uno contando una vocal específica (a, e, i, o, u) en el archivo de entrada.
 * Luego, los resultados se escriben en archivos de salida separados.
 * <p>
 *
 * @author Chema y Rodrigo
 * @date 14 enero, 2025
 */
public class SumaVocalesPadre {
    //List de procesos hijo
    List<Process> processes = new ArrayList<>();
    //Array de vocales
    String[] vocals = {"a", "e", "i", "o", "u"};
    //Array de nombre de archivos de salida
    String[] outputFiles = {"resultadoa.txt", "resultadoe.txt", "resultadoi.txt", "resultadoo.txt", "resultadou.txt"};
    //Número de procesos hijo (tantos como vocales)
    int numChildProcesses = vocals.length;


    /**
     * Inicia los procesos hijo para contar las vocales en el archivo de entrada.
     * <p>
     * Este método lanza cinco procesos hijo, cada uno contando una vocal específica en el archivo de entrada.
     * Los resultados se escriben en archivos de salida separados.
     * Espera a que todos los procesos terminen.
     * <p>
     *
     * @throws IOException Si ocurre un error de E/S.
     */
    public void iniciarProcesosHijo() throws IOException {
        //Creamos un bucle para que cree todos los procesos hijo necesarios
            for (int i = 0; i < numChildProcesses; i++) {
                //Primero creamos las variables que vamos a pasar a los procesos hijo
                String inputFile = "entrada2.txt";
                String vocal = vocals[i];
                String outputFile = outputFiles[i];

                //Creamos el proceso hijo correspondiente con el comando java -cp, luego debe recibir de argumentos el classpath y el nombre de la clase y lo añadimos al arraylist de procesos
                ProcessBuilder pb = new ProcessBuilder("java", "-cp", "target\\classes", "SumaVocalHijo");
                Process process = pb.start();
                processes.add(process);
                //Utilizamos el PrintStream en un try with resources para que se cierre automáticamente tras pasarle al proceso hijo los atributos que hemos asignado anteriormente
                try (PrintStream ps = new PrintStream(process.getOutputStream(), true)) {
                    ps.println(inputFile);
                    ps.println(vocal);
                    ps.println(outputFile);
                }
            }

        //esperar a que todos los procesos hijo terminen para que así al luego sumar los numeros de todos los archivos estos estén actualizados
        for (Process process : processes) {
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    /**
     * Calcula el total de vocales contadas previamente por los procesos hijo.
     * <p>
     * Este método lee los archivos de salida generados por los procesos hijo,
     * suma los conteos de vocales y muestra el total en la consola.
     * </p>
     */
    public void totalVocales() {
        int count = 0;
        //Bucle for a traves de todos los archivos de salida
        for (String outputFile : outputFiles) {
            try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
                String line;
                //Lee la línea, le hace un parseInt para pasarla a número, si no es un número el catch recoge la excepción y luego lo suma a count
                while ((line = reader.readLine()) != null) {
                    count += Integer.parseInt(line);
                }
            } catch (NumberFormatException exception) {
                System.out.println( exception +" No es un número");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //Saca por pantalla el número total de vocales
        System.out.println("En total hay " + count + " vocales");
    }
}
