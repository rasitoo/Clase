package Polinomio;
//Ejemplo uso de 2 genéricos
public class Operar <T extends Numero, P extends Polinomio>{
  T n;
  P p;
  Operar ( T n, P p){
	  this.n=n;
	  this.p=p;
  }
  void multiplicar (){
	  int aux=n.getValor();
	  for (int i=0; i<p.mayor();i++)
		  p.asignar(i, p.elemento(i)*aux);
  }
  public  P getMultiplicacion(){
	  int aux=n.getValor();
	  for (int i=0; i<p.mayor();i++)
		  p.asignar(i, p.elemento(i)*aux);
	  return p;
  }
  public static void main (String arg[]){
	  Polinomio p= new Polinomio();
	  p.asignar(3, 33);
	  p.asignar(5,  55);
	  p.asignar(2, 22);
	  Numero num= new Numero (2);
	  Operar <Numero, Polinomio>op= new Operar<Numero, Polinomio>(num,p);
	  op.multiplicar();
	  System.out.println(p);
	  Polinomio p2= op.getMultiplicacion();
	  System.out.println(p2);
	  
  }
}
