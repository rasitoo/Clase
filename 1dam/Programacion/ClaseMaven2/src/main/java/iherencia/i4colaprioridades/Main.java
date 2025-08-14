package iherencia.i4colaprioridades;

/**
 * @author Rodrigo
 * @date 23 abril, 2024
 */
public class Main {
    public static void main(String[] args) {
        ColaConPrioridades<Persona> cp = new ColaConPrioridades<Persona>(5);
        for (int i = 0; i < 10; i++) {
            Persona p = new Persona((int) (Math.random() * 65), "x", (int) (Math.random() * cp.getC().length - 1) + 1, i + 1);
            System.out.println(p);
            cp.anadir(p, p.prioridad);
        }
//        cp.getC()[1].imprimir();
//        cp.getC()[2].imprimir();
//        cp.getC()[3].imprimir();
//        cp.getC()[4].imprimir();
//        cp.getC()[5].imprimir();
        System.out.println();
        cp.sacarTodos();
    }
}
