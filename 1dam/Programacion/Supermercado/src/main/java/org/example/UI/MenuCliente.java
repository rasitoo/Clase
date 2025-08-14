package org.example.UI;

import BBDD.example.Configuracion.ConexionBD;
import org.example.modelo.Cliente;
import org.example.servicios.ServicioClientes;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuCliente {
    ConexionBD conexion=new ConexionBD();
    ServicioClientes servicioClientes=new ServicioClientes(conexion);
    Scanner sc=new Scanner(System.in);
    public MenuCliente() throws SQLException, ClassNotFoundException {
    }

    public void menu() throws Exception {
        int opc = 0;
        String opcTxt;
        do {
            System.out.println("1-Alta cliente");
            System.out.println("2-Listar clientes");
            System.out.println("3-login");
            System.out.println("0-Salir");
            opcTxt = sc.nextLine();
            opc = Integer.parseInt(opcTxt);
            switch (opc) {
                case 1:
                    pedirDatosAlta();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                   login();
                    break;
                case 0:
                    System.out.println("Hasta luego");break;
                default: System.out.println("Opción incorrecta");
            }

        } while (opc != 0);
    }

    private void pedirDatosAlta() throws Exception {
        System.out.println("nombre");
        String nom=sc.nextLine();
        if (servicioClientes.anadirCliente(nom)){
        System.out.println("operación correcta");}
        else
            System.out.println("Error en la operación de alta de cliente.");
    }
    private void listarClientes() throws Exception {
        List<Cliente> listCli=servicioClientes.obtenerTodosClientes();
        listCli.stream().forEach(System.out::println);
    }
    private void login() throws SQLException, ClassNotFoundException {
    System.out.println("Escribe tu id");
    int id=sc.nextInt();
    Cliente actual=servicioClientes.UsuarioCliente(id);
    if (actual!=null){
        MenuProductos menu=new MenuProductos(actual,servicioClientes);
        menu.menu();
    }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MenuCliente menuCliente=new MenuCliente();
        try {
            menuCliente.menu();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
