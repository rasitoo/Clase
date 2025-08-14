package jswing.j1calculadora.ejemdavid;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class Texto extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel line;
	
	
	void mostrarResult(String n) {
		line.setText("RESULTADO: "+n);
	}
	void actualizarTexto(Botones b) {
		line.setText(b.getNum());
	}
	
	
	Texto(){
		setLayout(new BorderLayout());
		line = new JLabel ("0");
		add(line, BorderLayout.NORTH);
	    line.setBorder(new MatteBorder(10,20,10,20,Color.white));
	}

}
