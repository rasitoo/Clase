
/*CLASE */
package PkEjemBasicos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ActionListenerTest3 {
	 public static void main(String[] args) { 
	  JFrame.setDefaultLookAndFeelDecorated(true); 
	  JFrame frame = new JFrame(); 
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	  JButton button = new JButton("Selecciona el fichero"); 
	  button.addActionListener(
			  new ActionListener() {
	    public void actionPerformed(ActionEvent e) { 
	     JFileChooser fileChooser = new JFileChooser(); 
	     int returnVal = fileChooser.showOpenDialog(null); 
	     if (returnVal == JFileChooser.APPROVE_OPTION) { 
	       System.out.println(fileChooser.getSelectedFile().getName()); 
	     }
	   } 
	 }); 
	frame.add(button); 
	frame.pack(); 
	frame.setVisible(true); 
	  }//main 
	} 

