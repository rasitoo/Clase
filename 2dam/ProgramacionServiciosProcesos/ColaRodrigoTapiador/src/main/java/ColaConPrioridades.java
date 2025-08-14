
public class ColaConPrioridades<T> extends Cola<T> {
    private Cola<T>[] c;

    ColaConPrioridades(int prioridades) {
        this.c = new Cola[prioridades];
        for (int i = 0; i < c.length; i++) {
            c[i] = new Cola<T>();
        }
    }

    public Cola<T>[] getC() {
        return c;
    }

    public void setC(Cola<T>[] c) {
        this.c = c;
    }

    public boolean anadir(T objeto, int prioridad) {
        if (c[prioridad] == null) {
            System.out.println("No existe cola con esa prioridad");
        }
        c[prioridad].anadir(objeto);
        return true;
    }

    @Override
    public T sacar(){
        int tamano;
        for (int i = 0; i < c.length; i++) {
            tamano = c[i].pila.size();
            if (tamano > 0)
                return c[i].pila.removeFirst();
        }
        return null;
    }
    public void sacarTodos() {
        int tamano;
        for (int i = 0; i < c.length; i++) {
            tamano = c[i].pila.size();
            for (int j = 0; j < tamano; j++) {
                System.out.println(c[i].sacar());
            }
        }
    }
    @Override
    public boolean estaVacia() {
        for (int i = 0; i < c.length; i++) {
            if (!c[i].pila.isEmpty())
                return false;
        }
        return true;
    }
}
