package ejercicios.ehibernate.apartadoa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "asignaturas")
public class Asignatura {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "numero_alumnos")
    int numero_alumnos;

    @ManyToMany(mappedBy = "asignaturas")
    List<Profesor> profesores= new ArrayList<>();

    public Asignatura(int id, String nombre, int numero_alumnos) {
        this.id = id;
        this.nombre = nombre;
        this.numero_alumnos = numero_alumnos;
    }

    public Asignatura() {}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Asignatura:" + nombre + ", Número de alumnos: " + numero_alumnos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero_alumnos() {
        return numero_alumnos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero_alumnos(int numero_alumnos) {
        this.numero_alumnos = numero_alumnos;
    }
}
