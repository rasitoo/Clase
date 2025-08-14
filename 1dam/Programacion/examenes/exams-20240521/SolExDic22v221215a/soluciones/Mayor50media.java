import java.util.Scanner;

public class Mayor50media {
	int []v;
	int cont;
	Mayor50media(){
		v= new int[100];
		cont=0;
	}
	boolean añadir(int n) {
		boolean anadido=true;
		if (cont <v.length)
		  v[cont++]=n;
		else
			anadido=false;
		return anadido;
	}
    double media() {
    	double sum=0;
    	for (int i=0; i<cont; i++)
    		sum+=v[i];
    	sum=sum/cont;
    	return sum;
    }
    void mostrarMayores50 () {
    	double media=media()*1.5;
    	System.out.println("Números que están un 50% por encima de la media: ");
    	for (int i=0; i<cont; i++)
    		if (v[i]>media) 
    			System.out.print(v[i]+ " ");
    	System.out.println();
    }
    void mostrarMenores50 () {
    	double media=media()*0.5;
    	System.out.println("Números que están un 50% por debajo de la media: ");
    	for (int i=0; i<cont; i++)
    		if (v[i]<media) 
    			System.out.print(v[i]+ " ");
    	System.out.println();
    }
	public static void main(String[] args) {
		Scanner sc= new Scanner (System.in);
		int n;
		boolean seguir=true;
		Mayor50media m= new Mayor50media();
		do {
			System.out.print("Num:");
			n=sc.nextInt();
			if (n!=0)
			  seguir=m.añadir(n);
			else
			  seguir=false;
		}while (seguir);
		m.mostrarMayores50();
		m.mostrarMenores50();
		
	}

}
