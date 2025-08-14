package jswing.j1calculadora;

import jswing.j1calculadora.iu.Calculadora;
import jswing.j1calculadora.servicio.Logica;

public class Main {
    public static void main(String arg[]) throws InterruptedException {
        Calculadora iu = new Calculadora();
        Logica logica = new Logica(iu);
        iu.setLogica(logica);
        iu.crearCalculadora();
    }
}
