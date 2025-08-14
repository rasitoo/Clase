package solucionesfede.ej4;

public class Producto {
    private String idFab;
    private String idProd;
    private String descripcion;
    private double precio;
    private int existencias;


    public Producto(String idFab, String idProd, String descripcion, double precio, int existencias) {
        this.idFab = idFab;
        this.idProd = idProd;
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencias = existencias;
    }


    public String getIdFab() {
        return idFab;
    }

    public void setIdFab(String idFab) {
        this.idFab = idFab;
    }

    public String getIdProd() {
        return idProd;
    }

    public void setIdProd(String idProd) {
        this.idProd = idProd;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idFab='" + idFab + '\'' +
                ", idProd='" + idProd + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", existencias=" + existencias +
                '}';
    }
}

