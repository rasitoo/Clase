import java.io.IOException;

/**
 * La clase Main
 * Esta clase crea una instancia de SumaVocalesPadre y llama al método iniciarProcesosHijo para iniciar los procesos hijo que contarán las vocales en el archivo de entrada.

 * @author Chema y Rodrigo
 * @date 14 enero, 2025
 */
public class Main {
    /**
     * El método main de la clase Main.
     * <p>
     * Este método crea una instancia de SumaVocalesPadre y llama al método iniciarProcesosHijo para iniciar los procesos hijo que contarán las vocales en el archivo de entrada. Una vez los procesos hijo han terminado se llama al método totalVocales que suma el numero de vocales que se encuentran en los diferentes archivos
     * <p>
     * Utilizamos de ejemplo<a href="https://www.jesusninoc.com/11/01/comunicacion-entre-proceso-padre-e-hijo/"> comunicación padre e hijo</a> y texto de entrada sacado de <a href="https://gist.github.com/jsdario/6d6c69398cb0c73111e49f1218960f79">Quijote en texto plano</a>
     *
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        SumaVocalesPadre ej = new SumaVocalesPadre();
        try {
            ej.iniciarProcesosHijo();
            ej.totalVocales();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}