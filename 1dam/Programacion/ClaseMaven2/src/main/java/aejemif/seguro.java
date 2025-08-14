package aejemif;

public class seguro {
    boolean hombre;
    Fecha2 hoy = new Fecha2();
    Fecha2 ultimoParte;
    String coche;
    double tarifa;

    seguro(boolean hombre, Fecha2 ultimoParte, String coche) {
        this.hombre = hombre;
        this.ultimoParte = ultimoParte;
        this.coche = coche;
    }

    double calculoTarifa() {
        switch (coche) {
            case "p":
                tarifa = 25000;
                if (hoy.difereciadias(ultimoParte) >= (365 * 5)) {
                    tarifa -= tarifa * 0.15;
                } else tarifa -= tarifa * 0.1;
                break;
            case "m":
                tarifa = 35000;
                if (!this.hombre)
                    tarifa -= tarifa * 0.16;
                else if (hoy.difereciadias(ultimoParte) >= (365 * 3))
                    tarifa -= tarifa * 0.17;
                else tarifa -= tarifa * 0.1;
                break;
            case "g":
                tarifa = 50000;
                if (hoy.difereciadias(ultimoParte) >= (365 * 7))
                    tarifa -= tarifa * 0.2;
                else if (!this.hombre && hoy.difereciadias(ultimoParte) < (365 * 7))
                    tarifa -= tarifa * 0.1;
                else tarifa -= tarifa * 0.08;

                break;
        }
        return tarifa;
    }

    public static void main(String[] args) {
        seguro maria = new seguro(false, new Fecha2(17, 3, 1999), "g");
        seguro paco = new seguro(true, new Fecha2(17, 3, 2015), "p");
        seguro juan = new seguro(true, new Fecha2(17, 3, 2022), "m");
        seguro marcos = new seguro(true, new Fecha2(17, 3, 2005), "g");
        seguro sofia = new seguro(false, new Fecha2(17, 3, 2006), "m");
        seguro carla = new seguro(false, new Fecha2(17, 3, 2021), "p");

        System.out.println(maria.calculoTarifa());
        System.out.println(paco.calculoTarifa());
        System.out.println(juan.calculoTarifa());
        System.out.println(marcos.calculoTarifa());
        System.out.println(sofia.calculoTarifa());
        System.out.println(carla.calculoTarifa());
    }
}
