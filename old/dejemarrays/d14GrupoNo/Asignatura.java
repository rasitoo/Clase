package dejemarrays.d14GrupoNo;

/**
 * Created by Rodrigo on 03 diciembre, 2023
 */
public class Asignatura {
    private int numero;
    private int nota;

    Asignatura(int numero){
        this.numero = numero;
        nota = -1;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
