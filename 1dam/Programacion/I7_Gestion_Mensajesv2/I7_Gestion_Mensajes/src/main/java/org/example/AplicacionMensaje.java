package org.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AplicacionMensaje {
	//La clave es el nº de tlf
	private Map<String,Persona> usuarios = new HashMap<>();
	private Map<String,Persona> administradores = new HashMap<>();
	
	public Map<String, Persona> getAdministradores(){
		return administradores;
	}
	
	public void setAdministradores(Map<String, Persona> administradores) {
		this.administradores = administradores;
	}

	public Map<String, Persona> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Map<String, Persona> usuarios) {
		this.usuarios = usuarios;
	}
	
	public static void main(String[] args) throws IOException {
	    Teclado t = new Teclado();
	    AplicacionMensaje obj = new AplicacionMensaje();
	    obj.añadirAdministradores();
	    obj.añadirUsuarios();
	    int opcion = -1;
	    do {
	        System.out.print("Inicie sesión con su número de teléfono:");
	        String num = t.leerString(); // Read phone number as a string
	        Persona inicioSesion = obj.usuarios.get(num);
	        if (inicioSesion == null) {
	            inicioSesion = obj.administradores.get(num);
	            if (inicioSesion == null) {
	                System.out.println("Usuario/Administrador no encontrado");
	            } else {
	                obj.mostrarMenuAdmin();
	                opcion = obj.pedirOpcion(t);
	                obj.ejecutarOpcionAdmin(t, opcion, inicioSesion);
	            }
	        } else {
	            obj.mostrarMenuUsuario();
	            opcion = obj.pedirOpcion(t);
	            obj.ejecutarOpcionUsuario(t, opcion, inicioSesion);
	        }

	    } while (opcion != 0);
	}
	
	void añadirUsuarios() {
		//Crear usuarios
        Usuario u1 = new Usuario("Juan","1");
        Usuario u2 = new Usuario("Maria","2");
        Usuario u3 = new Usuario("Carlos","3");
        Usuario u4 = new Usuario("Ana","4");
        Usuario u5 = new Usuario("Pedro","5");
        
        //Añadirlos
        usuarios.put(u1.getNumeroTelefono(),u1);
        usuarios.put(u2.getNumeroTelefono(),u2);
        usuarios.put(u3.getNumeroTelefono(),u3);
        usuarios.put(u4.getNumeroTelefono(),u4);
        usuarios.put(u5.getNumeroTelefono(),u5);
	}
	
	void añadirAdministradores() {
		//Crear administradores
		Administrador a1 = new Administrador("Luisa","11");
		Administrador a2 = new Administrador("Diego","22");
		
		//Añadirlos
		administradores.put(a1.getNumeroTelefono(), a1);
		administradores.put(a2.getNumeroTelefono(), a2);
	}
	
	void mostrarMenuUsuario() {
		System.out.println("1.Enviar mensaje");
		System.out.println("2.Ver mensajes enviados");
		System.out.println("3.Ver mensajes recibidos");
		System.out.println("4.Ver mensajes de un emisor");
		System.out.println("5.Ver lista de contactos");
		System.out.println("6.Borrar msg enviado");
		System.out.println("0.Salir");
	}
	
	void mostrarMenuAdmin() {
		System.out.println("1.Enviar mensaje");
		System.out.println("2.Ver mensajes enviados");
		System.out.println("3.Ver mensajes recibidos");
		System.out.println("4.Ver mensajes de un emisor");
		System.out.println("5.Ver lista de contactos");
		System.out.println("6.Ver mensajes de la aplicacion");
		System.out.println("0.Salir");
	}
	
	int pedirOpcion(Teclado t) throws IOException {
		return t.leerInt();
	}
	
	void ejecutarOpcionUsuario(Teclado t,int opcion,Persona inicioSesion) throws IOException {
		switch(opcion) {
		case 1:
			enviarMensaje(t,inicioSesion);
			break;
		case 2:
			verMensajesEnviados(inicioSesion);
			break;
		case 3:
			verMensajesRecibidos(inicioSesion);
			break;
		case 4:
			verMensajesEmisor(t, inicioSesion);
			break;
		case 5:
			verListaContactos();
			break;
		case 6:
			borrarMsgEnviado(t,inicioSesion);
		break;
		}
	}

	Persona comprobarDestinatario(Teclado t) throws IOException {
		System.out.println("Introduce el teléfono del destinatario");
		String destinatarioNum = t.leerString();
		Persona destinatario = usuarios.get(destinatarioNum);
		if (destinatario == null) {
			destinatario = administradores.get(destinatarioNum);
			if (destinatario == null) {
				System.out.println("Usuario/Administrador no encontrado");
			}
		}
		return destinatario;
	}
	private void borrarMsgEnviado(Teclado t,Persona inicioSesion) throws IOException {
		Persona p = comprobarDestinatario(t);
		if (p != null) {
			List<Mensaje> msgsADest = inicioSesion.verMensajesEnviados(p);
			if (msgsADest.isEmpty())
				System.out.println("No hay msgs para ese destinatario");
			else {
				System.out.println("Dar n\u00FAmero de msg a borrar entre 0 y " + (msgsADest.size() - 1));
				int pos= t.leerInt();
				if (pos >= 0 && pos < msgsADest.size()) {
					inicioSesion.borrarMsg(msgsADest.get(pos));
					System.out.println("Msg borrado");
				}
			}
		}
	}

	void enviarMensaje(Teclado t,Persona inicioSesion) throws IOException {

		System.out.println("Introduce el teléfono del destinatario");
		String destinatarioNum = t.leerString();
		Persona destinatario = usuarios.get(destinatarioNum);
        if (destinatario == null) {
            destinatario = administradores.get(destinatarioNum);
            if (destinatario == null) {
                System.out.println("Usuario/Administrador no encontrado");
            } 
        }
        if(destinatario != null) {
        	System.out.println("Elija el tipo de mensaje a enviar a "+destinatario.getNombre());
        	System.out.println("1.SMS");
        	System.out.println("2.MMS");
        	int opcion = t.leerInt();
        	switch(opcion) {
        	case 1:
        		System.out.print("Mensaje:");
        		String mensaje = t.leerString();
        		MensajeTexto sms = new MensajeTexto(mensaje,inicioSesion,destinatario);
        		System.out.println("Mensaje enviado");
        		inicioSesion.enviarMensaje(sms);
        		destinatario.recibirMensaje(sms);
        		break;
        	case 2:
        		System.out.print("Mensaje:");
        		String mensajeMMS = t.leerString();
        		System.out.println("Archivo:");
        		String archivo = t.leerString();
        		System.out.println("Tamaño archivo:");
        		int tamaño = t.leerInt();
        		MensajeMultimedia mms = new MensajeMultimedia(mensajeMMS,inicioSesion,destinatario,archivo,tamaño);
        		System.out.println("Mensaje enviado");
        		inicioSesion.enviarMensaje(mms);
        		destinatario.recibirMensaje(mms);
        		break;
        	}
        }
	}
	void verMensajesEnviados(Persona inicioSesion) {
		System.out.println("Mensajes enviados:");
		List<Mensaje>mensajes = inicioSesion.getMensajesEnviados();
		for(Mensaje mensaje:mensajes) {
			System.out.println(mensaje);
		}
	}
	
	void verMensajesRecibidos(Persona inicioSesion) {
		System.out.println("Mesanjes recibidos:");
		List<Mensaje>mensajes = inicioSesion.getMensajesRecibidos();
		for(Mensaje mensaje:mensajes) {
			System.out.println(mensaje);
		}
	}
	
	void verMensajesEmisor(Teclado t,Persona inicioSesion) throws IOException {
		List<Mensaje>mensajes = inicioSesion.getMensajesRecibidos();
		System.out.print("Introduzca el número del contacto deseado:");
		String numero = t.leerString();
		Persona emisor = usuarios.get(numero);
        if (emisor == null) {
            emisor = administradores.get(numero);
            if (emisor == null) {
                System.out.println("Usuario/Administrador no encontrado");
            } 
        }
        if(emisor != null) {
        	for (Mensaje mensaje : mensajes) {
        		if (mensaje.getRemitente().equals(emisor)) {
        			System.out.println("Mensaje de " + emisor.getNombre() + ":");
        			System.out.println(mensaje.getTexto());
        		}
        	}
        }
	}
	
	void verListaContactos() {
		for (String clave : usuarios.keySet()) {
		    Persona valor = usuarios.get(clave);
		    System.out.println("Nombre:"+valor.getNombre()+" -> Teléfono:"+clave);
		}
		for (String clave : administradores.keySet()) {
		    Persona valor = administradores.get(clave);
		    System.out.println("Nombre:"+valor.getNombre()+" -> Teléfono:"+clave);
		}
	}
	
	void ejecutarOpcionAdmin(Teclado t,int opcion,Persona inicioSesion) throws IOException {
		switch(opcion) {
		case 1:
			enviarMensaje(t,inicioSesion);
			break;
		case 2:
			verMensajesEnviados(inicioSesion);
			break;
		case 3:
			verMensajesRecibidos(inicioSesion);
			break;
		case 4:
			verMensajesEmisor(t, inicioSesion);
			break;
		case 5:
			verListaContactos();
			break;
		case 6:
			verMensajesAplicacion();
			break;
		}
	}
	
	void verMensajesAplicacion() {
		for (String clave : usuarios.keySet()) {
		    Persona valor = usuarios.get(clave);
		    System.out.println("Nombre:"+valor.getNombre()+" -> "+valor.getMensajesEnviados());
		}
		
		for (String clave : administradores.keySet()) {
		    Persona valor = administradores.get(clave);
		    System.out.println("Nombre:"+valor.getNombre()+" -> "+valor.getMensajesEnviados());
		}
	}


}
