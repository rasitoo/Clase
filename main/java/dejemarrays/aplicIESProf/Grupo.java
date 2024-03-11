package dejemarrays.aplicIESProf;
import java.io.IOException;
/**
 * JMPL
 */
public class Grupo {
	final static int MAXIMOALUMNOS=3;
	String nombre;
	Alumno [] alumnos;

	int contAlumnos;
/**
 * 
 * @param nombre
17 nov 2023
asdfkljalsñkdfj asdfj
 */
	Grupo(String nombre){
		this.nombre= nombre;
		contAlumnos=0;
		alumnos= new Alumno[MAXIMOALUMNOS];
	}
	/**
	 * 
	 */
	void mostrarMenu() {
		System.out.println ("1. Añadir alumno");
		System.out.println("2. Listar alumnos en orden de introducción");
		System.out.println("3. Modificar nombre alumno.");
		System.out.println("4. Borrar alumno "); 
		System.out.println("5. Consultar datos alumno");
		System.out.println("6. Matricular alumno en asignatura");
		System.out.println("7. Pedir nota alumno "); 
		System.out.println("8. Media notas alumno ");
		System.out.println("9. Media notas clase  ");
		System.out.println("10. Listar alumnos por orden de nota media");
		System.out.println("0. Finalizará el programa ");
		System.out.println("Elegir opción");
	}
	int pedirOpc(Teclado t) throws IOException {
        return t.leerInt();
	}
	boolean anadir(Teclado t) throws IOException {
		boolean ok=true;
		if (contAlumnos<MAXIMOALUMNOS) {
		  System.out.println("Dar nombre");
		  String nombre= t.leerString();
		  alumnos[contAlumnos]= new Alumno(nombre);
		  contAlumnos++;
		}
		else
			ok=false;
		return ok;
	}
	void listar() {
		if (contAlumnos<=0)
			System.out.println("No hay alumnos");
		else
		  for(int i=0; i<contAlumnos; i++) {
			alumnos[i].mostrar();
		}
	}
	Alumno buscarNIA(int nia){
		Alumno a=null;
		for ( int i=0; i<contAlumnos && a==null ; i++)
			if ( nia==alumnos[i].nia)
				a= alumnos[i];
		return a;
	}
	int buscarPosicionNIA(int nia){
		int pos=-1;  //-1 es que no lo ha encontrado
		for ( int i=0; i<contAlumnos && pos==-1; i++)
			if ( nia==alumnos[i].nia)
				pos=i;
		return pos;
	}
	// Matricula a un alumno en una asignatura
	boolean matricular(Teclado t)  throws IOException{
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
	// Modifica el nombre de un alumno 
	boolean modificar(Teclado t)  throws IOException{
		boolean modificado=false;
		System.out.println("Dar nia");
		int nia=t.leerInt();
		Alumno a=buscarNIA(nia);
		if (a!=null) {
			a.mostrar();
			System.out.println("Dar nuevo nombre");
			String nuevoNombre= t.leerString();
			a.setNombre(nuevoNombre);
			modificado=true;
		}
		return modificado;
	}
	// Consultar el nombre de un alumno 
	boolean consultar(Teclado t)  throws IOException{
		boolean consultado=false;
		System.out.println("Dar nia");
		int nia=t.leerInt();
		Alumno a=buscarNIA(nia);
		if (a!=null) { 
			a.mostrar();
			consultado=true;
		}
		return consultado;
	}
	// Pedir una nota del alumno 
		boolean pedirNota(Teclado t)  throws IOException{
			boolean existe=false;
			System.out.println("Dar nia");
			int nia=t.leerInt();
			Alumno a=buscarNIA(nia);
			if (a!=null) {
				existe= a.pedirNota(t);
			}
			return existe;
		}
	boolean borrar(Teclado teclado) throws IOException {
        boolean borrar=true;
		System.out.println("Dar nia");
        int nia= teclado.leerInt();
        int posAlumno=buscarPosicionNIA(nia);
        if (posAlumno!=-1){
            for (int i=posAlumno; i<contAlumnos-1;i++){
                alumnos[i]=alumnos[i+1];
            }
            alumnos[contAlumnos-1]=null;
            contAlumnos--;
        } else {
            borrar=false;
        }
        return borrar;
    }
	double mediaNotasAlumno(Teclado t) throws IOException{
		double media=-1;
		System.out.println("Dar nia");
		int nia=t.leerInt();
		Alumno a=buscarNIA(nia);
		if (a!=null) {
			media=a.mediaNotas();
		}
		return media;
	}
	void listarMedia(){
		Alumno[] alumnosordenado = new Alumno[alumnos.length];
		Alumno aux;

		for (int i = 0; i<alumnos.length; i++){
			alumnosordenado[i]= alumnos[i];
		}

		if (contAlumnos<=0)
			System.out.println("No hay alumnos");
		else if (contAlumnos==1) {
			alumnos[0].mostrar();
		} else {
			for (int j = 0; j < contAlumnos; j++) {
				for (int i = 0; i < contAlumnos-1; i++) {
					if (alumnosordenado[i].getMedia() > alumnosordenado[i + 1].getMedia()) {
						aux = alumnosordenado[i];
						alumnosordenado[i] = alumnosordenado[i + 1];
						alumnosordenado[i + 1] = aux;
					}
				}
			}
			for (int i = 0; i < contAlumnos; i++) {
				alumnosordenado[i].mostrar();
			}
		}
	}
	void ejecutarOpcion(int n, Teclado t) throws IOException  {
		switch(n) {
		case 1: 
			if (!anadir(t))
				System.out.println("Array lleno");
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
			if (!pedirNota(t))
				System.out.println("Error en la consulta");
			break;
		case 8: 
			double media=mediaNotasAlumno(t);
			if (media==-1 )
				System.out.println("Error en la consulta, no existe el alumno");
			else
				if (media==-2 )
				  System.out.println("El alumno no tiene notas");
				else
				  System.out.println("Nota media="+media);
			break;

			case 0:
			System.out.println("FIN"); 
			break;

			case 10:
				listarMedia();
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
		Alumno a = grupo.alumnos[0];
		System.out.println(a.getMedia());
	}
}