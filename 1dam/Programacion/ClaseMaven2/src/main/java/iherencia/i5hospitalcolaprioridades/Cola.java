package iherencia.i5hospitalcolaprioridades;

import java.util.ArrayDeque;

/**
 * @author Rodrigo
 * @date 23 abril, 2024
 */
public class Cola<T> implements MiPilaItf<T> {
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
