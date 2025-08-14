package dao;

import modelo.Sala;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * @author Rodrigo
 * @date 23 mayo, 2024
 */
public class Reader {
    public static double getSaturacion(List<Sala> salas) {
        double saturacion = 0.0;
        for (Sala sala : salas) {
            saturacion = saturacion + (BigDecimal.valueOf((double) sala.getSocios() / sala.getAforo()).setScale(2, RoundingMode.HALF_UP).doubleValue());
        }
        return saturacion;
    }

    public static int getAforoTotal(List<Sala> salas, int aforoTotal) {
        for (Sala gimnasio : salas) {
            aforoTotal = aforoTotal + gimnasio.getAforo();
        }
        return aforoTotal;
    }
}
