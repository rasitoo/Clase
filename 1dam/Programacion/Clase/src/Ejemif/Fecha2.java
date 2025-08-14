package Ejemif;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha2 {
    int dia;
    int mes;
    int year;

    public Fecha2(int dia, int mes, int year) {
        this.dia = dia;
        this.mes = mes;
        this.year = year;
    }

    public Fecha2() {
        Calendar c = GregorianCalendar.getInstance();
        dia = c.get(GregorianCalendar.DAY_OF_MONTH);
        mes = c.get(GregorianCalendar.MONTH) + 1;
        year = c.get(GregorianCalendar.YEAR);
    }

    Boolean esbisiesto() {
        return (this.year % 4 == 0 && this.year % 100 != 0) || year % 400 == 0;   //o son bisiestos por ser multiplo de 4 y no de 100 o lo son porque solo son de 400, si no, false.
    }

    public int cuantosdias() {
        switch (this.mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (esbisiesto())
                    return 29;
                else return 28;
            default:
                return -999;
        }
    }

    boolean fechacorrecta() {
        return this.dia >= 1 && this.dia <= this.cuantosdias() && this.mes <= 12 && this.mes >= 1 && this.year > 1;
    }

    int difereciadias(Fecha2 fechamasantigua) {
        int diferenciayear = this.year - fechamasantigua.year;
        int diferenciames = this.mes - fechamasantigua.mes;
        int diferenciadia = this.dia - fechamasantigua.dia;
        return diferenciayear * 365 + (diferenciames * 30) + diferenciadia;
    }

    void diasiguiente() {
        if (this.dia < this.cuantosdias()) {
            this.dia += 1;
        } else if (this.dia == this.cuantosdias() && this.mes < 12) {
            this.dia = 1;
            this.mes += 1;
        } else {
            this.dia = 1;
            this.mes = 1;
            this.year++;
        }
    }

    void mostrar() {
        System.out.println(this.dia + "/" + this.mes + "/" + this.year);
    }

    public static void main(String[] args) {
        Fecha2 fecha1 = new Fecha2(3, 1, 1999);
        Fecha2 fecha2 = new Fecha2(29, 2, 2024);
        Fecha2 fecha3 = new Fecha2(31, 12, 2000);

        System.out.println(fecha1.fechacorrecta());
        System.out.println(fecha2.fechacorrecta());
        System.out.println(fecha3.fechacorrecta());

        fecha1.diasiguiente();
        fecha2.diasiguiente();
        fecha3.diasiguiente();
        fecha1.mostrar();
        fecha2.mostrar();
        fecha3.mostrar();

        System.out.println(fecha3.difereciadias(fecha1));
        System.out.println(fecha2.cuantosdias());
    }
}
