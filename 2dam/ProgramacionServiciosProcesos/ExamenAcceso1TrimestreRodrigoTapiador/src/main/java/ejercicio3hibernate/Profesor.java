package ejercicio3hibernate;

import jakarta.persistence.*;

/**
 * @author Rodrigo
 * @date 03 diciembre, 2024
 */
@Entity
@Table(name = "profesor")
public class Profesor {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        int id;
        @Column(name = "nombre")
        String nombre;
        @Column(name = "ape1")
        String ape1;
        @Column(name = "ape2")
        String ape2;

    public Profesor() {}

    public Profesor(int id, String nombre, String ape1, String ape2) {
        this.id = id;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
    }    public Profesor( String nombre, String ape1, String ape2) {
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }
}
