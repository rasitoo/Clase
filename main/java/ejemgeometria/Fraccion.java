package ejemgeometria;

public class Fraccion {
	private int numerador;
	private int denominador;
	public Fraccion(int numerador, int denominador){
		this.numerador=numerador;
		this.denominador=denominador;
	}

	public int getNumerador() {
		return numerador;
	}

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}
	public int getDenominador() {
		return denominador;
	}
	public void setDenominador(int valor) {
		if (valor!=0)
			denominador=valor;
	}
	public void mostrar(){
		System.out.println(numerador + "/" + denominador);
	}
	Fraccion reducirfraccion(){
		int numerador = this.numerador;
		int denominador = this.denominador;

		for (int i = 2; i<=numerador && i<=denominador; i++){
			if (numerador%i == 0 && denominador%i == 0){
				numerador = numerador/i;
				denominador = denominador/i;
				i=1; //Se vuelve a comprobar sus divisores empezando de nuevo desde el 2, pongo 1 porque al volver a iniciar el bucle se le suma 1 a i, si pongo 2 empezaria el siguiente en 3
			}
		}
		return new Fraccion(numerador,denominador);
	}
	public static void main(String[] args) {
		Fraccion e = new Fraccion(322859458,645718916);

		Fraccion f1 = e.reducirfraccion();
		f1.mostrar();
	}

}
