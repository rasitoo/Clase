package exprlambda.lambdapersona1;

import java.util.ArrayList;

/**
 * @author Rodrigo
 * @date 27 febrero, 2024
 */
public class LambdaPersona {
    static void mostrarListaPersonas(ArrayList<Persona> miLista) {
        miLista
                .stream()

                .sorted((p1, p2) -> p2.getEdad() - p1.getEdad())
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        ArrayList<Persona> miLista = new ArrayList<>();
        miLista.add(new Persona("Ana", 10));
        miLista.add(new Persona("Oscar", 45));
        miLista.add(new Persona("Carlos", 70));
        miLista.add(new Persona("Antonio", 5));

        double noJubilados = miLista.stream()
                .mapToInt(persona -> persona.getEdad())
                .filter(edad -> edad <= 65)
                .count();

        System.out.println(noJubilados);
    }
}

