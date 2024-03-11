package pasoparams;

public class Fraccion {
	private int numerador=1;
	private int denominador=1;
	Fraccion(int num, int den){
		numerador=num;
		denominador=den;
	}
	int getNumerador() {
		return numerador;
	}
	int getDenominador() {
		return denominador;
	}
	void mostrar(String txt) {
		System.out.println("La fraccion " + txt + " es "+numerador+ "/"+ denominador);
	}
	Fraccion multiplicar(Fraccion f1) {
		Fraccion fres;
		int numres = this.numerador * f1.numerador;
		int denres = this.denominador * f1.denominador;
		fres = new Fraccion(numres, denres);
		return fres;
	}
	void dividir(Fraccion f1, Fraccion f2) {
		this.numerador = f1.numerador * f2.denominador;
		this.denominador = f1.denominador * f2.numerador;
	}
	public static void main(String[] args) {
		Fraccion f= new Fraccion(4,5);
		Fraccion f2= new Fraccion (6,8);
		Fraccion fresultado=f2.multiplicar(f);
		fresultado.mostrar("fresultado");
		fresultado.dividir(f, f2);
		fresultado.mostrar("fresultado división🫃❤️🦖");
	}
}
