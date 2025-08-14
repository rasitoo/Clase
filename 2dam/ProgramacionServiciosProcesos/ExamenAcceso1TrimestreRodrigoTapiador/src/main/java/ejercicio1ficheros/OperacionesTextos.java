package ejercicio1ficheros;

import java.io.*;

/**
 * @author Rodrigo
 * @date 03 diciembre, 2024
 */
public class OperacionesTextos {
    private static final String PATH = ".";

    public static void main(String[] args) {
        OperacionesTextos ej = new OperacionesTextos();
        ej.init();
        System.out.println(ej.lineaMenosCaracteres("Fich") + " es la linea mas corta");
        System.out.println(ej.tresUltimasLineas("Fich") + " son las tres ultimas lineas");
        System.out.println(ej.masAMayuscula("Fich") + " tiene mas A mayuscula");
        ej.mostrarCaracteresYA("Fich");
    }

    private void mostrarCaracteresYA(String archivo) {
        File fichero = new File(PATH + "\\" + archivo + ".txt");

        try (FileReader fic = new FileReader(fichero); BufferedReader bf = new BufferedReader(fic)) {
            String linea;

            int cont = 0;
            while ((linea = bf.readLine()) != null) {
                for (int i = 0; i < linea.length(); i++) {
                    if (linea.charAt(i) == 'A' || linea.charAt(i) == 'a') {
                        cont++;
                    }
                }

                System.out.println(linea+ "\t\t tiene " + linea.length() + " carácteres y " + cont + " Aes minúsculas o mayúsculas");
                cont = 0;
            }
            fic.close();
        } catch (FileNotFoundException r) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private String masAMayuscula(String archivo) {
        File fichero = new File(PATH + "\\" + archivo + ".txt");
        String lineaMasA = "";

        if (!fichero.exists())
            return "";

        try (FileReader fic = new FileReader(fichero); BufferedReader bf = new BufferedReader(fic)) {
            String linea;
            int contA = 0;
            int cont = 0;
            while ((linea = bf.readLine()) != null) {
                for (int i = 0; i < linea.length(); i++) {
                    if (linea.charAt(i) == 'A') {
                        cont++;
                    }
                }
                if (cont > contA) {
                    contA = cont;
                    lineaMasA = linea;
                }
                cont = 0;
            }
            fic.close();
            this.escribir(archivo + "-LineaMasA", lineaMasA, true);
        } catch (FileNotFoundException r) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lineaMasA;
    }

    private String tresUltimasLineas(String archivo) {
        File fichero = new File(PATH + "\\" + archivo + ".txt");
        String lineasFinales = "";

        if (!fichero.exists())
            return "";

        try (FileReader fic = new FileReader(fichero); BufferedReader bf = new BufferedReader(fic)) {
            String linea = "";
            String lineaUno = "";
            String lineaDos = "";
            String lineaTres = "";
            while ((linea = bf.readLine()) != null) {
                lineaTres = lineaDos.toString();
                lineaDos = lineaUno.toString();
                lineaUno = linea.toString();
            }

            lineasFinales = lineaTres + "\n" + lineaDos + "\n" + lineaUno;
            fic.close();
            this.escribir(archivo + "-UltimasTresLineas", lineasFinales, true);
        } catch (FileNotFoundException r) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lineasFinales;
    }

    private String lineaMenosCaracteres(String archivo) {
        File fichero = new File(PATH + "\\" + archivo + ".txt");
        String lineaMasCorta = "";

        if (!fichero.exists())
            return "";

        try (FileReader fic = new FileReader(fichero); BufferedReader bf = new BufferedReader(fic)) {
            String linea;
            int contCaracteres = 999999;
            while ((linea = bf.readLine()) != null)
                if (linea.length() < contCaracteres) {
                    contCaracteres = linea.length();
                    lineaMasCorta = linea;
                }
            fic.close();
            this.escribir(archivo + "-LineaMasCorta", lineaMasCorta, true);
        } catch (FileNotFoundException ignored) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lineaMasCorta;
    }

    private void init() {
        boolean escrito = escribir("Fich", "ACCESO A DATOS \n" +
                "SEGUNDO DE DAM  \n" +
                "2024-2025  \n" +
                "EXAMEN TRIMESTRE 1 \n" +
                "EJERCICIO NUMERO 1 \n", true);
        if (!escrito)
            System.out.println("Ha habido un error en la escritura");
    }

    private boolean escribir(String archivo, String texto, boolean sobreescribir) {
        File fichero = new File(PATH + "\\" + archivo + ".txt");
        StringBuilder escrito = new StringBuilder();


        if (!fichero.exists())
            try {
                if (fichero.createNewFile())
                    System.out.println("Se ha creado el archivo " + archivo);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        else if (!sobreescribir) {
            escrito.append(this.leer(archivo, false));
            escrito.append(texto);
        }


        try (FileWriter fic = new FileWriter(fichero)) {
            escrito.append(texto);
            char[] strc = escrito.toString().toCharArray();
            for (int i = 0; i < strc.length; i++) {
                fic.write(strc[i]);
            }
            System.out.println("Se ha escrito en " + archivo);
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

        try (FileReader fic = new FileReader(fichero); BufferedReader bf = new BufferedReader(fic)) {
            String linea;
            while ((linea = bf.readLine()) != null)
                if (linea.length() > 10)
                    texto.append(linea + "\n");
            fic.close();

            if (reescribir)
                this.escribir(archivo + "-Copia", texto.toString(), true);
        } catch (FileNotFoundException r) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return texto.toString();
    }

}
