package iherencia.i1supermercado.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cliente {
    int id;
    String nombre;
    double dineroGastado;
}
