package gficheros.gb3biblioteca;

public class Usuario {
    final static int MAXIMOPRESTADOS = 5;
    private int codigoUser;
    private String nombre;
    private Libro[] librosPrestados;
    int contPrestados;

    Usuario(String nombre, int contUsers) {
        librosPrestados = new Libro[MAXIMOPRESTADOS];
        this.nombre = nombre;
        this.codigoUser = contUsers;
    }

    void mostrar() {
        System.out.println("Código--> " + codigoUser);
        System.out.println("Nombre--> " + nombre);

        if (contPrestados > 0) {
            for (int i = 0; i < contPrestados; i++) {
                System.out.print("Libro prestado " + (i + 1) + "--> ");
                librosPrestados[i].mostrar();
            }
        }
        System.out.println();
    }

    public int getCodigoUser() {
        return codigoUser;
    }

    public void setCodigoUser(int codigoUser) {
        this.codigoUser = codigoUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getContPrestados() {
        return contPrestados;
    }

    public void setContPrestados(int contPrestados) {
        this.contPrestados = contPrestados;
    }

    public Libro[] getLibrosPrestados() {
        return librosPrestados;
    }

    public void setLibrosPrestados(Libro librosPrestados) {
        this.librosPrestados[contPrestados] = librosPrestados;
        contPrestados++;
    }

}
