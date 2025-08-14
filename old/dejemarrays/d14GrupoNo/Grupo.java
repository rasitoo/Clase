package dejemarrays.d14GrupoNo;

import java.util.Scanner;

import static dejemarrays.d14GrupoNo.Alumno.ASIGNATURAS;

/**
 * Created by Rodrigo on 03 diciembre, 2023
 */
public class Grupo {
    final static int MAXALUMNO = 30;
    Alumno[] alumnos = new Alumno[MAXALUMNO];
    int[][] m = new int[MAXALUMNO][ASIGNATURAS];
    Grupo(){
        for (int i = 0; i< m.length; i++){
            for (int j = 0; j<m[i].length; j++){
                alumnos[i] = new Alumno(i+1);
                Asignatura[] asig = alumnos[i].getAsignaturas();
                m[i][j] = asig[j].getNota();
            }
        }
    }
    void anadirNota(int numal, int numasig, int nota){
        Alumno a = alumnos[numal-1];
        Asignatura[] asig = a.getAsignaturas();
        asig[numasig-1].setNota(nota);
        a.setAsignaturas(asig);

    }
    void mostrar(){
        for (int i = 0; i< m.length; i++){
            System.out.print("Alumno nº" + alumnos[i].getNumero() + ". Notas: ");
            for (int j = 0; j<m[i].length; j++){
                Asignatura[] asig = alumnos[i].getAsignaturas();
                System.out.print(asig[j].getNota() +", ");
            }
            System.out.println();
        }
    }

    double mediaAl(int numal){
        double suma = 0;
        Asignatura[] asig = alumnos[numal-1].getAsignaturas();
        for (int i = 0; i<asig.length; i++){
            suma += asig[i].getNota();
        }
        return suma/asig.length;
    }

    public static void main(String[] args) {
        Grupo ej = new Grupo();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i<ej.m.length; i++){
            for (int j = 0; j<ej.m[i].length; j++){
                ej.anadirNota(i+1,j+1,(int) (Math.random()*11));
            }
        }
        ej.mostrar();

        System.out.println("La media es: " +ej.mediaAl(30));

    }
}
