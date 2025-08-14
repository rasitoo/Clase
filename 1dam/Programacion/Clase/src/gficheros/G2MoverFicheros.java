package gficheros;

import ExpresionesBooleanas.Teclado;

import java.io.File;
import java.io.IOException;

/**
 * @author Rodrigo🦖
 * @date 02 febrero, 2024
 */
public class G2MoverFicheros {
    String dir1 = "C:\\Users\\Rodrigo\\OneDrive\\Documents\\AAClase\\Programacion\\dir1";
    String dir2 = "C:\\Users\\Rodrigo\\OneDrive\\Documents\\AAClase\\Programacion\\dir2";
    File f1;
    String[] listaFicheros1;
    String[] listaFicheros2;
    boolean terminado = false;
    boolean encontrado = false;
    void mover(){
        for (int i = 0; i < listaFicheros1.length; i++) {
            f1 = new File(dir1, listaFicheros1[i]);
            for (int j = 0; j < listaFicheros2.length; j++) {
                if (listaFicheros1[i].equals(listaFicheros2[j])) {
                    encontrado = true;
                }
            }
            if (encontrado) {
                System.out.println("El archivo " + f1.getName() + " ya se encuentra en " + dir2);
                encontrado = false;
            } else {
                if (f1.renameTo(new File(dir2, f1.getName()))) {
                    System.out.println("Fichero " + f1 + " movido con exito");
                } else System.out.println("Error al mover el archivo " + f1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Teclado sc = new Teclado();
        G2MoverFicheros ej = new G2MoverFicheros();

        System.out.println("Direccion del primer fichero: ");
        //ej.dir1 = sc.leerString();
        ej.listaFicheros1 = new File(ej.dir1).list();
        System.out.println("Direccion del segundo fichero: ");
        //ej.dir2 = sc.leerString();
        ej.listaFicheros2 = new File(ej.dir2).list();

        ej.mover();

    }
}
