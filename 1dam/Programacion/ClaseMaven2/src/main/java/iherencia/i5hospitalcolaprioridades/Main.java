package iherencia.i5hospitalcolaprioridades;

import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 23 abril, 2024
 */
public class Main {
    public static void main(String[] args) {
        ColaConPrioridades<Paciente> cp = new ColaConPrioridades<Paciente>(5);
        Scanner scanner = new Scanner(System.in);
        int opc;
        String nombre;
        int edad;
        int prioridad;
        int orden = 1;
        for (int i = 0; i < 10; i++) {
            Paciente p = new Paciente((int) (Math.random() * 65), "x", (int) (Math.random() * cp.getC().length - 1) + 1, orden++);
            cp.anadir(p, p.prioridad);
        }


        do {
            System.out.println("Menú:");
            System.out.println("1- Añadir. Indicando la prioridad (5 prioridades: 5 más prioridad, 1 la de menos prioridad),");
            System.out.println("2- Extraer (todos). Si hay pacientes de prioridad 5 siempre se extraerán éstos primero, sino hay de prioridad se extraerán de prioridad 4 y sino hubiera de éstos de prioridad 3, etc.");
            System.out.println("3- Extraer (uno). Si hay pacientes de prioridad 5 siempre se extraerán éstos primero, sino hay de prioridad se extraerán de prioridad 4 y sino hubiera de éstos de prioridad 3, etc.");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Has seleccionado la Opción 1.");
                    System.out.println("Indica el nombre del paciente");
                    nombre = scanner.next();
                    System.out.println("Indica la edad del paciente");
                    edad = scanner.nextInt();
                    System.out.println("Indica la prioridad del paciente (1-5)");
                    prioridad = scanner.nextInt();
                    cp.anadir(new Paciente(edad, nombre, prioridad, orden++), prioridad);
                    break;
                case 2:
                    System.out.println("Has seleccionado la Opción 2.");
                    cp.sacarTodos();
                    break;
                case 3:
                    System.out.println("Has seleccionado la Opción 3.");
                    System.out.println(cp.sacar());
                    break;
                case 0:
                    System.out.println("Saliendo del menú. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opc != 0);

        scanner.close();
    }
}
