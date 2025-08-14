package org.example.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Compra {
    int idUusario;
    int idProducto;
    int cantidad;
}
