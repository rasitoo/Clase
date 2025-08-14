package gficheros.gb5csv;

import java.io.*;

public class Gb5CSV {
    static final String PATH = "." + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "gficheros" + File.separator + "gb5csv" + File.separator + "Vendedores.csv";

    void mediaVendedor() {//Teniendo solo en cuenta los años en los que el vendedor realizó alguna venta (se mostrará por pantalla el nombre del vendedor y su media de ventas)
        int cont = 0;
        double media = 0;
        String[] tok;
        String vendedor;
        try (BufferedReader br = new BufferedReader(
                new FileReader(PATH))) {
            br.readLine(); //para que pase de la primera línea
            while (br.ready()) {
                tok = br.readLine().split(";");
                vendedor = tok[0];
                for (int i = 1; i < tok.length - 1; i++) {
                    if (!tok[i].isEmpty()) {
                        media += Double.parseDouble(tok[i]);
                        cont++;
                    }
                }
                if (cont != 0){ //Se podria poner un try catch, pero mejor que el programa ni intente dividir entre 0, ya que crashearia
                    media = media / cont;
                }else {
                    System.out.println("No se han encontrado valores");
                }
                System.out.println(vendedor + " Media: " + media);
                cont = 0;
                media = 0;
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }

    void mediaDept(String dept) {//media de ventas de cada departamento de la empresa. Se supondrá que no hay más de 10 departamentos. No se hará ninguna suposición sobre el número de vendedores.
        int cont = 0;
        double media = 0;
        String[] tok;
        try (BufferedReader br = new BufferedReader(
                new FileReader(PATH))) {
            br.readLine(); //para que pase de la primera línea
            while (br.ready()) {
                tok = br.readLine().split(";");
                if (tok[tok.length - 1].equalsIgnoreCase(dept)) {
                    for (int i = 1; i < tok.length - 1; i++) {
                        if (!tok[i].isEmpty()) {
                            media += Double.parseDouble(tok[i]);
                            cont++;
                        }
                    }
                }
            }
            if (cont != 0){ //Se podria poner un try catch, pero mejor que el programa ni intente dividir entre 0, ya que crashearia
                media = media / cont;
            }else {
                System.out.println("No se han encontrado valores");
            }
            System.out.println(dept + " Media: " + media);
        }catch (ArithmeticException e){
            System.err.println("Division entre 0");
        }
        catch (IOException e) {
            System.err.println(e);
        }

    }

    static void leerFichTxt(String nomFich) {
        String linea;
        try (BufferedReader br = new BufferedReader(
                new FileReader(nomFich))) {
            while (br.ready()) {
                linea = br.readLine();
                System.out.println("#" + linea + "#");
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void leerFichParamDept(String nomFich, String dept) {
        String linea;
        String[] partes;
        try (BufferedReader br = new BufferedReader(
                new FileReader(nomFich))) {
            while (br.ready()) {
                linea = br.readLine();
                partes = linea.split(";");
                if (partes[partes.length - 1].equalsIgnoreCase(dept)) {
                    for (int i = 0; i < partes.length; i++) {
                        System.out.println(partes[i]);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Gb5CSV ej = new Gb5CSV();

        ej.mediaVendedor();
        ej.mediaDept("Libreria");
        ej.mediaDept("Automocion");
        ej.mediaDept("Deporte");


    }

}
