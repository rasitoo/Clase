package aejemif;

public class tarifaagua {
    int consumobimestral;
    Boolean domestico = false;
    double cuota;
    double diametrocontador;
    boolean plurivivienda;
    int usos;
    Fecha2 fechafactura;
    boolean autoabastecimiento;
    boolean asimiladodomestico;
    int consumobloque3;
    int consumobloque2;
    int consumobloque1;

    tarifaagua(int consumobimestral, double diametrocontador, int usos, Fecha2 fechafactura) { //caso de que no sea domestico, varibale plurivivienda y asimilado no tienen sentido
        this.consumobimestral = consumobimestral;
        this.diametrocontador = diametrocontador;
        this.usos = usos;
        this.fechafactura = fechafactura;
    }

    tarifaagua(Boolean domestico, int consumobimestral, double diametrocontador, int usos, Boolean asimiladodomestico, boolean plurivivienda, Fecha2 Fecha) { //domesticos, neecesitaos saber si es plurivivienda, es suministro asimilado al domestico y diametro
        this.domestico = domestico;
        this.consumobimestral = consumobimestral;
        this.plurivivienda = plurivivienda;
        this.diametrocontador = diametrocontador;
        this.usos = usos;
        this.asimiladodomestico = asimiladodomestico;
        this.fechafactura = Fecha;
    }

    tarifaagua(Boolean autoabastecimiento, int usos) { // suministro procedente de autoabastecimiento, solo utiliza depuración.
        this.autoabastecimiento = autoabastecimiento;
        this.usos = usos;
    }

    Boolean verano() {
        return fechafactura.mes >= 8 && fechafactura.mes <= 10;
    }

    int calculobloque() {
        if (consumobimestral > 50) {
            consumobloque3 = consumobimestral - 50;
            consumobloque2 = 50 - 25;
            consumobloque1 = 25;
            return 3;
        } else if (consumobimestral > 25) {
            consumobloque2 = consumobimestral - 25;
            consumobloque1 = 25;
            return 2;
        } else {
            consumobloque1 = consumobimestral;
            return 1;
        }
    }

    int calculobloquecomercial() {
        int bloque1;
        int bloque2;
        int bloque3;
        if (diametrocontador <= 15) {
            bloque1 = 90;
            bloque2 = 180;
            bloque3 = 180;
        } else if (diametrocontador == 20) {
            bloque1 = 150;
            bloque2 = 300;
            bloque3 = 300;
        } else if (diametrocontador == 25) {
            bloque1 = 200;
            bloque2 = 400;
            bloque3 = 400;
        } else if (diametrocontador == 30) {
            bloque1 = 350;
            bloque2 = 700;
            bloque3 = 700;
        } else if (diametrocontador == 40) {
            bloque1 = 450;
            bloque2 = 900;
            bloque3 = 900;
        } else if (diametrocontador == 50) {
            bloque1 = 600;
            bloque2 = 1200;
            bloque3 = 1200;
        } else if (diametrocontador == 65) {
            bloque1 = 800;
            bloque2 = 1600;
            bloque3 = 1600;
        } else if (diametrocontador >= 80) {
            bloque1 = 900;
            bloque2 = 1800;
            bloque3 = 1800;
        } else return -999;
        if (consumobimestral > bloque3) {
            consumobloque3 = consumobimestral - bloque2;
            consumobloque2 = bloque2 - bloque1;
            consumobloque1 = bloque1;
            return 3;
        } else if (consumobimestral > bloque1) {
            consumobloque2 = consumobimestral - bloque1;
            consumobloque1 = bloque1;
            return 2;
        } else {
            consumobloque1 = consumobimestral;
            return 1;
        }
    }

