package BotonModtexto;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class BotonModificaTexto extends JFrame {
	  JPanel contentPane;
	  JTextField Texto1 = new JTextField();
	  JButton jButton1 = new JButton();

	  //Construir el marco
	  public BotonModificaTexto() {
//	    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
	    try {
	      inicializacion();
	    }
	    catch(Exception e) {
	      e.printStackTrace();
	    }
	  }

	  //Inicialización de componentes
	  private void inicializacion() throws Exception  {
	    contentPane = (JPanel) this.getContentPane();
	    Texto1.setText("");
	    Texto1.setBounds(new Rectangle(9, 12, 64, 22));
	    contentPane.setLayout(null);
	    this.setSize(new Dimension(400, 300));
	    this.setTitle("Mi aplicación gráfica");
	    jButton1.setBounds(new Rectangle(90, 12, 200, 24));
	    jButton1.setText("Escribir");
	    jButton1.addActionListener(new miAdaptadorParaBoton(this));
	    jButton1.addMouseListener(new MouseAdapter() {
			  public void mouseEntered(MouseEvent e)  {
			        System.out.println("Cursor dentro del botón");
			    }
		  });
	    contentPane.add(Texto1, null);
	    contentPane.add(jButton1, null);
	  }

	  //Modificado para poder salir cuando se cierra la ventana
	  protected void processWindowEvent(WindowEvent e) {
	    super.processWindowEvent(e);
	    if (e.getID() == WindowEvent.WINDOW_CLOSING)
	      System.exit(0);
	  } 

	  void accionARealizar(ActionEvent e) {
	    Texto1.setText("Holaaaa");
	  }
	} //Fin clase BotonModificaTexto

	class miAdaptadorParaBoton implements java.awt.event.ActionListener {
	  BotonModificaTexto miVentana;

	  miAdaptadorParaBoton(BotonModificaTexto miVentana) {
	    this.miVentana = miVentana;
	  }
	  public void actionPerformed(ActionEvent e) {
		  miVentana.accionARealizar(e);
	  }
	}