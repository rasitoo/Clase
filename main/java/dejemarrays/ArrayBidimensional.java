package dejemarrays;

public class ArrayBidimensional {
    int m[][];

    ArrayBidimensional(int filas, int columnas) {
        m = new int[filas][columnas];
    }

    void inicializar(int valor) {
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[i].length; j++)
                m[i][j] = valor;
    }

    int sumar() {
        int suma = 0;
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[i].length; j++)
                suma += m[i][j];
        return suma;
    }

    int colocarvalorencasilla(int fila, int columna, int valor) {
        int valorantes = Integer.MIN_VALUE;
        if (m != null && fila <= m.length && fila >= 0 && m[fila] != null && columna >= 0 && columna < m[fila].length) {
            valorantes = m[fila][columna];
            m[fila][columna] = valor;
        }
        return valorantes;
    }

    void colocarvalorenfila(int fila, int valor) {
        if (m != null && fila <= m.length && fila >= 0 && m[fila] != null) {
            for (int i = 0; i < m[fila].length; i++) {
                m[fila][i] = valor;
            }
        } else System.out.println("Error");
    }

    void colocarvalorencolumna(int columna, int valor) {
        if (m != null && columna <= m.length && columna >= 0 && m[columna] != null) {
            for (int i = 0; i < m.length; i++) {
                if (m[i] != null)
                    m[i][columna] = valor;
            }
        } else System.out.println("Error");
    }

    void mostrar() {
        for (int i = 0; i < m.length; i++) { // muestra filas
            for (int j = 0; j < m[i].length; j++) // muestra columnas
                System.out.print(m[i][j] + "\t");
            System.out.println();
        }
    }

    int mayorValor() {
        int mayor = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] > mayor)
                    mayor = m[i][j];
            }
        }
        return mayor;
    }

    void sumacolumna() {
        int suma = 0;
        int longitud = m[0].length;
        for (int i = 0; i < longitud; i++) { // columna
            for (int j = 0; j < m.length; j++) { //fila
                suma += m[j][i];
                longitud = m[j].length;
            }
            System.out.println("La suma de la columna " + i + " es: " + suma);
            suma = 0;
        }
    }

    void mostrarnormal(int[] sumafila) {
        for (int i = 0; i < sumafila.length; i++) {
            System.out.println(i + " ---> " + sumafila[i]);
        }
    }

    int[] sumafila() {
        int[] suma = new int[m.length];
        for (int i = 0; i < m.length; i++) {//filas
            for (int j = 0; m[i] != null && j < m[i].length; j++) {//casillas por fila
                suma[i] += m[i][j];
            }
        }

        return suma;
    }

    void naleatorio(int n) {
        int j;
        int k = 0;
        for (int i = 0; i < n; i++) {
            j = (int) (Math.random() * m.length);
            for (int l = 0; l < m.length; l++) {
                k = (int) (Math.random() * m[l].length);
            }
            m[j][k] = (int) (Math.random() * 100 + 2);
        }
    }

    public static void main(String[] args) {
        ArrayBidimensional ob = new ArrayBidimensional(10, 15);
        ob.inicializar(1);
        //int suma = ob.sumar();
        //int valoranterior=ob.colocarvalorencasilla(2,4,999);
        //ob.colocarvalorencolumna(0, 1230);
        //ob.mostrar();
        //System.out.println(ob.mayorValor());
        //ob.sumacolumna();

        //int[] sumafila = ob.sumafila();
        //ob.mostrarnormal(sumafila);

        ob.naleatorio(6);
        ob.mostrar();


    }
}
