package ejemarrays.aplicIESProf;

import java.io.IOException;
import java.util.Objects;

public class Alumno {
  final static int MAXASIGNATURAS=10;
  static int numAlumnos=1;
  int nia;
  private double media;
  private String nombre;
  AsignaturaNota[] notas;   //OJO, puede haber null
  
  protected String getNombre() {
	return nombre;
  }
  protected void setNombre(String nombre) {
	this.nombre = nombre;
  }
  protected double getMedia(){return mediaNotas();}
  Alumno(String nombre){
	  this.nombre= nombre;
	  nia= numAlumnos;
	  numAlumnos++;
	  notas = new AsignaturaNota[MAXASIGNATURAS];
	  media = this.mediaNotas();
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
  
  AsignaturaNota buscarAsignatura(String nomAsig) {
	  AsignaturaNota a=null;
	  for ( int i=0; i<notas.length && a==null ; i++)
			if ( notas[i]!=null && nomAsig.equals(notas[i].nombre))
				a= notas[i];
		return a;
  }
//  Devuelve true si tod va bien.
boolean pedirNota(Teclado t) throws IOException {
	  boolean ok=false;
	  System.out.println("Dar nombre de asignatura");
	  String nomAsig= t.leerString();
	  AsignaturaNota asig= buscarAsignatura(nomAsig);
	  if (asig!=null) {
	    System.out.println("Dar nota ");
  	    double nota=t.leerDouble();
  	    asig.setCalificacion(nota);
  	    ok=true;
	  }
	  return ok;
  }
//devuelve -2 cuando hay error (no hay asignaturas con nota)
  double mediaNotas (){
	  double suma=0;
	  int contNotas=0;
	  double media;
	  for ( int i=0; i<notas.length  ; i++)
			if ( notas[i]!=null && notas[i].getCalificacion()!=-1) {
				suma= suma+ notas[i].getCalificacion();
				contNotas++;
			}
	  if (contNotas==0)
		  media=-2;
	  else
		  media=suma/contNotas;
	  return media;
  }
  void mostrar() {
	  System.out.println("NIA:"+nia+"->"+nombre);
	  for (int i=0; i<notas.length  ; i++) {
		  if (notas[i]!=null)
		    notas[i].mostrar();
	  }
  }
}
