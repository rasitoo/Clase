package ejercicios.braf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Rodrigo
 * @date 16 octubre, 2024
 */
public class Raf1 {
    private static final String PATH = ".\\src\\main\\resources\\AleatorioEmple1.dat";

    public static void main(String[] args) {
        try {
            // Abrimos el fichero en modo lectura/escritura
            RandomAccessFile fichero = new RandomAccessFile(PATH, "rw");
            int id = 20;
            long posicion = (id - 1) * 36;
            // Escribimos un entero
            fichero.writeInt(123);

            // Escribimos un String carácter por carácter
            String texto = "Hola";
            for (char c : texto.toCharArray()) {
                fichero.writeChar(c);
            }
            fichero.seek(posicion);
            // Escribimos un double
            fichero.writeDouble(45.67);

            // Cerramos el fichero
            fichero.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
