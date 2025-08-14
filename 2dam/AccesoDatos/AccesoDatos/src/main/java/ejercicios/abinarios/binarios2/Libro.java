package ejercicios.abinarios.binarios2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author Rodrigo
 * @date 09 octubre, 2024
 */
public class Libro {
    private long isbn;
    private String titulo;
    private String autor;

    public Libro(long isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn=" + isbn +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
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
    public long consultarISBN(){return isbn;}
    public String consultarTitulo(){return titulo;}
    public String consultarAutor(){return autor;}

    public Libro leer(DataInputStream lectura) throws IOException {
        isbn = lectura.readLong();
        titulo = lectura.readUTF();
        autor = lectura.readUTF();
        return new Libro(isbn, titulo, autor);
    }

    public void grabar(DataOutputStream f) throws IOException {
        f.writeLong(this.getIsbn());
        f.writeUTF(this.getTitulo());
        f.writeUTF(this.getAutor());
    }
}
