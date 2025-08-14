package ejemgeometria;

public class Circulo {
	Punto centro;
	double radio;
	final static double PI = 3.1416;
	Circulo(Punto centro, double radio){
		this.radio = radio;
		this.centro = centro;
	}
	void mostrar() {
		System.out.print("Radio: " + radio); //si quitas el ln no salta de linea
		centro.mostrar(" Centro");
	}
	double obtenerPerimetro(){
		return radio * 2 * PI;
	}
	double calcularArea(){
		return radio * radio * PI;
	}
	public static void main(String[] args) {
		Circulo c;
		c= new Circulo(new Punto(4, 5), 3);
		c.mostrar();
		System.out.println(c.obtenerPerimetro());

		double d = Math.sqrt(9);
		System.out.println(d);

		System.out.println(c.calcularArea());

	}

}
