package ejercicios.aaejer.ejer15;

import java.io.*;
import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 02 octubre, 2024
 */
public class AplicacionFicherosTextos {
    public void ejercicio6() {
        String path = ".\\src\\main\\resources";
        String[] lineas = {"Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis",
                "Siete", "..."};
        File fichero = new File(path + "\\ejer6.txt");
        try {
            FileWriter fic = new FileWriter(fichero);
            char[] strc;
            for (int i = 0; i < lineas.length; i++) {
                strc = lineas[i].toCharArray();
                for (int j = 0; j < strc.length; j++)
                    fic.write(strc[j]);
                fic.write("\n");
            }
            fic.close();

        } catch (IOException i) {

        }
    }

    public void ejercicio7() {
        String path = ".\\src\\main\\resources";
        String[] lineas = {"Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis",
                "Siete", "..."};
        File fichero = new File(path + "\\ejer7.txt");
        try {
            FileWriter fic = new FileWriter(fichero);
            char[] strc;
            for (int i = 0; i < lineas.length; i++) {
                if (i % 2 == 0) {
                    strc = lineas[i].toCharArray();
                    for (int j = 0; j < strc.length; j++)
                        fic.write(strc[j]);
                    fic.write("\n");
                }
            }
            fic.close();

        } catch (IOException i) {

        }
    }

    public void ejercicio8() {
        String path = ".\\src\\main\\resources";
        File origen = new File(path, "\\ejer8entrada.txt");
        File destino = new File(path, "\\ejer8copia.txt");

        char[] arraynum;
        arraynum = new char[(int) origen.length()];
        try {
            if (!origen.exists())
                origen.createNewFile();
            if (!destino.exists())
                destino.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileReader inputStream = new FileReader(origen); FileWriter outputStream = new FileWriter(destino)) {

            for (int i = 0; i < origen.length(); i++)
                arraynum[i] = (char) inputStream.read();
            for (int i = 0; i < arraynum.length; i++) {
                if (arraynum[i] != (char) -1)
                    outputStream.write(arraynum[i]);
            }
            outputStream.write("FIN");

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void ejercicio9() {
        String PATH = ".\\src\\main\\resources";

        char[] arraynum;
        File origen = new File(PATH, "\\ejer9entrada.txt");
        File destino = new File(PATH, "\\ejer9par.txt");
        File destinoImp = new File(PATH, "\\ejer9imp.txt");
        arraynum = new char[(int) origen.length()];
        try {
            if (!origen.exists())
                origen.createNewFile();
            if (!destino.exists())
                destino.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileReader inputStream = new FileReader(origen); FileWriter outputStreamPar = new FileWriter(destino); FileWriter outputStreamImp = new FileWriter(destinoImp)) {

            for (int i = 1; i < origen.length(); i++)
                arraynum[i] = (char) inputStream.read();
            for (int i = 1; i < arraynum.length; i++) {
                if (arraynum[i] != (char) -1 && arraynum[i] != '\n' && arraynum[i] != '\r') {
                    if (i % 2 == 0)
                        outputStreamPar.write(arraynum[i]);
                    else
                        outputStreamImp.write(arraynum[i]);
                }
            }
            outputStreamPar.write("FIN PARES");
            outputStreamImp.write("FIN IMPARES");


        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public String pedirPalabra() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la palabra a buscar:");
        return sc.nextLine();
    }

    public void ejercicio10(String palabra) {
        File origen = new File(".\\src\\main\\resources", "\\ejer10.txt");
        String linea;
        int cont = 0;
        boolean encontrado = false;
        if (origen.exists()) {
            try (BufferedReader bf = new BufferedReader(new FileReader(origen))) {
                while ((linea = bf.readLine()) != null) {
                    cont++;
                    for (int i = 0; i < linea.length(); i++) {
                        if (linea.toCharArray()[i] == palabra.toCharArray()[0] && linea.substring(i, i + palabra.length()).equals(palabra)) {
                            encontrado = true;
                            System.out.println("Nombre del Fichero: " + origen.getAbsolutePath());
                            System.out.println("Línea: " + linea);
                            System.out.println("Nº Línea: " + cont);
                            System.out.println("Posición: " + i + " a " + (i + palabra.length()));
                            System.out.println();
                        }
                    }

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else System.out.println("No existe el fichero " + origen);
        if (!encontrado)
            System.out.println("No se ha podido encontrar la linea introducida");
    }
}
