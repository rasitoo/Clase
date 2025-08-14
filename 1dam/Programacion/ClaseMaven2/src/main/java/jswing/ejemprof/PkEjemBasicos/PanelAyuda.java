package jswing.ejemprof.PkEjemBasicos;
import javax.swing.*;


public class PanelAyuda extends JPanel {
		public PanelAyuda (String msg){
		JButton miBoton= new JButton ("hola");
		miBoton.setToolTipText(msg);
		add(miBoton);  //A�ado el bot�n al panel
		}
}

