package aejemgeometria;

public class Triangulo {
	Punto p1; //aunque en la clase punto ya existe p1 en la clase triangulo no.
	Punto p2;
	Punto p3;
	Triangulo(Punto p1,Punto p2,Punto p3){
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	void mostrar(String txt) {
		System.out.println(txt + ":");
		p1.mostrar("p1");
		p2.mostrar("p2");
		p3.mostrar("p3");
	}
	void obtenerPerimetro(String txt){
		double d1= p1.calcularDistancia(p2);     //Math.sqrt((p1.x-p2.x)*(p1.x-p2.x))+((p1.y-p2.y)*(p1.y-p2.y));
		double d2= p2.calcularDistancia(p3);    //Math.sqrt((p1.x-p3.x)*(p1.x-p3.x))+((p1.y-p3.y)*(p1.y-p3.y));
		double d3= p3.calcularDistancia(p1);    //Math.sqrt((p3.x-p2.x)*(p3.x-p2.x))+((p3.y-p2.y)*(p3.y-p2.y));
		double perimetro= d1+ d2+ d3;
		System.out.println("El perimetro del triangulo "+ txt + " es: " + perimetro);
	}
	boolean esEquilatero(){
		double d1= p1.calcularDistancia(p2);
		double d2= p2.calcularDistancia(p3);
		double d3= p3.calcularDistancia(p1);
		return Math.round(d1)== Math.round(d2) && Math.round(d2) == Math.round(d3);
	}

	public static void main(String[] args) {
		Triangulo t1;
		Punto puntoa = new Punto(0,0);
		Punto puntob = new Punto(4,0);
		Punto puntoc = new Punto(2,3.47);

		t1= new Triangulo(puntoa, puntob, puntoc);
		t1.mostrar("t1");
		t1.obtenerPerimetro("t1");
		System.out.println(t1.esEquilatero());
	}

}
