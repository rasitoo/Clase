package iherencia.i3interfazordenar;

import lombok.Data;

/**
 * @author Rodrigo
 * @date 12 abril, 2024
 */
@Data
public class Persona implements Ordenable {
    private String nombre;
    private int edad;

    Persona(){
        this.nombre = null;
        this.edad = (int) (Math.random() * 100);
    }

    @Override
    public boolean esMayor(Ordenable o) {
        if (o instanceof Persona){
            Persona p = (Persona) o;
            return edad > p.getEdad();
        }
        return false;
    }

    @Override
    public boolean esMenor(Ordenable o) {
        if (o instanceof Persona){
            Persona p = (Persona) o;
            return edad < p.getEdad();
        }
        return false;
    }
}
