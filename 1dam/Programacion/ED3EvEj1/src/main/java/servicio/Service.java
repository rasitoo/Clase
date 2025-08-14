package servicio;

import dao.Reader;
import modelo.Sala;

import java.util.List;

public class Service {
    public static Sala getSalaMaxAforo(List<Sala> salas) {
        double mayorAforo = Double.MIN_VALUE;
        Sala salaMaxAforo = null;
        for (int i = 0; i < salas.size(); i++) {
            Sala sala = salas.get(i);
            if (sala.getAforo() > mayorAforo) {
                mayorAforo = sala.getAforo();
                salaMaxAforo = sala;
            }
        }
        return salaMaxAforo;
    }

    public static Sala getSalaMinAforo(List<Sala> salas) {
        double menorAforo = Double.MAX_VALUE;
        Sala salaMinAforo = null;
        for (int i = 0; i < salas.size(); i++) {
            Sala sala = salas.get(i);
            if (sala.getAforo() < menorAforo) {
                menorAforo = sala.getAforo();
                salaMinAforo = sala;
            }
        }
        return salaMinAforo;
    }

    public String calidadEspacios(double saturacionTotal) {
        String calidad = "Z";
        if (saturacionTotal < 0.4) {
            calidad = "A";
        } else if (saturacionTotal > 0.4 && saturacionTotal < 0.6) {
            calidad = "B";
        } else if (saturacionTotal > 0.6) {
            calidad = "C";
        }
        return calidad;
    }
    public double calculoAforoTotalLibre(List<Sala> salas, int numeroClientesActualesTotales) {
        int aforoTotal = 0;
        aforoTotal = Reader.getAforoTotal(salas, aforoTotal);
        return aforoTotal/numeroClientesActualesTotales;
    }

}
