
public class SumaFracciones {
	Fraccion vf[]= new Fraccion[5];
    
	SumaFracciones() {
		for (int  i=0; i<vf.length; i++)
			vf[i]=new Fraccion();
	}
	Fraccion sumarTodos() {
		Fraccion fres=null;
		if (vf!=null && vf.length!=0) 
 		  if( vf.length==1)
 			  fres=vf[0];//mejor clonar
 		  else {
 		    fres=vf[0].sumar(vf[1]);
		    for (int  i=2; i<vf.length; i++) 
			  fres=fres.sumar(vf[i]);
 		  }
		return fres;
	}
	public static void main(String[] args) {
		SumaFracciones pf= new SumaFracciones();
		Fraccion fr=pf.sumarTodos();
		if (fr==null)
		  System.out.println("No hay fracciones");
		else
		  fr.mostrar();
	}

}
