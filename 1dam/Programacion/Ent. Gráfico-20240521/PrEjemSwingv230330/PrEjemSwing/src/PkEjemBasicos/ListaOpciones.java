package PkEjemBasicos;

import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class ListaOpciones extends JPanel {
	String opciones[]={"Opc0","Opc1", "Opc2", "Opc3","Opc4", "Opc5", "Opc6"};
    JList lista;
	ListaOpciones(){
	  lista= new JList(opciones);
	  lista.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e)  {
		        if (e.getClickCount() == 2){ // Se mira si es doble click
		            int posicion = lista.locationToIndex(e.getPoint());
		            System.out.println("La posicion es " + posicion);
		         }
		    }
	  });
	  lista.addMouseListener(new MouseAdapter() {
		  public void mouseEntered(MouseEvent e)  {
		        System.out.println("Cursor dentro de la lista");
		    }
	  });
	  ScrollPane zonaConScroll= new ScrollPane ();
	  zonaConScroll.add(lista);
	  add(zonaConScroll);
	}
}

 