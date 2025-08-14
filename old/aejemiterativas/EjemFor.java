package aejemiterativas;

public class EjemFor {
    EjemFor(){}
    void mostrarTablas(){
        for (int i=2; i<=5; i++)
            for (int j=1; j<=10;j++)
                System.out.println(i + "*" + j+ " = " + (i*j));
    }
    void c7SumarNumeros(int n){
        int suma = 0;
        for (int i = 1; i <= n;i++){
            suma +=i;
            System.out.print(i);
            if (i<n)
                System.out.print("+");
            else System.out.print("=");
        }
        System.out.println(suma);
    }
    int c8Factorial(int n){
        int factorial = 1;
        for (int i = 1; i <= n;i++)
            factorial *=i;
        return factorial;
    }
    boolean c9Primo(int n){
        int divisores = 0;
        for (int i = 1; i <= n;i++){
            if (n%i == 0)
                divisores++;
        }
        return divisores==2 && n!=1;
    }
    void c10Fibonacci(int n){
        int n1 = 0;
        int n2 = 1;
        for (int i = 1; i<=n;i++){
            System.out.print(n1);
            i++;
            if (i<=n) {
                System.out.print("," +n2);
                int ntemp = n1;
                n1 = ntemp + n2;
                n2 += n1;
            } if (i!=n) {
                System.out.print(",");
            }
        }
    }

    public static void main(String[] args) {
        EjemFor e = new EjemFor();
/*
        Scanner sc = new Scanner(System.in);
        System.out.println("Número: ");
        int n = sc.nextInt();
*/
        //e.mostrarTablas();
        //e.c7SumarNumeros(n);
        //System.out.println(e.c8Factorial(n));
        //System.out.println(e.c9Primo(n));
        //e.c10Fibonacci(n);
    }
}
