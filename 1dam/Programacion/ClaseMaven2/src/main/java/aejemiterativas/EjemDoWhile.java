package aejemiterativas;

public class EjemDoWhile {
    EjemDoWhile(){}
    int  sumarDigitos(int n1){
        int resto;//el resto seria el ultimo digito del numero
        int cociente;//el cociente seria el numero sin el ultimo digito
        int suma = 0;
        do {
            resto = n1 % 10;
            cociente = n1 / 10;
            suma += resto; //añadimos el ultimo digito
            n1 = cociente; //intercambiamos el numero por el mismo pero sin el numero que ya hemos sumado
        }while (n1>0); //el programa continua hasta que el cociente es menor que 0, es decir hasta que ya hemos sumado todos los digitos
        return suma;
    }
    int  contarDigitos(int n1){
        int cont = 0;
        int cociente;
        do {
            cociente = n1 / 10;
            n1 = cociente;
            cont++;
        }while (n1>0);
        return cont;
    }
    void reloj()throws InterruptedException {
        int hora = 23;
        int minutos = 59;
        int segundos = 50;
        while (true) {
            System.out.println(hora + ":" + minutos + ":" + segundos);
            Thread.sleep(1000);
            segundos++;
            if (segundos > 59) {
                minutos++;
                segundos = 0;
            }
            if (minutos > 59) {
                hora++;
                minutos = 0;
            }
            if (hora > 23) {
                hora = 0;
                minutos = 0;
                segundos = 0;
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        /*int cont = 0;
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.println("Dar número");
            n = sc.nextInt();
            cont++;
        }while (n!=0);
        System.out.println("ha dado " + cont + " números");*/
        EjemDoWhile x1 = new EjemDoWhile();
        System.out.println(x1.sumarDigitos(1234));
        System.out.println(x1.contarDigitos(1232456788));
        x1.reloj();
    }
}
