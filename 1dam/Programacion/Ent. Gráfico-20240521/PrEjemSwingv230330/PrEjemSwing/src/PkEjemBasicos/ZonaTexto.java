package PkEjemBasicos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.*;

	public class ZonaTexto extends JPanel{
		JTextField unaLinea;
		ZonaTexto(){ 
	       setLayout (new BorderLayout());
	       unaLinea= new JTextField ();
	       JTextArea zonaTxt= new JTextArea();
	       JTextPane zonaTxtConfigurable= new JTextPane();
	       
	       MutableAttributeSet atributoTxt= new SimpleAttributeSet();
	       StyleConstants.setBold(atributoTxt,true);
	       StyleConstants.setFontSize(atributoTxt, 15);
	       zonaTxtConfigurable.setCharacterAttributes(atributoTxt, false);
	       
	       zonaTxtConfigurable.setBorder(new MatteBorder(10,20,30,40,Color.red));
	       
	       add(unaLinea, BorderLayout.NORTH);
	       add(zonaTxt, BorderLayout.SOUTH);
	       add(zonaTxtConfigurable, BorderLayout.CENTER);
	       JButton miBoton= new JButton("Aceptar");
	       add(miBoton, BorderLayout.EAST);
	       
	       class Oyente implements ActionListener{
	   		public void actionPerformed(ActionEvent e){
	   			String s=zonaTxtConfigurable.getText();	
	   			System.out.println("LINEA:"+s);
	   		  }
	   	    }
			Oyente oyente=new Oyente();
			miBoton.addActionListener(oyente);
	     
		}
	}
