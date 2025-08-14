package Aparcamiento.servicio;

import Aparcamiento.DAO.DAOCliente;
import Aparcamiento.DAO.DAOClienteImpl;
import Aparcamiento.DAO.DAOCoche;
import Aparcamiento.comunes.Color;
import Aparcamiento.modelo.Cliente;
import Aparcamiento.modelo.Coche;
import Aparcamiento.modelo.CocheEsporadico;
import Aparcamiento.modelo.CocheFijo;

import java.util.List;

public class ServicioParking {
    DAOCoche daoCoche;
    DAOCliente daoCliente;

    public ServicioParking(DAOCoche daoCoche, DAOCliente daoCliente) {
        this.daoCoche = daoCoche;
        this.daoCliente = daoCliente;
    }

    public void altaCochesFijos(Cliente c, List<String> matriculas) {
        for (String matricula : matriculas) {
            daoCoche.anadirCoche(new CocheFijo(c, matricula));
        }
    }

    public Cliente buscarCliente(String dni) {
        return daoCliente.buscarCliente(dni);
    }

    public List<String> matriculasCochesFijos(String dni) {
        return daoCoche.obtenerTodasCochesFijos(dni);
    }

    public boolean añadirCliente(Cliente c) {
        return daoCliente.anadirCliente(c);
    }

    public void obtenerTodosClientesBD() {
        //RELLENAR CODIGO Añadir todos los clientes que figuran en la BD al daoClientes
    }

    public void obtenerTodosCochesBD() {
        //RELLENAR CODIGO Añadir todos los coches que figuran en la BD al daoCoches y
        // todos los clientes
    }

    public void llegadaCoche(String matricula) {
        Coche c = daoCoche.buscarCoche(matricula);
    }

    public boolean entraCoche(String matricula) {
        if (daoCoche.buscarCoche(matricula) instanceof CocheFijo)
            return true;
        else {
            CocheEsporadico coche = new CocheEsporadico(matricula);
            daoCoche.anadirCoche(coche);
            coche.anadirEntrada();
        }
        return false;
    }

    public double salidaCoche(String matricula) {
        Coche c = daoCoche.buscarCoche(matricula);
        if (c instanceof CocheEsporadico){
            ((CocheEsporadico) c).anadirSalida();
            daoCoche.borrarCoche(matricula);

        }
        return -1; // si es fijo, si no devuelve precio
    }

    public List<String> matriculasCohesAparcamientoMes(int mes) {
        List<String> listaMats = daoCoche.obtenerMatriculasTodosCocheMes(mes);
        return listaMats;
    }

    public double pagoClienteFijo(String dni) {
        return daoCoche.pagoClienteFijo(dni);
    }

    public Cliente clienteDeCocheFijo(String matricula) {
        return daoCoche.obtenerClienteCocheFijo(matricula);
    }
}
