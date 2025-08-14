package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Persona {
	private String nombre;
	private String numeroTelefono;
	private List<Mensaje> mensajesEnviados;
	private List<Mensaje> mensajesRecibidos;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public List<Mensaje> getMensajesEnviados() {
		return mensajesEnviados;
	}
	public void setMensajesEnviados(List<Mensaje> mensajesEnviados) {
		this.mensajesEnviados = mensajesEnviados;
	}
	public List<Mensaje> getMensajesRecibidos() {
		return mensajesRecibidos;
	}
	public void setMensajesRecibidos(List<Mensaje> mensajesRecibidos) {
		this.mensajesRecibidos = mensajesRecibidos;
	}
	
	Persona(String nombre,String numero){
		this.nombre=nombre;
		this.numeroTelefono=numero;
		this.setMensajesEnviados(new ArrayList<>());
		this.setMensajesRecibidos(new ArrayList<>());
	}
	
	public void enviarMensaje(Mensaje mensaje) {
        mensajesEnviados.add(mensaje);
    }
	
	public void recibirMensaje(Mensaje mensaje) {
		mensajesRecibidos.add(mensaje);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[nombre=").append(nombre).append(", numeroTelefono=").append(numeroTelefono)
				.append("]");
		return builder.toString();
	}


	public List<Mensaje> verMensajesEnviados(Persona p) {
		System.out.println("Mensajes enviados de "+this.nombre+" a "+p.getNombre());
		List<Mensaje>mensajes = this.getMensajesEnviados();
		int i=0;
		List<Mensaje> msgsADest= new ArrayList<>();
		for(Mensaje mensaje:mensajes) {
			if (p.getNombre().equals(mensaje.getDestinatario().getNombre())){
			  System.out.println(i++ +"->"+mensaje);
			  msgsADest.add(mensaje);
			}
		}
		return msgsADest;
	}

	public void borrarMsgEnviado(Mensaje mensaje){
		Iterator it=mensajesEnviados.iterator();
		while (it.hasNext()) {
			if (mensaje.equals(it.next())) {
				it.remove();
			}
		}
	}
	public void borrarMsgRecibido(Mensaje mensaje){
		Iterator it=mensajesRecibidos.iterator();
		while (it.hasNext()) {
			if (mensaje.equals(it.next())) {
				it.remove();
			}
		}
	}
	public void borrarMsg(Mensaje mensaje) {
		borrarMsgRecibido(mensaje);
		borrarMsgEnviado(mensaje);
	}
}
