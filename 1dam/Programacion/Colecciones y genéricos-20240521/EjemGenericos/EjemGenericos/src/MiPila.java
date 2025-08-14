import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class MiPila <T> implements MiPilaItf<T>{
    ArrayDeque <T>pila;
    MiPila(){
        pila = new ArrayDeque<T>();
    }
    @Override
    public boolean anadir(T objeto) {
        pila.add(objeto);
        return true;
    }
    @Override
    public T sacar(){
        return pila.removeLast();
    }
    @Override
    public void imprimir(){
        pila.stream().forEach(System.out::println);
    }
    @Override
    public boolean estaVacia() {
        return pila.isEmpty();
    }


}
