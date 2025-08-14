package jswing.j1calculadora.ejemdavid;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Botones extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    String num = "";
    boolean sumar = false;
    boolean borrrar = false;
    int contSumados = 0;


    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public boolean isSumar() {
        return sumar;
    }

    public void setSumar(boolean sumar) {
        this.sumar = sumar;
    }

    public int getContSumados() {
        return contSumados;
    }

    public void setContSumados(int contSumados) {
        this.contSumados = contSumados;
    }

    public boolean isBorrrar() {
        return borrrar;
    }

    public void setBorrrar(boolean borrrar) {
        this.borrrar = borrrar;
    }

    Botones() {
        setLayout(new FlowLayout());
        JButton uno = new JButton("1");
        JButton cero = new JButton("0");
        JButton suma = new JButton("+");
        JButton igual = new JButton("=");
        JButton borrar = new JButton("C");
        add(uno);
        add(cero);
        add(suma);
        add(igual);
        add(borrar);

        uno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num = num + "1";
            }
        });

        cero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num = num + "0";
            }
        });

        suma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contSumados++;
            }
        });

        igual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sumar = true;
            }
        });

        borrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num = "";
                borrrar = true;
                contSumados = 0;
            }
        });


    }

}
