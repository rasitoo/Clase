package jswing.ejemprof.PkDemoBolas;
import jswing.ejemprof.ApliCanvas.*;

import java.awt.Color;

public class Bola implements Dibujable, Tickable {
	private double posX, posY;
	private double angulo;
	private double velocidad;
	private double elasticidad;
	private Color color;
	private Lienzo lienzo;
	
	public Bola(double posX, double posY, double angulo, double velocidad, double elasticidad, Color color, Lienzo lienzo) {
		this.posX = posX;
		this.posY = posY;
		this.angulo = angulo;
		this.velocidad = velocidad;
		this.elasticidad = elasticidad;
		this.color = color;
		this.lienzo = lienzo;
	}
	
	public void setLienzo(Lienzo lienzo) {
		this.lienzo = lienzo;
	}

	public void tick() {
		// Recalcular la nueva posici�n X:
		if (!reboteX()) { // Si NO rebota.
			posX = posX + desplazamientoX();
		} else { // Si rebota.
			if (desplazamientoX()>0) { // Voy hacia la dcha.
				posX = (lienzo.getTamX()-1) - (posX+desplazamientoX()-lienzo.getTamX());
			} else { // Voy hacia la izda.
				posX = (- (posX+desplazamientoX()));
			}
		}

		// Recalcular la nueva posici�n Y:
		if (!reboteY()) { // Si NO rebota.
			posY = posY + desplazamientoY();
		} else { // Si rebota.
			if (desplazamientoY()>0) { // Voy hacia la dcha.
				posY = (lienzo.getTamY()-1) - (posY+desplazamientoY()-lienzo.getTamY());
			} else { // Voy hacia la izda.
				posY = (- (posY+desplazamientoY()));
			}
		}
		
		// Recalcular la velocidad.
		if (reboteX()) velocidad = velocidad*elasticidad;
		if (reboteY()) velocidad = velocidad*elasticidad;
		if (velocidad > 1.0) velocidad = 1.0; // Velocidad m�xima.

		// Recalcular el �ngulo.
		if (reboteX() && reboteY()) { // Si rebota �doble� en una esquina.
			// Nos giramos 180� y sacamos el m�dulo por si nos pasamos de rosca.
			angulo = (angulo + 180) % 360;
		} else if (reboteX()) { // Si rebota solo en una pared lateral.
			// Esta operaci�n actualiza el �ngulo correctamente aunque parezca mentira.
			angulo = ((180 - angulo) + 360) % 360;
		} else if (reboteY()) { // Si rebota solo en techo o suelo.
			// Esta operaci�n actualiza el �ngulo correctamente aunque parezca mentira.
			angulo = ((360 - angulo)) % 360;
		} else {
			// Si no rebota en ning�n sitio, el �ngulo no se toca y sigue como estaba.
		}
	}

	public void dibujar() {
		lienzo.marcarPixel((int) Math.floor(posX), (int) Math.floor(posY), color);
	}
	
	private boolean reboteX() {
		// Rebota si la potencial nueva posici�n se sale del lienzo, por defecto o por exceso.
		double potencialNuevaPosicionX = posX+desplazamientoX();
		return (potencialNuevaPosicionX < 0 || potencialNuevaPosicionX >= lienzo.getTamX());
	}

	private boolean reboteY() {
		// Rebota si la potencial nueva posici�n se sale del lienzo, por defecto o por exceso.
		double potencialNuevaPosicionY = posY+desplazamientoY();
		return (potencialNuevaPosicionY < 0 || potencialNuevaPosicionY >= lienzo.getTamY());
	}
	
	private double desplazamientoX() {
		// Las funciones trigonom�tricas reciben el �ngulo en radianes,
		// as� que hay que convertir nuestros grados a radianes: *pi/180.
		return velocidad * Math.cos(angulo * (Math.PI/180));
	}

	private double desplazamientoY() {
		// Las funciones trigonom�tricas reciben el �ngulo en radianes,
		// as� que hay que convertir nuestros grados a radianes: *pi/180.
		// El seno hay que negarlo ya que en trigonometr�a "hacia arriba"
		// es positivo mientras que aqu� "hacia arriba" es negativo.
		return velocidad * (- Math.sin(angulo * (Math.PI/180)));
	}
}