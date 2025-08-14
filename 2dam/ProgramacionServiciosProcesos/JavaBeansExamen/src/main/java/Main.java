import controller.GestionHospital;
import model.Repository;
import view.View;

import java.util.*;

/**
 * @author Rodrigo
 * @date 25 febrero, 2025
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        View view = new View();
        Repository repository = new Repository();
        GestionHospital gestion = new GestionHospital(repository, view);

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("**** APLICACION JAVABEANS HOSPITALES *******:");
                System.out.println("1. Insertar Hospital");
                System.out.println("2. Insertar Médico sin usar ArraysList");
                System.out.println("3. Insertar Médico usando ArrayList)");
                System.out.println("4. Insertar Pacientes Adultos");
                System.out.println("5. Mostrar todos los Hospitales");
                System.out.println("6. Mostrar todos los Médicos");
                System.out.println("7. Mostrar todos los Pacientes");
                System.out.println("8. Mostrar el paciente más joven");
                System.out.println("9. Mostrar el paciente más viejo");
                System.out.println("10. Mostrar el segundo paciente");
                System.out.println("11. Mostrar el último paciente");
                System.out.println("12. Mostrar médicos con más de dos especialidades sin usar ArraysList");
                System.out.println("13. Mostrar médicos con más de dos especialidades usando ArrayList");
                System.out.println("14. Salir");
                System.out.print("Pulsa la Opción: ");


                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("ID del hospital: ");
                        int idHospital = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print(" Nombre : ");
                        String nombreHospital = scanner.nextLine();
                        System.out.print(" Dirección: ");
                        String direccionHospital = scanner.nextLine();
                        gestion.insertarHospital(idHospital, nombreHospital, direccionHospital);
                        break;

                    case 2:
                        System.out.print("ID del médico: ");
                        int idMedicoString = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nombre del médico: ");
                        String nombreMedicoString = scanner.nextLine();
                        System.out.print("Entra las especialidades separadas por guiones... ");
                        String especialidadesString = scanner.nextLine();
                        System.out.print("ID del hospital: ");
                        int hospitalIdString = scanner.nextInt();
                        gestion.insertarMedicoConString(idMedicoString, nombreMedicoString, especialidadesString, hospitalIdString);
                        break;

                    case 3:
                        System.out.print("ID del médico: ");
                        int idMedicoArrayList = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nombre: ");
                        String nombreMedicoArrayList = scanner.nextLine();
                        ArrayList<String> especialidadesArrayList = new ArrayList<>();
                        System.out.println("Entra las especialidades ('fin' para acabar): ");
                        while (true) {
                            String especialidad = scanner.nextLine();
                            if (especialidad.equalsIgnoreCase("fin")) break;
                            especialidadesArrayList.add(especialidad);
                        }
                        System.out.print("ID del hospital: ");
                        int hospitalIdArrayList = scanner.nextInt();
                        gestion.insertarMedicoConArrayList(idMedicoArrayList, nombreMedicoArrayList, especialidadesArrayList, hospitalIdArrayList);
                        break;

                    case 4:
                        System.out.print("ID del paciente: ");
                        int idPaciente = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nombre: ");
                        String nombrePaciente = scanner.nextLine();
                        System.out.print("Edad: ");
                        int edadPaciente = scanner.nextInt();
                        System.out.print("ID del médico: ");
                        int medicoIdPaciente = scanner.nextInt();
                        gestion.insertarPaciente(idPaciente, nombrePaciente, edadPaciente, medicoIdPaciente);
                        break;

                    case 5:
                        gestion.mostrarHospitales();
                        break;

                    case 6:
                        gestion.mostrarMedicos();
                        break;

                    case 7:
                        gestion.mostrarPacientes();
                        break;

                    case 8:
                        gestion.PacienteMasJoven();
                        break;

                    case 9:
                        gestion.PacienteMasViejo();
                        break;

                    case 10:
                        gestion.SegundoPaciente();
                        break;

                    case 11:
                        gestion.UltimoPaciente();
                        break;

                    case 12:
                        gestion.MedicosMasDeDosSinArraysList();
                        break;

                    case 13:
                        gestion.MedicosMasDeDosConArrayList();
                        break;

                    case 14:
                        System.out.println("FIN DEL PROGRAMA.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("OPCION INCORRECTA.");
                }

                System.out.print("\n Pulsa Enter para continuar...");
                scanner.nextLine();

            }
        }catch (InputMismatchException e){
            System.err.println("Has introducido un tipo de dato incorrecto");
        }
        catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }
}

