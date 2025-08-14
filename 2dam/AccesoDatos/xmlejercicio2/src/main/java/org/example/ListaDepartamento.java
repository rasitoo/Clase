package org.example;

import java.util.ArrayList;
import java.util.List;
// import com.thoughtworks.xstream.XStream;
//import javax.xml.transform.stream.*; ¿¿¿???

class ListaDepartamento {
    private List<Departamento> lista = new ArrayList<Departamento>();

    public ListaDepartamento(){ }

    public void add(Departamento dep) {
        lista.add(dep);
    }
    public List<Departamento> getListaDepartamentos() {
        return lista;
    }
}//fin ListaDepartamentos

