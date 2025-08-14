package gficheros.gb7agenda;


import java.io.Serializable;

/**
 * @author Rodrigo
 * @date 15 febrero, 2024
 */
public class Persona implements Serializable {
    private String nombre;
    private String tlf;
    private int diacum;
    private int mescum;
    private boolean personal;

    public Persona() {
    }

    public Persona(boolean personal, String nombre, String tlf, int diacum, int mescum) {
        this.nombre = nombre;
        this.tlf = tlf;
        this.diacum = diacum;
        this.mescum = mescum;
        this.personal = personal;
    }

    @Override
    public String toString() {
        return "exprlambda.lambdapersonaprof.Persona{" +
                "nombre='" + nombre + '\'' +
                ", tlf='" + tlf + '\'' +
                ", diacum=" + diacum +
                ", mescum=" + mescum +
                ", personal=" + personal +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public int getDiacum() {
        return diacum;
    }

    public void setDiacum(int diacum) {
        this.diacum = diacum;
    }

    public int getMescum() {
        return mescum;
    }

    public void setMescum(int mescum) {
        this.mescum = mescum;
    }

    public boolean isPersonal() {
        return personal;
    }

    public void setPersonal(boolean personal) {
        this.personal = personal;
    }
}
