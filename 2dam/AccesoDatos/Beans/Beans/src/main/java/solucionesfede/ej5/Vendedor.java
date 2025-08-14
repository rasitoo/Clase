package solucionesfede.ej5;

import java.util.Date;

public class Vendedor {
    private int numEmp;
    private String nombre;
    private int edad;
    private int numOfi;
    private String oficio;
    private Date fechaCont;
    private int numDir;
    private double cuota;
    private double ventas;


    public Vendedor(int numEmp, String nombre, int edad, int numOfi, String oficio, Date fechaCont, int numDir, double cuota, double ventas) {
        this.numEmp = numEmp;
        this.nombre = nombre;
        this.edad = edad;
        this.numOfi = numOfi;
        this.oficio = oficio;
        this.fechaCont = fechaCont;
        this.numDir = numDir;
        this.cuota = cuota;
        this.ventas = ventas;
    }


    public int getNumEmp() { return numEmp; }
    public void setNumEmp(int numEmp) { this.numEmp = numEmp; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public int getNumOfi() { return numOfi; }
    public void setNumOfi(int numOfi) { this.numOfi = numOfi; }

    public String getOficio() { return oficio; }
    public void setOficio(String oficio) { this.oficio = oficio; }

    public Date getFechaCont() { return fechaCont; }
    public void setFechaCont(Date fechaCont) { this.fechaCont = fechaCont; }

    public int getNumDir() { return numDir; }
    public void setNumDir(int numDir) { this.numDir = numDir; }

    public double getCuota() { return cuota; }
    public void setCuota(double cuota) { this.cuota = cuota; }

    public double getVentas() { return ventas; }
    public void setVentas(double ventas) { this.ventas = ventas; }
}
