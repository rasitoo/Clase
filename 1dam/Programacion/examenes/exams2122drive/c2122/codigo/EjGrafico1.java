package Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class EjGrafico1 {
	JFrame frame;
	JButton miBoton;
	JTextField texto;
	String msg="";
	
    public EjGrafico1(String txt) throws InterruptedException {
    	Container panel;
    	frame= new JFrame(txt);
    	miBoton= new JButton("botón");
    	panel = frame.getContentPane();
    	panel.add(miBoton,BorderLayout.NORTH);
    	texto= new JTextField(txt);
    	panel.add(texto,BorderLayout.SOUTH);
     	frame.setSize(400,100);
    	frame.setVisible( true );
    	miBoton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				msg=msg+"X";
				if (msg.equals("XXXXX")) msg="";
				texto.setText(msg);			}     	});

    }

    public static void  main(String args[]) throws InterruptedException {
    	EjGrafico1 o= new EjGrafico1("TEXTO"); 
    	Thread.sleep(8000);
        o.frame.dispose();
    }
}
