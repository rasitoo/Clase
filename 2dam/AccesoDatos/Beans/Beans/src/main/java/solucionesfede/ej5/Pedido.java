package solucionesfede.ej5;

import java.util.Date;

public class Pedido {
    private int numPed;
    private Date fechaPed;
    private int numCli;
    private int numEmp;
    private String idFab;
    private String idProd;
    private int cantidad;
    private double importe;


    public Pedido(int numPed, Date fechaPed, int numCli, int numEmp, String idFab, String idProd, int cantidad, double importe) {
        this.numPed = numPed;
        this.fechaPed = fechaPed;
        this.numCli = numCli;
        this.numEmp = numEmp;
        this.idFab = idFab;
        this.idProd = idProd;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public int getNumPed() { return numPed; }
    public void setNumPed(int numPed) { this.numPed = numPed; }

    public Date getFechaPed() { return fechaPed; }
    public void setFechaPed(Date fechaPed) { this.fechaPed = fechaPed; }

    public int getNumCli() { return numCli; }
    public void setNumCli(int numCli) { this.numCli = numCli; }

    public int getNumEmp() { return numEmp; }
    public void setNumEmp(int numEmp) { this.numEmp = numEmp; }

    public String getIdFab() { return idFab; }
    public void setIdFab(String idFab) { this.idFab = idFab; }

    public String getIdProd() { return idProd; }
    public void setIdProd(String idProd) { this.idProd = idProd; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getImporte() { return importe; }
    public void setImporte(double importe) { this.importe = importe; }
}

