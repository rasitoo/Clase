package ejercicios.aaejer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author Rodrigo
 * @date 17 septiembre, 2024
 */
public class Ejer14 {

    public static void main(String[] args) {
        if (args.length <2) {
            System.out.println("No se han introducido los argumentos necesarios");
        } else {
            try {
                Files.copy(new File(args[0]).toPath(), new File(args[1]).toPath());
            } catch (IOException e) {

            }
        }
    }
}
