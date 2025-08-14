package org.example.DAO;

import com.google.gson.Gson;
import org.example.modelo.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DAOProductos implements DAOBase<Producto> {

    List<Producto> listaProductos;
    private void anadirProdsEjemplo(){
        //Aquí se podría cargar el fichero en la lista
        listaProductos.add(new Producto(1, "Manzana", 1.0, 10));
        listaProductos.add(new Producto(2, "Pera", 1.0, 10));
        listaProductos.add(new Producto(3, "Naranja", 1.0, 10));
    }
    public DAOProductos(){
        listaProductos = new ArrayList<>();

    }
    @Override
    public boolean anadir(Producto dato) {
        if (recuperarPorId(dato.getId()) != null) {
            return false;
        }
        return listaProductos.add(dato);
    }


    @Override
    public Producto recuperarPorId(int id) {
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getId() == id) {
                return listaProductos.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean borrar(Producto dato) {
        return false;
    }

    @Override
    public List<Producto> listar() {
        if (listaProductos.isEmpty()){
            return null;
        }
        else {
            List<Producto> listaNueva = clonar(listaProductos);
            return listaNueva;
        }
    }
    private List<Producto> clonar(List<Producto> lista){
        List <Producto> clon = new ArrayList<>();
        Producto paux;
       for (Producto prod:listaProductos){
            Gson gson = new Gson();
            paux = gson.fromJson(gson.toJson(prod), Producto.class);
            clon.add(paux);
        }
        return clon;
    }

    @Override
    public boolean modificar(Producto dato) {
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getId() == dato.getId()) {
                listaProductos.set(i, dato);
                return true;
            }
        }
        return false;
    }
    public int maximoId(){
        Optional<Producto> maximoidProducto= Optional.ofNullable(listaProductos.stream()
                .max((p1, p2) -> Integer.compare(p1.getId(), p2.getId())).orElse(null));
        if (maximoidProducto.isEmpty()){
            return 0;
        }
        return maximoidProducto.get().getId();
    }

    public static void main(String[] args) {
        DAOProductos d = new DAOProductos();
        d.anadirProdsEjemplo();
        System.out.println(d.maximoId());
    }

}
