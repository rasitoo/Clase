package ejercicios.aaejer;

import java.io.*;

/**
 * @author Rodrigo
 * @date 18 septiembre, 2024
 */
public class Entrega1 {
    private static final String PATH = ".\\src\\main\\resources";

    private boolean escribir(String archivo, String texto, boolean sobreescribir) {
        File fichero = new File(PATH + "\\" + archivo + ".txt");
        StringBuilder escrito = new StringBuilder();


        if (!fichero.exists())
            try {
                if (fichero.createNewFile())
                    System.out.println("Se ha creado un nuevo archivo\n\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        else if (!sobreescribir) {
            escrito.append(this.leer(archivo, false));
            escrito.append(texto);
        }


        try {
            escrito.append(texto);
            FileWriter fic = new FileWriter(fichero);
            char[] strc = escrito.toString().toCharArray();
            for (int i = 0; i < strc.length; i++) {
                fic.write(strc[i]);
            }
            fic.close();

        } catch (IOException i) {
            return false;
        }

        return true;
    }

    private String leer(String archivo, boolean reescribir) {
        File fichero = new File(PATH + "\\" + archivo + ".txt");
        StringBuilder texto = new StringBuilder();

        if (!fichero.exists())
            return "";

        try {
            FileReader fic = new FileReader(fichero);
            BufferedReader bf = new BufferedReader(fic);
            String linea;
            while ((linea = bf.readLine()) != null)
                if (linea.length() > 10)
                    texto.append(linea + "\n");
            fic.close();

            if (reescribir)
                this.escribir("CopiaMasDe10Caracteres", texto.toString(), true);
        } catch (FileNotFoundException r) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return texto.toString();
    }

    public static void main(String[] args) {
        Entrega1 ej = new Entrega1();
        boolean ok = ej.escribir("Fich", "Repasando \n" +
                "Ficheros de textos  \n" +
                "En la asignatura  \n" +
                "De Acceso a Datos \n", true);
        if (!ok)
            System.out.println("Ha habido un error en la escritura");
//        boolean ok = ej.escribir("Fich", "Repasando \n", true);
//        if (!ok)
//            System.out.println("Ha habido un error en la escritura");
//        ok = ej.escribir("Fich", "Ficheros de textos  \n", false);
//        if (!ok)
//            System.out.println("Ha habido un error en la escritura");
//        ok = ej.escribir("Fich", "En la asignatura  \n", false);
//        if (!ok)
//            System.out.println("Ha habido un error en la escritura");
//        ok = ej.escribir("Fich", "De Acceso a Datos \n", false);
//        if (!ok)
//            System.out.println("Ha habido un error en la escritura");

        String ok2 = ej.leer("Fich", true);
        if (ok2.isEmpty())
            System.out.println("El archivo no existe o está vacío");

    }
}
