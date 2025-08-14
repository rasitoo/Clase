package ejemplo1;

import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 12 febrero, 2025
 */
public class Main {
    public static void main(String[] args) {
        GestorDatos ej = new GestorDatos();

        Menu menu = new Menu(ej);
        Scanner sc = new Scanner(System.in);
        menu.ejecutarMenu(sc);

    }
}
