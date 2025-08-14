package CoycontraVarianza;

import java.util.ArrayList;
import java.util.List;

public class UsoCoyContraVarianza {

	public void UsoCoyContraVarianzaColecciones() {
	//NO válido:	
	//	ArrayList<Number> lp= new ArrayList<Integer>();
	//NO válido:
	//	ArrayList<Integer> lp2= new ArrayList<Number>();
	}

	public void UsoCoyContraVarianzaArrays() {
		//Covarianza: OK en arrays
	   Integer[] myInts = {1,2,3,4};
	   Number[] myNumber = myInts;   //Integer extends Number
	   myNumber[0] = 3.14;  //Error de ejecución al poner un double en un array de Integer 
	   
	   //Contravarianza no es válida
	   Number[] miNums2 = {1,2,3,4};
	  //Inválido :   Integer[] miEnteros = miNums2;   
	   myNumber[0] = 3.14;
	}
	
	static List<? extends Number> inicializarLista(int fin){
		List<Integer>lista= new ArrayList<Integer>();
		for (int i=0; i<fin; i++)
		  lista.add(i+3);
		return lista;
	}
	static void CovarianzaWildCards() {
		List<? extends Number> listaNums1 = new ArrayList<Integer>();
		List<? extends Number> listaNums2 = new ArrayList<Float>();
		List<? extends Number> listaNums3 = new ArrayList<Double>();
		Number num=33;
		//No podemos realizar añadidos a las listas tal cual
		//  listaNums1.add(num);
		//Number n=listaNums1.get(0);
		listaNums1=inicializarLista(5);
		//Si podemos obtener el valor
		Integer ni=(Integer)listaNums1.get(0);
		System.out.println(ni);
	}

	static void ContraarianzaWildCards() {
		List<? super Integer> listaNums1 = new ArrayList<Number>();
		//No válido Number myNum = listaNums1.get(0); 
	}

	
	static long sum(Number[] numbers) {
		long suma = 0;
		for(Number number : numbers) 
			suma += number.longValue();
		return suma;
	}
	static void sumar() {
	  Integer[] myInts = {1,2,3,4,5};
	  Long[] myLongs = {1L, 2L, 3L, 4L, 5L};
	  Double[] myDoubles = {1.0, 2.0, 3.0, 4.0, 5.0};
	  System.out.println(sum(myInts));
	  System.out.println(sum(myLongs));
	  System.out.println(sum(myDoubles));
	}
	public static void main(String[] args) {
		sumar();
		CovarianzaWildCards();
	}
}
