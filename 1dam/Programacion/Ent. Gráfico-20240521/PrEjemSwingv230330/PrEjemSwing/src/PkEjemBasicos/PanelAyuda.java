package PkEjemBasicos;
import javax.swing.*;


public class PanelAyuda extends JPanel {
		public PanelAyuda (String msg){
		JButton miBoton= new JButton ("hola");
		miBoton.setToolTipText(msg);
		add(miBoton);  //Añado el botón al panel
		}
}

