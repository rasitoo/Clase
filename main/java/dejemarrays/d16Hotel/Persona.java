package dejemarrays.d16Hotel;

/**
 * @author Rodrigo🦖
 * @date 08 diciembre, 2023
 */
public class Persona {
    String DNI;
    String nombre;
    Reserva[] reservas = new Reserva[30];

    Persona(String DNI, String nombre) {
        this.DNI = DNI;
        this.nombre = nombre;
    }

    Reserva anadirReserva(Habitacion habitacion, int dia) {
        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] == null) {
                reservas[i] = new Reserva(dia, habitacion.planta * 100 + habitacion.habitacion);
                return reservas[i];
            }
        }
        return null;
    }

    void mostrarReservas() {
        for (int i = 0; i < reservas.length; i++){

            if (reservas[i] != null) {
                System.out.print(i + "\t");
                reservas[i].mostrar();
            }
        }
    }
}
