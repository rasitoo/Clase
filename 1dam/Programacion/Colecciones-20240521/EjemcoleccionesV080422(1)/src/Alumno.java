
public class Alumno {
  String nombre;
  int edad;
  
  Alumno (String n, int e){
	  edad=e;
	  nombre=n;
  }
  public String toString () {
	  return ( nombre + " " + String.valueOf(edad));
  }
}
