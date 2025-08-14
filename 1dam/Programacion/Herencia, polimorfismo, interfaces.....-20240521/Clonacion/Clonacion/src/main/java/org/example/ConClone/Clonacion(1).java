package org.example.ConClone;

import java.util.Vector;

public class Clonacion {
	void clonarVector() {
		int []aEnteros={1,3,6,2};
		Vector <Integer> vEnteros= new Vector<Integer>();
		for (Integer i:aEnteros)
			vEnteros.add(i);
		Vector <Integer> vCopia  = new Vector<Integer> (vEnteros.size());
		vCopia= (Vector<Integer>) vEnteros.clone();
		vCopia.add(111);
		vEnteros.remove(new Integer(6));
		System.out.println("vEnteros");
		for (Integer i:vEnteros )
			System.out.print(i+",");
		System.out.println();
		System.out.println("vEnteros");
		for (Integer i:vCopia )
			System.out.print(i+",");
		System.out.println();
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		Persona p= new Persona("Juan", 11);
		p.anadirDireccion(new Direccion("Calle uno", 1));
		p.anadirDireccion(new Direccion("Calle dos", 2));
		Persona p2= p;
		Persona p3= (Persona) p.clone();

		//funciona la clonación del nombre pero no la lista de direcciones
		p.nombre="otro nombre";
		p.anadirDireccion(new Direccion("Calle tres", 3));

		System.out.println("p:"+p);
		System.out.println("p2:"+p2);
		System.out.println("p3:"+p3);
		
		

	}

}
