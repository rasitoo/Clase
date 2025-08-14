package servicio;

import iu.Ventana;


/**
 * @author Rodrigo
 */

public class Logica extends Thread {
    private Ventana iu;
    private String numeroActual = "";

    public Logica(Ventana iu) { //Con el constructor creamos una copia de la iu para acceder a toda la información que ha dado el usuario y poder modificarla
        this.iu = iu;
    }

    public void accionBoton(String nombre) {
        if (nombre.equals("Boton1")) {
            numeroActual += "1";
            iu.modificartexto(numeroActual);
        } else {
            numeroActual += "2";
            iu.modificartexto(numeroActual);
        }
    }

    @Override
    public void run() {
        int sum = 0;
        try {
            Thread.sleep(10000);
            for (int i = 0; i < numeroActual.length(); i++) {
                sum += Integer.parseInt(String.valueOf(numeroActual.charAt(i)));
            }
            System.out.println(sum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
