package dejemarrays.aplicIES;

public class AsignaturaNota {
  String nombre;
  double calificacion;
  AsignaturaNota (String nombre){
	  this.nombre=nombre;
	  calificacion=-1;
  }
  void mostrar() {
	  if (calificacion==-1)
	    System.out.println(nombre+"->"+"NE");
	  else
	    System.out.println(nombre+"->"+calificacion);
  }
}
