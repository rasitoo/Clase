
import java.util.Vector;
public class Clonacion {
	@SuppressWarnings("unchecked")
	static Vector <Integer>  clonar( Vector <Integer> vOrigen) {
		Vector <Integer> vCopia= (Vector<Integer>) vOrigen.clone();
		return vCopia;
	}
public static void main(String[] args) throws CloneNotSupportedException {
int []aEnteros={1,3,6,2,6};
Vector <Integer> vEnteros= new Vector<Integer>();
for (Integer i:aEnteros)
  vEnteros.add(i);
Vector <Integer> vCopia=clonar(vEnteros);
vCopia.add(111);
// deprecated: vEnteros.remove(new Integer(6));
vEnteros.remove(Integer.valueOf(6));
System.out.println("vEnteros");
for (Integer i:vEnteros )
  System.out.print(i+",");
System.out.println();
System.out.println("vCopia");
for (Integer i:vCopia )
  System.out.print(i+",");
System.out.println();
}
}

