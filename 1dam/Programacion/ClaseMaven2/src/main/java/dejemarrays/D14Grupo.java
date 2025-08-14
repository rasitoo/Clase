package dejemarrays;

import dejemarrays.d14GrupoNo.Alumno;

/**
 * Created by Rodrigo on 03 diciembre, 2023
 */
public class D14Grupo {
    final static int MAXALUMNO = 30;
    final static int ASIGNATURAS = 10;
    Alumno[] alumnos = new Alumno[MAXALUMNO];
    int[][] m = new int[MAXALUMNO][ASIGNATURAS];

    D14Grupo() {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = -1;
            }
        }
    }

    void anadirNota(int numal, int numasig, int nota) {
        m[numal][numasig] = nota;
    }

    void mostrar() {
        for (int i = 0; i < m.length; i++) {
            System.out.print("Alumno nº" + (i + 1) + ". Notas: ");
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + ", ");
            }
            System.out.println();
        }
    }

    double mediaAl(int numal) {
        double suma = -1;
        for (int i = 0; i < m[numal - 1].length; i++) {
            if (m[numal - 1][i] != -1)
                suma += m[numal - 1][i];
        }
        return suma / ASIGNATURAS;
    }

    double mediaAsig(int numasig) {
        double suma = 0;
        for (int i = 0; i < m.length; i++) {
            if (m[i][numasig] != -1)
                suma += m[i][numasig];
        }
        return suma / MAXALUMNO;
    }

    int mejorAl() {
        int mejor = 1;
        double mejormedia = mediaAl(mejor);
        for (int i = 1; i <= m.length; i++) {
            if (this.mediaAl(i) > mejormedia) {
                mejor = i;
            }
        }
        return mejor;
    }

    int masSuspensos() {
        int suma = 0;
        int mas = 1;
        int suspensos = 0;
        for (int i = 0; i < ASIGNATURAS; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[j][i] != -1 && m[j][i] < 5)
                    suma++;
            }
            if (suma > suspensos) {
                suspensos = suma;
                mas = i;
            }
            suma = 0;
        }
        return mas;
    }

    double mediaClase() {
        int alumnos = 0;
        double suma = 0;
        for (int i = 0; i < m.length; i++) {
            if (this.mediaAl(i + 1) > 0) {
                suma += this.mediaAl(i + 1);
                alumnos++;
            }
        }
        return suma / alumnos;
    }

    void mostrarMedia() {
        for (int i = 0; i < m.length; i++) {
            System.out.print("Alumno nº" + (i + 1) + ". Notas: ");
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + ", ");
            }
            if (this.mediaAl(i + 1) < 5 && this.mediaAl(i + 1) > 0)
                System.out.print("SUSPENSO");
            else if (this.mediaAl(i + 1) >= 5) {
                System.out.print("APROBADO");
            } else System.out.print("NO MATRICULADO");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        D14Grupo ej = new D14Grupo();

        for (int i = 0; i < ej.m.length - 1; i++) {
            for (int j = 0; j < ej.m[i].length; j++) {
                ej.anadirNota(i, j, (int) (Math.random() * 11));
            }
        }
        ej.mostrarMedia();

        System.out.println("La media es: " + ej.mediaAl(30));
        System.out.println("La media de la asignatura es: " + ej.mediaAsig(3));
        System.out.println(ej.mejorAl() + " tiene la mejor media con: " + ej.mediaAl(ej.mejorAl()));
        System.out.println(ej.masSuspensos() + " tiene mas suspensos");
        System.out.println("La nota media de la clase es:  " + ej.mediaClase());
        ej.mostrarMedia();
    }
}
