package ejemarrays;

import java.util.Arrays;

public class AlgoritmosOrdenar {
    AlgoritmosOrdenar() {
    }

    public byte[] burbuja(byte[] v) {
        byte aux;
        for (int j = 0; j < v.length; j++) {
            for (int i = 0; i < v.length - 1; i++) {
                if (v[i] > v[i + 1]) {
                    aux = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = aux;
                }
            }
        }
        return v;
    }

    String[] ordenarStrings() {
        String[] v = {"uno", "dos", "tres", "cuatro"};
        Arrays.sort(v);
        return v;
    }

    void mostrar(String[] v) {
        for (int j = 0; j < v.length; j++) {
            System.out.print(v[j] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] v = {3, 8, 1, 47, 8, 2, 1, 6, 9, 32, 0, 1, 4};
        AlgoritmosOrdenar e = new AlgoritmosOrdenar();

//        v = e.Burbuja(v);

        String[] v1 = e.ordenarStrings();
        e.mostrar(v1);
    }
}
