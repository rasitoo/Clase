package Aparcamiento.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EstanciaEnAparcamiento {
    Fecha entrada=null;
    Fecha salida=null;
}
