
public class Fraccion {
  private int num;
  private int den;

  Fraccion(){
	  num=(int)(Math.random()*10+1);
	  den=(int)(Math.random()*10+1);
  }
  public Fraccion(int num, int den) {
	super();
	this.num = num;
	this.den = den;
  }
  public int getNum() {
	return num;
  }
  public void setNum(int num) {
	this.num = num;
  }
  public int getDen() {
	return den;
  }
  public void setDen(int den) {
	this.den = den;
  }
  Fraccion sumar(Fraccion f) {
	  int num,den;
	  num=this.num*this.den+this.den*f.num;
	  den=this.den*f.den;
	  Fraccion fr= new Fraccion(num,den);
	  return fr;
  }
  void mostrar() {
	  System.out.println(num+"/"+den);
  }
  public static void main(String[] args) {
	System.out.println("Ejecutado");
	Fraccion f1= new Fraccion(3,5);
	Fraccion f2= new Fraccion(4,5);
	Fraccion fs=f1.sumar(f2);
	fs.mostrar();
  }

}
