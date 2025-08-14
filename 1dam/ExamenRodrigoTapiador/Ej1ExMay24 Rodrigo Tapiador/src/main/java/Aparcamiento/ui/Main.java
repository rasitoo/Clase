package Aparcamiento.ui;

import Aparcamiento.DAO.Configuracion.ConexionBD;
import Aparcamiento.DAO.DAOClienteImpl;
import Aparcamiento.DAO.DAOCoche;
import Aparcamiento.DAO.DAOCocheImpl;
import Aparcamiento.modelo.Cliente;
import Aparcamiento.servicio.ServicioParking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static Teclado t = new Teclado();

    void menu(ServicioParking servicioParking) throws IOException {
        int opc;
        do {
            System.out.println("1. Alta cliente");
            System.out.println("2. Llegada coche");
            System.out.println("3. Salida coche");
            System.out.println("4. Coches usan el aparcamiento en un mes");
            System.out.println("5. Pago mensual de un cliente fijo");
            System.out.println("6. Matriculas coches fijos de un cliente");
            System.out.println("0. Fin");
            opc = t.leerInt();
            switch (opc) {
                case 1:
                    altaCliente(servicioParking);
                    break;
                case 2:
                    llegadaCoche(servicioParking);
                    break;
                case 3:
                    salidaCoche(servicioParking);
                    break;
                case 4:
                    cochesEnAparcamientoMes(servicioParking);
                    break;
                case 5:
                    pagoMensualClienteFijo(servicioParking);
                    break;
                case 6:
                    matriculasCochesFijosCliente(servicioParking);
                    break;
                case 0:
                    System.out.println("Fin");
            }
        } while (opc != 0);
    }

    private void pagoMensualClienteFijo(ServicioParking servicioParking) throws IOException {
        System.out.println("DNI: ");
        String dni = t.leerString();
        if (servicioParking.buscarCliente(dni) == null) {
            System.out.println("El cliente no existe");
        } else {
            double precio = servicioParking.pagoClienteFijo(dni);
            System.out.println("El cliente de dni " + dni + " tiene que pagar " + precio);
        }
    }

    private void cochesEnAparcamientoMes(ServicioParking servicioParking) throws IOException {
        System.out.println("mes");
        int mes = Integer.parseInt(t.leerString());
        List<String> listaMats = servicioParking.matriculasCohesAparcamientoMes(mes);
        listaMats.stream().forEach(m -> System.out.println("MAT:" + m));
    }


    private void llegadaCoche(ServicioParking servicioParking) throws IOException {
        System.out.println("Matrícula coche");
        String matricula = t.leerString();
        if (servicioParking.entraCoche(matricula))
            System.out.println("Coche FIJO");
        else
            System.out.println("Coche Esporádico");
    }

    private void salidaCoche(ServicioParking servicioParking) throws IOException {
        System.out.println("Matrícula coche");
        String matricula = t.leerString();
        double d = servicioParking.salidaCoche(matricula);
        if (d < 0) {
            Cliente c = servicioParking.clienteDeCocheFijo(matricula);
            if (c != null)
                System.out.println("Propietario de " + matricula + " " + c.getNombre());
        } else
            System.out.println("El precio es " + d);
    }

    private static void matriculasCochesFijosCliente(ServicioParking servicioParking) throws IOException {
        System.out.println("DNI: ");
        String dni = t.leerString();
        if (servicioParking.buscarCliente(dni) == null) {
            System.out.println("El cliente no existe");
        } else {
            servicioParking.matriculasCochesFijos(dni).stream().forEach(c -> System.out.println("Mat:" + c + ":"));
        }
    }

    private static void altaCliente(ServicioParking servicioParking) throws IOException {
        String matricula, nombre = "nadie", cuenta = "no hay";

        List<String> matriculas = new ArrayList<>();
        System.out.println("DNI: ");
        String dni = t.leerString();
        Cliente c = servicioParking.buscarCliente(dni);
        if (c != null) {
            System.out.println("El cliente ya existe, añadiremos matrículas");
        } else {
            System.out.println("Nombre: ");
            nombre = t.leerString();
            System.out.println("Cuenta: ");
            cuenta = t.leerString();
            c = new Cliente(dni, nombre, cuenta);
            servicioParking.añadirCliente(c);
        }
        System.out.println("dar matrículas e introduce F para finalizar");
        do {
            matricula = t.leerString();
            if (!matricula.equals("F") && !matricula.equals("f"))
                matriculas.add(matricula);
        } while (!matricula.equals("F") && !matricula.equals("f"));
        if (!matriculas.isEmpty()) ;
        servicioParking.altaCochesFijos(c, matriculas);
    }

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        ConexionBD conexion = new ConexionBD();
        try (Connection con = conexion.getConexionBD()) {
            DAOCoche daoCoche = new DAOCocheImpl(con);
            ServicioParking servicioParking = new ServicioParking(daoCoche, new DAOClienteImpl());
            // servicioParking.obtenerTodosClientesBD();
            servicioParking.obtenerTodosCochesBD();
            m.menu(servicioParking);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}