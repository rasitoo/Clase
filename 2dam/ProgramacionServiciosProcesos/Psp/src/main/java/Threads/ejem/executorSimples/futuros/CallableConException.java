package Threads.ejem.executorSimples.futuros;

import javax.xml.transform.stream.StreamSource;
import java.util.concurrent.*;

public class CallableConException implements Callable<Integer> {
    int numero;

    public CallableConException(int numero) {
        this.numero = numero;
    }

    public Integer call() throws MiException {
        System.out.println("Ejecutando el call");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (numero < 0) {
            throw new MiException("El número debe ser positivo");
        } else
            return numero + 1;
    }
}

class MiException extends ExecutionException {
    public MiException(String msg) {
        super(msg);
    }
}

class pruebaCallabelConException {
    public static void main(String[] args) {
        ExecutorService servicio = null;
        try {
            servicio = Executors.newFixedThreadPool(1);
            Future<Integer> resultado = servicio.submit(new CallableConException(-3));
            //No hay porque poner el while pero así vemos que se puede ejecutar mientras espero.
            System.out.println("Resultado:" + resultado.get().intValue());
            //    System.exit(0);  // si no seguirá ejecutando por el servicio.

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("producida MiException " + e.getMessage());
        }
        servicio.shutdown();
        System.out.println("FIN");
    }
}
