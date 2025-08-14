package jswing.j2simon.iu;

import lombok.Data;

import javax.swing.*;
import java.awt.*;

/**
 * @author Rodrigo
 * @date 25 abril, 2024
 */
@Data
public class Boton extends JButton {
    private Color color;
    private int posicion;

    public Boton() {
        super.setContentAreaFilled(true);
    }

    public Boton(String texto) {
        super(texto);
        super.setContentAreaFilled(false);
    }

    public Boton(int posicion) {
        switch (posicion) {
            case 0:
                this.posicion = posicion;
                this.color = Color.RED;
                setBackground(getColor().darker());
                break;
            case 1:
                this.posicion = posicion;
                this.color = Color.GREEN;
                setBackground(getColor().darker());
                break;
            case 2:
                this.posicion = posicion;
                this.color = Color.BLUE;
                setBackground(getColor().darker());
                break;
            case 3:
                this.posicion = posicion;
                this.color = Color.YELLOW;
                setBackground(getColor().darker());
                break;
            case 4:
                this.posicion = posicion;
                this.color = Color.ORANGE;
                setBackground(getColor().darker());
                break;
            case 5:
                this.posicion = posicion;
                this.color = Color.PINK;
                setBackground(getColor().darker());
                break;
            case 6:
                this.posicion = posicion;
                this.color = Color.CYAN;
                setBackground(getColor().darker());
                break;
        }
    }


}
