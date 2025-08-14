package Polinomio;

import java.util.Vector;

public class Polinomio {
 Vector <Integer>coeficientes= new Vector<Integer>();
 void asignar (int posicion, int valorCoeficiente){
	 if (coeficientes.size()<posicion){
	   for (int i=coeficientes.size(); i<posicion; i++)
		  coeficientes.add(0);
	   coeficientes.add( valorCoeficiente );
	 }
	 else
		   coeficientes.setElementAt(valorCoeficiente, posicion );
 }
 int mayor(){
	 return coeficientes.size();
 }
 int elemento (int pos){
	 return coeficientes.elementAt(pos);
 }
 public String toString(){
	 String aux="";
	 int i=0;
	 for (int c: coeficientes){
		 if (c!=0)
		   aux+= c+"x^"+i+"+";
		 i++;
	 }
	 return aux;
 }
}
