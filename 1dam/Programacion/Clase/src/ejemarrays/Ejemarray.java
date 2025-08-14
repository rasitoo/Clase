package ejemarrays;

public class Ejemarray {
    Ejemarray(){}
    void aleatorios (int[] v){
        for (int i=0; i<v.length; i++){
            v[i]= (int) (Math.random()*10);
        }
    }
    void mostrar(int[] v){
        for (int i = 0; i<v.length;i++)
            System.out.println(i+"->"+v[i]);
    }
    int contarvalor(int[] v, int n){
        int cont = 0;
        for (int i = 0; i<v.length;i++){
            if (n == v[i])
                cont++;
        }
        return cont;
    }
    boolean apareceElValor(int[] v, int n){
        boolean aparece = false;
        for (int i = 0; i<v.length;i++){
            if (v[i] == n)
                return aparece=true;
        }
        return aparece;
    }
    double media(int[] v){
        int suma = 0;
        for (int i = 0; i<v.length;i++){
            suma += v[i];
        }
        double media = suma / v.length;
        return media;
    }
    void encimaDeLaMedia(int[] v){
        double media = this.media(v);
        System.out.print("La media es: " + (int) media + "\nLos números: ");
        for (int i = 0; i<v.length;i++) {
            if (v[i] > media)
                System.out.print(v[i] + " ");
        }
        System.out.println("están por encima de la media.");
    }
    public static void main(String[] args) {
        Ejemarray e = new Ejemarray();
        int[] v = new int[3];
        e.aleatorios(v);
        int[] v2 = new int[10];
        e.aleatorios(v2);
        e.mostrar(v2);
        //System.out.println(e.contarvalor(v2,7));
        //System.out.println(e.apareceElValor(v2,7));
        e.encimaDeLaMedia(v2);

    }
}
