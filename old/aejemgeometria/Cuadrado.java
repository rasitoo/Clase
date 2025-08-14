package aejemgeometria;

public class Cuadrado {
	Punto pSupIzq;
	Punto pInfDcho;
	Punto pInfIzq;
	Punto pSupDcho;
	Cuadrado(Punto p1, Punto p3){
		pSupIzq = p1;
		pInfDcho = p3;
		pInfIzq = new Punto(pSupIzq.getX(), pInfDcho.getY());
		pSupDcho = new Punto(pInfDcho.getX(), pSupIzq.getY());
	}
	void mostrar(String txt) {
		pSupIzq.mostrar("pSupIzq");
		pInfIzq.mostrar("pInfIzq");
		pInfDcho.mostrar("pInfDcho");
		pSupDcho.mostrar("pSupDcho");
	}
	double calcularPerimetro() {
		double v1 = pSupIzq.calcularDistancia(pInfIzq);
		double v2 = pInfIzq.calcularDistancia(pInfDcho);

		double perimetro = v1*2 + v2*2;
		return perimetro;
	}
	public static void main(String[] args) {
		Cuadrado c= new Cuadrado(new Punto(1,5), new Punto (9,3));
		c.mostrar("c");

		double p = c.calcularPerimetro();
		System.out.println("El perimetro del cuadrado es:" + p);
	}

}
