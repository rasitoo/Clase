package _22_09_2023_;

public class Empleado { //clase empleado, metodo  main, creamos objeto empleado y booleana para comprobar condiciones
	int edad = 20;
	double sueldo = 2000;
	double gratificacion;
	int categoria = 1;
	double porcentaje = 0.1;
	boolean Varon;
	Empleado(int edadE, double sueldoE, int categoria, boolean Varon){
		edad = edadE;
		sueldo = sueldoE;
		this.categoria = categoria;
		this.Varon = Varon;
	}
	boolean HayQueSubirSueldo() { //si gana menos de 1050 o categoria<3
		boolean subir;
		subir = sueldo < 1050 || categoria < 3;
		return subir;
	}
	boolean HayQueJubilarlo(int edadJ) {
		boolean jubilar;
		jubilar = edad > edadJ;
		return jubilar;
	}
	double diezPorcientoSueldo(double sueldo) {
        return sueldo * 0.1;
	}
	double ObtenerPorcentaje(double tantoporciento) {
		double porcentaje;
		porcentaje = this.sueldo *  tantoporciento/100;
		return porcentaje;
	}
	void mostrar() {
		System.out.println("Edad:"+edad + " Sueldo: "+sueldo + " Categoría:"+categoria + " Varon: " + Varon + " Gratificacion: "+ gratificacion);
	}
	void SubidaSueldo(){
		if (sueldo<=1000 && Varon) {
			sueldo += sueldo * 0.1;
			gratificacion=20;
		}
		else if (sueldo>1000 && sueldo<2000 && Varon) {
			sueldo += sueldo*0.08;
			gratificacion=10;
		}
		else if (sueldo>2000) {
			sueldo+= sueldo*0.07;
		}
		else if (sueldo <= 1500) {
			sueldo += sueldo*0.1;
			gratificacion = 30;
		}
	}
	public static void main(String args[]) {
		Empleado e1= new Empleado(17, 1500, 1, true);
		Empleado e3= new Empleado(17, 1500, 1, false);

		boolean b= e1.edad < 18 && e1.sueldo > 1000 && e1.sueldo < 2000;
		boolean b2= e3.categoria < 2 && e3.sueldo > 1000;
		System.out.println("Es menor de 18 y gana entre 1000 y 2000: " + b);
		System.out.println("Empleado e3 con categoria menor de 2 y sueldo mayor de 100: " + b2);

		boolean subida = e3.HayQueSubirSueldo();
		System.out.println("Hay que subirle el sueldo a e3: "+ subida);

		int edadJubilacion=66;
		System.out.println("Hay que jubilar los mayores de: " + edadJubilacion);
		boolean jubilar = e3.HayQueJubilarlo(edadJubilacion);
		System.out.println("Hay que jubilar a e3: " + jubilar);

		double porcentaje = e3.diezPorcientoSueldo(e3.sueldo);
		System.out.println("El 10% del sueldo de e3 es: " + porcentaje);

		double veinteporciento = e3.ObtenerPorcentaje(20);
		System.out.println("El 20% del sueldo de e3 es: " + veinteporciento);

		e1.mostrar();
		e3.mostrar();

		e1.SubidaSueldo();
		e3.SubidaSueldo();

		e1.mostrar();
		e3.mostrar();

	}

}
