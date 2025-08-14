package Aparcamiento.DAO;

import Aparcamiento.modelo.Cliente;
import Aparcamiento.modelo.Coche;
import Aparcamiento.modelo.CocheFijo;

import java.util.List;

public interface DAOCoche {
    void anadirCoche(Coche c);
    boolean borrarCoche(String matricula);
    boolean modificarCoche(String matricula, Coche c);
    Coche buscarCoche(String matricula);
    List<String> obtenerTodasCochesFijos(String dni);
    List<CocheFijo> obtenerTodasCochesFijosBD( );
    public List<String> obtenerMatriculasTodosCocheMes(int mes);
    public List<String> obtenerTodosClientes();

    double pagoClienteFijo(String dni);

    Cliente obtenerClienteCocheFijo(String matricula);
}
