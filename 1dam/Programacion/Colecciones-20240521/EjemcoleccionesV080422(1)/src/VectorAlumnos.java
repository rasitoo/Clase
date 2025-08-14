import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class VectorAlumnos {

	public static void main (String arg[]){
	Vector <Alumno> va;
	va=new Vector <Alumno>(2);
	
	Alumno a= new Alumno ("Juan", 11);
    va.add(a);
    va.add(new Alumno ("Ana",12));
    va.add(new Alumno ("Oscar",13));
    va.add(new Alumno ("María",14));
    for (int i=0; i<va.size(); i++)
    	System.out.println (va.elementAt(i) );
    
    a= va.elementAt(2);
    
	System.out.println ("FIN VECTOR Alumno");
    Vector vo;
    vo=new Vector (5,2);
    
    vo.add(a);
    vo.add(new Integer(33));
    vo.add(12);  //También se permite añadir el entero directamente
    for (int i=0; i<vo.size(); i++)
    	System.out.println (vo.elementAt(i) );
    
   
  //  a=(Alumno) vo.elementAt(1);
    

    

	}
}
