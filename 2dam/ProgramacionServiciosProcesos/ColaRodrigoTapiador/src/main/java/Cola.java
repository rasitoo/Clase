import java.util.ArrayDeque;


public class Cola<T> implements IMiPila<T> {
    ArrayDeque<T> pila;
    Cola(){
        pila = new ArrayDeque<T>();
    }
    @Override
    public boolean anadir(T objeto) {
        pila.add(objeto);
        return true;
    }
    @Override
    public T sacar(){
        return pila.removeFirst();
    } //RemoveFirst porque el primero que entra es el primero en salir
    @Override
    public void imprimir(){
        pila.stream().forEach(System.out::println);
    }
    @Override
    public boolean estaVacia() {
        return pila.isEmpty();
    }

}
