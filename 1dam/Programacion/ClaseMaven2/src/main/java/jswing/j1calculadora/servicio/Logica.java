package jswing.j1calculadora.servicio;

import jswing.j1calculadora.iu.Calculadora;
import lombok.Data;

/**
 * @author Rodrigo
 * @date 18 abril, 2024
 */
@Data
public class Logica {
    private Calculadora iu;
    private String numeroActual = "";

    public Logica(Calculadora iu) { //Con el constructor creamos una copia de la iu para acceder a toda la información que ha dado el usuario y poder modificarla
        this.iu = iu;
    }

    public void accionBoton(String nombre) { //este metodo es llamado por el listener (este a su vez llama a cálculo si es necesario) y luego a modificar texto para que en la iu se vea el resultado de la pulsación
        if (nombre.equals("C")) { //Si es la C borra el número
            numeroActual = "";
            iu.modificartexto("");
        } else if (nombre.equals("=")) { //si es un = realiza el cálculo
            if (!numeroActual.isEmpty()) {
                int resultado = calculo(numeroActual);
                iu.modificartexto(Integer.toBinaryString(resultado)); // lo transforma a binario
            }
        } else {
            numeroActual += nombre;
            iu.modificartexto(numeroActual);
        }
    }

    private int calculo(String numeroActual) {
        int resultado = 0;
        String[] partes = numeroActual.split("[+]"); //Entre corchetes porque es una regex y no lo interpreta como carácter literal
        for (int i = 0; i < partes.length; i++) {
            if (!partes[i].isEmpty()) //si el primer caracter que introduce el usuario es un + o introduce varios + seguidos daria error porque la primera posición del array sería null
                resultado += Integer.parseInt(partes[i], 2);
        }
        return resultado;
    }
}
