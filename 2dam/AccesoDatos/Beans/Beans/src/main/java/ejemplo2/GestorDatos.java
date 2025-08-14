package ejemplo2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rodrigo
 * @date 12 febrero, 2025
 */
public class GestorDatos {
    private List<Cliente> clientes;
    private List<Producto> productos;

    public GestorDatos(){
        clientes = new ArrayList<>();
        productos = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void addProducto(Producto producto) {
        productos.add(producto);
    }
}
