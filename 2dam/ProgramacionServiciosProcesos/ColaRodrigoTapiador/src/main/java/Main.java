import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Lector lector = new Lector("./archivo.csv");
            Planificador planificador = new Planificador(lector.getProcesos(), lector.getRodajaTiempo());
            planificador.ejecutar();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
