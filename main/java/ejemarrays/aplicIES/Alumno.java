package ejemarrays.aplicIES;

public class Alumno {
  final static int MAXASIGNATURAS=10;
  static int numAlumnos=1;
  int nia;
  String nombre;
  AsignaturaNota[] notas;   //OJO, puede haber null
  Alumno(String nombre){
	  this.nombre= nombre;
	  nia= numAlumnos;
	  numAlumnos++;
	  notas = new AsignaturaNota[MAXASIGNATURAS];
  }
  boolean matricular(String nomAsig) {
	  boolean matriculado=false;
	  for (int i=0; !matriculado && i<notas.length; i++)
		  if (notas[i]==null) {
			  notas[i]=new AsignaturaNota(nomAsig);
			  matriculado=true;
		  }
	  return matriculado;
  }
  void mostrar() {
	  System.out.println("NIA:"+nia+"->"+nombre);
	  for (int i=0; i<notas.length  ; i++) {
		  if (notas[i]!=null)
			  notas[i].mostrar();
	  }
  }
}
