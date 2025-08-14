package org.example.ConCloneable;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
/**
 * @author josema
 *
 */
public class Persona extends ClonableJM{
    /**
     * @param args  parámetros de la clase
     */
  String nombre;
  int edad;
  List<Direccion> direcciones= new ArrayList<>();
    @Override
    /**
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        Persona p=new Persona(nombre, edad);
        p.direcciones=clonarLista(direcciones);
        return p;
    }
    public <T> List<T> clonarLista(Collection<? extends ClonableJM> lista) {
        List<T> copia = new ArrayList<T>();
        for (ClonableJM t : lista) {
            try {
                copia.add( (T) t.clone());
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
        return copia;
    }

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
