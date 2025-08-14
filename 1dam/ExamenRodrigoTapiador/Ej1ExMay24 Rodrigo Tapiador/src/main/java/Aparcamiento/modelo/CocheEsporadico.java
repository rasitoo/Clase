package Aparcamiento.modelo;

import Aparcamiento.comunes.Color;
import Aparcamiento.comunes.Datos;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CocheEsporadico extends Coche {
    private double cuotaAcumulada;
    List<EstanciaEnAparcamiento> historial = null;

    public CocheEsporadico(String matricula) {
        super(matricula, Color.OTROS);
        historial = new ArrayList<>();
        //RELLENAR CODIGO Crear un CocheEsporadico inicializando el color a OTROS y
        // creando el arrayList historial vacío.

    }

    //En este cado en lugar de POJO+servicios utilizamos métodos en la propia clase.
    //Le ponemos la fecha actual a la entrada en el aparcamiento
    public void anadirEntrada() {
        historial.add(new EstanciaEnAparcamiento(new Fecha(), null));
    }

    //Le ponemos la fecha actual a la salida del aparcamiento
    public double anadirSalida() {
        for (int i = 0; i < historial.size(); i++) {
            if (historial.get(i).salida == null){
                historial.get(i).setSalida(new Fecha());
            }
        }
        return 0;
    }
}
