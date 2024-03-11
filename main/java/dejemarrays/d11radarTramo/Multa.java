package dejemarrays.d11radarTramo;

/**
 *
 */
public class Multa {
    int puntos;
    int dinero;
    int exceso;

    /**
     *
     * @param exceso
     */
    Multa(int exceso){
        this.exceso = exceso;
        if (exceso<30){
            puntos = 0;
            dinero = 100;
        } else if (exceso<50) {
            puntos = 2;
            dinero = 300;
        } else if (exceso<60) {
            puntos = 4;
            dinero = 400;
        } else if (exceso<70) {
            puntos = 6;
            dinero = 500;
        }else {
            puntos = 6;
            dinero = 600;
        }
    }

    /**
     *
     */
    void mostrar(){
        System.out.println("\t\tTenía un exceso de velocidad de " + exceso + " Km/h");
        System.out.println("\t\tSe le retirarán " + puntos + " puntos del carnet");
        System.out.println("\t\tSe multará con " + dinero + " euros");
    }
}
