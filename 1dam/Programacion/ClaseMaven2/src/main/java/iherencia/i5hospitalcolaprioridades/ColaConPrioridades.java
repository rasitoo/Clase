package iherencia.i5hospitalcolaprioridades;

/**
 * @author Rodrigo
 * @date 23 abril, 2024
 */
public class ColaConPrioridades<T> extends Cola<T> {
    private Cola<T>[] c;

    ColaConPrioridades(int prioridades) {
        this.c = new Cola[prioridades+1];
        for (int i = 1; i < c.length; i++) {
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
            System.out.println("Cola no existe");
        }
        c[prioridad].anadir(objeto);
        return true;
    }

    public void sacarTodos() {
        int tamano;
        for (int i = c.length-1; i > 0; i--) {
            tamano = c[i].pila.size();
            if (tamano > 0) {
                for (int j = 0; j < tamano; j++) {
                    System.out.println(c[i].sacar());
                }
            }
            else {
                System.out.println("No hay pacientes con prioridad " + i);
            }

        }
    }
    @Override
    public T sacar() {
        int tamano;
        for (int i = c.length-1; i > 0; i--) {
            tamano = c[i].pila.size();
            for (int j = 0; j < tamano; j++) {
                return c[i].sacar();
            }
        }
        return null;
    }
}
