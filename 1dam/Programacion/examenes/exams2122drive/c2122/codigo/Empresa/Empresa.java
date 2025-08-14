import java.util.Vector;

public class Empresa {
  Vector <Empleado>trabajadores= new Vector <Empleado>();
  
  
  String dniCobraMas5UltimosAnos() {
	  double sueldoMax=-1;
	  String nombreEmp="";
	  for (Empleado e: trabajadores)
		  if(e.sueldoUltimos5Anos()>sueldoMax){
			  sueldoMax=e.sueldoUltimos5Anos();
			  nombreEmp=e.dni;
		  }
	  return nombreEmp;
  }
	public static void main(String[] args) {
		Empresa emp=new Empresa();
		Empleado e1= new Empleado("1234567A");
		e1.cargarSueldosBrutos("empleado1.txt");
		emp.trabajadores.add (e1);
		Empleado e2= new Empleado("7777567A");
		e2.cargarSueldosBrutos("empleado2.txt");
		emp.trabajadores.add (e2);
		System.out.println(e1.anoMayorSueldoMayor());
		System.out.println(e2.sueldoEntreAnos(2000, 2025));
		System.out.println(emp.dniCobraMas5UltimosAnos());
		
	
	}

}
