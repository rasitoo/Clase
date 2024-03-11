package expresionesbooleanas;

public class Fecha {
    int mes;
    int year;
    Fecha(int mes, int year){
        this.mes = mes;
        this.year = year;
    }
    int diferenciaFechas(Fecha fecha){
        int diferenciaAños = this.year - fecha.year;
        int diferenciaMes = this.mes - fecha.mes;
        return  diferenciaAños * 12 + diferenciaMes;
    }
    public static void main(String[] args){
        Fecha fecha1 = new Fecha(3, 1999);
        Fecha fecha2 = new Fecha(4, 2000);

        System.out.println(fecha2.diferenciaFechas(fecha1));
    }
}
