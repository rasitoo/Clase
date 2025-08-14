/**
 * @author Chema y Rodrigo
 * @date 11 febrero, 2025
 */
public class Main {
    public static void main(String[] args) {


        CuentaBancaria c = new CuentaBancaria(40);
        Persona h1 = new Persona("Mikel", c, 15, 3);
        Persona h2 = new Persona("Nerea", c, 10, 4);

        h1.start();
        h2.start();
        try {
            h1.join();
            h2.join();
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
