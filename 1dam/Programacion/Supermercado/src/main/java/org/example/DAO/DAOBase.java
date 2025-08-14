package org.example.DAO;

import BBDD.example.Configuracion.Persona;

import java.util.List;

public interface DAOBase <T> {
    public boolean anadir(T dato);
    public T recuperarPorId(int id);
    public boolean modificar(T dato);
    public boolean borrar(T dato);
    public List<T> listar ();

}
