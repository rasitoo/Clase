package PkEjemBasicos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.WindowConstants;

public class Simple1ConWindowClose {

    public static void main(String arg[]) throws InterruptedException {
        JFrame ventana = new JFrame("Mi ventana de texto");
        ventana.setSize(new Dimension(260, 220));
        ventana.setVisible(true);
        System.out.println("Se muestra la ventana (sin etiqueta) y continua");
        Thread.sleep(4000);


        JLabel e = new JLabel("Mi Etiqueta");
        ventana.getContentPane().add(e, BorderLayout.CENTER);
        ventana.pack(); //Se crea una ventana del tama�o apropiado para sus componentes
        JMenuBar jmb = new JMenuBar();
        jmb.add(new JMenu("Opc1"));
        jmb.add(new JMenu("Opc2"));
        ventana.setJMenuBar(jmb);
        System.out.println("Se refresa la ventana (con etiqueta) y continua");
        ventana.repaint();
        ventana.pack();
        ventana.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Se ha cerrado la ventana");
                System.exit(0);
            }

            public void windowIconified(WindowEvent e) {
                System.out.println("Se ha iconizado la ventana");

            }
        });
        System.out.println("fin del main");
    }
}
