package aejemiterativas.relojobjetos;

public class Tiempo {
    int hora;
    int minuto;
    int segundo;
    public Tiempo(int hora, int minuto, int segundo){
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }
    void mostrar(String txt){
        String horamostrar = "" + hora;
        String minutomostrar = "" + minuto;
        String segundomostrar = "" + segundo;
        if (hora < 10)
            horamostrar = "0" + hora;
        if (minuto < 10)
            minutomostrar = "0" + minuto;
        if (segundo < 10)
            segundomostrar = "0" + segundo;
        System.out.println("La hora "+ txt +" es: "+ horamostrar + ":" + minutomostrar + ":" + segundomostrar);
    }
    void mostrar(){
        String horamostrar = "" + hora;
        String minutomostrar = "" + minuto;
        String segundomostrar = "" + segundo;
        if (hora < 10)
            horamostrar = "0" + hora;
        if (minuto < 10)
            minutomostrar = "0" + minuto;
        if (segundo < 10)
            segundomostrar = "0" + segundo;
        System.out.println(horamostrar + ":" + minutomostrar + ":" + segundomostrar);
    }
    Tiempo nuevahora(){
        int hora1 = hora;
        int minuto1 = minuto;
        int segundo1 = segundo;
        Tiempo t1 = new Tiempo(hora1, minuto1, segundo1);
        t1.sumarsegundos(1);
        return t1;
    }
    public void reloj()throws InterruptedException {
        while (true) {
            this.mostrar();
            Thread.sleep(1000);
            segundo++;
            if (segundo > 59) {
                minuto++;
                segundo = 0;
            }
            if (minuto > 59) {
                hora++;
                minuto = 0;
            }
            if (hora > 23) {
                hora = 0;
                minuto = 0;
                segundo = 0;
            }
        }
    }
    void sumarsegundos(int segundos) {
        int cont = 0;
        while (cont < segundos) {
            segundo++;
            if (segundo > 59) {
                minuto++;
                segundo = 0;
            }
            if (minuto > 59) {
                hora++;
                minuto = 0;
            }
            if (hora > 23) {
                hora = 0;
                minuto = 0;
                segundo = 0;
            }
            cont++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Tiempo t = new Tiempo(23, 1, 1);

        t.mostrar("t");

        Tiempo t1 = t.nuevahora();
        t1.mostrar("t1");

        t1.sumarsegundos(20);
        t1.mostrar("t1");

        t.reloj();
    }
}
