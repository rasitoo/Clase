package apasoparams;

public class PasoValorObj {
	void metodo(Numero a) {
		a.valor=55;
	}
	public static void main(String[] args) {
		Numero n= new Numero(44);
		PasoValorObj pvo= new PasoValorObj();
		pvo.metodo(n);
		System.out.println(n.valor);
	}

}
