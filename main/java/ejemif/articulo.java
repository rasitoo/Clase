package ejemif;

import java.util.Scanner;

public class articulo {
    private int codigo = 0;
    public String nombre;
    private String color;
    private double precio;

    public articulo() {
        codigo = 0;
        nombre = "default";
        color = "white";
        precio = -999;
    }

    articulo(String nombre, String color, double precio) {
        this.precio = precio;
        this.color = color;
        this.nombre = nombre;
        this.codigo++;
    }

    articulo(String nombre, String color) {
        this.precio = -999;
        this.color = color;
        this.nombre = nombre;
        this.codigo++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    void incremetnarPrecio(double incremento) {
        precio += incremento;
    }

    void rebajarPrecio() {
        precio -= precio * 0.1;
    }

    void mostrar() {
        System.out.println("El articulo es: " + nombre);
        System.out.println("Su codigo es: " + codigo);
        System.out.println("Su color es: " + color);
        System.out.println("Su precio es: " + precio);
        System.out.println();
    }

    public static void main(String[] args) {
        articulo x1 = new articulo();
        articulo x2 = new articulo("patata", "marron", 1);
        articulo x3 = new articulo("cebolla", "morada", 2);

        x1.setCodigo(4);
        x1.setColor("verde");
        x1.setNombre("aaa");
        x1.setPrecio(7);

        x3.incremetnarPrecio(8);

        x2.setNombre("agua");
        x2.setColor("incolora");

        x1.mostrar();
        x2.mostrar();
        x3.mostrar();

        Scanner sc = new Scanner(System.in);
        System.out.println("incremento del articulo2: ");
        x2.incremetnarPrecio(sc.nextInt());

        x1.rebajarPrecio();

        x1.mostrar();
        x2.mostrar();
        x3.mostrar();
    }
}
