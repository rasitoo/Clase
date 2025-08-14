package ejercicios.aaejer;

import java.io.*;

/**
 * @author Rodrigo
 * @date 18 septiembre, 2024
 */
public class Ejer3 {
    private static final String PATH = ".\\src\\main\\resources";

    byte[] arraynum;

    public boolean leerUnicode(File origen) {
        boolean completado = false;
        arraynum = new byte[(int) origen.length()];
        try (FileInputStream inputStream = new FileInputStream(origen)) {
            for (int i = 0; i < origen.length(); i++)
                arraynum[i] = (byte) inputStream.read();
            completado = true;
            for (int i = 0; i < arraynum.length; i++){
                System.out.println( i + 1 + ":" + (char) arraynum[i] + ", UNICODE: " + arraynum[i]);
            }
            System.out.println("total de carácteres leidos: " + arraynum.length);

        } catch (Exception e) {
            System.out.println(e);
            completado = false;
        }
        return completado;
    }

    public static void main(String[] args) {
        Ejer3 ej = new Ejer3();
        ej.leerUnicode(new File(PATH,"ejem.txt"));
    }
}
