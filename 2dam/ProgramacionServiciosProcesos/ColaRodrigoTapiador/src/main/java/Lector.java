import dataclases.Proceso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lector {
    private int rodajaTiempo;
    private List<Proceso> procesos;

    public Lector(String filePath) throws IOException {
        procesos = new ArrayList<>();
        leerArchivo(filePath);
    }

    private void leerArchivo(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            rodajaTiempo = Integer.parseInt(br.readLine().trim());
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                int id = Integer.parseInt(datos[0]);
                int tiempoEjecucion = Integer.parseInt(datos[1]);
                int tiempoEntrada = Integer.parseInt(datos[2]);
                int prioridad = Integer.parseInt(datos[3]);
                procesos.add(new Proceso(id, tiempoEjecucion, tiempoEntrada, prioridad));
            }
        }
    }

    public int getRodajaTiempo() {
        return rodajaTiempo;
    }

    public List<Proceso> getProcesos() {
        return procesos;
    }
}