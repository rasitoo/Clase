package ejercicios.aaejer.ejer15;

import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 02 octubre, 2024
 */
public class Main {
    static AplicacionFicherosTextos ej = new AplicacionFicherosTextos();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        while (opcion !=6) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Opción 1. Ejercicio 6 ");
            System.out.println("2. Opción 2. Ejercicio 7. ");
            System.out.println("3. Opción 3. Ejercicio 8. ");
            System.out.println("4. Opción 4. Ejercicio 9. ");
            System.out.println("5. Opción 5. Ejercicio 10. ");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    ej.ejercicio6();
                    break;
                case 2:
                    ej.ejercicio7();
                    break;
                case 3:
                    ej.ejercicio8();
                    break;
                case 4:
                    ej.ejercicio9();
                    break;
                case 5:
                    ej.ejercicio10(ej.pedirPalabra());
                    break;
                case 6:
                    System.out.println(" SALIMOS DE LA APLICACION");
                    break;
                default:
                    System.out.println("OPCION INVALIDA.");
            }
        }
        scanner.close();
    }
}
