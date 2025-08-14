package PkEjemBasicos;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Un bot�n y una etiqueta dentro de un panel 
public class Boton extends JPanel {
    int contPulsaciones = 0;
    //La etiqueta no puede ser definida dentro del constructor.
    //Se tiene que definir como atributo.
    JLabel etiqueta = new JLabel("Pulsaciones:" + contPulsaciones);


    Boton(String nombre, JFrame ventana) {
        Icon miFoto = new ImageIcon("iconoEstrella.jpg");
        JButton miBoton = new JButton(nombre, miFoto);
        miBoton.setMnemonic(KeyEvent.VK_I); //Si pulso la ALT+ I se pulsa el bot�n
        add(miBoton);
        add(etiqueta);
        miBoton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contPulsaciones++;
                etiqueta.setText("Pulsaciones:" + contPulsaciones);
            }
        });
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 200);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(null);

        Boton boton = new Boton("Aceptar", ventana);
        ventana.add(boton);

        ventana.setVisible(true);
    }
}
