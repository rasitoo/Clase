package iherencia.i1supermercado.DAO;

import java.util.List;

public interface DAOBase <T> {
    public boolean anadir(T dato);
    public T recuperarPorId(int id);
    public boolean modificar(T dato);
    public boolean borrar(T dato);
    public List<T> listar ();

}
