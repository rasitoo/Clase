package ejemarrays.d11radarTramo;

public class Vehiculo {
    Multa multa;
    String matricula;
    long tiempo;
    int velocidad;
    boolean multado;

    /**
     *
     * @param matricula
     */
    Vehiculo(String matricula){
        this.matricula = matricula;
        tiempo = System.currentTimeMillis();
        velocidad = (int) (Math.random() * 100) + 80; //Velocidad aleatoria entre 80 y 180
        multado = false;
    }

    /**
     *
     */
    void mostrar(){
        System.out.println("Vehículo " + matricula);
        System.out.println("\tHa tardado " + tiempo + " segundos");
        System.out.println("\tIba a una velocidad de " + velocidad + " Km/h");
        if (multado){
            System.out.println("\tHa sido multado, esta es la multa:");
            multa.mostrar();
        }
        else System.out.println("\tNo ha sido multado");
    }
}
