package dao;

import modelo.Sala;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    
    public List<Sala> construirSalas(int numSalas){
        List<Sala> salas = new ArrayList<>();
        for (int i = 0; i < numSalas; i++) {
            int aforo = (int) (100 + (Math.random() * 300));
            int socios = (int) (Math.random() * aforo);
            Sala sala = new Sala(i+1, aforo, socios, 30 + (Math.random() * 100));
            salas.add(sala);
        }
        return salas;
    }

}
