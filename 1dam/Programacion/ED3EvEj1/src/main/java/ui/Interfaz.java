package ui;

import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 23 mayo, 2024
 */
public class Interfaz {
    static Scanner sc = new Scanner(System.in);

    public static int leerNum(){
        return Integer.parseInt(sc.nextLine());
    }
}
