package org.example.ConCloneable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Direccion extends ClonableJM{
    String calle;
    int numero;
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
