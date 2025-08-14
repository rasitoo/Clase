package solucionesfede.ej4;

import java.util.Scanner;

public class Main {

    public static void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        while (true) {
            System.out.println("\n APLICACION JAVABEANS DE VENDEDORES");
            System.out.println("\n ----------------------------------");
            System.out.println("1. Insertar Oficina");
            System.out.println("2. Listar Oficinas");
            System.out.println("3. Borrar Oficina");
            System.out.println("4. Insertar Vendedor");
            System.out.println("5. Listar Vendedores");
            System.out.println("6. Borrar Vendedor");
            System.out.println("7. Insertar Cliente");
            System.out.println("8. Listar Clientes");
            System.out.println("9. Borrar Cliente");
            System.out.println("10. Insertar Producto");
            System.out.println("11. Listar Productos");
            System.out.println("12. Borrar Producto");
            System.out.println("13. Insertar Pedido");
            System.out.println("14. Listar Pedidos");
            System.out.println("15. Borrar Pedido");
            System.out.println("16. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: OperacionesCRUD.InsertarOficina(); break;
                case 2: OperacionesCRUD.listarOficinas(); break;
                case 3: OperacionesCRUD.eliminarOficina(); break;
                case 4: OperacionesCRUD.InsertarVendedor(); break;
                case 5: OperacionesCRUD.listarVendedores(); break;
                case 6: OperacionesCRUD.eliminarVendedor(); break;
                case 7: OperacionesCRUD.InsertarCliente(); break;
                case 8: OperacionesCRUD.listarClientes(); break;
                case 9: OperacionesCRUD.eliminarCliente(); break;
                case 10: OperacionesCRUD.InsertarProducto(); break;
                case 11: OperacionesCRUD.listarProductos(); break;
                case 12: OperacionesCRUD.eliminarProducto(); break;
                case 13: OperacionesCRUD.InsertarPedido(); break;
                case 14: OperacionesCRUD.listarPedidos(); break;
                case 15: OperacionesCRUD.eliminarPedido(); break;
                case 16: System.out.println("Saliendo del programa"); return;
                default: System.out.println("Opción incorrecta.");
            }
        }
    }

    public static void main(String[] args) {
        mostrarMenu();
    }
}