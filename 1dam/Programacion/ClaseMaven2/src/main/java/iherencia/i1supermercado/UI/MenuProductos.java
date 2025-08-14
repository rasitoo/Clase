package iherencia.i1supermercado.UI;

import iherencia.i1supermercado.modelo.Producto;
import iherencia.i1supermercado.servicios.ServicioProductos;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MenuProductos {
    Scanner sc = new Scanner(System.in);
    ServicioProductos servicioProductos = new ServicioProductos();

    void menu() {
        int opc = 0;
        String opcTxt;
        do {
            mostrarOpciones();
            opcTxt = sc.nextLine();
            opc = Integer.parseInt(opcTxt);
            try {
                opc = Integer.parseInt(opcTxt);
                switch (opc) {
                    case 1:
                        pedirDatosAltaProd();
                    case 2:
                        comprarProducto();
                    case 3:
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                        ;
                }
            } catch (NumberFormatException e) {
                System.out.println("opción incorrecta");
            }
        } while (opc != 0);
    }

    private void pedirDatosAltaProd() {
        System.out.println("nombre Producto");
        String nomProd = sc.nextLine();
        System.out.println("precio");
        double precio = sc.nextDouble();
        System.out.println("cantidad");
        int cant = sc.nextInt();
        if (servicioProductos.darAltaProducto(nomProd, precio, cant))
            System.out.println("operación correcta");
        else
            System.out.println("Error en la operación de alta de producto.");

    }

    public void comprarProducto() {
        List<Producto> listProd = servicioProductos.obtenerListadoProductos();
        listProd.stream().forEach(System.out::println);
        System.out.println("Elegir id producto");
        int id = sc.nextInt();
        servicioProductos.existeProducto(id);
        System.out.println("Elegir cantidad");
        int cant = sc.nextInt();
        if (servicioProductos.verificarStock(id, cant)) {
            double precioTotal = servicioProductos.comprar(id, cant);
            System.out.println("operación correcta");
        } else
            System.out.println("Error en la operación de compra de producto.");
    }

    void mostrarOpciones() {
        System.out.println("1-Alta producto");
        System.out.println("2-Comprar producto");
        System.out.println("3-listar productos");
        System.out.println("0-salir");
    }

}
