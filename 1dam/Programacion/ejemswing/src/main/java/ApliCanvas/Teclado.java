package ApliCanvas;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// NOTA: los códigos de las teclas están en forma de constantes en:
//       KeyEvent.VK_ZZZ

public class Teclado implements KeyListener, Tickable {
	private static final int NUM_TECLAS = 256;
	
	private boolean[] estadoTeclasBasico; // Estado actual del teclado.

	private enum EstadoTeclaCon1Vez {
		LIBRE,           // No abajo.
		PRESIONADA_1VEZ, // Abajo por primera vez.
		PRESIONADA_MAS   // Abajo, pero no por primera vez.
	}

	private EstadoTeclaCon1Vez[] estadoTeclasCon1Vez; // Estado del teclado ya analizado.

	public Teclado() {
		estadoTeclasBasico = new boolean[NUM_TECLAS];
		
		estadoTeclasCon1Vez = new EstadoTeclaCon1Vez[NUM_TECLAS];
		// Se inicializa el estado 
		for (int i = 0; i < NUM_TECLAS; ++i) {
			estadoTeclasCon1Vez[i] = EstadoTeclaCon1Vez.LIBRE;
		}
	}
	
	public boolean pulsada(int codigoTecla) {
		return estadoTeclasBasico[codigoTecla];
	}

	public synchronized void procesarEstadosCon1Vez() {
		for (int i = 0; i < NUM_TECLAS; ++i) {
			if (estadoTeclasBasico[i]) { // La tecla está pulsada.
				if (estadoTeclasCon1Vez[i] == EstadoTeclaCon1Vez.LIBRE) {
					// La tecla está abajo ahora pero no lo estaba antes.
					estadoTeclasCon1Vez[i] = EstadoTeclaCon1Vez.PRESIONADA_1VEZ;
				} else {
					// La tecla está abajo ahora y YA lo estaba antes.
					estadoTeclasCon1Vez[i] = EstadoTeclaCon1Vez.PRESIONADA_MAS;
				}
			} else { // La tecla no está pulsada.
				estadoTeclasCon1Vez[i] = EstadoTeclaCon1Vez.LIBRE;
			}
		}
	}

	public boolean pulsada1Vez(int codigoTecla) {
		return estadoTeclasCon1Vez[codigoTecla] == EstadoTeclaCon1Vez.PRESIONADA_1VEZ;
	}

	// Método de la interfaz KeyListener. NO necesitamos llamarlo nosotros,
	// es un método para que "el sistema" nos informe de teclas pulsadas.
	public synchronized void keyPressed(KeyEvent evento) {
		int codigo = evento.getKeyCode();
		
		// Solo se actualiza la tecla si el código está entre las
		// teclas "normales" (ya que puede haber otras multimedia, etc.).
		if (codigo >= 0 && codigo < NUM_TECLAS) {
			estadoTeclasBasico[codigo] = true;
		}
	}

	// Método de la interfaz KeyListener. NO necesitamos llamarlo nosotros,
	// es un método para que "el sistema" nos informe de teclas pulsadas.
	public synchronized void keyReleased(KeyEvent evento) {
		int codigo = evento.getKeyCode();

		// Solo se actualiza la tecla si el código está entre las
		// teclas "normales" (ya que puede haber otras multimedia, etc.).
		if (codigo >= 0 && codigo < NUM_TECLAS) {
			estadoTeclasBasico[codigo] = false;
		}
	}

	// Método de la interfaz KeyListener. NO necesitamos llamarlo nosotros,
	// es un método para que "el sistema" nos informe de teclas pulsadas.
	public void keyTyped(KeyEvent e) {
		// No necesitamos este método pero como la interfaz
		// KeyListener nos obliga a implementarlo, lo ponemos vacío.
	}

	public void tick() {
		procesarEstadosCon1Vez();
	}
}