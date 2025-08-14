package HashTable;


import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class EjemHashTable {
	static Hashtable <String, Persona> ht= new Hashtable <String, Persona>();
	static Hashtable <Clave, Persona> ht2= new Hashtable <Clave, Persona>();
	static Hashtable <Integer, Integer> ht4= new Hashtable <Integer, Integer>(33,(float)0.75);

	
	static void crearHashTableEnteros(){
		ht4.put(3,30);
		ht4.put(1, 10);
		ht4.put(2, 2);
		System.out.println(ht4.size());
		for (int i=0; i<33; i++)
			ht4.put(i, i*10);
	}
    static void crearHashTableSimple(){
		ht.put("Juan",  new Persona ("Juan",1,100));
		ht.put("Ana",  new Persona ("Ana",2,200));
		ht.put("Jose",  new Persona ("Jose",4,400));
		Persona p=new Persona ("Oscar",3,300);
		ht.put(p.nombre,  p);

		Persona px= ht.get("Ana");
		System.out.println("nombre:"+px.nombre+" edad:"+px.edad);
    }
    static void listarHashTableSimple(){ 
     //No está ordenado por ningún criterio, tampoco por el orden de inserción
    	Enumeration<Persona> listaPersonas;
    	Persona p;

    	listaPersonas = ht.elements();
    	while(listaPersonas.hasMoreElements()) {
    		p =  listaPersonas.nextElement();
    	    System.out.println("Nombre " +p.nombre+ " Edad:"+ p.edad+" sueldo:"+p.sueldo);
    	}
    }    
    static void listarHashTableSimple2(){ 
        //No está ordenado por ningún criterio, tampoco por el orden de inserción
    	//Se puede usar LinkedHashMap para conseguir orden.
    	Collection<Persona> listaPersonas;
       	Persona p;

       	listaPersonas = ht.values();
       	Iterator<Persona> it=listaPersonas.iterator();
       	while(it.hasNext()) {
       		p =  it.next();
       	    System.out.println("Nombre " +p.nombre+ " Edad:"+ p.edad);
       	}
       }
    static void listarHashTableOrdenada(){
        // Obtenemos los elementos del Hasttable
        Set<Entry<String, Persona>> set = ht.entrySet();
        // Obtenemos un iterator de los elementos obtenidos
        Iterator<Map.Entry<String,Persona>> i = set.iterator();
        while(i.hasNext()) {
          Persona p=(Persona)((Map.Entry<String,Persona>)i.next()).getValue();
          System.out.println(p.nombre+":"+p.edad);
        }
    }
    static void crearHashTable(){
		ht2.put(new Clave(19,"aa"),  new Persona ("Juan",1,100));
		ht2.put(new Clave(18,"b"),  new Persona ("Ana",2,200));
		Clave c=new Clave(17,"CCC"); 
		ht2.put(c,  new Persona ("Oscar",3,300));

		Persona p2= ht2.get(c);  //no sería válido poner ht2.get(new Clave(17)); porque referenciaría a otra clave
		System.out.println(p2.edad);
    }
    static void listarClaves (){
    	Enumeration<Clave> claves = ht2.keys();

    	while (claves.hasMoreElements()) {
    	  System.out.println(""+"hashtable llaves: " + claves.nextElement());

    	}
    }
    
    static void añadirDuplicados(){
		ht.put("Marta",  new Persona ("Marta",4,400));
		Persona px= ht.get("Marta");
		System.out.println("1nombre:"+px.nombre+" edad:"+px.edad);
		ht.put("Marta",  new Persona ("Marta",43,4300));
		px= ht.get("Marta");
		System.out.println("2nombre:"+px.nombre+" edad:"+px.edad);
		px=ht.remove("Marta");
		System.out.println("eliminado nombre:"+px.nombre+" edad:"+px.edad);
		px= ht.get("Marta");
		if (px==null) System.out.println("Marta ya no está");

    }
	public static void main(String[] args) {
		crearHashTableEnteros();
		crearHashTableSimple();
		listarHashTableSimple2();
		crearHashTable();
		listarHashTableOrdenada();
		añadirDuplicados();
		System.out.println("Claves");
		listarClaves();
		
		

	}

}
