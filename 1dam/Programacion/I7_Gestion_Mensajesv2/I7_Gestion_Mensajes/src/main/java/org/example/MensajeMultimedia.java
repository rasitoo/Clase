package org.example;

public class MensajeMultimedia extends Mensaje {
	private String nombreArchivo;
	private int tamañoArchivo;
	
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	public int getTamañoArchivo() {
		return tamañoArchivo;
	}
	public void setTamañoArchivo(int tamañoArchivo) {
		this.tamañoArchivo = tamañoArchivo;
	}
	
	MensajeMultimedia(String mensaje, Persona envio, Persona destino,String archivo,int tamaño) {
		super(mensaje, envio, destino);
		// TODO Auto-generated constructor stub
		this.nombreArchivo=archivo;
		this.tamañoArchivo=tamaño;
	}

}
