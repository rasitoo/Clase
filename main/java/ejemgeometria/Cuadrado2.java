package ejemgeometria;

public class Cuadrado2 {
	Punto pSupIzq;
	Punto pInfDcho;
	Cuadrado2(Punto p1, Punto p3){
		pSupIzq = p1;
		pInfDcho = p3;
	}
	void mostrar(String txt) {
		Punto pInfIzq = crearPtoInfIzq();
		Punto pSupDcho = crearPtoSupDcho();
		pSupIzq.mostrar("pSupIzq");
		pInfIzq.mostrar("pInfIzq");
		pInfDcho.mostrar("pInfDcho");
		pSupDcho.mostrar("pSupDcho");
	}
	Punto crearPtoSupDcho() {
		return new Punto(pInfDcho.getX(), pSupIzq.getY());
	}
	Punto crearPtoInfIzq() {
		return new Punto(pSupIzq.getX(), pInfDcho.getY());
	}
	double calcularPerimetro() {
		Punto pInfIzq = crearPtoInfIzq();
		double v1 = pSupIzq.calcularDistancia(pInfIzq);

		double perimetro = v1 * 4;
		return perimetro;
	}
	public static void main(String[] args) {
		Cuadrado2 c= new Cuadrado2(new Punto(1,5), new Punto (5,1));
		c.mostrar("c");

		double p = c.calcularPerimetro();
		System.out.println("El perimetro del cuadrado es:" + p);
	}

}
