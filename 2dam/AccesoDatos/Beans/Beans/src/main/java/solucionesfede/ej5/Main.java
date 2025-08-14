package solucionesfede.ej5;

import java.sql.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

                Connection conexion = null;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/vendedores", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        do {
            System.out.println("---------------------------------------------------------------");
            System.out.println("----- APLICACION JAVABEANS VENDEDORES CON BASES DE DATOS ------");
            System.out.println("---------------------------------------------------------------");
            System.out.println("1. Insertar Oficina");
            System.out.println("2. Listar Oficinas");
            System.out.println("3. Borrar Oficina");
            System.out.println("4. Insertar Vendedor");
            System.out.println("5. Listar Vendedores");
            System.out.println("6. Borrar Vendedor");
            System.out.println("7. Insertar Producto");
            System.out.println("8. Listar Productos");
            System.out.println("9. Borrar Producto");
            System.out.println("10. Insertar Cliente");
            System.out.println("11. Listar Clientes");
            System.out.println("12. Borrar Cliente");
            System.out.println("13. Insertar Pedido");
            System.out.println("14. Listar Pedidos");
            System.out.println("15. Borrar Pedido");
            System.out.println("16. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Scanner sc = new Scanner(System.in);
                    // Solicitar los datos de la oficina al usuario
                    System.out.print("número de oficina: ");
                    int numOfi1 = sc.nextInt();

                    sc.nextLine(); 

                    System.out.print("ciudad de la oficina: ");
                    String ciudad = sc.nextLine();

                    System.out.print("región de la oficina: ");
                    String region = sc.nextLine();

                    System.out.print("número de director: ");
                    int numDir = sc.nextInt();

                    System.out.print("objetivo de ventas: ");
                    double objetivo = sc.nextDouble();

                    System.out.print("ventas realizadas: ");
                    double ventas = sc.nextDouble();

                    Oficina oficina = new Oficina(numOfi1, ciudad, region, numDir, objetivo, ventas);

                    OperacionesCRUD.insertarOficina(oficina);

                    System.out.println("La Oficina se ha guardado.");
                    break;

                case 2:
                    List<Oficina> oficinas = OperacionesCRUD.listarOficinas();
                    if (oficinas.isEmpty()) {
                        System.out.println("No se encontraron oficinas.");
                    } else {
                        for (Oficina oficina2 : oficinas) {
                            System.out.println("Oficina: " + oficina2.getNumOfi() + ", Ciudad: " + oficina2.getCiudad() +
                                    ", Región: " + oficina2.getRegion() + ", Objetivo: " + oficina2.getObjetivo() +
                                    ", Ventas: " + oficina2.getVentas());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Número de oficina a borrar: ");
                    int numOfi = scanner.nextInt();
                    OperacionesCRUD.borrarOficina(numOfi);
                    break;
                case 4:
                    Scanner sc1 = new Scanner(System.in);

                    System.out.print("Número de empleado: ");
                    int numEmp = sc1.nextInt();
                    sc1.nextLine(); 

                    System.out.print("Nombre del vendedor: ");
                    String nombreVendedor = sc1.nextLine();

                    System.out.print("Edad: ");
                    int edadVendedor = sc1.nextInt();

                    System.out.print("número de cuota: ");
                    int cuotaVendedor = sc1.nextInt();

                    System.out.print("fecha de alta (YYYY-MM-DD): ");
                    String fechaAlta = sc1.next(); 
                    Date fechaAltaDate = Date.valueOf(fechaAlta); 

                    System.out.print("número de director: ");
                    int numDirVendedor = sc1.nextInt();

                    System.out.print("ventas realizadas: ");
                    double ventasVendedor = sc1.nextDouble();

                    Vendedor vendedor = new Vendedor(numEmp, nombreVendedor, edadVendedor, cuotaVendedor, "Vendedor", fechaAltaDate, numDirVendedor, ventasVendedor, ventasVendedor);

                    OperacionesCRUD.insertarVendedor(vendedor);

                    System.out.println("El Vendedor se ha guardado.");
                    break;
                case 5:
                    List<Vendedor> vendedores = OperacionesCRUD.listarVendedores();
                    if (vendedores.isEmpty()) {
                        System.out.println("No se encontraron vendedores.");
                    } else {
                        for (Vendedor vendedor2 : vendedores) {
                            System.out.println("Vendedor: " + vendedor2.getNumEmp() + ", Nombre: " + vendedor2.getNombre() +
                                    ", Edad: " + vendedor2.getEdad() + ", Cuota: " + vendedor2.getCuota() +
                                    ", Ventas: " + vendedor2.getVentas());
                        }
                    }
                    break;

                case 6:
                    System.out.print("Número de empleado a borrar: ");
                    int numEmp1 = scanner.nextInt();
                    OperacionesCRUD.borrarVendedor(numEmp1);
                    break;
                case 7:
                    Scanner sc2 = new Scanner(System.in);

                    // Solicitar datos del producto
                    System.out.print("ID del producto: ");
                    String idProd = sc2.nextLine();

                    System.out.print("descripción: ");
                    String descripcionProd = sc2.nextLine();

                    System.out.print("precio: ");
                    double precioProd = sc2.nextDouble();

                    System.out.print("cantidad en existencias: ");
                    int existenciasProd = sc2.nextInt();

                    Producto producto = new Producto(idProd, "PROD1", descripcionProd, precioProd, existenciasProd);

                    OperacionesCRUD.insertarProducto(producto);

                    System.out.println("El Producto se ha guardado.");
                    break;

                case 8:
                    List<Producto> productos = OperacionesCRUD.listarProductos();
                    if (productos.isEmpty()) {
                        System.out.println("No se encontraron productos.");
                    } else {
                        for (Producto producto2 : productos) {
                            System.out.println("Producto: " + producto2.getIdProd() + ", Descripción: " + producto2.getDescripcion() +
                                    ", Precio: " + producto2.getPrecio() + ", Existencias: " + producto2.getExistencias());
                        }
                    }
                    break;

                case 9:
                    System.out.print("ID del producto a borrar: ");
                    String idProd1 = scanner.next();
                    OperacionesCRUD.borrarProducto(idProd1);
                    break;
                case 10:
                    Scanner sc3 = new Scanner(System.in);

                    System.out.print("número de cliente: ");
                    int numCli = sc3.nextInt();
                    sc3.nextLine(); 

                    System.out.print("nombre de la empresa: ");
                    String empresaCli = sc3.nextLine();

                    System.out.print("número de vendedor asociado: ");
                    int numVendedor = sc3.nextInt();

                    System.out.print("límite de crédito: ");
                    double limiteCredito = sc3.nextDouble();

                    Cliente cliente = new Cliente(numCli, empresaCli, numVendedor, limiteCredito);

                    OperacionesCRUD.insertarCliente(cliente);

                    System.out.println("Cliente se ha guardado.");
                    break;

                case 11:
                    List<Cliente> clientes = OperacionesCRUD.listarClientes();
                    if (clientes.isEmpty()) {
                        System.out.println("No se encontraron clientes.");
                    } else {
                        for (Cliente cliente2 : clientes) {
                            System.out.println("Cliente: " + cliente2.getNumCli() + ", Empresa: " + cliente2.getEmpresa() +
                                    ", Limite Crédito: " + cliente2.getLimiteCredito());
                        }
                    }
                    break;

                case 12:
                    System.out.print("Número de cliente a borrar: ");
                    int numCli1 = scanner.nextInt();
                    OperacionesCRUD.borrarCliente(numCli1);
                    break;

                case 13:
                    Scanner sc4 = new Scanner(System.in);

                    // Solicitar datos del pedido
                    System.out.print("número de pedido: ");
                    int numPed = sc4.nextInt();

                    System.out.print("fecha del pedido (YYYY-MM-DD): ");
                    String fechaPedido = sc4.next(); 
                    Date fechaPedidoDate = Date.valueOf(fechaPedido); 

                    System.out.print("número de cliente: ");
                    int numCliPedido = sc4.nextInt();

                    System.out.print("Introduce el número de vendedor: ");
                    int numVendedorPedido = sc4.nextInt();

                    System.out.print("Introduce el ID del producto: ");
                    String idProductoPedido = sc4.next();

                    System.out.print("Introduce la cantidad de producto: ");
                    int cantidadPedido = sc4.nextInt();

                    System.out.print("Introduce el importe del pedido: ");
                    double importePedido = sc4.nextDouble();


                    Pedido pedido = new Pedido(numPed, fechaPedidoDate, numCliPedido, numVendedorPedido, idProductoPedido, idProductoPedido, cantidadPedido, importePedido);

                    OperacionesCRUD.insertarPedido(pedido);

                    System.out.println("El pedido se ha guardado.");
                    break;

                case 14:
                    List<Pedido> pedidos = OperacionesCRUD.listarPedidos();
                    if (pedidos.isEmpty()) {
                        System.out.println("No se encontraron pedidos.");
                    } else {
                        for (Pedido pedido2 : pedidos) {
                            System.out.println("Pedido: " + pedido2.getNumPed() + ", Fecha: " + pedido2.getFechaPed() +
                                    ", Cliente: " + pedido2.getNumCli() + ", Producto: " + pedido2.getIdProd() + ", Importe: " + pedido2.getImporte());
                        }
                    }
                    break;

                case 15:
                    System.out.print("Número de pedido a borrar: ");
                    int numPed1 = scanner.nextInt();
                    OperacionesCRUD.borrarPedido(numPed1);
                    break;
                case 16:
                    System.out.println("FIN DEL PROGRAMA");
                    break;
                default:
                    System.out.println("OPCION INCORRECTA.");
            }
        } while (opcion != 16);


        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
