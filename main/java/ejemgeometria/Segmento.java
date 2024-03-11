package ejemgeometria;
//crear constructor, metodo mostrar y metodo calcularLongitud

public class Segmento {
	Punto p1;
	Punto p2;
	Segmento(Punto p1, Punto p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	void mostrar() {
		System.out.print("p1: " + p1.getX() + "," + p1.getY());
		System.out.println(" p2: " + p2.getX() + "," + p2.getY());
	}
	double calcularLongitud() {
		double d1 = p1.getX() - p2.getX();
		double d2 = p1.getY() - p2.getY();
		double longitud = Math.sqrt(d1*d1 + d2*d2);
		return longitud;
	}
	public static void main(String[]args) {
		Segmento s1= new Segmento(new Punto(5,2), new Punto(2,3));
		s1.mostrar();
		double l = s1.calcularLongitud();
		System.out.println(l);
	}

}
