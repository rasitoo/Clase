package dejemarrays;

/**
 * @author Rodrigo🦖
 * @date 07 diciembre, 2023
 */
public class D15Tablero {
    final static int ALTURA = 10;
    final static int GROSOR = 30;
    char[][] tablero = new char[ALTURA][GROSOR];

    D15Tablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = 'O';
            }
        }
    }

    void mostrar() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    void barco4Casillas() {
        int dir = (int) (Math.random() * 2);//0 es horizontal y 1 vertical
        int dir2 = (int) (Math.random() * 2); //0 es hacia abajo/izquierda y 1 es arriba/derecha
        int fila = (int) (Math.random() * (ALTURA - 7) + 4); //De esta forma evitamos que esté en un borde y sobrepase los límites del array.
        int columna = (int) (Math.random() * (GROSOR - 7) + 4);

        for (int i = 0; i < 4; i++) {
            if (dir == 0) { //horizontal, dir2 == 0 es izquierda y 1 derecha
                if (dir2 == 0) {
                    tablero[fila][columna - i] = '1';
                } else if (dir2 == 1) {
                    tablero[fila][columna + i] = '1';
                }
            } else if (dir == 1) { //vertical, dir2 == 0 es abajo y 1 arriba
                if (dir2 == 0) {
                    tablero[fila - i][columna] = '1';
                } else if (dir2 == 1) {
                    tablero[fila + i][columna] = '1';
                }
            }
        }
    }

    void barco1Casilla() {
        boolean contacto = false;
        boolean colocado = false;
        int fila = (int) (Math.random() * (ALTURA));
        int columna = (int) (Math.random() * (GROSOR));

        while (!colocado) {

            for (int i = -1; fila + i < ALTURA && i < 2; i++) { //miramos la fila anterior, luego en la que se va a colocar y luego la siguiente
                if (fila + i < 0)
                    i++;
                for (int j = -1; columna + j < GROSOR && j < 2; j++) {//por cada fila miramos la columna anterior, el lugar donde se va a colocar y el siguiente
                    if (columna + j < 0)
                        j++;
                    if (tablero[fila + i][columna + j] == '1') {
                        contacto = true;
                        break;
                    }
                }
            }
            if (contacto) {
                fila = (int) (Math.random() * (ALTURA));
                columna = (int) (Math.random() * (GROSOR));
                contacto = false;
            } else {
                tablero[fila][columna] = '1';
                colocado = true;
            }
        }
    }

    public static void main(String[] args) {
        D15Tablero ej = new D15Tablero();
        for (int i = 0; i < 6; i++) {
            ej.barco4Casillas();
        }
        for (int i = 0; i < 6; i++) {
            ej.barco1Casilla();
        }
        ej.mostrar();
    }
}
