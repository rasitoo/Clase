package jswing.j2simon.iu;
/*
 * GridLayoutDemo.java
 *
 */

import jswing.j2simon.servicio.Comprobacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Simon extends JFrame {
    final static int PULSACION = 1000;
    final static int CANTBOTONES = 4; //max 10
    final static int NUMRONDAS = 10;
    int ronda = 1;
    final static int maxGap = 20;
    int[] secuencia = new int[NUMRONDAS];
    int intento = 0;
    GridLayout experimentLayout = new GridLayout(0, 2);
    Boton[] jb = new Boton[CANTBOTONES];
    JFrame j;

    public Simon(String name) {
        super(name);
        setResizable(false);
    }

    void aleatorio() throws InterruptedException {
        for (int i = 0; i < ronda; i++) {
            secuencia[i] = (int) (Math.random() * CANTBOTONES);
            System.out.println(secuencia[i]);
            pintar(secuencia[i]);
        }
        ronda++;
    }

    public void addComponentsToPane(final Container pane) {
        j = this;
        final JPanel parteSuperior = new JPanel();
        parteSuperior.setLayout(experimentLayout);
        JPanel parteInferior = new JPanel();
        parteInferior.setLayout(new GridLayout(1, 3));

        //Set up components preferred size
        JButton b = new JButton("Para usar en medidas.");
        Dimension buttonSize = b.getPreferredSize();
        parteSuperior.setPreferredSize(new Dimension((int) (buttonSize.getWidth() * 2.5) + maxGap,
                (int) (buttonSize.getHeight() * 3.5) + maxGap * 2));


        for (int i = 0; i < CANTBOTONES; i++) {
            jb[i] = new Boton(i);
            parteSuperior.add(jb[i]);
        }
        //todo secuencia de luces

        parteInferior.add(new Label("Ronda: 0"));

        parteInferior.add(new Label(" "));

        pane.add(parteSuperior, BorderLayout.NORTH);
        pane.add(new JSeparator(), BorderLayout.CENTER);
        pane.add(parteInferior, BorderLayout.SOUTH);
        for (int i = 0; i < CANTBOTONES; i++) {
            int finalI = i;
            jb[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        pintar(finalI);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            });
        }
    }

    private void pintar(int finalI) throws InterruptedException {
        jb[finalI].setBackground(jb[finalI].getColor());
        Thread.sleep(PULSACION);
        jb[finalI].setBackground(jb[finalI].getColor().darker());
    }

    private void createAndShowGUI() throws InterruptedException {
        //Create and set up the window.
        Simon frame = new Simon("GridLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        Thread.sleep(1000);
        this.aleatorio();
    }

    public static void main(String[] args) throws InterruptedException {
        Simon iu = new Simon("Simon");
        Comprobacion comprobacion = new Comprobacion(iu);
        long inicio = System.currentTimeMillis();

        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        iu.createAndShowGUI();


        long fin = System.currentTimeMillis() - inicio;
        System.out.println(fin);

        while (comprobacion.isCorrecto()) {
            iu.aleatorio();
        }
    }
}
