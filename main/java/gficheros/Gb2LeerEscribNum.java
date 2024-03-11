package gficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * @author Rodrigo🦖
 * @date 02 febrero, 2024
 */
public class Gb2LeerEscribNum {
    String origen = "C:\\Users\\Rodrigo\\OneDrive\\Documents\\AAClase\\Programacion\\dir1\\1.txt";
    String destino = "C:\\Users\\Rodrigo\\OneDrive\\Documents\\AAClase\\Programacion\\dir2\\2.txt";
    byte[] arraynum;

    public boolean copiarOrdenado(String origen, String destino) {
        boolean completado = false;
        File origenarch = new File(origen);
        arraynum = new byte[(int) origenarch.length()];
        try (FileInputStream inputStream = new FileInputStream(origen); FileOutputStream outputStream = new FileOutputStream(destino)) {

            for (int i = 0; i < origenarch.length(); i++)
                arraynum[i] = (byte) inputStream.read();
            arraynum = burbuja(arraynum);
            completado = true;
            for (int i = 0; i < arraynum.length; i++){
                outputStream.write(arraynum[i]);
            }

        } catch (Exception e) {
            System.out.println(e);
            completado = false;
        }
        return completado;
    }

    private byte[] burbuja(byte[] v) {
        byte aux;
        for (int j = 0; j < v.length; j++) {
            for (int i = 0; i < v.length - 1; i++) {
                if (v[i] > v[i + 1]) {
                    aux = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = aux;
                }
            }
        }
        return v;
    }

    public static void main(String[] args) {
        Gb2LeerEscribNum ej = new Gb2LeerEscribNum();
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

        if (!ej.copiarOrdenado(origen, destino)) {
            System.out.println("No se ha podido copiar correctamente");
        } else System.out.println("Se ha copiado correctamente");
    }
}
