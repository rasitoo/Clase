package PkEjemBasicos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class EjemBasico {
    public static void main(String arg[]) throws InterruptedException {
        JFrame ventana = new JFrame("ahhhhhhhhhhhhhhhhhhhhhhhhh");

        //Etiqueta e= new Etiqueta();
        Boton e= new Boton("Mi bot�n", ventana);
        //ZonaTexto e= new ZonaTexto();
        //BarraScroll e= new BarraScroll();
        //Menu e = new Menu();
        //ListaOpciones e = new ListaOpciones();
        //PanelAyuda e = new PanelAyuda("Ayuda de mi bot�n");
        ventana.getContentPane().add(e, BorderLayout.CENTER);
        ventana.setMinimumSize(new Dimension(300, 200));
        ventana.pack(); //Se crea una ventana del tama�o apropiado para sus componentes
        ventana.setVisible(true);
        System.out.println("Se muestra la ventana ");
        ventana.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Se ha cerrado la ventana");
                System.exit(0);
            }

            public void windowIconified(WindowEvent e) {
                System.out.println("Se ha iconizado la ventana");

            }
        });
    }
}
