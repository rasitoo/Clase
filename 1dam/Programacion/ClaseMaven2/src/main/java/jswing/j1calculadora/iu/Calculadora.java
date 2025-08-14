package jswing.j1calculadora.iu;

import jswing.j1calculadora.servicio.Logica;
import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Rodrigo
 * @date 17 abril, 2024
 */
@Data
public class Calculadora {
    private JTextField salida = new JTextField();
    private Logica logica;

    public void crearCalculadora() {
        //Se crea la ventana
        JFrame ventana = new JFrame("Calculadora binaria");
        ventana.setMinimumSize(new Dimension(300, 200));
        ventana.setVisible(true);
        ventana.setLayout(new GridLayout(2, 1)); //una línea con lo introducido y otra con los botones

        //Se crea el panel con los botones, en el ejemplo del profe se usa un get para coger el panel y modificarlo, yo creo uno nuevo y lo añado
        JPanel panelbotones = new JPanel();
        panelbotones.setLayout(new GridLayout(1, 5)); //Se pone en una línea todos los botones
        anadirBoton(panelbotones, "0");
        anadirBoton(panelbotones, "1");
        anadirBoton(panelbotones, "+");
        anadirBoton(panelbotones, "=");
        anadirBoton(panelbotones, "C");
        //Se añade el bloque de salida y luego los botones
        salida.setEditable(false); //Solo se podrá editar mediante los botones
        ventana.add(salida);
        //Se añade el panel de botones a la ventana
        ventana.add(panelbotones);
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
//        boton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                logica.accionBoton(nombre);
//            }
//        });
        panelbotones.add(boton);
    }

    public void modificartexto(String s) {
        getSalida().setText(s);
    }
}
