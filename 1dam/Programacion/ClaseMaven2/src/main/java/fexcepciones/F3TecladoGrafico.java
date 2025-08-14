package fexcepciones;
/**
 * @author Jos� Manuel P�rez
 */

import javax.swing.JOptionPane;

public class F3TecladoGrafico {

    /**
     * Est� metodo muestra una ventana gr�fica con el texto recibido como
     * par�metro y pide un n�mero entero por teclado.
     *
     * @param texto - Este texto ser� mostrado en la ventana gr�fica
     * @return Devolver� el n�mero entero le�do de teclado
     */
    public int leerInt(String texto) {
        int num = 0;
        num = Integer.parseInt(JOptionPane.showInputDialog(texto));
        return num;
    }

    double leerDouble(String texto) {
        double num = Double.parseDouble(JOptionPane.showInputDialog(texto));
        return num;
    }

    String leerString(String texto) {
        String t = JOptionPane.showInputDialog(texto);
        return t;
    }

    void mostrarMsg(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }

    int botonSeleccion(String opciones[]) {
        Object botones[] = new Object[opciones.length];
        for (int i = 0; i < opciones.length; i++)
            botones[i] = opciones[i];
        int opc = JOptionPane.showOptionDialog(
                null,  //componente padre
                "Seleccione opcion",  //mensaje
                "Selector de opciones", //titulo de la ventana
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,    // null para icono por defecto.
                botones,   // null para YES, NO y CANCEL
                botones[0]);  //opci�n por defecto

        return opc;
    }

    int menuSeleccion(String opciones[]) {
        Object opcionesObj[] = new Object[opciones.length];
        for (int i = 0; i < opciones.length; i++)
            opcionesObj[i] = opciones[i];
        Object opc = JOptionPane.showInputDialog(
                null,
                "Seleccione opcion",
                "Selector de opciones",
                JOptionPane.PLAIN_MESSAGE,
                null,  // null para icono defecto
                opcionesObj,
                opcionesObj[0]);

        //System.out.println("El usuario ha elegido "+opc);
        int i = 0;
        while (opc != opcionesObj[i]) i++;

        return i;
    }

    public static void main(String a[]) {
        F3TecladoGrafico t = new F3TecladoGrafico();
        try {
            int n = t.leerInt("Dar n�mero");
            System.out.println("N�mero le�do:" + n);
        }catch (NumberFormatException e){
            System.out.println("Formato no valido");
        }

        /*
        double d = t.leerDouble("Dar n�mero real");
        System.out.println("N�mero le�do:" + d);
        String s = t.leerString("Dar String");
        System.out.println("String le�do:" + s);
        t.mostrarMsg("Se acabo \n fin");

        String msgs[] = {"cero", "uno", "dos", "tres"};
        n = t.botonSeleccion(msgs);
        System.out.println("Opci�n elegida:" + n);

        String msgs2[] = {"opc00", "opc01", "opc02"};
        n = t.menuSeleccion(msgs2);
        System.out.println("Opci�n elegida:" + n);
        */

    }

}
