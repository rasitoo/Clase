package gficheros.gb7agenda;

import java.io.*;
import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 13 febrero, 2024
 */
public class Gb7Agenda {
    static final String PATH = "." + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "gficheros" + File.separator + "gb7agenda" + File.separator + "data" + File.separator;

    void altaPersona(Persona p, ServicioPersona sp) {
    try (DataOutputStream f = new DataOutputStream(new FileOutputStream(PATH + "agenda.dat", true))){
        sp.guardarPersonaFich(f, p);
    } catch (FileNotFoundException e) {
        System.err.println("No se ha encontrado ese fichero");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    }

//    void bajaPersona(ServicioPersona sp, String nom) {
//        try (DataOutputStream f = new DataOutputStream(new FileOutputStream(PATH + "agenda.dat", true)))
//        (DataInputStream in = new DataInputStream(new FileInputStream(PATH + "agenda.dat"))){
//            sp.borrarPersonaFich(f, nom);
//        } catch (FileNotFoundException e) {
//            System.err.println("No se ha encontrado ese fichero");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    void consultaNombre() {

    }

    void cumpleaneros() {

    }

    void totalPersonas() {

    }

    void ficheroPersonales() {

    }

    public static void main(String[] args) {
        Gb7Agenda ej = new Gb7Agenda();
        Scanner scanner = new Scanner(System.in);
        ServicioPersona sp = new ServicioPersona();
        int opcion = 5;

        while (opcion != 0) {
            System.out.println("1. Alta persona");
            System.out.println("2. Baja persona");
            System.out.println("3. Consulta exprlambda.lambdapersonaprof.Persona por nombre");
            System.out.println("4. Mostrar personas que cumplen años hoy o mañana.");
            System.out.println("5. Mostrar el número de personas almacenadas en el fichero.");
            System.out.println("6. Crear un fichero que contenga todos los datos de las personas consideradas contactos personales.");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ej.altaPersona(sp.pedirDatos(scanner), sp);
                    break;
                case 2:
                    System.out.println("Escribe el nombre de la persona que quieres borrar");
                    //ej.bajaPersona(sp, scanner.next());
                    break;
                case 3:
                    ej.consultaNombre();
                    break;
                case 4:
                    ej.cumpleaneros();
                    break;
                case 5:
                    ej.totalPersonas();
                    break;
                case 6:
                    ej.ficheroPersonales();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.err.println("Opción inválida. Inténtalo de nuevo.");
            }
        }
    }
}
