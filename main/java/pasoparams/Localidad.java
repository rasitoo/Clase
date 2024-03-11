package pasoparams;

public class Localidad {
    private int temperaturaayer = -275;
    private int temperaturahoy;
    private double altitud;
    Localidad(int temperaturahoy, double altitud){
        this.temperaturahoy = temperaturahoy;
        this.altitud = altitud;
    }
    void anadirTemperatura(int temperatura) {
        this.temperaturaayer = this.temperaturahoy;
        this.temperaturahoy = temperatura;
    }
    int diferenciaTemperatura() {
        if (temperaturaayer == -275)
            return -999;
        return this.temperaturahoy - this.temperaturaayer;
    }
    void mostrar(String txt) {
        System.out.println("La altitud de la "+ txt +" es: " + this.altitud);
        System.out.println("La temperatura ayer era de: " + this.temperaturaayer + " grados");
        System.out.println("La temperatura hoy es de: " + this.temperaturahoy + " grados");
    }


    public static void main(String[] args) {
        Localidad mostoles = new Localidad(26, 500.4);
        Localidad rivas = new Localidad(39, 100.1);
        Localidad madrid = new Localidad(38, 300.98);

        rivas.anadirTemperatura(41);
        madrid.anadirTemperatura(36);

        mostoles.mostrar("Mostoles");
        rivas.mostrar("Rivas");
        madrid.mostrar("Madrid");

        int difmos = mostoles.diferenciaTemperatura();
        int difmad = madrid.diferenciaTemperatura();
        int difriv = rivas.diferenciaTemperatura();

        System.out.println("La diferencia de temperatura en Mostoles es de " + difmos + " grados");
        System.out.println("La diferencia de temperatura en Rivas es de " + difriv + " grados");
        System.out.println("La diferencia de temperatura en Madrid es de " + difmad + " grados");



    }

}