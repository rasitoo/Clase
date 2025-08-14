
public class EjemRunable1 implements Runnable {
  int id;
  EjemRunable1 (int i){
	  id= i;
  }
  public void run () {
      for (int i = 1; i <= 5; i++) {
    	 int x=(int)(Math.random()*1000);
    	 try {
    		Thread.sleep(x);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
         System.out.println("TH:"+id);
      }
  }

public static void main(String[] args) {

	 new Thread(new EjemRunable1(1)).start ();
	 new Thread(new EjemRunable1(2)).start ();

}
}
