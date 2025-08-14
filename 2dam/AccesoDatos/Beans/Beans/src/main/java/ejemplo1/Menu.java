package ejemplo1;

import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 12 febrero, 2025
 */
public class Menu {
    private GestorDatos ej;

    public Menu(GestorDatos ej) {
        this.ej = ej;
    }

    public void mostrarMenu() {
        System.out.println("1. Listar Clientes");
        System.out.println("2. Listar Productos");
        System.out.println("3. Agregar Cliente");
        System.out.println("4. Agregar Producto");
        System.out.println("5. Precio mas alto de los productos");
        System.out.println("6. Cliente con el nombre mas largo");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public void ejecutarMenu(Scanner sc) {
        int id;
        String nombre;

        while (true) {
            mostrarMenu();

            switch (sc.next()) {
                case "1":
                    System.out.println("--- LISTA DE CLIENTES ---");
                    for (Cliente cliente : ej.getClientes()) {
                        System.out.println("ID: " + cliente.getId() + ", Nombre: " + cliente.getNombre() + ", Correo: " + cliente.getCorreo() + ", Teléfono: " + cliente.getTelefono());
                    }
                    break;
                case "2":
                    System.out.println("--- LISTA DE PRODUCTOS ---");
                    for (Producto producto : ej.getProductos()) {
                        System.out.println("ID: " + producto.getId() + ", Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
                    }
                    break;
                case "3":
                    System.out.print("Ingrese el ID del nuevo cliente: ");
                    id = sc.nextInt();
                    System.out.print("Ingrese el nombre del nuevo cliente: ");
                    nombre = sc.next();
                    System.out.print("Ingrese el telefono del nuevo cliente: ");
                    String telefono = sc.next();
                    System.out.print("Ingrese el correo del nuevo cliente: ");
                    String correo = sc.next();

                    ej.addCliente(new Cliente(id, nombre, correo, telefono));
                    System.out.println("El cliente se ha insertado correctamente");

                    break;
                case "4":
                    System.out.print("Ingrese el ID del nuevo producto: ");
                    id = sc.nextInt();
                    System.out.print("Ingrese el nombre del nuevo producto: ");
                    nombre = sc.next();
                    System.out.print("Ingrese el precio del nuevo producto: ");
                    double precio = sc.nextDouble();

                    ej.addProducto(new Producto(id, nombre, precio));
                    break;
                case "5":
                    System.out.println("El precio más alto de los productos es: " + ej.getProductos().stream().mapToDouble(Producto::getPrecio).max().orElse(0.0));
                    break;
                case "6":
                    System.out.println("El cliente con el nombre más largo es: " + ej.getClientes().stream().max(Comparator.comparingInt(c -> c.getNombre().length())).map(Cliente::getNombre).orElse("No hay clientes"));
                    break;
                case "0":
                    System.out.println("Saliendo");
                    return;
            }
        }
    }
}
