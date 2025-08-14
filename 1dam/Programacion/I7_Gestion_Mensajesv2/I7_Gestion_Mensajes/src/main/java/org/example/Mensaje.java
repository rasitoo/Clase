package org.example;

import java.util.Objects;

public class Mensaje {
	int id;
	private String texto;
	private Persona remitente;
	private Persona destinatario;
	static int contMensajes=0;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Persona getRemitente() {
		return remitente;
	}
	public void setRemitente(Persona remitente) {
		this.remitente = remitente;
	}
	public Persona getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Persona destinatario) {
		this.destinatario = destinatario;
	}
	
	Mensaje(String mensaje,Persona envio,Persona destino){
		this.texto=mensaje;
		this.remitente=envio;
		this.destinatario=destino;
		id=contMensajes++;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mensaje [texto=").append(texto).append(", remitente=").append(remitente)
				.append(", destinatario=").append(destinatario).append("]");
		return builder.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Mensaje mensaje = (Mensaje) o;
		return id == mensaje.id && Objects.equals(remitente, mensaje.remitente) && Objects.equals(destinatario, mensaje.destinatario);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, remitente, destinatario);
	}
}
