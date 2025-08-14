package org.example.LibreriaCloning;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Persona {
  String nombre;
  int edad;
  List<Direccion> direcciones= new ArrayList<>();


  public Persona(String nombre, int edad) {
	super();
	this.nombre = nombre;
	this.edad = edad;
  }
@Override
public String toString() {
	String aux="Persona [nombre=" + nombre + ", edad=" + edad + "]";
    if (direcciones.size()!=0)
      for (Direccion d:direcciones)
        aux+="\n\t"+d.toString();
    else
      aux+="\nNo hay direcciones";
    return aux;
}

    public void anadirDireccion(Direccion direccion) {
        direcciones.add(direccion);
    }
}
