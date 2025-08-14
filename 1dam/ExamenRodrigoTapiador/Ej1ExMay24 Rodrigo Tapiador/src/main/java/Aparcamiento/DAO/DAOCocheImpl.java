package Aparcamiento.DAO;

import Aparcamiento.comunes.Color;
import Aparcamiento.comunes.Datos;
import Aparcamiento.modelo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DAOCocheImpl implements DAOCoche {
    private final static String TABLA = "BDPRUEBA1.coche";
    List<Coche> coches = null;
    private Connection conexion = null;

    public DAOCocheImpl(Connection con) {
        this.conexion = con;
        coches = new ArrayList<>();
    }

    @Override
    public void anadirCoche(Coche coche) {
        coches.add(coche);
        if (coche instanceof CocheFijo)
            try {
                PreparedStatement ps = conexion.prepareStatement("INSERT INTO BDPRUEBA1.coche(matricula, dni) VALUES (?,?)");
                ps.setString(1, coche.getMatricula());
                if (coche instanceof CocheFijo) {
                    ps.setString(2, ((CocheFijo) coche).getCliente().getDni());
                }
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
    }

    @Override
    public boolean borrarCoche(String matricula) {
        return false;
    }

    @Override
    public boolean modificarCoche(String matricula, Coche c) {
        return false;
    }

    @Override
    public Coche buscarCoche(String matricula) {
        for (int i = 0; i < coches.size(); i++) {
            if (coches.get(i).getMatricula().equals(matricula)) {
                return coches.get(i);
            } else return new CocheEsporadico(matricula);
        }
        //EN BD
//        try {
//            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM BDPRUEBA1.coche WHERE matricula = ?");
//            ps.setString(1, matricula);
//            ps.executeQuery();
//            ResultSet clienteAux = ps.executeQuery();
//            if (clienteAux.next()) {
//                String dni = clienteAux.getString("dni");
//                Coche c = new Coche(matricula, Color.OTROS);
//                return c;
//            } else
//                return null;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
        return null;
    }

    @Override
    public List<String> obtenerTodasCochesFijos(String dni) {
        List<String> matriculasCoches = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM BDPRUEBA1.coche WHERE dni = ?");
            ps.setString(1, dni);
            ResultSet cocheAux = ps.executeQuery();
            while (cocheAux.next()) {
                String matricula = cocheAux.getString("matricula");
                matriculasCoches.add(matricula);
            }
            return matriculasCoches;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<String> obtenerTodosClientes() {
        List<String> dniClientes = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM BDPRUEBA1.coche");
            ResultSet cocheAux = ps.executeQuery();
            while (cocheAux.next()) {
                String dni = cocheAux.getString("dni");
                dniClientes.add(dni);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return dniClientes;
    }


    public List<CocheFijo> obtenerTodasCochesFijosBD() {
        List<CocheFijo> cochesFijos = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM BDPRUEBA1.coche");
            ResultSet cocheAux = ps.executeQuery();
            while (cocheAux.next()) {
                String matricula = cocheAux.getString("matricula");
                String dni = cocheAux.getString("dni");
                cochesFijos.add(new CocheFijo(new Cliente(dni), matricula));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return cochesFijos;
    }

    @Override
    public List<String> obtenerMatriculasTodosCocheMes(int mes) {

        int ano = new Fecha().getAno();
        ArrayList<String> matriculas = new ArrayList<>();
        for (int i = 0; i < coches.size(); ++i) {
            if (coches.get(i) instanceof CocheFijo) {
                matriculas.add(coches.get(i).getMatricula());
            } else {
                List<EstanciaEnAparcamiento> historial = ((CocheEsporadico) coches.get(i)).getHistorial();
                for (int j = 0; j < historial.size(); j++) {
                    if (historial.get(j).getEntrada().getMes() == mes) {
                        matriculas.add(coches.get(i).getMatricula());
                    }
                }

            }
        }
        return matriculas;
    }

    @Override
    public double pagoClienteFijo(String dni) {
        double precio = 0;
        int numcoches = 0;
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM BDPRUEBA1.coche WHERE dni = ?");
            ps.setString(1, dni);
            ps.executeQuery();
            ResultSet clienteAux = ps.executeQuery();
            while (clienteAux.next()) {
                numcoches++;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
        Datos datos = Datos.getDatos();
        double cuotames = datos.getCuotaMes();
        for (int i = 0; i < numcoches; i++) {
            precio += cuotames - ((i * datos.getDescuentoMes() * 100));
        }
        return precio;
    }

    @Override
    public Cliente obtenerClienteCocheFijo(String matricula) {
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM BDPRUEBA1.coche WHERE matricula = ?");
            ps.setString(1, matricula);
            ps.executeQuery();
            ResultSet clienteAux = ps.executeQuery();
            if (clienteAux.next()) {
                String dni = clienteAux.getString("dni");
                Cliente p = new DAOClienteImpl().buscarCliente(dni);
                return p;
            } else
                return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


}
