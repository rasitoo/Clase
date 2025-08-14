package ejercicios.abinarios.binarios5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author Rodrigo
 * @date 15 octubre, 2024
 */
public class Libro {

    @Override
    public String toString() {
        return "Libro{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", precio=" + precio +
                '}';
    }

    private String codigo;
    private String titulo;
    private String autor;
    private String editorial;
    private double precio;

    public Libro() {
        this.precio = 0;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Libro(String codigo, String titulo, String autor, String editorial, double precio) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.precio = precio;
    }

    public void grabarLibro(DataOutputStream f) throws IOException {
        f.writeUTF(this.getCodigo());
        f.writeUTF(this.getTitulo());
        f.writeUTF(this.getAutor());
        f.writeUTF(this.getEditorial());
        f.writeDouble(this.getPrecio());



    }

    public Libro leer(DataInputStream f) throws IOException {
        codigo = f.readUTF();
        titulo = f.readUTF();

        return this;
    }
}