    double calculoCuota() {
        double aduccion = 0;
        double distribucion = 0;
        double alcantarillado = 0;
        double depuracion = 0;

        if (domestico) {
            if (plurivivienda) {
                aduccion += usos * 0.0178 * (15 * 15 + 225); // inicio cuotas fijas
                distribucion += usos * 0.0081 * (15 * 15 + 225);
            } else {
                aduccion += 0.0178 * (diametrocontador * diametrocontador + 225 * usos);
                distribucion += 0.0081 * (diametrocontador * diametrocontador + 225 * usos);
            }
            if (asimiladodomestico)
                alcantarillado += 1.0701 * (diametrocontador * diametrocontador / 100);
            else alcantarillado += 1.0701 * usos;
            depuracion += 3.1371 * usos; // fin cuotas fijas
            switch (calculobloque()) { // inicio cuotas variables
                case 3:
                    distribucion += 0.5016 * consumobloque3;
                    alcantarillado += 0.1472 * consumobloque3;
                    depuracion += 0.5431 * consumobloque3;
                    if (verano()) {
                        aduccion += 1.9746 * consumobloque3;
                    } else {
                        aduccion += 1.3163 * consumobloque3;
                    } //no pongo break; ya que inicio en el caso de mas consumo (bloque3) hasta llegar a bloque2, calcular su tarifa y continuar con bloque 1, si el consumo es minimo inicia en bloque 1, fin del switch

                case 2:
                    distribucion += 0.2103 * consumobloque2;
                    alcantarillado += 0.1203 * consumobloque2;
                    depuracion += 0.3556 * consumobloque2;
                    if (verano()) {
                        aduccion += 0.6855 * consumobloque2;
                    } else {
                        aduccion += 0.5486 * consumobloque2;
                    }

                case 1:
                    distribucion += 0.1335 * consumobloque1;
                    alcantarillado += 0.1094 * consumobloque1;
                    depuracion += 0.3115 * consumobloque1;
                    aduccion += 0.2965 * consumobloque3;
            }
        } else if (autoabastecimiento) {
            depuracion += 22.51 * usos;
        } else { //comercios, ademas existe una tarifa para "otros" aunque en realidad ess la misma que para domesticos, no plurivivienda y asimilado al domestico.
            aduccion += 0.0178 * (diametrocontador * diametrocontador + 225 * usos);
            distribucion += 0.0081 * (diametrocontador * diametrocontador + 225 * usos);
            alcantarillado += 1.0701 * (diametrocontador * diametrocontador / 100);
            depuracion += 3.1371 * (diametrocontador * diametrocontador / 100);
            switch (calculobloquecomercial()) { // inicio cuotas variables
                case 3: // en caso de comercios los bloques solo se usan para aduccion y distribucion, depuracion y alcantarillado es como el domestico con otra tarifa
                    distribucion += 0.5016 * consumobloque3;
                    if (verano()) {
                        aduccion += 1.4565 * consumobloque3;
                    } else {
                        aduccion += 0.9709 * consumobloque3;
                    } //no pongo break; ya que inicio en el caso de mas consumo (bloque3) hasta llegar a bloque2, calcular su tarifa y continuar con bloque 1, si el consumo es minimo inicia en bloque 1, fin del switch

                case 2:
                    distribucion += 0.2103 * consumobloque2;
                    if (verano()) {
                        aduccion += 0.6855 * consumobloque2;
                    } else {
                        aduccion += 0.5486 * consumobloque2;
                    }

                case 1:
                    distribucion += 0.1335 * consumobloque1;
                    aduccion += 0.2965 * consumobloque3;
            }
            switch (calculobloque()) { //alcantarillado y depuracion es como el domestico
                case 3:
                    alcantarillado += 0.1472 * consumobloque3;
                    depuracion += 0.5431 * consumobloque3;
                case 2:
                    alcantarillado += 0.1203 * consumobloque2;
                    depuracion += 0.3556 * consumobloque2;
                case 1:
                    alcantarillado += 0.1094 * consumobloque1;
                    depuracion += 0.3115 * consumobloque1;
            }
        }
        cuota = aduccion + alcantarillado + depuracion + distribucion;
        return cuota;
    }

    public static void main(String[] args) {
        tarifaagua x1 = new tarifaagua(true, 1); //autoabastecimiento
        tarifaagua x2 = new tarifaagua(60, 20, 2, new Fecha2()); //comercial
        tarifaagua x3 = new tarifaagua(true, 20, 10, 1, false, false, new Fecha2(1, 2, 2003));
        tarifaagua x4 = new tarifaagua(true, 1, 1, 1, true, true, new Fecha2(1, 2, 2003));
        tarifaagua x5 = new tarifaagua(true, 20, 10, 1, false, true, new Fecha2(1, 2, 2003));


        System.out.println(x1.calculoCuota());
        System.out.println(x2.calculoCuota());
        System.out.println(x3.calculoCuota());
        System.out.println(x4.calculoCuota());
        System.out.println(x5.calculoCuota());
    }
}
