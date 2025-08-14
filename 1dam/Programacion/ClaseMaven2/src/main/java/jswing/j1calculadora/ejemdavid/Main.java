package jswing.j1calculadora.ejemdavid;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Main {
    String resultado = "0";
    int contSumados = 0;


    public void suma(String n) {
        int a1 = Integer.parseInt(resultado, 2);
        int a2;
        if (!n.equals("")) {
            a2 = Integer.parseInt(n, 2);
        } else {
            a2 = 0;
        }
        int resultado = a1 + a2;

        this.resultado = Integer.toString(resultado, 2);
        contSumados++;
    }

    public static void main(String[] args) {
        Main m = new Main();
        JFrame ventana = new JFrame("Calculadora");
        ventana.setLayout((new BorderLayout()));
        Texto texto = new Texto();
        ventana.add(texto, BorderLayout.NORTH);

        Botones botones = new Botones();
        ventana.add(botones, BorderLayout.SOUTH);

        ventana.pack();
        ventana.setVisible(true);

        ventana.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Se ha cerrado la ventana");
                System.exit(0);
            }
        });

        while (true) {
            texto.actualizarTexto(botones);
            if (botones.contSumados > m.contSumados && !botones.num.equals("")) {
                m.suma(botones.getNum());
                botones.setNum("");
            }
            if (botones.isSumar()) {
                m.suma(botones.getNum());
                botones.setNum("");
                botones.setSumar(false);
                while (!botones.isBorrrar())
                    texto.mostrarResult(m.resultado);
                m.contSumados = 0;
            }
            if (botones.isBorrrar()) {
                m.resultado = "0";
                m.contSumados = 0;
                botones.setBorrrar(false);
            }
        }
    }

}
