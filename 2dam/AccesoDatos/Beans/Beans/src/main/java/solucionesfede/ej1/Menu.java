package solucionesfede.ej1;

import java.util.Scanner;

public class Menu {
    private GestorDatos gestorDatos;

    public Menu(GestorDatos gestorDatos) {
        this.gestorDatos = gestorDatos;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Listar Clientes");
            System.out.println("2. Listar Productos");
            System.out.println("3. Agregar Cliente");
            System.out.println("4. Agregar Producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    listarClientes();
                    break;
                case 2:
                    listarProductos();
                    break;
                case 3:
                    agregarCliente(scanner);
                    break;
                case 4:
                    agregarProducto(scanner);
                    break;
                case 5:
                    System.out.println("Fin del Programa!");
                    break;
                default:
                    System.out.println("Opcion Erronea, intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    private void listarClientes() {
            if (gestorDatos.obtenerClientes().isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Cliente cliente : gestorDatos.obtenerClientes()) {
                System.out.println("ID: " + cliente.getId() + ", Nombre: " + cliente.getNombre() + ", Correo: " + cliente.getEmail()
                        + ", Teléfono: " + cliente.getTelefono());
            }
        }
    }


    private void listarProductos() {
         if (gestorDatos.obtenerProductos().isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Producto producto : gestorDatos.obtenerProductos()) {
                System.out.println("ID: " + producto.getId() + ", Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio()+" Euros");
            }
        }
    }


    private void agregarCliente(Scanner scanner) {
        System.out.print("ID del cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("correo: ");
        String correo = scanner.nextLine();
        System.out.print("telefono: ");
        String telefono = scanner.nextLine();

        Cliente nuevoCliente = new Cliente(id, nombre, correo, telefono);
        gestorDatos.agregarCliente(nuevoCliente);
        System.out.println("El cliente se ha insertado correctamente.");
    }

    private void agregarProducto(Scanner scanner) {
        System.out.print("ID del  producto: ");
        int id = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("precio: ");
        double precio = scanner.nextDouble();

        Producto nuevoProducto = new Producto(id, nombre, precio);
        gestorDatos.agregarProducto(nuevoProducto);
        System.out.println("El producto se ha insertado correctamente.");
    }
}

