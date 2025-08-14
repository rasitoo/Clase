package Threads.ejem;

public class EjemRunable1 implements Runnable {
    int id;

    EjemRunable1(int i) {
        id = i;
    }

    void metodo() {
        System.out.println("Metodo");
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            int x = (int) (Math.random() * 1000);
            try {
                Thread.sleep(x);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("TH:" + id);//aqu� no se puede usar getState() ya que no es  la clase Thread
            //  if (id==1 && i ==2 )return;  //S�lo termina el th 1
            //con System.exit(0) finalizar�a toda la aplicaci�n, todos los threads.
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long ms = System.currentTimeMillis();
        EjemRunable1 ejth1 = new EjemRunable1(1);
        new Thread(ejth1).start();
        ejth1.metodo();
        System.out.println("ejth1.id:" + ejth1.id);
        Thread th2 = new Thread(new EjemRunable1(2));
        th2.start();
        System.out.println("Threads creados");
        //Thread.sleep(10000);
        th2.join();
        //Al no hacer th1.join, los msgs del th1 se pueden mezclar con los holas
        System.out.println("Ha finalizado el thread 2");
        new Thread(() -> {
            for (int i = 1; i < 4; i++) System.out.println("Hola");
        }).start();
        long ms2 = System.currentTimeMillis();
        System.out.println(ms2 - ms);
    }
}
