package Aparcamiento.modelo;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
@Data
public class Fecha {
	LocalDateTime fechaHora;
	public  Fecha() {
		fechaHora= LocalDateTime.now();
	}
	public long diferenciaSegundos(Fecha fecha){
		return this.fechaHora.until(fecha.fechaHora, ChronoUnit.SECONDS);
	}
	public int getMes(){
		return fechaHora.getMonth().getValue();
	}
	public int getAno(){
		return fechaHora.getYear();
	}

	@Override
	public String toString(){
		return fechaHora.getDayOfMonth()+"-"+fechaHora.getMonthValue()+"-"+fechaHora.getYear()+ "  "+
		fechaHora.getHour()+":"+fechaHora.getMinute()+":"+fechaHora.getSecond();
	}
	public static void main(String[] args) throws InterruptedException {
		Fecha fecha = new Fecha();
		System.out.println(fecha.toString());
		Thread.sleep(3000);
		Fecha fecha2 = new Fecha();
		System.out.println(fecha.diferenciaSegundos(fecha2));
		System.out.print("mes "+fecha.getMes());
		System.out.println("  agno "+fecha.getAno());
	}
}
