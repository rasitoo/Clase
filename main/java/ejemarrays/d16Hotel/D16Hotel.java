package ejemarrays.d16Hotel;

import expresionesbooleanas.Teclado;

import java.io.IOException;
import java.util.Objects;

/**
 * @author Rodrigo🦖
 * @date 08 diciembre, 2023
 */
public class D16Hotel {
    final static int PLANTAS = 10;
    final static int HABITACIONESPLANTA = 12;

    Habitacion[][] habitacioneshotel = new Habitacion[PLANTAS][HABITACIONESPLANTA];

    Persona[] personas = new Persona[1000];

    D16Hotel() {
        for (int i = 0; i < habitacioneshotel.length; i++) {
            for (int j = 0; j < habitacioneshotel[i].length; j++) {
                habitacioneshotel[i][j] = new Habitacion(i, j);
            }
        }
    }

    void pedirReserva(Teclado sc) throws IOException {
        boolean reservado = false;
        int habitacionReserva;

        System.out.println("Introduce el DNI: ");
        String DNI = sc.leerString();
        int posPersona = buscarDNI(DNI);

        if (posPersona == -1) {
            System.out.println("Ese DNI no está en nuestro sistema, introduce el nombre: ");
            String nombre = sc.leerString();
            anadirPersona(new Persona(DNI, nombre));
            posPersona = buscarDNI(DNI);
        }

        System.out.println("Quiere habitacion doble? 0 = no, 1 = si");
        int doble1 = sc.leerInt();
        boolean doble = (doble1 != 0);

        System.out.println("Qué día desea reservar?");
        int dia = sc.leerInt();
        if (dia > 31 || dia < 1) {
            System.out.println("dia no valido, introduce otro: ");
            dia = sc.leerInt();
        }

        while (!reservado) {
            habitacionReserva = buscarHabitacionLibre(doble, dia);
            if (reservar(posPersona, habitacionReserva, dia)) {
                reservado = true;
            }
        }
    }

    boolean reservar(int pos, int numhabitacion, int dia) {
        boolean ok = false;
        int piso = pisoHabitacion(numhabitacion);
        int hab = numhabitacion - pisoHabitacion(numhabitacion) * 100;
        if (habitacionLibre(habitacioneshotel[piso][hab], dia)) {
            habitacioneshotel[piso][numhabitacion].reservas[dia] = personas[pos];
            Reserva reserva = personas[pos].anadirReserva(habitacioneshotel[piso][numhabitacion], dia);
            System.out.print("Felicidades, ha reservado la ");
            reserva.mostrar();
            ok = true;
        }
        return ok;
    }

    int buscarDNI(String DNI) {
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) break;
            else if (Objects.equals(DNI, personas[i].DNI)) {
                return i;
            }
        }
        return -1;
    }

    Persona buscarPersona(int posicion) {
        return personas[posicion];
    }

    int buscarHabitacionLibre(boolean doble, int dia) {
        for (int i = 0; i < habitacioneshotel.length; i++) {
            for (int j = 0; j < habitacioneshotel[i].length; j++) {
                if (habitacioneshotel[i][j].doble == doble && habitacioneshotel[i][j].reservas[dia] == null) {
                    return habitacioneshotel[i][j].planta * 100 + habitacioneshotel[i][j].habitacion;
                }
            }
        }
        return -1;
    }

    int buscarHabitacion(boolean doble, int dia) {
        for (int i = 0; i < habitacioneshotel.length; i++) {
            for (int j = 0; j < habitacioneshotel[i].length; j++) {
                if (habitacioneshotel[i][j].doble == doble) {
                    return habitacioneshotel[i][j].planta * 100 + habitacioneshotel[i][j].habitacion;
                }
            }
        }
        return -1;
    }

    int pisoHabitacion(int habitacion) {
        return habitacion / 100;
    }

    boolean habitacionLibre(Habitacion habitacion, int dia) {
        if (habitacion.reservas[dia] != null) {
            return false;
        }
        return true;
    }

    void anadirPersona(Persona persona) {
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                personas[i] = persona;
                break;
            }
        }
    }

    void anularReserva(Teclado sc) throws IOException {
        System.out.println("Indica el DNI de la persona: ");
        String DNI = sc.leerString();

        int posPersona = buscarDNI(DNI);
        if (posPersona == -1) System.out.println("Error, esa persona no existe");
        else {
            personas[posPersona].mostrarReservas();
            System.out.println("Que numero de reserva desea anular?");
            int numReserva = sc.leerInt();
            if (personas[posPersona].reservas[numReserva] != null) {
                int hab = personas[posPersona].reservas[numReserva].habitacion;
                int dia = personas[posPersona].reservas[numReserva].dia;
                int piso = pisoHabitacion(hab);
                int habitacion = hab - piso * 100;
                habitacioneshotel[piso][habitacion].reservas[dia] = null;
                personas[posPersona].reservas[numReserva] = null;
                System.out.println("reserva anulada con exito");
            } else System.out.println("no existe esa reserva");
        }
    }

    void plano(int dia) {
        for (int i = 0; i < habitacioneshotel.length; i++) {
            for (int j = 0; j < habitacioneshotel[i].length; j++) {
                if (i == 0) System.out.print("00" + habitacioneshotel[i][j].habitacion + ":");
                else System.out.print(habitacioneshotel[i][j].planta * 100 + habitacioneshotel[i][j].habitacion + ":");
                if (habitacioneshotel[i][j].reservas[dia] != null) System.out.print("X");
                else if (habitacioneshotel[i][j].doble) System.out.print("D");
                else System.out.print("s");
                System.out.print("\t");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) throws IOException {
        D16Hotel ej = new D16Hotel();
        Teclado sc = new Teclado();
        Persona[] personasnuevas = {new Persona("12345678A", "Juan Pérez"), new Persona("87654321B", "Ana García"), new Persona("23456789C", "Luis Rodríguez"), new Persona("98765432D", "María López"), new Persona("34567890E", "Pedro Sánchez"), new Persona("09876543F", "Laura Martínez"), new Persona("45678901G", "Carlos González"), new Persona("10987654H", "Sara Fernández"), new Persona("56789012I", "José García"), new Persona("21098765J", "Elena Pérez")};
        for (int i = 0; i < personasnuevas.length; i++) {
            ej.anadirPersona(personasnuevas[i]);
        }
        ej.pedirReserva(sc);
        ej.pedirReserva(sc);
        ej.anularReserva(sc);
        ej.plano(3);
    }
}
