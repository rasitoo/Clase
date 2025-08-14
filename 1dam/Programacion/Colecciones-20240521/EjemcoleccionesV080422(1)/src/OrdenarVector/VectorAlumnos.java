package OrdenarVector;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class VectorAlumnos {
    static void mostrar(Vector va){
    	for (int i=0; i<va.size(); i++)
        	System.out.println (va.elementAt(i) );
    }
    
	public static void main (String arg[]){
	VectorAlumnos obj= new VectorAlumnos();
	Vector <Alumno> va;
	va=new Vector <Alumno>(2);
	
	Alumno a= new Alumno ("Juan", 13);
    va.add(a);
    va.add(new Alumno ("Ana",12));
    va.add(new Alumno ("Juan",11));
    va.add(new Alumno ("María",14));
    VectorAlumnos.mostrar(va);

    
   
	System.out.println ("FIN VECTOR Alumno");

    
  //  Vector <int> vint= new Vector<int>();  //No permitido 
    
    Collections.sort(va);    
    VectorAlumnos.mostrar(va);
    
    //  a=(Alumno) vo.elementAt(1);
    System.out.println("Ordeno por edad");
    //Convierto a Integer porque compareto tiene que recibir objetos.
    Collections.sort(va, (a1, a2) -> (Integer.valueOf(a1.edad)).compareTo(Integer.valueOf(a2.edad)));
    System.out.println(va);
   

	}
}
