package ejemplos;

import java.io.File;

/**
 * @author Rodrigo
 * @date 17 septiembre, 2024
 */
public class CreaDir {
    private static final String PATH = ".\\src\\main\\resources";

    public static void main(String[] args) {
        File d = new File(PATH + "\\NUEVODIR");
        d.mkdir();
        File f1 = new File(d, "fichero1.txt");
        File f2 = new File(d, "fichero2.txt");

        try {
            if (f1.createNewFile())
                System.out.println("Se ha creado correctamente");
            else
                System.out.println("No se ha podido crear");
            if (f2.createNewFile())
                System.out.println("Se ha creado correctamente");
            else
                System.out.println("No se ha podido crear");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
