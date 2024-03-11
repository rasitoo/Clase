package gficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * @author Rodrigo🦖
 * @date 02 febrero, 2024
 */
public class Gb1CopiarFich {
    String origen = "C:\\Users\\Rodrigo\\OneDrive\\Documents\\AAClase\\Programacion\\dir1\\1.txt";
    String destino = "C:\\Users\\Rodrigo\\OneDrive\\Documents\\AAClase\\Programacion\\dir2\\2.txt";

    public boolean copiar(String origen, String destino) {
        boolean completado = false;
        File origenarch = new File(origen);
        try (FileInputStream inputStream = new FileInputStream(origen); FileOutputStream outputStream = new FileOutputStream(destino)) {

            for (int i = 0; i < origenarch.length(); i++)
                outputStream.write(inputStream.read());

            completado = true;

        } catch (Exception e) {
            System.out.print(e);
            completado = false;
        }
        return completado;
    }

    public static void main(String[] args) {
        Gb1CopiarFich ej = new Gb1CopiarFich();
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica la ruta de origen:");
        String origen = sc.nextLine();
        if (origen.isEmpty()) {
            origen = ej.origen;
        }
        System.out.println("Indica la ruta de destino:");
        String destino = sc.nextLine();
        if (destino.isEmpty()) {
            destino = ej.destino;
        }

        if (!ej.copiar(origen, destino)) {
            System.out.println("No se ha podido copiar correctamente");
        } else System.out.println("Se ha copiado correctamente");
    }
}
