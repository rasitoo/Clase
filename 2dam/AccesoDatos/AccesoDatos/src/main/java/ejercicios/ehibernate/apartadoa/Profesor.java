package ejercicios.ehibernate.apartadoa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profesores")
public class Profesor {
    @Id
    @Column(name = "id")
    int id;

    @Column(name = "nombre")
    String nombre;
    @Column(name = "categoria")
    String categoria;
    @Column(name = "salario")
    double salario;

    @ManyToMany
    @JoinTable(
            name = "profesor_asignatura",
            joinColumns = @JoinColumn(name = "profesor_id"),
            inverseJoinColumns = @JoinColumn(name = "asignatura_id")
    )
    List<Asignatura> asignaturas= new ArrayList<>();

    public Profesor(int id, String nombre, String categoria, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.salario = salario;
    }

    public Profesor() {}

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Profesor: "+ nombre +", Categoría: "+categoria;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getSalario() {
        return salario;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }
}
