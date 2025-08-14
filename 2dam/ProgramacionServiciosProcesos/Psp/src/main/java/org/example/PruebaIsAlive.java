package org.example;

import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class PruebaIsAlive {

    public static int MAX_TIEMPO = 11;

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder();
        //  String[] comando = new String[]{"bash", "-c" , "/usr/bin/java", "--version"};  //cuidado
        //  String[] comando = new String[]{ "java", "--version"}; // en windows
        //  String[] comando = new String[]{ "bash","-c","pwd"}; // en windows da /mnt/c/Users/josema/Documents/java/ProyecJetBrains/PSP/ProcesosPesados/EsperaFinProcesoSleep
        // String[] comando = new String[]{ "java", "./target/classes/org/EscribeCadaSeg"}; // en windows
        //colocar el fichero .class en el directorio org/example de la raiz del proyecto
        File miDir = new File(".");
        String dirActual = "";
        try {
            dirActual = miDir.getCanonicalPath();
            System.out.println("Dir actual:" + dirActual);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String directorioRemotoLinux = "/home/jperez/org/example";
        pb.directory(new File(directorioRemotoLinux));
        String[] cmdCopiaFich = new String[]{"cp",
                dirActual + "/src/main/java/org/example/EscribeCadaSeg.java",
                directorioRemotoLinux};
        System.out.println(Arrays.toString(cmdCopiaFich));
        String[] comando;

        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            System.out.println("En windows");
            comando = new String[]{"java", "org.example.EscribeCadaSeg"}; // en windows
        } else {
            System.out.println("En wsl");
            pb = new ProcessBuilder(cmdCopiaFich);
            pb.inheritIO();
            try {
                pb.start();
            } catch (IOException e) {
                System.out.println("Error en la copia");
            }
            comando = new String[]{"/bin/javac", "EscribeCadaSeg.java"}; // en wsl
            try {
                pb.start();
            } catch (IOException e) {
                System.out.println("Error en compilación");
            }
            comando = new String[]{"/bin/java", "org.example.EscribeCadaSeg"}; // en wsl
            try {
                pb.start();
            } catch (IOException e) {
                System.out.println("Error en ejecución");
            }
        }
        pb = new ProcessBuilder(comando);
        pb.inheritIO();
        try {

            Process p = pb.start();
            int i = 0;
            boolean fin = false;
            while (!fin) {
                System.out.printf("Verificación %d: ", i++);
                if (p.isAlive()) {
                    System.out.println("Proceso está vivo.");
                    Thread.sleep(3000);
                } else {
                    System.out.println("Proceso no está vivo.");
                    fin = true;
                }
            }

        } catch (IOException e) {
            System.err.println("Error durante ejecución del proceso");
            e.printStackTrace();
        } catch (InterruptedException ex) {
            System.err.println("Proceso interrumpido");
        }
    }

}
