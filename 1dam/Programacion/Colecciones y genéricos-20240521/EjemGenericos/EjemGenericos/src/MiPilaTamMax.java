public class MiPilaTamMax<T> extends MiPila<T> {
    int tamMax;
    MiPilaTamMax(int tamMax){
        this.tamMax = tamMax;
    }
    @Override
    public boolean anadir(T objeto) {
        if (pila.size() < tamMax) {
            pila.add(objeto);
            return true;
        }
        return false;
    }

}
