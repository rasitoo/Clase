package aejemif.ejer5EquiposFutbol;

public class Equipo {
    private int puntuacion;
    private int golesfavor;
    private int golescontra;

    private String nombre;

    Equipo(String nombre) {
        this.nombre = nombre;

    }

    public int getGolescontra() {
        return golescontra;
    }

    public void setGolescontra(int golescontra) {
        this.golescontra = golescontra;
    }

    public int getGolesfavor() {
        return golesfavor;
    }

    public void setGolesfavor(int golesfavor) {
        this.golesfavor = golesfavor;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    void mostrarpuntuacion() {
        System.out.println("La puntuación de " + this.nombre + " es: " + getPuntuacion());
    }

    void mostrarGolesFavor() {
        System.out.println("El número de goles a favor de " + this.nombre + " es: " + getGolesfavor());
    }

    void mostrarGolesContra() {
        System.out.println("El número de goles en contra de " + this.nombre + " es: " + getGolescontra());
    }

    public static void main(String[] args) {

    }
}
