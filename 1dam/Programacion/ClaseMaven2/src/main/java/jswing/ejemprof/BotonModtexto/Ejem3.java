package jswing.ejemprof.BotonModtexto;

//Con herencia y uso de container
import java.awt.*;
import java.io.InputStream;
import java.net.URL;

import javax.swing.*;

public class Ejem3 extends JFrame {
	private Container panel;
	private JButton miboton, miboton2;

	public Ejem3() throws InterruptedException {
		super("Ejemplo 01 con bot�n");

//Cambiamos el icono por defecto
		URL u = getClass().getResource("iconoEstrella.jpg");
		System.out.println(u);
		Image icon = new ImageIcon(u).getImage();

		setIconImage(icon);
// Configurar componentes ;
		miboton = new JButton("Aceptar");
		miboton2 = new JButton("Rechazar");
		panel = getContentPane();
		panel.add(miboton);
		panel.add(miboton2);
		pack();
		setState(Frame.NORMAL);

		setSize(400, 100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Thread.sleep(5000); // Desaparece a los 5sg
		setVisible(false);
		Thread.sleep(5000); // Reaparece 5 seg despu�s
		setVisible(true);
		Thread.sleep(5000); // borro la ventana 5 seg despu�s
		dispose();
		Thread.sleep(5000); // borro la ventana 5 seg despu�s
		System.out.println("Se ha cerrado la ventana y se termina la aplicaci�n");
	}

	public static void main(String args[]) throws InterruptedException {
		Ejem3 aplicacion = new Ejem3();
	}
}