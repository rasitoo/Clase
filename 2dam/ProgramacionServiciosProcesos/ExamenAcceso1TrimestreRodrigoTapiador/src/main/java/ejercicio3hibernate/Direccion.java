package ejercicio3hibernate;

import jakarta.persistence.*;

/**
 * @author Rodrigo
 * @date 03 diciembre, 2024
 */
@Entity
@Table(name = "direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "calle")
    String calle;
    @Column(name = "numero")
    int numero;
    @Column(name = "poblacion")
    String poblacion;
    @Column(name = "provincia")
    String provincia;

    public Direccion() {
    }

    public Direccion(int id, String calle, int numero, String poblacion, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.poblacion = poblacion;
        this.provincia = provincia;
    }
    public Direccion( String calle, int numero, String poblacion, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.poblacion = poblacion;
        this.provincia = provincia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
