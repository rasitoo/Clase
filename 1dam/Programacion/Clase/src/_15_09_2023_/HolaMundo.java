package _15_09_2023_;

public class HolaMundo {
	public static void main (String arg[]){
    System.out.println(" ");
    int n=2000000007;
    double f=n; //si no fuese double no pillaría el 7 del final
    System.out.println(f + " " + n);
    f++;
    System.out.println(f);

    byte b=0x7F;
    System.out.println(b);

    long l=8000000000000000000L; //Hay que poner L al final para que coja todos los números
    System.out.println(l);

    boolean matriculado=true;
    System.out.println(matriculado);

    char c='A';  //Para char se tiene que usar comilla simple ''
    System.out.println(c);
	}
}
