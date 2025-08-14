package HashTable;


public class Persona {
  String nombre;
  int edad;
  double sueldo;
public Persona(String nombre, int edad, double sueldo) {
	super();
	this.nombre = nombre;
	this.edad = edad;
	this.sueldo = sueldo;
}
public int compareTo(String anotherString) {
	return nombre.compareTo(anotherString);
}
public boolean equals(Object anObject) {
	return nombre.equals(anObject);
}
public int hashCode() {
	return edad;
}

}
