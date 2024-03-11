package gficheros.gb7agenda;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Rodrigo
 * @date 15 febrero, 2024
 */

class Fecha {
    private int año;
    private int mes;
    private int dia;

    public boolean esBisiesto() {
        GregorianCalendar c = new GregorianCalendar(año, 11, 31);
        return c.isLeapYear(año);
    }

    public void siguiente() throws Exception {
        GregorianCalendar c = new GregorianCalendar(año, mes - 1, dia);
        int diaDelAño = c.get(Calendar.DAY_OF_YEAR);
        if ((!esBisiesto() && diaDelAño != 365) || diaDelAño != 366) {
            c.add(Calendar.DAY_OF_YEAR, 1);
            mes = 1 + c.get(Calendar.MONTH);
            dia = c.get(Calendar.DAY_OF_MONTH);
        } else throw new Exception("Fecha generada incorrecta");
    }
}

