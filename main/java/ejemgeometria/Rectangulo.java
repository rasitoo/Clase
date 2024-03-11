package ejemgeometria;

public class Rectangulo {
	Punto pSupIzq;
	Punto pInfDcho;
	Punto pInfIzq;
	Punto pSupDcho;
	RGB colorBorde = new RGB(255,255,255);
	RGB colorRelleno = new RGB(0,0,0);

	Rectangulo(){
		pInfIzq = new Punto(0,0);
		pSupDcho = new Punto(1,1);
		pInfDcho = new Punto(pSupDcho.getX(), pInfIzq.getY());
		pSupIzq = new Punto(pInfIzq.getX(), pSupDcho.getY());
	}
	Rectangulo( Punto p1, double ancho, double alto){
		pInfIzq = p1;
		pSupDcho = new Punto(p1.getX() + ancho, p1.getY() + alto);
		pInfDcho = new Punto(pSupDcho.getX(), pInfIzq.getY());
		pSupIzq = new Punto(pInfIzq.getX(), pSupDcho.getY());

	}
	Rectangulo(Punto p1, Punto p3){
		pSupDcho = p1;
		pInfIzq = p3;
		pInfDcho = new Punto(pSupDcho.getX(), pInfIzq.getY());
		pSupIzq = new Punto(pInfIzq.getX(), pSupDcho.getY());
	}
	void mostrar(String txt) {
		System.out.println("Los puntos del rectangulo " + txt + " son:");
		pSupIzq.mostrar("pSupIzq");
		pInfIzq.mostrar("pInfIzq");
		pInfDcho.mostrar("pInfDcho");
		pSupDcho.mostrar("pSupDcho");
		colorBorde.mostrar("color borde");
		colorRelleno.mostrar("color relleno");
	}
	double calcularPerimetro() {
		double v1 = pSupIzq.calcularDistancia(pInfIzq);
		double v2 = pInfIzq.calcularDistancia(pInfDcho);

		return v1*2 + v2*2;
	}
	double calcularArea(){
		double v1 = pSupIzq.calcularDistancia(pInfIzq);
		double v2 = pInfIzq.calcularDistancia(pInfDcho);
		return  v1 * v2;
	}
	double mostrarBase(){
		return pInfIzq.calcularDistancia(pInfDcho);
	}
	double mostrarAltura(){
		return pSupIzq.calcularDistancia(pInfIzq);
	}
	public static void main(String[] args) {
		Rectangulo c= new Rectangulo(new Punto(1,8), new Punto (5,1));
		c.mostrar("c");
		System.out.println(c.mostrarBase());
		System.out.println(c.mostrarAltura());
		System.out.println(c.calcularArea());
		System.out.println(c.calcularPerimetro());

		Rectangulo c2= new Rectangulo(new Punto(2,6), 8, 9);
		c2.colorBorde = new RGB(125,125,125);
		c2.colorRelleno = new RGB(125,125,125);
		c2.mostrar("c2");
		Rectangulo c3= new Rectangulo();
		c3.mostrar("c3");
		double p = c.calcularPerimetro();
		System.out.println("El perimetro del cuadrado es:" + p);
	}

}
