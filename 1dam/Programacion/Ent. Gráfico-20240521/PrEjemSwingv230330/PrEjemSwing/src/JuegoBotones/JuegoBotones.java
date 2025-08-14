package JuegoBotones;
/*
 * GridLayoutDemo.java
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JuegoBotones extends JFrame {
    final static int maxGap = 20;
    int botonRojo=0;
    GridLayout experimentLayout = new GridLayout(0,2);
    JButton jb[]=new JButton[10];
    int c=0;
    JFrame j;
    
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
        
        
        for (int i=0; i<6; i++){
        	jb[i]=new JButton("B"+i);
        	jb[i].setBackground(Color.BLUE);
        	parteSuperior.add(jb[i]);
        }
        cambiarBoton();
        
        parteInferior.add(new Label("Aciertos: 0"));

        parteInferior.add(new Label(" "));
      
        pane.add(parteSuperior, BorderLayout.NORTH);
        pane.add(new JSeparator(), BorderLayout.CENTER);
        pane.add(parteInferior, BorderLayout.SOUTH);
        for (int i=0; i<6; i++){
          jb[i].addActionListener(new ActionListener() {     
            public void actionPerformed(ActionEvent e) {
            	if ( e.getSource().equals(jb[botonRojo])) {
            		System.out.println("Acierto");
            		cambiarBoton();
            		c++;
            		if (c==3)
							j.dispose();
            	}	
            	else
            		System.out.println("Fallo");
            }
          });
        } 
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JuegoBotones frame = new JuegoBotones("GridLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
    	long inicio= System.currentTimeMillis();
        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        } 

  //      javax.swing.SwingUtilities.invokeLater(new Runnable() {
  //          public void run() {
                createAndShowGUI();
  //          }
  //      });
        long fin=System.currentTimeMillis()-inicio;
        System.out.println(fin);
        		
    }
}
