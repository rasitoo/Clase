package jswing.ejemprof.PkDemoBolas;
import java.awt.Color;
import java.util.ArrayList;


import jswing.ejemprof.ApliCanvas.*;

public class PrincipalDemoBolas {
	private static final int DELAY = 20; // Milisegundos.

	public static void main(String[] args) {
		boolean pantallaBuena = true; // true: VentanaMultimedia; false: PantallaBN
		boolean aumentoProgresivoPantalla = false;
		
		Lienzo lienzo;
		if (pantallaBuena) {
			lienzo = new VentanaMultimedia("Ventana gr�fica", 16, 16, 10, Color.BLACK);
			((VentanaMultimedia) lienzo).setTitle("PRUEBA");
		} else {
			lienzo = new PantallaBN(16, 16);
		}
		
		ArrayList<Bola> bolas = new ArrayList<Bola>();
		
		bolas.add(new Bola(8, 8,  70, 0.30, 0.90, new Color(100, 100, 100), lienzo));
		bolas.add(new Bola(8, 8,  40, 0.25, 1.01, Color.BLUE, lienzo));
		bolas.add(new Bola(8, 8,  30, 0.20, 1.02, Color.WHITE, lienzo));
		bolas.add(new Bola(8, 8,  20, 0.12, 1.03, Color.ORANGE, lienzo));
		bolas.add(new Bola(8, 8,  10, 0.15, 1.04, Color.CYAN, lienzo));
		bolas.add(new Bola(8, 8,  00, 0.16, 1.05, Color.GRAY, lienzo));
		bolas.add(new Bola(8, 8,  80, 0.14, 1.06, Color.RED, lienzo));
		bolas.add(new Bola(8, 8,  90, 0.21, 1.07, Color.MAGENTA, lienzo));
		bolas.add(new Bola(8, 8, 100, 0.13, 1.08, Color.YELLOW, lienzo));
		bolas.add(new Bola(8, 8, 131, 0.10, 1.10, Color.PINK, lienzo));

		while (true) {
			if (aumentoProgresivoPantalla && Math.random() < 0.02) {
				lienzo.redimensionar(lienzo.getTamX()+1, lienzo.getTamY()+1);
			}
			
			lienzo.limpiar();
			
			lienzo.escribirTexto(5, 2, "�Demo!", Color.GREEN);

			for (Bola bola: bolas) {
				bola.tick();
				bola.dibujar();
			}

			lienzo.volcar();

			Utilidades.espera(DELAY);
		}
	}
}