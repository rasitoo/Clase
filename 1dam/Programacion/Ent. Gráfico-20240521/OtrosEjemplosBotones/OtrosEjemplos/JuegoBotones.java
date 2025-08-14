package OtrosEjemplos;
/*
 * GridLayoutDemo.java
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JuegoBotones extends JFrame {
    final static int MAXBUTTONS = 12;
    final static int NUMCOLUMNAS=3;
    final static int maxGap = 20;
    int botonRojo=0;
    GridLayout experimentLayout = new GridLayout(0,NUMCOLUMNAS);
    JButton jb[]=new JButton[MAXBUTTONS];
    Color colores[]={Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW};

    static int contAciertos =0;
    int contFallos =0;
    JFrame j;
    static JuegoBotones ventana;
    
    public JuegoBotones(String name) {
        super(name);
        setResizable(false);
    }
    void cambiarBoton() {
    	jb[botonRojo].setBackground(Color.BLUE);
    	botonRojo= aleatorio();
    	jb[botonRojo].setBackground(Color.RED);
    }
    int aleatorio() {  //devuelve valor de 0 a 5
    	return (int)(Math.random()*6);
    }
    public void addComponentsToPane(final Container pane) {
    	j=this;
        final JPanel parteSuperior = new JPanel();
        parteSuperior.setLayout(experimentLayout);
        JPanel parteInferior = new JPanel();
        parteInferior.setLayout(new GridLayout(1,3));
        		
        //Set up components preferred size
        JButton b = new JButton("Para usar en medidas.");
        Dimension buttonSize = b.getPreferredSize();
        parteSuperior.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 2.5)+maxGap,
                (int)(buttonSize.getHeight() * 3.5)+maxGap * 2));
        
        
        for (int i=0; i<MAXBUTTONS; i++){
        	jb[i]=new JButton("B"+i);
        	jb[i].setBackground(Color.BLUE);
        	parteSuperior.add(jb[i]);
        }
        cambiarBoton();
        JLabel msgAciertos= new JLabel("Aciertos: 0");
        parteInferior.add(msgAciertos);
        JLabel msgFallos= new JLabel("Fallos: 0");
        parteInferior.add(msgFallos);

        pane.add(parteSuperior, BorderLayout.NORTH);
        pane.add(new JSeparator(), BorderLayout.CENTER);
        pane.add(parteInferior, BorderLayout.SOUTH);
        for (int i=0; i<MAXBUTTONS; i++){
          jb[i].addActionListener(new ActionListener() {     
            public void actionPerformed(ActionEvent e) {
            	if ( e.getSource().equals(jb[botonRojo])) {
            		System.out.println("Acierto");
            		cambiarBoton();
            		contAciertos++;
            		msgAciertos.setText("Aciertos: "+ contAciertos);
            		if (contAciertos ==3) {
                        j.dispose();
                     //   System.exit(0);
                    }
            	}	
            	else {
                    contFallos++;
                    msgFallos.setText("Fallos: "+ contFallos);
                    System.out.println("Fallo");
                }
            }
          });
        } 
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
         ventana = new JuegoBotones("GridLayoutDemo");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        ventana.addComponentsToPane(ventana.getContentPane());
        //Display the window.
        ventana.pack();
        ventana.setVisible(true);
    }

    
    public static void main(String[] args) throws InterruptedException {
    	long inicio= System.currentTimeMillis();
        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        } 

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
          public void run() {
                createAndShowGUI();
          }
        });
        controlDelTiempo();
        long fin=System.currentTimeMillis()-inicio;
        System.out.println(fin);
        		
    }

    private static void controlDelTiempo() throws InterruptedException {
        for (int i=0; i<10 && contAciertos<3; i++) {
            Thread.sleep(3000);
            ventana.cambiarBoton();
            System.out.println("Tiempo "+i);
        }
    }
}
