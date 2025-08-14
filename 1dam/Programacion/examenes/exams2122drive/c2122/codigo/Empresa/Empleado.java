import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Empleado {
  final static int ANOINICIAL=2000;
  double sueldoBrutoAnual[];
  String dni;
  Empleado(String dni){
	  this.dni=dni;
	  sueldoBrutoAnual= new double[23];
  }
 //Devuelve el sueldo bruto entre los años indicados, ambos incluidos.
  double sueldoEntreAnos(int anoInicial, int anoFinal) {
	  int ini=anoInicial-ANOINICIAL;
	  int fin=anoFinal-ANOINICIAL;
	  int suma=0;
	  if (ini<0 || fin>=sueldoBrutoAnual.length)
		 suma=-1;
	  else
	    for (int i=ini; i<=fin; i++)
		  suma+=sueldoBrutoAnual[i];	
	  return suma;
  }
  //Devolverá el año (entre 2000 y 2022, con el mayor sueldo)
  int anoMayorSueldoMayor() {
	  int i=0;
	  double sueldoMax=sueldoBrutoAnual[0];
	  if (sueldoBrutoAnual.length>0)
	    for (i=1; i<sueldoBrutoAnual.length;i++)
		  if(sueldoBrutoAnual[i]>sueldoMax)
			  sueldoMax=sueldoBrutoAnual[i];
	  return i+ANOINICIAL;
  }
  void cargarSueldosBrutos(String nomFich) {
	  String linea;
	  int ano; 
	  double sueldo;
	  int i=1;
	  try (BufferedReader f = new BufferedReader(new FileReader(nomFich))) {
		  while (f.ready()) {
			linea=f.readLine();
			String tokens[]=linea.split("#");
			ano=Integer.parseInt( tokens[0]);
			sueldo = Double.parseDouble(tokens[1]);
			sueldoBrutoAnual[ano-ANOINICIAL]=sueldo;
			i++;
		  }
		} catch (IOException e) {
			System.out.println("Error en la lectura del fichero");
		}  
	    catch (ArrayIndexOutOfBoundsException e) {
		  System.out.println("El año de la línea "+i+" no es válido");
	    }
	    catch (NumberFormatException e) {
	    	System.out.println("El valor leído del fichero en la línea "+i+" no es correcto");
	    }  
  }
  double sueldoUltimos5Anos(){
	  //Otra opción es usar sueldoEntreAnos(2018,2022)
	  double sueldo5Anos=0;
	  for (int i=sueldoBrutoAnual.length-1; i>=sueldoBrutoAnual.length-5;i--)
		  sueldo5Anos+= sueldoBrutoAnual[i];
	  return sueldo5Anos;
	  

  }
	public static void main(String[] args) {
		Empleado e= new Empleado("12345678A");
		e.cargarSueldosBrutos("juan.txt");
		System.out.println(e.sueldoEntreAnos(2001, 2005));
		System.out.println (e.anoMayorSueldoMayor());
		
	}
}
