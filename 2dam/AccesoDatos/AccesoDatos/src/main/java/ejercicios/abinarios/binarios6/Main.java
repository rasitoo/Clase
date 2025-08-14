package ejercicios.abinarios.binarios6;

import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 16 octubre, 2024
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        String nom = null, loc = null;
        DepartamentoDao dao = new DepartamentoDao();
        int opc;
        do {
            System.out.println("Elige una opción");
            System.out.println("1. Añadir departamento");
            System.out.println("2. Modificar departamento");
            System.out.println("3. Eliminar departamento");
            System.out.println("4. Listar");
            System.out.println("0. Salir");
            switch (opc = sc.nextInt()) {
                case 1:
                    System.out.println("Introduce el numero de departamento");
                    num = sc.nextInt();
                    if (!dao.encontrarDept(num)) {
                        System.out.println("Introduce el nombre del departamento");
                        nom = sc.next();
                        System.out.println("Introduce la localidad");
                        loc = sc.next();
                        if (dao.anadirDep(new Departamento(num,nom,loc))) {
                            System.out.println("departamento añadido correctamente");
                        } else System.out.println("Error al añadir");

                    } else System.out.println("Ese departamento ya existe");
                    break;
                case 2:
                    System.out.println("Introduce el numero de departamento");
                    num = sc.nextInt();
                    if (dao.encontrarDept(num)) {
                        System.out.println("Introduce el nuevo nombre del departamento");
                        nom = sc.next();
                        System.out.println("Introduce la nueva localidad");
                        loc = sc.next();
                        if (dao.modificarDep(num, nom, loc)) {
                            System.out.println("departamento modificado correctamente");
                        } else System.out.println("Error al modificar");

                    } else System.out.println("Ese departamento no existe");
                    break;
                case 3:
                    System.out.println("Introduce el numero de departamento");
                    num = sc.nextInt();
                    if (dao.encontrarDept(num)) {
                        if (dao.eliminarDep(num))
                            System.out.println("Departamento eliminado correctamente");
                        else System.out.println("Error al eliminar el departamento");
                    } else System.out.println("Ese departamento no existe");
                    break;
                case 4:
                    dao.listar();
                    break;
                case 0:
                    System.out.println("saliendo...");
                    return;
            }
        } while (true);
    }

}
