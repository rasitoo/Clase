package iherencia.i6emparejarparentesis;

public class Numero {
    int valor;

    Numero(int n) {
        valor = n;
    }

    int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Numero [valor=" + valor + "]";
    }

}
