package aexpresionesbooleanas;

public class CuotaAgua {
    boolean aguaCaliente;
    double consumo;
    double cuota;
    Fecha fechaAlta;
    Fecha fechaHoy = new Fecha(10, 2023);

    CuotaAgua(boolean aguaCaliente, double consumo, double cuota, Fecha fechaAlta) {
        this.aguaCaliente = aguaCaliente;
        this.consumo = consumo;
        this.cuota = cuota;
        this.fechaAlta = fechaAlta;
    }

    boolean hayQueIncrementarCuota() {
        return aguaCaliente || consumo > 50 || fechaHoy.diferenciaFechas(fechaAlta) < 60;
    }

    void incrementarCuota() {
        if (hayQueIncrementarCuota())
            this.cuota += this.cuota * 0.1;
    }

    public static void main(String[] args) {
        CuotaAgua Paco = new CuotaAgua(false, 49.6, 300, new Fecha(12, 1999));
        CuotaAgua Pepe = new CuotaAgua(true, 53.6, 300, new Fecha(12, 2005));

        System.out.println(Paco.hayQueIncrementarCuota());
        System.out.println(Pepe.hayQueIncrementarCuota());

        Paco.incrementarCuota();
        Pepe.incrementarCuota();
        System.out.println(Paco.cuota);
        System.out.println(Pepe.cuota);
    }
}
