package dejemarrays.d12biblioteca;

import java.io.IOException;

public class D12Biblioteca {
    final static int MAXLIBROS = 2000;
    final static int MAXUSUARIOS = 100;
    Libro[] catalogo = new Libro[MAXLIBROS];
    Usuario[] usuarios = new Usuario[MAXUSUARIOS];
    int contUser = 0;
    int contLibro = 0;
    void menu(){
        System.out.println("1. ALta de libros");
        System.out.println("2. Alta de usuarios");
        System.out.println("3. Baja de usuarios");
        System.out.println("4. Préstamo de libros");
        System.out.println("5. Devolución del libro");
        System.out.println("6. Consulta del libro");
        System.out.println("7. Listado de usuarios");
        System.out.println("8. Listado de libros no prestados");
        System.out.println("0. Fin de la aplicación");
    }
    int pedirOpc(Teclado t) throws IOException {
        System.out.print("Elige una opción: ");
        return t.leerInt();
    }
    void ejecutarOpc(int n, Teclado t) throws IOException {
        switch (n){
            case 0:
                System.out.println("FIN");
                break;
            case 1:
                if (!anadirLibro(t))
                    System.out.println("Error");
                break;
            case 2:
                if (!anadirUsuario(t))
                    System.out.println("Error");
                break;
            case 3:
                if (!bajaUsuario(t))
                    System.out.println("Error");
                break;
            case 4:
                if (!prestamo(t))
                    System.out.println("Error");
                break;
            case 5:
                if (!devolverLibro(t))
                    System.out.println("Error");
                break;
            case 6:
                System.out.println("Indica el código del libro que buscas: ");
                int x = t.leerInt();
                if (!consultaLibro(x)){
                    buscarID(x).mostrar();
                }
                break;
            case 7:
                listarUsuarios();
                break;
            case 8:
                listarLibros();
                break;
        }
    }
    boolean anadirLibro(Teclado t) throws IOException {
        boolean anadido = false;

        System.out.println("Indica el nombre del libro");
        String titulo = t.leerString();
        if (contLibro < MAXLIBROS) {
            for (int i = 0; !anadido && i <= contLibro; i++) {
                if (catalogo[i] == null) {
                    catalogo[i] = new Libro(i, titulo);
                    contLibro++;
                    anadido = true;
                }
            }
        }else System.out.println("MAXLIBROS");
        return anadido;
    }
    boolean anadirUsuario(Teclado t) throws IOException {
        boolean anadido = false;
        System.out.println("Indica el nombre del usuario");
        String username = t.leerString();
        if (contUser < MAXUSUARIOS) {
            for (int i = 0; !anadido && i <= contUser; i++) {
                if (usuarios[i] == null) {
                    usuarios[i] = new Usuario(i, username);
                    contUser++;
                    anadido = true;
                }
            }
        }else System.out.println("MAXALUMNOS");
        return anadido;
    }
    boolean bajaUsuario(Teclado t) throws IOException {
        boolean baja = true;
        System.out.println("Indica el ID del usuario al que dar de baja: ");
        int ID = t.leerInt();
        Usuario u = buscarID(ID);
        if (u != null){
            for (int i = 0; i<u.libros.length; i++){
                if (u.libros[i] != null){
                    baja = false;
                    System.out.println("Tiene libros en préstamo");
                    break;
                }
            }
            if (baja){
                usuarios[ID] = null;
                contUser--;
            }
        }else{
            System.out.println("Ese usuario no existe");
            baja=false;
        }
        return baja;
    }
    boolean consultaLibro(int n){
        boolean disponible = false;
        if (catalogo[n].prestado == -1){
            catalogo[n].mostrar();
            disponible = true;
        }
        return disponible;
    }
    void listarUsuarios(){
        for (int i = 0;i<MAXUSUARIOS && i<=contUser; i++){
            if (usuarios[i] != null)
               usuarios[i].mostrar();
        }
    }
    void listarLibros(){
        for (int i = 0; i<MAXLIBROS && i<contLibro; i++){
            if (catalogo[i].prestado == -1)
                catalogo[i].mostrar();
        }
    }
    boolean prestamo(Teclado t) throws IOException {
        boolean ok = false;
        System.out.println("Indica el ID del usuario: ");
        int user = t.leerInt();
        if (usuarios[user] != null){
            System.out.println("Indica el ID del libro: ");
            int ID = t.leerInt();
            if (catalogo[ID] != null) {
                if (usuarios[user].prestamo(buscarCodigo(ID))){
                    catalogo[ID].prestado = user;
                    ok = true;
                }else System.out.println("No puede tomar prestado mas libros");
            } else System.out.println("Ese libro no existe");
        }else System.out.println("Ese usuario no existe");
        return ok;
    }
    boolean devolverLibro(Teclado t) throws IOException {
        boolean devuelto = false;

        System.out.println("Indica la ID del usuario");
        Usuario u = buscarID(t.leerInt());
        if (u != null) {
            System.out.println("Indica la ID del libro");
            int ID = t.leerInt();
            if (!u.devolucion(ID))
                System.out.println("Ese usuario no tiene ese libro");
            else {
                devuelto = true;
                catalogo[ID].prestado = -1;
            }
        }else System.out.println("Ese usuario no existe");
        return devuelto;
    }
    Usuario buscarID(int ID){
        return usuarios[ID];
    }
    Libro buscarCodigo(int codigo){
        return catalogo[codigo];
    }

    public static void main(String[] args) throws IOException {
        D12Biblioteca e = new D12Biblioteca();
        Teclado t = new Teclado();
        int n;
        do {
            e.menu();
            n = e.pedirOpc(t);
            e.ejecutarOpc(n,t);
        }while (n !=0);
    }
}
