import java.io.IOException;

/**
 * @author Rodrigo
 * @date 17 enero, 2025
 */
public class Main {
    public static void main(String[] args) {
        TiemposLenguajes ej = new TiemposLenguajes();

        try {
            ej.ejecutarProcesos();
            ej.leerProcesos();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
