package Aparcamiento.modelo;

import Aparcamiento.comunes.Color;
import Aparcamiento.comunes.Datos;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.IOException;

@EqualsAndHashCode(callSuper = true)
@Data
public class CocheFijo extends Coche{
    private  Cliente cliente;

    CocheFijo(Cliente cliente, String matricula, Color color) {
        super(matricula, color);
        this.cliente = cliente;
        super.setMatricula(matricula);
    }
    public CocheFijo(Cliente cliente, String matricula) {
        //RELLENAR CODIGO crear un CocheFijo con color OTROS y cliente y matrícula recibidos
        super(matricula, Color.OTROS);
        this.cliente = cliente;

    }
    double obtenerCuotaMes()  {
       return Datos.getDatos().getCuotaMes();
    }
}
