package Aparcamiento.comunes;

import Aparcamiento.ui.Main;
import lombok.Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@Data
public class Datos {
    private static String NOMFICH = "."+ File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "datos";
    double cuotaMes;
    double precioPrimeraMediaHora;
    double precioMinuto;
    double descuentoMes;
    static Datos d = null;

    private Datos() {
        String linea;

        try (BufferedReader f = new BufferedReader(new FileReader(NOMFICH))) {
            while (f.ready()) {
                linea = f.readLine();
                String tokens[] = linea.split(":");
                cuotaMes = Double.parseDouble(tokens[1]);
                linea = f.readLine();
                tokens = linea.split(":");
                precioPrimeraMediaHora = Double.parseDouble(tokens[1]);
                linea = f.readLine();
                tokens = linea.split(":");
                precioMinuto = Double.parseDouble(tokens[1]);
                linea = f.readLine();
                tokens = linea.split("=");
                descuentoMes = Double.parseDouble(tokens[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("fin de la aplicación");
            System.exit(-1);
        }
    }

    public static Datos getDatos() {
        if (d == null)
            d = new Datos();
        return d;
    }
}
