import java.util.Vector;

public class GestionarCapacidad {

	static void mostrar(Vector <Integer> v) {
		for (Integer i: v)
			System.out.println(i);
	}
	public static void main(String[] args) {
		Vector <Integer> vEnteros= new Vector<Integer>(4,3);
		System.out.println("1.-"+vEnteros.capacity());//4
		for (int i=0; i<8; i++)
		 vEnteros.add(i*10);
		System.out.println("2.-"+vEnteros.capacity());

		for (int i=0; i<3; i++)
			vEnteros.remove(1);
		System.out.println("3.-"+vEnteros.capacity());  //10
		vEnteros.ensureCapacity(6);
		System.out.println("4.-"+vEnteros.capacity());//10
		mostrar(vEnteros);
		vEnteros.setSize(3);
		System.out.println("5.-"+vEnteros.capacity());//10
		
	}

}
