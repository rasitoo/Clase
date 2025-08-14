package aejemif.ejer7juego;

public class Punto2 {
	private double x,y;
	Punto2(double x, double y){
		this.x = x; //this.x es el atributo y x el parámetro
		this.y = y;
	}
	void mostrar(String txt) {
		System.out.println(txt +": " + x + "," + y);
	}
	public double calcularDistancia(Punto2 p1) {
		double ladox = p1.x-this.x;
		double ladoy = (p1.y-this.y);
		return Math.sqrt((ladox*ladox)+(ladoy*ladoy));
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public static void main(String[] args) { //El main y el constructor son ambos métodos por eso  van separaodos
		Punto2 p1=new Punto2(4, 6);
		p1.mostrar("p1");
		Punto2 p2= new Punto2(5, 3);
		p2.mostrar("p2");
		Punto2 p3 = new Punto2(1, 3);
		p3.mostrar("p3");
	}

}
