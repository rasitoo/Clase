package org.example.LibreriaCloning;


import com.google.gson.Gson;

import java.util.Vector;

public class Clonacion {

	public static void main(String[] args) throws CloneNotSupportedException {
		Persona persona1= new Persona("Juan", 11);
		persona1.anadirDireccion(new Direccion("Calle uno", 1));
		persona1.anadirDireccion(new Direccion("Calle dos", 2));
		Persona p2= persona1;

		//Persona p3= (Persona) persona1.clone();
		Gson gson = new Gson();
		Persona p3 = gson.fromJson(gson.toJson(persona1), Persona.class);

		persona1.nombre="otro nombre";
		p3.anadirDireccion(new Direccion("Calle tres", 3));

		System.out.println("persona1 :"+persona1);
		System.out.println("p2:"+p2);
		System.out.println("p3:"+p3);
		
		

	}

}
