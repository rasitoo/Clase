package aejemif.ejer7juego;

public class arma {
    String nombre;
    double porcentaje;

    arma(String nombre, double porcentaje) {
        this.porcentaje = porcentaje;
        this.nombre = nombre;
    }

    void mostrar() {
        System.out.println("El arma es: " + this.nombre + " y tiene un aumento de fuerza del " + this.porcentaje * 100);
    }
}
