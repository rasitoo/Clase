package org.example.ConClone;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Direccion implements Cloneable {
    String calle;
    int numero;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
