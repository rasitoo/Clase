import iu.Ventana;

import servicio.Logica;

public class Main {
    public static void main(String arg[]) throws InterruptedException {
        Ventana c = new Ventana();
        Logica logica = new Logica(c);
        Thread log = new Thread(logica);

        c.setLogica(logica);
        c.crearVentana();
        log.start();
    }
}
