package ejercicios.ehibernate.apartadoa;

/**
 * @author Rodrigo
 * @date 20 noviembre, 2024
 */

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @Column(name = "Id")
    private int id;
    @Column(name = "nombre", nullable = false) // para aceptar valores nulos
    private String nombre;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "permiso")
    private String permiso;

    // Constructores
    public Usuarios() {
    }

    public Usuarios(int id, String nombre, String categoria, String permiso) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.permiso = permiso;
    }


    // Getters y setters
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }
}