package dejemarrays.d12biblioteca;

public class Usuario {
    int ID;
    Libro[] libros;
    String username;

    Usuario(int ID, String username){
        this.ID = ID;
        this.username = username;
        libros = new Libro[5];
    }
    boolean prestamo(Libro libro){
        boolean ok = false;
        for (int i = 0; !ok && i<libros.length; i++){
            if (libros[i] == null){
                libros[i] = libro;
                ok = true;
            }
        }
        return ok;
    }
    boolean  devolucion(int ID){
        boolean ok = false;
        for (int i = 0; i<libros.length; i++){
            if (libros[i].codigo == ID){
                libros[i] = null;
                ok = true;
                break;
            }
        }
        return ok;
    }
    void mostrar(){
        System.out.println("ID: " + ID + "\tNombre de usuario: " + username);
        for (int i = 0; i < libros.length;i++){
            if (libros[i] != null) {
                System.out.print("\tlibro " + i + ":\t");
                libros[i].mostrar();
            }
        }
    }
}
