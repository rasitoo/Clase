package Threads.ejem;

public class EjemploThread1 extends Thread {
    int id;

    EjemploThread1(int i) {
        id = i;
    }

    void esperar(long n) {
        double x = 99;
        for (long i = 0; i < n; i++) x = 2 * x - 3 * i + 2;
    }

    public void run() {
        //   if (id==2) setPriority(MAX_PRIORITY);
        esperar(100000);
        for (int i = 1; i <= 5; i++) {
            int x = (int) (Math.random() * 1000);
		    /*	 try {
		    		Thread.sleep(x);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		      */
            System.out.println("TH:" + id + " tiempo:" + System.nanoTime());
        }
        System.out.print("TH:" + id + " Estado:" + this.getState() + " PRIORIDAD:" + getPriority());
        System.out.println();
    }

    public static void main(String[] args) {
        Thread t1 = new EjemploThread1(1);
        t1.start();
        new EjemploThread1(2).start();
        //   new Thread(new RunnableExample ()).start ();
        //	t1.setPriority(Thread.MAX_PRIORITY);
        System.out.println("en el main la prioridad del thread1 es:" + t1.getPriority());
        System.out.println("TH principal");

    }

}
