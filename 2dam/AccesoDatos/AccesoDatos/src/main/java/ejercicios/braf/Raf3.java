package ejercicios.braf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Rodrigo
 * @date 16 octubre, 2024
 */
public class Raf3 {
    private static final String PATH = ".\\src\\main\\resources\\AleatorioEmple2.dat";

    public static void main(String[] args) {
        try(RandomAccessFile fichero = new RandomAccessFile(PATH, "r")) {


            int id, dep, posicion;
            double salario;
            char apellido[] = new char[10], aux;

            posicion = 0;

            while (true){
                fichero.seek(posicion);
                id = fichero.readInt();
                for (int i = 0; i < apellido.length; i++) {
                    apellido[i] = fichero.readChar();
                }
                String apellidoS = new String(apellido);
                dep = fichero.readInt();
                salario = fichero.readDouble();

                System.out.println("ID: " + id + ", Apellido: " + apellidoS + ", Departamento: " + dep + ", Salario: " + salario);
                posicion = posicion +36; //4 + 20+ 4+ 8
                if (fichero.getFilePointer() == fichero.length())
                    return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
