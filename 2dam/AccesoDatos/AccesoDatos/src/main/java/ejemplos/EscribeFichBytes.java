package ejemplos;

import java.io.*;

/**
 * @author Rodrigo
 * @date 17 septiembre, 2024
 */
public class EscribeFichBytes {
    private static final String PATH = ".\\src\\main\\resources\\NUEVODIR\\Fichbytes.dat";

    public static void main(String[] args) throws IOException {
        File fichero = new File(PATH);
        //crea flujo de salida hacia el fichero
        FileOutputStream fileout = new FileOutputStream(fichero);
        //crea flujo de entrada
        FileInputStream filein = new FileInputStream(fichero);
        int i;
        for (i = 1; i < 100; i++)
            fileout.write(i); //escribe datos en el flujo de salida
        fileout.close(); // cerrar stream de salida
        //visualizar los datos del fichero
        while ((i = filein.read()) != -1)  //lee dato del flujo de entrada
            System.out.println(i);
        filein.close();  //cerrar stream de entrada
    }
}
