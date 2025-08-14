package solucionesfede.ej4;

import java.util.*;

public class OperacionesCRUD  {


    private static List<Oficina> oficinas = new ArrayList<>();
    private static List<Vendedor> vendedores = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Producto> productos = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();


    public static void InsertarOficina() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de oficina: ");
        int numOfi = sc.nextInt();
        System.out.print("Ciudad: ");
        String ciudad = sc.next();
        System.out.print("Región: ");
        String region = sc.next();
        System.out.print("Número de director: ");
        int numDir = sc.nextInt();
        System.out.print("objetivo: ");
        double objetivo = sc.nextDouble();
        System.out.print("ventas: ");
        double ventas = sc.nextDouble();
        oficinas.add(new Oficina(numOfi, ciudad, region, numDir, objetivo, ventas));
        System.out.println("La oficina hja sido insertada");
    }

    public static void InsertarVendedor() {
        Scanner sc = new Scanner(System.in);
        System.out.print("número de empleado: ");
        int numEmp = sc.nextInt();
        System.out.print("nombre: ");
        String nombre = sc.next();
        System.out.print("edad: ");
        int edad = sc.nextInt();
        System.out.print("número de oficina: ");
        int numOfi = sc.nextInt();
        System.out.print("oficio: ");
        String oficio = sc.next();
        System.out.print("fecha de contratación (dd/mm/aa): ");
        String fechaCont = sc.next();
        System.out.print("número de director: ");
        int numDir = sc.nextInt();
        System.out.print("cuota: ");
        double cuota = sc.nextDouble();
        System.out.print("ventas: ");
        double ventas = sc.nextDouble();
        vendedores.add(new Vendedor(numEmp, nombre, edad, numOfi, oficio, fechaCont, numDir, cuota, ventas));
        System.out.println("El vendedor ha sido insertado.");
    }

    public static void InsertarCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de cliente: ");
        int numCli = sc.nextInt();
        System.out.print("empresa: ");
        String empresa = sc.next();
        System.out.print("número de empleado: ");
        int numEmp = sc.nextInt();
        System.out.print("límite de crédito: ");
        double limiteCredito = sc.nextDouble();
        clientes.add(new Cliente(numCli, empresa, numEmp, limiteCredito));
        System.out.println("El cliente ha sido insertado.");
    }

    public static void InsertarProducto() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ID de fábrica: ");
        String idFab = sc.next();
        System.out.print("ID de producto: ");
        String idProd = sc.next();
        System.out.print("descripción: ");
        String descripcion = sc.next();
        System.out.print("precio: ");
        double precio = sc.nextDouble();
        System.out.print("existencias: ");
        int existencias = sc.nextInt();
        productos.add(new Producto(idFab, idProd, descripcion, precio, existencias));
        System.out.println("El producto ha sido insertado.");
    }

    public static void InsertarPedido() {
        Scanner sc = new Scanner(System.in);
        System.out.print("número de pedido: ");
        int numPed = sc.nextInt();
        System.out.print("fecha del pedido (dd/mm/aa): ");
        String fechaPed = sc.next();
        System.out.print("número de cliente: ");
        int numCli = sc.nextInt();
        System.out.print("número de empleado: ");
        int numEmp = sc.nextInt();
        System.out.print("ID de fábrica: ");
        String idFab = sc.next();
        System.out.print("ID de producto: ");
        String idProd = sc.next();
        System.out.print("cantidad: ");
        int cantidad = sc.nextInt();
        System.out.print("importe: ");
        double importe = sc.nextDouble();
        pedidos.add(new Pedido(numPed, new Date(), numCli, numEmp, idFab, idProd, cantidad, importe));
        System.out.println("El pedido ha sido insertado.");
    }


    public static void listarOficinas() {
        if (oficinas.isEmpty()) {
            System.out.println("No hay ninguna oficina en la lista.");
        } else {
            for (Oficina oficina : oficinas) {
                System.out.println(oficina);
            }
        }
    }

    public static void listarVendedores() {
        if (vendedores.isEmpty()) {
            System.out.println("No hay ningun vendedor en la lista.");
        } else {
            for (Vendedor vendedor : vendedores) {
                System.out.println(vendedor);
            }
        }
    }

    public static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay ningun cliente en la lista.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    public static void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay ningun producto en la lista.");
        } else {
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    public static void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay ningun pedido en a lista.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        }
    }


    public static void eliminarOficina() {
        Scanner sc = new Scanner(System.in);
        System.out.print("número de oficina a borrar: ");
        int numOfi = sc.nextInt();

        Oficina oficinaAEliminar = null;

        for (Oficina oficina : oficinas) {
            if (oficina.getNumOfi() == numOfi) {
                oficinaAEliminar = oficina;
                break;
            }
        }

        if (oficinaAEliminar != null) {
            oficinas.remove(oficinaAEliminar);
            System.out.println("La oficina ha sido borrada.");
        } else {
            System.out.println("La oficina no esta.");
        }
    }

    public static void eliminarVendedor() {
        Scanner sc = new Scanner(System.in);
        System.out.print("número de empleado a borrar: ");
        int numEmp = sc.nextInt();

        Vendedor vendedorAEliminar = null;

        for (Vendedor vendedor : vendedores) {
            if (vendedor.getNumEmp() == numEmp) {
                vendedorAEliminar = vendedor;
                break;
            }
        }

        if (vendedorAEliminar != null) {
            vendedores.remove(vendedorAEliminar);
            System.out.println("El vendedor ha sido borrado.");
        } else {
            System.out.println("El vendedor no esta en la lista.");
        }
    }

    public static void eliminarCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de cliente a borrar: ");
        int numCli = sc.nextInt();

        Cliente clienteAEliminar = null;

        for (Cliente cliente : clientes) {
            if (cliente.getNumCli() == numCli) {
                clienteAEliminar = cliente;
                break;
            }
        }

        if (clienteAEliminar != null) {
            clientes.remove(clienteAEliminar);
            System.out.println("El cliente ha sido borrado.");
        } else {
            System.out.println("El cliente no esta.");
        }
    }


    public static void eliminarProducto() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ID de producto a borrar: ");
        String idProd = sc.next();

        Producto productoAEliminar = null;

        for (Producto producto : productos) {
            if (producto.getIdProd().equals(idProd)) {
                productoAEliminar = producto;
                break;
            }
        }

        if (productoAEliminar != null) {
            productos.remove(productoAEliminar);
            System.out.println("El Producto ha sido borrado.");
        } else {
            System.out.println("El Producto no esta en la lista.");
        }
    }


    public static void eliminarPedido() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de pedido a borrar: ");
        int numPed = sc.nextInt();

        Pedido pedidoAEliminar = null;

        for (Pedido pedido : pedidos) {
            if (pedido.getNumPed() == numPed) {
                pedidoAEliminar = pedido;
                break;
            }
        }

        if (pedidoAEliminar != null) {
            pedidos.remove(pedidoAEliminar);
            System.out.println("El pedido ha sido borrado.");
        } else {
            System.out.println("El pedido no está en la lista.");
        }
    }



}