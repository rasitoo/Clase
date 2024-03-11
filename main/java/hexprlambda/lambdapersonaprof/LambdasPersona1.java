package hexprlambda.lambdapersonaprof;


import java.util.ArrayList;

public class LambdasPersona1 {
    static void ordenarPorNombre(ArrayList<Persona> miLista) {
        miLista
                .stream()
                .sorted((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()))
                .forEach(System.out::println);
    }

    static void ordenarPorEdad(ArrayList<Persona> miLista) {
        miLista
                .stream()
                .sorted((p1, p2) -> p2.getEdad() - p1.getEdad())
                .forEach(p -> System.out.println(p));
    }

    static void ordenarInversoEdad(ArrayList<Persona> miLista) {
        miLista.sort((p1, p2) -> p2.getEdad() - p1.getEdad());
    }

    static void aumentarEdad(ArrayList<Persona> miLista) {
        miLista
                .stream()
                .peek(p -> p.setEdad(p.getEdad() + 1))
                .forEach(System.out::println);
    }

    static void mostrarListaPersonas(ArrayList<Persona> miLista) {
        miLista
                .stream()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        ArrayList<Persona> miLista = new ArrayList<Persona>();
        miLista.add(new Persona("Miguel", 15));
        miLista.add(new Persona("Alicia", 14));
        miLista.add(new Persona("Carlos", 72));
        ordenarPorNombre(miLista);
        System.out.println("nom________________");
        mostrarListaPersonas(miLista);
        System.out.println("norm________________");
        ordenarPorEdad(miLista);
        System.out.println("edad________________");
        aumentarEdad(miLista);
        System.out.println("aument________________");
        mostrarListaPersonas(miLista);
        System.out.println("norm________________");
        ordenarInversoEdad(miLista);
        mostrarListaPersonas(miLista);
        System.out.println("inverso edad -----------------");
    }

}
