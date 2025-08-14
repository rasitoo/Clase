package dejemarrays.aplicIES;
import java.io.IOException;
import java.util.Objects;

/**
 *
 */
public class Grupo {
	final static int MAXIMOALUMNOS=30;
	String nombre;
	Alumno[] alumnos;
	int contAlumnos;
	
	public Grupo(String nombre){
		this.nombre= nombre;
		contAlumnos=0;
		alumnos= new Alumno[MAXIMOALUMNOS];
	}
	public void mostrarMenu() {
		System.out.println("1.  Añadir alumno");
		System.out.println("2.  Listar alumnos por orden de introducción");
		System.out.println("3.  Modificar nombre alumno.");
		System.out.println("4.  Borrar alumno ");
		System.out.println("5.  Consultar datos alumno");
		System.out.println("6.  Matricular alumno en asignatura");
		System.out.println("7.  Pedir nota alumno ");
		System.out.println("8.  Media notas alumno ");
		System.out.println("9.  Media notas clase  ");
		System.out.println("10. Listado ordenado por nota media.");
		System.out.println("0.  Finalizará el programa ");
		System.out.println("Elegir opción");
	}
	public int pedirOpc(Teclado t) throws IOException {
        return t.leerInt();
	}
	public boolean anadir(Teclado t) throws IOException {
		boolean ok=true;
		if (contAlumnos<MAXIMOALUMNOS) {
		  System.out.println("Dar nombre");
		  String nombre= t.leerString();
		  for (int i = 0; i<=contAlumnos;i++)//Hago este bucle para poder reutilizar los huecos del array que dejan los alumnos borrados
			  if (alumnos[i] == null) {
				  alumnos[i] = new Alumno(nombre);
				  contAlumnos++;
				  break;
			  }
		}
		else
			ok=false;
		return ok;
	}
	public void listar() {
		if (contAlumnos<=0)
			System.out.println("No hay alumnos");
		else
		  for(int i=0; i<MAXIMOALUMNOS && i<=contAlumnos; i++) { //Añado la condicion maximoalumnos porque cuando contAlumnos == Maximo el contador aumenta 1 y supera el maximo, dando error
			  if (alumnos[i] != null)
				  alumnos[i].mostrar();
		}
	}
	public Alumno buscarNIA(int nia){
		Alumno a=null;
		for ( int i=0; i<contAlumnos ; i++) {
			if (nia == alumnos[i].nia)
				a = alumnos[i];
		}
		return a;
	}
	// Matricula a un alumno en una asignatura
	public boolean modificar(Teclado t) throws IOException {
		boolean modificado = false;
		System.out.println("Dar nia del alumno al que cambiar el nombre: ");
		int nia=t.leerInt();
		Alumno a= buscarNIA(nia);
		if (a==null)
			System.out.println("Ese nia no existe");
		else {
			System.out.println("Nuevo nombre: ");
            a.nombre= t.leerString();
			modificado = true;
		}
		return modificado;
	}
	public boolean borrar(Teclado t) throws IOException {
		boolean borrado = false;
		System.out.println("Dar nia del alumno que quieres borrar: ");
		int nia= t.leerInt();
		Alumno a = buscarNIA(nia);
		if (a==null)
			System.out.println("Ese nia no existe");
		else {
			for (int i = 0; i<contAlumnos;i++)
				if (alumnos[i].nia ==nia) {
					alumnos[i] = null;
					contAlumnos--; // si no borramos 1 entonces el contador llegaría al maximo de alumnos contando alumnos borrados
					borrado = true;
				}

		}
        return borrado;
    }
	public boolean consultar(Teclado t) throws IOException {
		boolean consultar = false;
		System.out.println("Dar nia del alumno que quieres consultar: ");
		int nia = t.leerInt();
		Alumno a = buscarNIA(nia);
		for (int i = 0; i<contAlumnos; i++){
			if (alumnos[i].nia == nia){
				a.mostrar();
				consultar=true;
			}
		}
		return consultar;
	}
	public boolean matricular(Teclado t)  throws IOException{
		boolean matriculado=false;
		System.out.println("Dar nia");
		int nia=t.leerInt();
		Alumno a= buscarNIA(nia);
		if ( a==null)
			System.out.println("Ese nia no existe");
		else {
			System.out.println("Nombre asig");
			String nomAsig= t.leerString();
			if (a.matricular(nomAsig) )
				matriculado=true;
		}
		return matriculado;
	}
	public boolean nota(Teclado t) throws IOException {
		boolean nota = false;
		System.out.println("Indica el nia del alumno al que añadirle una nota");
		int nia = t.leerInt();
		Alumno a = buscarNIA(nia);
		if (a != null) {
			System.out.println("Indica la asignatura a la que añadirle la nota a " + a.nombre);
			String asig = t.leerString();
			for (int i = 0; i<a.notas.length;i++){
				if (a.notas[i] != null && Objects.equals(a.notas[i].nombre, asig)) {
					System.out.println("Indica la nota:");
					int calificacion = t.leerInt();
					if (calificacion >= 0 && calificacion <= 10){
						a.notas[i].calificacion = calificacion;
					nota = true;
					}
				}
			}
		}
		return nota;
	}
	public double mediaAl(int nia){
		double media = 0;
		int cont = 0;
		Alumno a = buscarNIA(nia);
		for (int i = 0;i<a.notas.length;i++){
			if (a.notas[i] != null) {
				media += a.notas[i].calificacion;
				cont++;
			}
		}
		return media/cont;
	}
	public double mediaCl(){
		double media = 0;
		int cont = 0;
		int nia;
		for(int i=0; i<MAXIMOALUMNOS && i<=contAlumnos; i++){
			nia = alumnos[i].nia;
			media += mediaAl(nia);
			cont++;
		}
		return media/cont;
	}
	void listaOrdenada(){

	}
	public void ejecutarOpcion(int n, Teclado t) throws IOException  {
		switch(n) {
		case 1: 
			if (!anadir(t))
				System.out.println("Se ha llegado al numero maximo de alumnos");
			break;
		case 2: 
			listar(); 
			break;
		case 3: 
			if (!modificar(t))
				System.out.println("Error en la modificación");
			break;
		case 4: 
			if (!borrar(t) )
				System.out.println("Error en el borrado");
			break;
		case 5: 
			if (!consultar(t))
				System.out.println("Error en la consulta");
			break;
		case 6: 
			if( matricular(t) )
				System.out.println("Matriculado con éxito");
			else
				System.out.println("No se le ha podido matricular en esa asig. ");
			break;
		case 7:
			if (!nota(t))
				System.out.println("Error en la nota");
			break;
		case 8:
			System.out.println("Indica el nia del alumno al que calcularle la media");
			int nia = t.leerInt();
			System.out.println(mediaAl(nia));
			break;
		case 9:
			System.out.println(mediaCl());
			break;
		case 10:
			listaOrdenada();
			break;
		case 0:
			System.out.println("FIN"); 
			break;
		}
	}
	public static void main(String[] args) throws IOException {
		Grupo grupo= new Grupo("1DAM");
		Teclado t=new Teclado();
		int n;
		do {
			grupo.mostrarMenu();
			n=grupo.pedirOpc(t);
			grupo.ejecutarOpcion(n, t);
		}while(n!=0);
	}

}
