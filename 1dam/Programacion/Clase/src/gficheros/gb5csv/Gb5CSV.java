package gficheros.gb5csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Gb5CSV {
    final static String PATH = "C:" + File.separator + "Users" + File.separator + "Rodrigo" + File.separator + "OneDrive" + File.separator + "Documents" + File.separator + "AAClase" + File.separator + "Programacion" + File.separator + "Clase" + File.separator + "src" + File.separator + "gficheros" + File.separator + "gb5csv" + File.separator + "Vendedores.csv";

    static void leerFichTxt(String nomFich) {
        String linea;
        try (BufferedReader br = new BufferedReader(
                new FileReader(nomFich))) {
            while (br.ready()) {
                linea = br.readLine();
                System.out.println("#" + linea + "#");
            }

        } catch (IOException e) {
            System.out.println("error en fich");
        }
    }

    static void leerFichParamDept(String nomFich, String Dept) {
        String linea;
        String[] partes;
        try (BufferedReader br = new BufferedReader(
                new FileReader(nomFich))) {
            while (br.ready()) {
                linea = br.readLine();
                partes = linea.split(";");
                if (partes[partes.length-1].equalsIgnoreCase(Dept)) {
                    for (int i = 0; i < partes.length; i++) {
                        System.out.println(partes[i]);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("error en fich");
        }
    }

    public static void main(String[] args) {
        leerFichTxt(PATH);

    }

}
