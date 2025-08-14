package ejemarrays.aplicIESProf;

public class AsignaturaNota {
  String nombre;
  private double calificacion;
  AsignaturaNota (String nombre){
	  this.nombre=nombre;
	  calificacion=-1;
  }
  
  public String getNombre() {
	return nombre;
 }

  public double getCalificacion() {
	return calificacion;
  }

protected void setNombre(String nombre) {
	this.nombre = nombre;
}

protected void setCalificacion(double calificacion) {
	this.calificacion = calificacion;
}

void mostrar() {
	  if (calificacion==-1)
	    System.out.println(nombre+"->"+"NE");
	  else
	    System.out.println(nombre+"->"+calificacion);
  }
}
