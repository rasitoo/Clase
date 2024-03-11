package dejemarrays.d16Hotel;

import java.util.Random;

/**
 * @author Rodrigo🦖
 * @date 08 diciembre, 2023
 */
public class Habitacion {
    Random rdm = new Random();
    boolean doble;
    Persona[] reservas;
    int planta;
    int habitacion;
    Habitacion(int planta, int habitacion){
        this.planta = planta;
        this.habitacion = habitacion;
        doble = rdm.nextBoolean();
        reservas = new Persona[31];
    }
}
