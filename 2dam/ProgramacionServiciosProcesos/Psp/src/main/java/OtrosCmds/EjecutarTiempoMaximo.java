package OtrosCmds;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class EjecutarTiempoMaximo {
    public static int MAXTIEMPO = 500;

    public static void main(String args[]) {
        ProcessBuilder pb = new ProcessBuilder(new String[]{"find", "/", "-name", "\"*\""});

        pb.inheritIO();
        pb.redirectErrorStream(true);
        try {
            Process p = pb.start();
            if (!p.waitFor(MAXTIEMPO, TimeUnit.MILLISECONDS)) {
                p.destroy();
                System.out.println("No finalizó en el tiempo estipulado");
            }
        } catch (IOException e) {
            System.err.println("Error durante la ejecución");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
