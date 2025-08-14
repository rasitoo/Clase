package ejemarrays.d14GrupoNo;

/**
 * Created by Rodrigo on 03 diciembre, 2023
 */
public class Alumno {
    private int numero;
    final static int ASIGNATURAS = 10;
    private Asignatura[] asignaturas = new Asignatura[ASIGNATURAS];

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Asignatura[] getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Asignatura[] asignaturas) {
        this.asignaturas = asignaturas;
    }

    Alumno(int numero){
        this.numero=numero;
        for (int i = 0; i<asignaturas.length; i++){
            asignaturas[i] = new Asignatura(i + 1);
        }
    }
}
