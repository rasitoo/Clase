package ejercicios.braf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Rodrigo
 * @date 16 octubre, 2024
 */
public class Raf2 {
    private static final String PATH = ".\\src\\main\\resources\\AleatorioEmple2.dat";

    public static void main(String[] args) {
        try {
            // Abrimos el fichero en modo lectura/escritura
            RandomAccessFile fichero = new RandomAccessFile(PATH, "rw");

            String apellido[] = {"FERNANDEZ", "GIL", "LOPEZ", "RAMOS", "SEVILLA", "CASILLA", "REY"};
            int dep[] = {10, 20, 10, 10, 30, 30, 20};
            double salario[] = {
                    1000.45, 2400.60, 3000.0, 1500.65, 2200.0, 1435.87, 2000.0
            };

            StringBuffer buffer = null;
            int n = apellido.length;

            for (int i = 0; i < n; i++){
                fichero.writeInt(i+1);
                buffer = new StringBuffer(apellido[i]);
                buffer.setLength(10);
                fichero.writeChars(buffer.toString());
                fichero.writeInt(dep[i]);
                fichero.writeDouble(salario[i]);
            }
            // Cerramos el fichero
            fichero.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
