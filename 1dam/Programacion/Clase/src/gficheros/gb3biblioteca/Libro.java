package gficheros.gb3biblioteca;

public class Libro {
    private int codigoLibro;
    private String titulo;
    private boolean disponible; // no prestado

    void mostrar() {
        System.out.println("Codigo--> " + codigoLibro);
        System.out.println("Título--> " + titulo);
        System.out.println("Disponible--> " + disponible);
        System.out.println();
    }

    Libro(String titulo, int contLibros) {
        this.titulo = titulo;
        this.codigoLibro = contLibros;
        this.disponible = true;
    }

    public int getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(int codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
