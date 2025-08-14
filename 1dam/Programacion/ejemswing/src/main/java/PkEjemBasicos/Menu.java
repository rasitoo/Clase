package PkEjemBasicos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionListener;


public class Menu extends JPanel {
    String opciones[] = {"Opc1", "Opc2", "Opc3"};
    JLabel mensaje;
    JComboBox menu1;

    Menu() {
        mensaje = new JLabel("Seleccionado:Opc por defecto", JLabel.CENTER);
        menu1 = new JComboBox();
        for (int i = 0; i < opciones.length; i++)
            menu1.addItem(opciones[i]);
        menu1.setEditable(true);
        menu1.setSelectedItem(" Opc. por defecto");
        menu1.setMaximumRowCount(4);
        menu1.addActionListener(null);
        menu1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mensaje.setText("Seleccionado:" + menu1.getSelectedItem().toString());
            }
        });
        add(menu1);
        add(mensaje);
    }
}
