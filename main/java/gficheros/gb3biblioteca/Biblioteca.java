package gficheros.gb3biblioteca;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Biblioteca {
    static Teclado t = new Teclado();
    final static int MAXIMOLIBROS = 2000;
    final static int MAXIMOUSERS = 100;
    final static String PATH = "C:\\Users\\Rodrigo\\OneDrive\\Documents\\AAClase\\Programacion\\Clase\\src\\gficheros\\gb3Biblioteca\\data";

    Libro[] libros;
    Usuario[] users;
    int contLibros;
    int contUsers;

    Biblioteca() {
        contLibros = 0;
        contUsers = 0;
        libros = new Libro[MAXIMOLIBROS];
        users = new Usuario[MAXIMOUSERS];
    }

    void mostrarMenu() {
        System.out.println("1.- Alta de libros.");
        System.out.println("2.- Alta de usuarios.");
        System.out.println("3.- Baja de usuarios.");
        System.out.println("4.- Préstamo de libros.");
        System.out.println("5.- Devolución de libro.");
        System.out.println("6.- Consulta de libro.");
        System.out.println("7.- Listado de usuarios.");
        System.out.println("8.- Listado de libros no prestados.");
        System.out.println("9.- Guardar datos.");
        System.out.println("0.- Salir");
    }

    int pedirOpc() throws IOException {
        int n = t.leerInt();
        return n;
    }

    void ejecutarOpc(int n) throws IOException {
        switch (n) {
            case 1:
                if (!anadirLibro()) {
                    System.out.println("Se ha alcanzado el maximo de libros");
                }
                break;
            case 2:
                if (!anadirUser()) {
                    System.out.println("Se ha alcanzado el maximo de usuarios");
                }
                break;
            case 3:
                if (!bajaUser()) {
                    System.out.println("No se puede dar de baja a este usuario");
                }
                break;

            case 4:
                if (!prestamoLibro()) {
                    System.out.println("No se ha podido llevar a cabo el prestamo");
                }
                break;

            case 5:
                if (!devolverLibro()) {
                    System.out.println("No se ha devuelto ningún libro");
                }
                break;

            case 6:
                if (!consultarLibro()) {
                    System.out.println("No se ha podido consultar este libro");
                }
                break;

            case 7:
                listarUsers();
                break;

            case 8:
                listarLibros();
                break;

            case 9:
                escribirFichLib(libros);
                escribirFichUsr(users);
                break;

            case 0:
                break;
        }
    }


    boolean bajaUser() throws IOException {
        boolean ok = true;
        System.out.println("Dar código de usuario");
        int codUser = t.leerInt();
        if (codUser < 0 || codUser >= contUsers) {
            ok = false;
        } else {
            for (int i = codUser; i < contUsers - 1; i++) {
                users[i] = users[i + 1];
                users[i].setCodigoUser(users[i].getCodigoUser() - 1);
            }
            if (contUsers > 0) {
                contUsers--;
            }
        }

        return ok;
    }

    boolean anadirLibro() throws IOException {
        boolean ok = true;
        if (contLibros < MAXIMOLIBROS) {
            System.out.println("Dar título");
            String titulo = t.leerString();
            libros[contLibros] = new Libro(titulo, contLibros);
            contLibros++;
        } else {
            ok = false;
        }
        return ok;
    }

    boolean anadirUser() throws IOException {
        boolean ok = true;
        if (contUsers < MAXIMOUSERS) {
            System.out.println("Dar nombre");
            String nombre = t.leerString();
            users[contUsers] = new Usuario(nombre, contUsers);
            contUsers++;
        } else {
            ok = false;
        }
        return ok;
    }

    boolean prestamoLibro() throws IOException {
        boolean ok = true;
        System.out.println("Dar código del libro");
        int codLib = t.leerInt();
        if (codLib >= contLibros) {
            ok = false;
        } else if (!libros[codLib].isDisponible()) {
            ok = false;
        } else {
            System.out.println("Dar código de usuario");
            int codUser = t.leerInt();
            if (codUser >= contUsers) {
                ok = false;
            } else if (users[codUser].getContPrestados() >= 5) {
                ok = false;
            } else {
                users[codUser].setLibrosPrestados(libros[codLib]);
                libros[codLib].setDisponible(false);
            }
        }
        return ok;
    }

    boolean devolverLibro() throws IOException {
        boolean ok = true;
        System.out.println("Dar código de usuario");
        int codUser = t.leerInt();
        if (codUser >= contUsers) {
            ok = false;
        } else if (users[codUser].getContPrestados() <= 0) {
            ok = false;
        } else {
            System.out.println("Dar código del libro");
            int codLib = t.leerInt();
            if (codLib >= contLibros) {
                ok = false;
            } else if (libros[codLib].isDisponible()) {
                ok = false;
            } else {
                Libro[] prestados = users[codUser].getLibrosPrestados();
                for (int i = 0; i < users[codUser].getContPrestados(); i++) {
                    if (prestados[i].getCodigoLibro() == libros[codLib].getCodigoLibro()) {
                        libros[codLib].setDisponible(true);
                        for (int j = i; j < users[codUser].getContPrestados() - 1; j++) {
                            prestados[j] = prestados[j + 1];
                        }
                        prestados[users[codUser].getContPrestados() - 1] = null;
                        users[codUser].setContPrestados(users[codUser].getContPrestados() - 1);
                    } else {
                        ok = false;
                    }
                }
            }
        }
        return ok;
    }


    boolean consultarLibro() throws IOException {
        Libro[] prestados;
        boolean ok = true;
        System.out.println("Dar codigo de libro");
        int codLibro = t.leerInt();
        if (codLibro >= contLibros) {
            ok = false;
        } else {
            libros[codLibro].mostrar();
            if (!libros[codLibro].isDisponible()) {
                for (int i = 0; i < contUsers; i++) {
                    prestados = users[i].getLibrosPrestados();
                    for (int j = 0; j < users[i].getContPrestados(); j++) {
                        if (libros[codLibro].getCodigoLibro() == prestados[j].getCodigoLibro()) {
                            System.out.println("Codigo usuario--> " + users[i].getCodigoUser());
                            System.out.println("Nombre de usuario--> " + users[i].getNombre());
                        }
                    }
                }
            }
        }

        return ok;
    }


    void listarUsers() {
        if (contUsers <= 0) {
            System.out.println("No hay usuarios");
        } else {
            for (int i = 0; i < contUsers; i++) {
                users[i].mostrar();
            }
        }
    }


    void listarLibros() {
        if (contLibros <= 0) {
            System.out.println("No hay libros");
        } else {
            for (int i = 0; i < contLibros; i++) {
                if (libros[i].isDisponible()) {
                    libros[i].mostrar();
                }
            }
        }
    }

    public void escribirFichLib(Libro[] lista) {
        File fichero = new File(PATH, "Libros.dat");
        try (FileOutputStream f = new FileOutputStream(fichero);) {
            for (int i = 0; i < contLibros; i++) {
                for (int j = 0; j < lista[i].getTitulo().length(); j++)
                    f.write(lista[i].getTitulo().charAt(j));
                f.write(';');
            }
        } catch (IOException e) {
            System.out.println("Error en escritura de datos (libros)");
        }
    }

    public void escribirFichUsr(Usuario[] lista) {
        File fichero = new File(PATH, "Usuarios.dat");
        try (FileOutputStream f = new FileOutputStream(fichero);) {
            for (int i = 0; i < contUsers; i++) {
                for (int j = 0; j < lista[i].getNombre().length(); j++)
                    f.write(lista[i].getNombre().charAt(j));
                f.write(';');
            }
        } catch (IOException e) {
            System.out.println("Error en escritura de datos (usuarios)");
        }
    }

    public void leerFichUsr() {
        StringBuffer datos = new StringBuffer();
        String[] datosSep;
        try (FileInputStream inputStream = new FileInputStream(PATH + "\\Usuarios.dat")) {
            while (inputStream.available() > 0) {
                datos.append((char) inputStream.read());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        datosSep = datos.toString().split(";");
        for (int i = 0; i<datosSep.length; i++){
            String nombre = datosSep[i];
            users[contUsers] = new Usuario(nombre, contUsers);
            contUsers++;
        }
    }

    public void leerFichLib() {
        StringBuffer datos = new StringBuffer();
        String[] datosSep;
        char c;
        try (FileInputStream inputStream = new FileInputStream(PATH + "\\Libros.dat")) {
            while (inputStream.available() > 0) {
                datos.append((char) inputStream.read());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        datosSep = datos.toString().split(";");
        for (int i = 0; i<datosSep.length; i++){
            String nombre = datosSep[i];
            libros[contLibros] = new Libro(nombre, contLibros);
            contLibros++;
        }
    }

    public static void main(String[] args) throws IOException {
        Biblioteca obj = new Biblioteca();
        int n;
        System.out.println("Quiere importar los datos antes de iniciar el programa? S/N");
        Character c = Character.toLowerCase(t.leerChar());
        if (c == 's') {
            obj.leerFichLib();
            obj.leerFichUsr();
            System.out.println("Datos importados.");
        } else System.out.println("no se han importado los datos");
        do {
            obj.mostrarMenu();
            n = obj.pedirOpc();
            obj.ejecutarOpc(n);
        } while (n != 0);
        System.out.println("Quiere guardar los datos antes de cerrar el programa? S/N");
        c = Character.toLowerCase(t.leerChar());
        if (c == 's') {
            obj.escribirFichLib(obj.libros);
            obj.escribirFichUsr(obj.users);
            System.out.println("Datos guardados.FIN.");
        } else System.out.println("FIN");
    }

}
