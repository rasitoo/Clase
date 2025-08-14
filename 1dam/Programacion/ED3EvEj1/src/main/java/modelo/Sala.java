package modelo;

public class Sala {
    private int id;
    private int aforo;
    private int socios;
    private double coste;
    public Sala() {
    }
    public Sala(int id, int aforo, int socios, double coste) {
        this.id = id;
        this.aforo = aforo;
        this.socios = socios;
        this.coste = coste;
    }

    @Override
    public String toString() {
        return "Sala [id=" + id + ", aforo=" + aforo + ", socios=" + socios + "]";
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the aforo
     */
    public int getAforo() {
        return aforo;
    }
    /**
     * @param aforo the aforo to set
     */
    public void setAforo(int aforo) {
        this.aforo = aforo;
    }
    /**
     * @return the coste
     */
    public double getCoste() {
        return coste;
    }
    /**
     * @param coste the coste to set
     */
    public void setCoste(double coste) {
        this.coste = coste;
    }
    /**
     * @return the socios
     */
    public int getSocios() {
        return socios;
    }
    /**
     * @param socios the socios to set
     */
    public void setSocios(int socios) {
        this.socios = socios;
    }
}
