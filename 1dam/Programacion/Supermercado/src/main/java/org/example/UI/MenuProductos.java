package org.example.UI;

import BBDD.example.Configuracion.ConexionBD;
import org.example.modelo.Cliente;
import org.example.modelo.Compra;
import org.example.modelo.Producto;
import org.example.servicios.ServicioClientes;
import org.example.servicios.ServicioCompra;
import org.example.servicios.ServicioProductos;
import org.example.servicios.ServicioProductosBBDD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;



public class MenuProductos {
    Cliente cliente;
    Scanner sc= new Scanner(System.in);
    ConexionBD conexion=new ConexionBD();
    ServicioProductosBBDD servicioProductos= new ServicioProductosBBDD(conexion);
    ServicioClientes servicioClientes;
    ServicioCompra servicioCompra=new ServicioCompra(conexion);

    public MenuProductos(Cliente c,ServicioClientes servicioClientes) throws SQLException, ClassNotFoundException {
        this.cliente=c;
        this.servicioClientes=servicioClientes;
    }

    void menu(){
       int opc=0;
       String opcTxt;
        do   {
            mostrarOpciones();
            opcTxt=sc.nextLine();
            opc= Integer.parseInt(opcTxt);
            try {
                switch (opc) {
                    case 1:
                        pedirDatosAltaProd();
                    case 2:
                        comprarProducto(cliente);
                    case 3:
                        listarProductos();
                        break;
                    case 4:
                        listarCompras();
                        break;
                    case 0:
                        System.out.println("Hasta luego, muchas gracias por comprar");
                        break;
                    default:
                        System.out.println("Opción incorrecta");;
                }
            }catch (NumberFormatException e) {
                System.out.println("opción incorrecta");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }while(opc!= 0);
    }
    private void pedirDatosAltaProd() throws Exception {
        System.out.println("nombre Producto");
        String nomProd=sc.nextLine();
        System.out.println("precio");
        String opcTxt0=sc.nextLine();
        double  precio = Integer.parseInt(opcTxt0);
        System.out.println("cantidad");
       String opcTxt=sc.nextLine();
       int  cant = Integer.parseInt(opcTxt);
        if (servicioProductos.anadirProducto(nomProd, precio,cant))
            System.out.println("operación correcta");
        else
            System.out.println("Error en la operación de alta de producto.");
    }
    public void comprarProducto(Cliente c) throws Exception {
        System.out.println("Elegir nombre producto");
        String nombre=sc.nextLine();
        Producto p=servicioProductos.comprarProducto(nombre);
        System.out.println("Elegir cantidad");
        String opcTxt=sc.nextLine();
        int  cant = Integer.parseInt(opcTxt);
        if (servicioProductos.verificarStock(p,cant)){
            double precioTotal= servicioProductos.modificarProducto(p,cant);
            servicioClientes.modificarCliente(c,precioTotal);
            Compra nueva=new Compra(c.getId(), p.getId(), cant);
            Compra tmp=servicioCompra.sacarCompra(nueva);
            if (tmp!=null){
                servicioCompra.modificarCompra(nueva);
            }
            else {
                servicioCompra.anadirCompra(nueva);
            }
            System.out.println("operación correcta");
        }
        else
            System.out.println("Error en la operación de compra de producto.");
    }
    public void listarProductos(){
        List<Producto> listProd=servicioProductos.obtenerTodosProductos();
        listProd.stream().forEach(System.out::println);
    }
    public void listarCompras(){
        List<Compra> listCom=servicioCompra.sacarCompras(cliente);
        listCom.stream().forEach(System.out::println);
    }
    void mostrarOpciones() {
        System.out.println("1-Alta producto");
        System.out.println("2-Comprar producto");
        System.out.println("3-listar productos");
        System.out.println("4-Sacar compras");
        System.out.println("0-salir");
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

    }

}
