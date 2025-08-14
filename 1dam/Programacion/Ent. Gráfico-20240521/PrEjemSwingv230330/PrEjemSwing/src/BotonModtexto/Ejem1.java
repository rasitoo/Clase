package BotonModtexto;
//Ejemplo con herencia
import javax.swing.*;

public class Ejem1 extends JFrame {
// Constantes y componentes (objetos)
	public Ejem1() {
		super("Ejemplo 00");
// Configurar Componentes ;
// Configurar Manejadores Eventos ;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

// Terminar la aplicación al cerrar la ventana.
	public static void main(String args[]) {
		Ejem1 aplicacion = new Ejem1();
	}
}