package solucionesfede.ej4;

public class Cliente {
    private int numCli;
    private String empresa;
    private int numEmp;
    private double limiteCredito;


    public Cliente(int numCli, String empresa, int numEmp, double limiteCredito) {
        this.numCli = numCli;
        this.empresa = empresa;
        this.numEmp = numEmp;
        this.limiteCredito = limiteCredito;
    }


    public int getNumCli() {
        return numCli;
    }

    public void setNumCli(int numCli) {
        this.numCli = numCli;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getNumEmp() {
        return numEmp;
    }

    public void setNumEmp(int numEmp) {
        this.numEmp = numEmp;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "numCli=" + numCli +
                ", empresa='" + empresa + '\'' +
                ", numEmp=" + numEmp +
                ", limiteCredito=" + limiteCredito +
                '}';
    }
}

