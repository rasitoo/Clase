package ejercicio1ficheros.operacionesbinarias;

import java.io.*;

/**
 * @author Rodrigo
 * @date 03 diciembre, 2024
 */
public class OperacionesBinarias {
    File archivo;

    public static void main(String[] args) {
        OperacionesBinarias ej = new OperacionesBinarias();
        ej.crearArchivoTiendas();
        ej.mediaAritmetica();
    }

    private void mediaAritmetica() {
        if (!archivo.exists()) {
            System.out.println("El archivo no existe");
            return;
        }
        try (ObjectInputStream f = new ObjectInputStream(new FileInputStream(archivo))) {
            boolean fin = false;
            double cont = 0;
            double sumaAnual = 0;
            while (!fin) {
                try {
                    Tienda a = (Tienda) f.readObject();
                    if (a.getLocalidad().equalsIgnoreCase("madrid")) {
                        cont++;
                        sumaAnual += a.getBeneficiosAnuales();
                    }
                } catch (EOFException e) {
                    fin = true;
                }
            }
            if (cont <= 0)
                System.out.println("No hay tiendas en madrid");
            else
                System.out.println("La Media de beneficios anuales de las tiendas de Madrid son : " + sumaAnual / cont);

        } catch (StreamCorruptedException e) {
            System.err.println("Fichero corrupto porque el Object stream se vuelve a crear y lo corrompe");
        } catch (FileNotFoundException e) {
            System.err.println("El fichero no existe");
        } catch (IOException e) {
            System.err.println("Error en el fichero");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void crearArchivoTiendas() {
        archivo = new File(".\\Tiendas.dat");
        try {
            if (!archivo.exists())
                archivo.createNewFile();
        } catch (IOException e) {
            System.err.println(e);
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(new Tienda("1", "Atos Origin", "Madrid", 120000, 10000));
            oos.writeObject(new Tienda("2", "Scaletrix", "Barcelona", 150000, 12500));
            oos.writeObject(new Tienda("3", "Mecatronic", "Valencia", 90000, 7500));
            oos.writeObject(new Tienda("4", "System Juegos", "Madrid", 110000, 9167));
            oos.writeObject(new Tienda("5", "Futbol Factory", "Madrid", 130000, 10833));
            oos.writeObject(new Tienda("6", "Deportes Julian", "Sevilla", 80000, 6667));
            oos.writeObject(new Tienda("7", "Juegos Online", "Madrid", 140000, 11667));
            oos.writeObject(new Tienda("8", "Mac Revolution", "Barcelona", 170000, 14167));
            oos.writeObject(new Tienda("9", "RAM Store", "Zaragoza", 100000, 8333));
            oos.writeObject(new Tienda("10", "Tarjeta TOP", "Madrid", 105000, 8750));
        } catch (IOException e) {
            System.err.println("Error creando el fichero binario de Tiendas: " + e.getMessage());
        }
    }
}

