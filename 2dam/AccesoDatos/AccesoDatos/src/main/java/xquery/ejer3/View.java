package xquery.ejer3;

import java.util.List;

/**
 * @author Rodrigo
 * @date 24 febrero, 2025
 */
public class View {
    public void mostrarResultado(List<String> resultados) {
        for (String resultado: resultados )
            System.out.println(resultado);
    }
}
