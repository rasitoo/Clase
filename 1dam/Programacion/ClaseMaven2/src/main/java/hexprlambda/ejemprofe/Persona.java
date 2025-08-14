package hexprlambda.ejemprofe;

import java.util.ArrayList;
import java.util.List;

public class Persona {
	private String nombre;
	private String apellido;
	int edad;
	List<Persona> hijos=null;
	
	public Persona(){}
	public Persona(String nombre, int e) {
		this.nombre = nombre;
		this.edad = e;
	}
	public Persona(String nombre, String apellido,int e) {
		this.nombre = nombre;
		this.apellido= apellido;
		this.edad = e;
	}
	void addHijo(Persona hijo) {
		if (hijos==null) hijos= new ArrayList<Persona>();
		hijos.add(hijo);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	public static Persona crearDesdeArray(String []datos) {
		return new Persona(datos[0],Integer.parseInt(datos[1]));
		
	}
	 public static int compararPorNombre(Persona a, Persona b) {
	      return a.nombre.compareTo(b.nombre);
	 }
} // clase Persona
