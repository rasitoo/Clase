public interface IMiPila<T> {
	public boolean anadir(T objeto);
	public T sacar();
	public void imprimir();
	boolean estaVacia();
}