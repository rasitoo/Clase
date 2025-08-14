package Test;

public class Test1 {
	public int atr=10;
	void incrementa( Test1 otro, int x ){
	      	 atr=  otro.atr+x;
	      	 x++;
	}
	public static void main (String arg[]){
		Test1 a= new Test1();
		Test1 b= new Test1();
		int n=3;
	  	a.incrementa(b,n);
	    System.out.println ( "a= "+ a.atr + " b=" + b.atr+ " n="+n);
    }
}
