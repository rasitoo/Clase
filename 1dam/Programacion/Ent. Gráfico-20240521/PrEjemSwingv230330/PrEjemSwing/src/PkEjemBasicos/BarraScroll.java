package PkEjemBasicos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class BarraScroll extends JPanel {
   JLabel posicion;
   JScrollBar BarraDesplazamientoV;
   BarraScroll (){
     setLayout (new BorderLayout());
     posicion=new JLabel ("Sin datos",JLabel.CENTER);
     add(posicion, BorderLayout.CENTER);
     BarraDesplazamientoV = new JScrollBar(JScrollBar.VERTICAL,0,5,0,100);
     add(BarraDesplazamientoV, BorderLayout.EAST);
     JScrollBar BarraDesplazamientoH = new JScrollBar(JScrollBar.HORIZONTAL,0,5,0,100);
     add(BarraDesplazamientoH, BorderLayout.SOUTH);

     BarraDesplazamientoV.addAdjustmentListener(new AdjustmentListener() {
 	    public void adjustmentValueChanged(AdjustmentEvent e) {
 		    //  label.setText("    New Value is " + e.getValue() + "      ");
 	    	posicion.setText("Posición Vertical " + BarraDesplazamientoV.getValue() + "      ");
 		      repaint();
 	    }
     });
  } 
}
