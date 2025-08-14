package PkEjemBasicos;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.*;

public class Etiqueta extends JPanel {
    public Etiqueta() {
        setLayout(new BorderLayout());
        JLabel etiqueta = new JLabel("Texto de la etiqueta");
        etiqueta.setHorizontalAlignment(JLabel.CENTER);
        add(etiqueta, BorderLayout.NORTH);  //A�ado la etiqueta al panel

        JLabel etiqueta2 = new JLabel("Otra etiqueta");
        etiqueta2.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 22));
        ImageIcon miFoto = new ImageIcon("iconoEstrella.jpg");
        etiqueta2.setIcon(miFoto);
        etiqueta2.setHorizontalAlignment(JLabel.RIGHT);
        add(etiqueta2, BorderLayout.SOUTH);
    }
}


