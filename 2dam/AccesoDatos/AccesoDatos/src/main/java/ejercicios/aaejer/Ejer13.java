package ejercicios.aaejer;

import java.io.File;

/**
 * @author Rodrigo
 * @date 17 septiembre, 2024
 */
public class Ejer13 {

    public static void main(String[] args) {
        if (args.length == 0){
            File d = new File(".\\src\\main\\resources" + "\\default");
            d.mkdir();
        }else {
            File d = new File(args[0] + "\\" + args[1]);
            d.mkdir();
        }
    }
}
