package _18_09_2023_;

public class Alumno {
	// Declaramos atributos
	int edad = 13; // el atributo se pone fuera del método, y se usa en cualquiera no-estático.
	int nota1 = 4, nota2 = 6;
	String nombre;
	Alumno(int edad, String nombreAlumno){ //es un constructor ya que se llama igual que la clase
		nombre=nombreAlumno;
		this.edad=edad;
	}

	// método sin atributo
	void incrementarEdad() { // parametro/método, al ser void no devuelve nada
		edad++;
	}

	// metodo con atributo entero
	void incrementarEdad(int aumento) {
		edad += aumento;
	}

	// método que devuelve un entero por lo que tiene que teneruna instrucción
	// return
	int devolverNotaMedia() { // Este método devuelve un valor int, mejor que no sea un atributo porque es fácilmente calculable
		int notaMedia = (nota1 + nota2) / 2;
		return notaMedia;
	}

	public static void main(String arg[]) {
		System.out.println("Inicio");
		Alumno a; // Referenciamos al objeto
		a = new Alumno(22, "Ana"); // creamos el objeto, a es la dirección de memoria donde está el objeto
							// (referencia).
		Alumno a2 = new Alumno(22, "Ana");
		System.out.println("edad del alumno: " + a.edad);
		a.edad = 30; // al ser un método estático tenemos que referenciar al objeto para usar la
						// edad, la cual modificamos
		a.nombre = "Pepe";
		System.out.println("edad del alumno: " + a.edad + " nombre: " + a.nombre);
		a.incrementarEdad(8);
		System.out.println("edad del alumno: " + a.edad + " nombre:" + a.nombre);
		System.out.println("edad del alumno2: " + a2.edad + " nombre: " + a2.nombre);
		int nm = a.devolverNotaMedia();
		System.out.println("La nota media es: " + nm);

		Alumno ax= new Alumno (44, "Pepe"); //ax referencia al objeto que creamos al otro lado del igual
		Alumno ay=ax; //ay referencia al mismo objeto que ax pero no crea ninguno nuevo
		System.out.println("1-" + ax.nombre);
		System.out.println("2-" + ay.nombre);
		ay.nombre= "Juan";
		System.out.println("3-" + ay.nombre);
	}
}