/**
 * La clase Main es el punto de entrada de la aplicación.
 * Crea instancias de la clase Compartido y de la clase Suma,
 * y ejecuta dos hilos(clase Suma) que modifican el valor compartido.
 *
 * @author Rodrigo
 * @date 31 enero, 2025
 */
public class Main {
    public static final Integer inicio = 100;
    /**
     * Método principal que inicia la ejecución de la aplicación.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Compartido c = new Compartido(inicio);
        Suma h1 = new Suma("hilo1", c, 1, 70000);
        Suma h2 = new Suma("hilo2", c, -1, 70000);

        h1.start();
        h2.start();
        try {
            h1.join();
            h2.join();
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(h1.getName() + ": " + h1.getValor());
        System.out.println(h2.getName() + ": " + h2.getValor());

    }
}
