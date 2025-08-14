package iherencia.i1supermercado.modelo;

import lombok.Data;

/**
 * @author Rodrigo
 * @date 09 abril, 2024
 */
@Data
public class Clientes extends Usuario {
    private Producto[] compras;
    private boolean preferente;
}
