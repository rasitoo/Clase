/**
 * La clase `Vaso` representa un vaso que puede ser llenado y vaciado por diferentes hilos.
 * También lleva un registro del número de veces que ha sido llenado.
 *
 * La clase incluye métodos para consultar y modificar el estado del vaso,
 * así como un método para introducir un retardo en la ejecución.
 *
 * @author Chema y Rodrigo
 * @date 11 febrero, 2025
 */
public class Vaso {

    private boolean lleno; // false
    private int veces; // 0
    private final long retardo = 3000; // en milisegundos

    public Vaso() {
        veces = 1;
    }

    // Métodos de consulta y asignación como los getters y setters:

    // ¿el vaso está lleno? ... devolver true equivale a sí.
    public boolean estaLLeno() {
        return lleno;
    }

    // llenar el vaso ... asignar el valor true al atributo lleno.
    public void llenarVaso() {
        lleno = true;
    }

    // vaciar el vaso ... asignar el valor false al atributo lleno.
    public void vaciarVaso() {
        lleno = false;
    }

    // incrementar el total de veces que se ha realizado el proceso.
    // se hará por un total de 3 veces.
    public void incrementarVeces() {
        veces++;
    }

    // consulta el número de veces que se le ha llenado el vaso al cliente.
    // el atributo es private, luego utilizamos un método puente.
    public int consultarVeces() {
        return veces;
    }

    // retardo de 3 segundos para ver "despacio" cómo se ejecuta el programa.
    public void retardar() {
        try {
            Thread.sleep(retardo); // retardo de X segundos.
        } catch(InterruptedException ie) {
            System.out.println(ie);
        }
    }

}
