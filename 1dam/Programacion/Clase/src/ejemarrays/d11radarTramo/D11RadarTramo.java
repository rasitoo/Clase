package ejemarrays.d11radarTramo;

/**
 * @author Rodrigo
 */
public class D11RadarTramo {
    long tiempoInicial = System.currentTimeMillis();
    long tiempoActual;
    private double limite;
    private int distancia;
    Multa multa;
    double tiempoDeberiaTardar; //Tiempo que deberia tardar en recorrer el tramo, si tarda menos se multa
    Vehiculo[] ventrada = {new Vehiculo("9743MPF"),new Vehiculo("2794WLV"),new Vehiculo("4898JBY"),new Vehiculo("6179XYX"),new Vehiculo("6419PCP"),new Vehiculo("0796WDJ"),new Vehiculo("8701HTB"),new Vehiculo("0171CFW"),new Vehiculo("7648CHP"),new Vehiculo("0852KBX") };
    Vehiculo[] vmultado = new Vehiculo[10];

    /**
     * @param distancia
     * @param limite
     */
    D11RadarTramo(int distancia, double limite){
        this.limite = limite;
        this.distancia = distancia;
        tiempoDeberiaTardar = (distancia/(limite)) * 3600;
    }

    /**
     * @throws InterruptedException
     */
    void iniciar() throws InterruptedException {
        int cont = 0;
        while (tiempoActual< tiempoDeberiaTardar){
            tiempoActual = (System.currentTimeMillis() - tiempoInicial) / 1000;
            Thread.sleep(1000);
            for (int i = 0; i<ventrada.length; i++){
                if (!ventrada[i].multado && tiempoquetarda(ventrada[i]) < tiempoActual){
                    ventrada[i].multado = true;
                    System.out.println(ventrada[i].matricula + " ha sido multado por ir a "+ ventrada[i].velocidad + " Km/h");
                    vmultado[cont] = ventrada[i];
                    vmultado[cont].tiempo = tiempoActual;
                    vmultado[cont].multa = new Multa((int) (vmultado[cont].velocidad - limite));
                    cont++;
                }else if (!ventrada[i].multado && tiempoquetarda(ventrada[i]) >= tiempoActual){
                    ventrada[i].tiempo = tiempoActual;
                }
            }
        }
    }

    /**
     * @param v
     * @return
     */
    double tiempoquetarda(Vehiculo v){
        return ((double) this.distancia /v.velocidad * 3600);
    }

    /**
     * @param v
     */
    void mostrar(Vehiculo[] v){
        for (int i = 0; i<v.length; i++)
            v[i].mostrar();
    }

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        D11RadarTramo e = new D11RadarTramo(1,100);

        e.iniciar();
        e.mostrar(e.ventrada);
    }
}
