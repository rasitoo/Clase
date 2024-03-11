package dejemarrays.d16Hotel;

/**
 * @author Rodrigo🦖
 * @date 08 diciembre, 2023
 */
public class Reserva {
    int dia;
    int habitacion;
    Reserva(int dia, int habitacion){
        this.dia = dia;
        this.habitacion = habitacion;
    }
    void mostrar(){
        System.out.println("habitación: " + habitacion + "\t Día: " + dia);
    }
}
