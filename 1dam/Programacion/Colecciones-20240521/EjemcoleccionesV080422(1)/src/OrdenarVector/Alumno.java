package OrdenarVector;

public class Alumno implements Comparable<Alumno> {
  String nombre;
  int edad;
  
  Alumno (String n, int e){
	  edad=e;
	  nombre=n;
  }
  public String toString () {
	  return ( nombre + " " + String.valueOf(edad));
  }
public int compareTo(Alumno a) {  //Ordeno primero por nombre y luego por edad
	 int compEdades=edad- a.edad;
	 int compNombres = nombre.compareTo(a.nombre);
     return compEdades+compNombres *1000;
}
}
