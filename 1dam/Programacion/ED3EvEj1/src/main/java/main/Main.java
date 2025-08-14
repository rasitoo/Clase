package main;

import dao.Builder;
import dao.Reader;
import modelo.Sala;
import servicio.Service;
import ui.Interfaz;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int opc;
        List<Sala> salas = null;
        double  saturacionTotal=0;
        int numeroClientesActualesTotales=0;
        Builder builder = new Builder();
        Service service = new Service();
        do {
            System.out.println("1-Generar automáticamente las salas ");
            System.out.println("2-Añade Sala");
            System.out.println("3-Mostrar Sala Mayor Aforo");
            System.out.println("4-Mostrar Sala Menor Aforo");
            System.out.println("5-Mostrar saturación");
            System.out.println("6-Mostar Aforo total libre");
            System.out.println("0-Salir");
            opc = Interfaz.leerNum();

            switch(opc){
                case 1:
                    System.out.println("Número de salas");
                    int numSalas= Interfaz.leerNum();
                    numeroClientesActualesTotales = (int) (Math.random() * 500);
                    System.out.println("Numero de clientes: " + numeroClientesActualesTotales);
                    salas = builder.construirSalas(numSalas);
                    System.out.println("Salas: " + salas);
                    break;
                case 2:
                    break;
                case 3:    //conseguir Sala con mayor aforo
                    Sala salaMaxAforo = Service.getSalaMaxAforo(salas);
                    System.out.println("Sala mayor aforo: " + salaMaxAforo);
                    break;
                case 4:        //Conseguir Sala con menor aforo
                    Sala salaMinAforo = Service.getSalaMinAforo(salas);
                    System.out.println("Sala menor aforo: " + salaMinAforo);
                    break;
                case 5:        //conseguir saturacion total
                    double saturacion = Reader.getSaturacion(salas);

                    saturacionTotal=saturacion/salas.size();
                    System.out.println("Saturación total: " + saturacionTotal);
                    break;
                case 6:System.out.println("Indice calidad: " + service.calidadEspacios(saturacionTotal));
                    System.out.println("Aforo total libre: " + service.calculoAforoTotalLibre(salas, numeroClientesActualesTotales));
                    break;
                default:
                    System.out.println("OpciÃ³n incorrecta");
                    break;
            }
            System.out.println("Dar opción");

        } while (opc!=0);

    }

}
