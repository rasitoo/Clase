package iu;


import servicio.Logica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Rodrigo
 */
public class Ventana {
    private JTextField salida = new JTextField("NADA");
    private Logica logica = new Logica(this);

    public JTextField getSalida() {
        return salida;
    }

    public void setLogica(Logica logica) {
        this.logica = logica;
    }

    public void crearVentana() {
        //Se crea la ventana
        JFrame ventana = new JFrame("Ej2 Botones");
        ventana.setMinimumSize(new Dimension(300, 200));
        ventana.setVisible(true);
        ventana.setLayout(new GridLayout(2, 1)); //una línea con lo introducido y otra con los botones

        JPanel panelbotones = new JPanel();
        panelbotones.setLayout(new GridLayout(1, 2)); //Se pone en una línea todos los botones
        anadirBoton(panelbotones, "Boton1");
        anadirBoton(panelbotones, "Boton2");


        //Se añade el panel de botones a la ventana
        ventana.add(panelbotones);
        //Se añade el bloque de salida
        salida.setEditable(false); //Solo se podrá editar mediante los botones
        ventana.add(salida);
        ventana.pack(); //Se crea una ventana del tama�o apropiado para sus componentes

        //Listener
        System.out.println("Se muestra la ventana ");
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Se ha cerrado la ventana");
                System.exit(0);
            }
        });
    }

    public void anadirBoton(JPanel panelbotones, String nombre) {
        JButton boton = new JButton(nombre);
        boton.addActionListener(e -> logica.accionBoton(nombre));
        panelbotones.add(boton);
    }

    public void modificartexto(String s) {
        getSalida().setText(s);
    }
}
