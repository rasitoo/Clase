import java.util.Scanner;

public class CerosConsecutivos {

	public static void main(String[] args) {
		Scanner sc= new Scanner (System.in);
		int n,cont0=0, cont1=0, max0=0, max1=0;
		do {
			n=sc.nextInt();
			if (n==0) {
				cont0++;
				cont1=0;
			}
			if (n==1) {
				cont1++;
				cont0=0;
			}
			if (cont0>max0)
				max0=cont0;
			if (cont1>max1)
				max1=cont1;
		} while (n ==0 || n==1);
		System.out.println("Máximo de 0 seguidos:"+max0);
		System.out.println("Máximo de 1 seguidos:"+max1);
	}

}
