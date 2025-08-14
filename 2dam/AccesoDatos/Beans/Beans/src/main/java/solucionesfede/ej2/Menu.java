package solucionesfede.ej2;

import java.util.Scanner;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private OperacionesClientes operacionesClientes;
    private OperacionesProducto operacionesProducto;
    private Scanner scanner;

    public Menu() {
        this.operacionesClientes = new OperacionesClientes();
        this.operacionesProducto = new OperacionesProducto();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Ver clientes");
            System.out.println("2. Agregar cliente");
            System.out.println("3. Ver productos");
            System.out.println("4. Agregar producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) {
                case 1 -> verClientes();
                case 2 -> agregarCliente();
                case 3 -> verProductos();
                case 4 -> agregarProducto();
                case 5 -> System.out.println("FIN DEL PROGRAMA.");
                default -> System.out.println("OPCION ERRONEA.");
            }
        } while (opcion != 5);
    }

    private void verClientes() {
        List<Cliente> clientes = operacionesClientes.obtenerClientes();
        System.out.println("\n--- Lista de Clientes ---");
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId() + ", Nombre: " + cliente.getNombre() + ", Email: " + cliente.getEmail()
            + ", telefono: " + cliente.getTelefono());
        }
    }

    private void agregarCliente() {
        System.out.print("Id del cliente: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("correo: ");
        String correo = scanner.nextLine();
        System.out.print("telefono: ");
        String telefono = scanner.nextLine();

        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNombre(nombre);
        cliente.setEmail(correo);
        cliente.setTelefono(telefono);


        operacionesClientes.agregarCliente(cliente);
        System.out.println("El cliente se guardo correctamente.");
    }

    private void verProductos() {
        List<Producto> productos = operacionesProducto.obtenerProductos();
        System.out.println("\n--- Lista de Productos ---");
        for (Producto producto : productos) {
            System.out.println("ID: " + producto.getId() + ", Nombre: " + producto.getNombre() + ", Precio: $" + producto.getPrecio());
        }
    }

    private void agregarProducto() {
        System.out.print("Id del producto: ");
        int idpr = Integer.parseInt(scanner.nextLine());
        System.out.print("nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); 

        Producto producto = new Producto();
        producto.setId(idpr);
        producto.setNombre(nombre);
        producto.setPrecio(precio);

        operacionesProducto.agregarProducto(producto);
        System.out.println("El Producto se guardó correctamente.");
    }
}

