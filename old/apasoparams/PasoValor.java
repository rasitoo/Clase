package apasoparams;

public class PasoValor {
	void metodo(int a) {
		a=7;
	}

	public static void main(String[] args) {
		int x=3;
		PasoValor pv=new PasoValor();
		pv.metodo(x);
		System.out.println(x);
	}

}
