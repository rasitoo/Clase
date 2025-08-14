package solucionesfede.ej5;

public class Oficina {
    private int numOfi;
    private String ciudad;
    private String region;
    private int numDir;
    private double objetivo;
    private double ventas;

    public Oficina(int numOfi, String ciudad, String region, int numDir, double objetivo, double ventas) {
        this.numOfi = numOfi;
        this.ciudad = ciudad;
        this.region = region;
        this.numDir = numDir;
        this.objetivo = objetivo;
        this.ventas = ventas;
    }

    public int getNumOfi() { return numOfi; }
    public void setNumOfi(int numOfi) { this.numOfi = numOfi; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public int getNumDir() { return numDir; }
    public void setNumDir(int numDir) { this.numDir = numDir; }

    public double getObjetivo() { return objetivo; }
    public void setObjetivo(double objetivo) { this.objetivo = objetivo; }

    public double getVentas() { return ventas; }
    public void setVentas(double ventas) { this.ventas = ventas; }
}
