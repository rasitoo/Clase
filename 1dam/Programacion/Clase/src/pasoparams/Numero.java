package pasoparams;

public class Numero {
	int valor;
	int getValor() {
		return valor;
	}
	Numero(int valor){
		this.valor=valor;
	}

	public static void main(String[] args) {
		Numero n= new Numero(33);
		System.out.println(n.getValor());
	}

}
