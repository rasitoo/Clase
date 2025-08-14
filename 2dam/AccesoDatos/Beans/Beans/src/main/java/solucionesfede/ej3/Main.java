package solucionesfede.ej3;

import java.util.Scanner;
    public class Main {

            public static void main(String[] args) {

                Scanner sc = new Scanner(System.in);

                Operaciones operaciones = new Operaciones();

                int opcion;


                do {

                    System.out.println("\nSeleccione una opción:");
                    System.out.println("1. Listar Clientes");
                    System.out.println("2. Listar Productos");
                    System.out.println("3. Listar Pedidos");
                    System.out.println("4. InsertarCliente");
                    System.out.println("5. InsertarProducto");
                    System.out.println("6. InsertarPedido");
                    System.out.println("7. Salir");
                    System.out.print("Ingrese su opción: ");


                    opcion = sc.nextInt();


                    switch (opcion) {
                        case 1:

                            System.out.println("\nLISTADO DE CLIENTES:");
                            System.out.println("--------------------");
                            for (Cliente cliente : operaciones.GuardarClientes()){
                                System.out.println("ID: " + cliente.getId() + ", Nombre: " + cliente.getNombre() + ", Correo:" + cliente.getEmail());
                            }
                            break;

                        case 2:

                            System.out.println("\nLISTADOS DE PRODUCTOS:");
                            for (Producto producto : operaciones.GuardarProductos()) {
                                System.out.println("ID: " + producto.getId() + ", Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
                            }
                            break;

                        case 3:
                            System.out.println("\nLISTADO DE PEDIDOS:");
                            for (Pedido pedido : operaciones.GuardarPedidos()) {
                                System.out.println("ID Pedido: " + pedido.getId() + ", ID Cliente: " + pedido.getClienteId() +
                                        ", ID Producto: " + pedido.getProductoId() + ", Cantidad: " + pedido.getCantidad());
                            }
                            break;

                        case 4:

                            System.out.println("\nInsertar un cliente");
                            Cliente nuevoClie = new Cliente(3, "Carlos Diaz", "carlosdias@gmail.com");
                            operaciones.InsertarCliente(nuevoClie);
                            System.out.println("Insertado ID: " + nuevoClie.getId() + ", Nombre: " + nuevoClie.getNombre() + ", Correo:" + nuevoClie.getEmail());
                            break;

                        case 5:

                            System.out.println("\n Insertar un Producto ");
                            Producto nuevoProd = new Producto(3, "Teclados", 30.00);
                            operaciones.InsertarProducto(nuevoProd);
                            System.out.println("Insertado Producto ID: " + nuevoProd.getId() + ", Nombre: " + nuevoProd.getNombre() + ", Precio: " + nuevoProd.getPrecio());
                            break;

                        case 6:

                            System.out.println("\n Insertar un pedido ");
                            Pedido nuevoPedido = new Pedido(3, 3, 3, 5);
                            operaciones.InsertarPedido(nuevoPedido);
                            System.out.println("Insertado Pedido ID: " + nuevoPedido.getId() + ", ID Cliente: " + nuevoPedido.getClienteId() +
                                    ", ID Producto: " + nuevoPedido.getProductoId() + ", Cantidad: " + nuevoPedido.getCantidad());
                            break;

                        case 7:
                            System.out.println("FIN DEL PROGRAMA");
                            break;

                        default:
                            System.out.println("OPCION ERRONEA");
                            break;
                    }

                } while (opcion != 7);

               sc.close();
            }
    }
