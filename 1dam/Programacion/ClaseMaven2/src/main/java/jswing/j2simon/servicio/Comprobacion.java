package jswing.j2simon.servicio;

import jswing.j2simon.iu.Simon;
import lombok.Data;

import javax.swing.*;

/**
 * @author Rodrigo
 * @date 18 abril, 2024
 */
@Data
public class Comprobacion {
    private Simon iu;
    private JButton jb;
    private boolean correcto = true;

    public Comprobacion(Simon iu) { //Con el constructor creamos una copia de la iu para acceder a toda la información que ha dado el usuario y poder modificarla
        this.iu = iu;
    }

    public void comprobar(){

    }


}
