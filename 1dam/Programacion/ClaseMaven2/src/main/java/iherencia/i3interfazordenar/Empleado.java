package iherencia.i3interfazordenar;

import lombok.Data;

/**
 * @author Rodrigo
 * @date 12 abril, 2024
 */
@Data
public class Empleado extends Persona {
    private int antiguedad;


    Empleado(){
        this.antiguedad = (int) (Math.random() *50);
    }
    @Override
    public boolean esMenor(Ordenable o) {
        if (o instanceof Empleado){
            Empleado p = (Empleado) o;
            return antiguedad < p.getAntiguedad();
        }
        return false;
    }

    @Override
    public boolean esMayor(Ordenable o) {
        if (o instanceof Empleado){
            Empleado p = (Empleado) o;
            return antiguedad > p.getAntiguedad();
        }
        return false;
    }
}
