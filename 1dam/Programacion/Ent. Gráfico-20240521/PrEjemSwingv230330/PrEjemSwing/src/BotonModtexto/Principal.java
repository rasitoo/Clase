package BotonModtexto;
import javax.swing.JFrame;
import javax.swing.UIManager;
import java.awt.*;

public class Principal {
  boolean packFrame = false;

  //Construir la aplicaci�n
  public Principal() {
	BotonModificaTexto contenidoVentana = new BotonModificaTexto();
    //Validar que los elementos est�n en su sitio, validar marcos que tienen tama�os preestablecidos
    //Empaquetar marcos que cuentan con informaci�n de tama�o preferente �til. Ej. de su dise�o.
    if (packFrame) contenidoVentana.pack();
    else           contenidoVentana.validate();

    //Centrar la ventana en la pantalla
/*    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 System.out.println(Toolkit.getDefaultToolkit().getScreenSize());
    Dimension frameSize = contenidoVentana.getSize();
    if (frameSize.height > screenSize.height) 
      frameSize.height = screenSize.height;
    if (frameSize.width > screenSize.width) 
      frameSize.width = screenSize.width;
    contenidoVentana.setLocation((screenSize.width - frameSize.width) / 2,
    		(screenSize.height - frameSize.height) / 2);
 */   contenidoVentana.setVisible(true);
  }

  //M�todo Main
  public static void main(String[] args) {
/*    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception e) {
      e.printStackTrace();
    }
*/    new Principal();
  }
}