package PkEjemBasicos;
	import javax.swing.*;
	import javax.swing.event.ChangeEvent;
	import javax.swing.event.ChangeListener;
	import java.awt.*;

	public class EjemColorChooser extends JFrame implements ChangeListener {
	    private JColorChooser colorChooser = null;

	    public EjemColorChooser() throws HeadlessException {
	        initUI();
	    }

	    private void initUI() {

	        setTitle("JColorChooser Demo");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new BorderLayout());

	        colorChooser = new JColorChooser();
	        getContentPane().add(colorChooser, BorderLayout.PAGE_END);

	        colorChooser.getSelectionModel().addChangeListener(this);
	        this.pack();
	    }

	    /**
	     * Gestión de la selección del ColorChooser.
	     *
	     * @param e the ChangeEvent
	     */
	    public void stateChanged(ChangeEvent e) {
	        //Obtenemos el color (getColor) y lo mostramos en formato RGB
	
	        Color color = colorChooser.getColor();
	        System.out.println("color = " + color);
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                new EjemColorChooser().setVisible(true);
	            }
	        });
	    }
	}
