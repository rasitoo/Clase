package hexprlambda.ejemprofe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreacionStream {
    static void listarNombres(Stream<Persona> strPersonas) {
        List<String> listaNombres = strPersonas.
                map(Persona::getNombre).  //transformo con Function implicita (p)->p.getNombre()
                        toList();  //convierto en lista de 'Stringcollect(Collectors.toList());'
        for (String s : listaNombres)
            System.out.println(s);
    }

    static void listarInteger(Stream<Integer> str) {
        Integer[] intArr = str.toArray(Integer[]::new);
        System.out.println(Arrays.toString(intArr));
        for (Integer i : intArr)
            System.out.print(i + ",");
        System.out.println();
    }

    static void media(Stream<Persona> strPersonas) {
        List<Persona> personas = strPersonas.filter(p -> p.edad <= 120 && p.edad > 0)
                .toList();
        long cont = personas.size(); //'.collect(Collectors.counting()) or stream.count'
        double mediaEdades = personas.stream().collect(Collectors.averagingInt(p -> p.edad)); //se podria hacer un stream de double

        System.out.println("hay " + cont + " personas con edades validas y su media de edades es: " + mediaEdades);
    }

    static void negativosPositivos(Stream<Integer> str) {
        List<Integer> nums = str.toList();

        long contnega = nums.stream().filter(i -> i < 0).collect(Collectors.counting());
        double medianega = nums.stream().filter(i -> i < 0).collect(Collectors.averagingInt(i -> i));
        System.out.println("hay " + contnega + " numeros negativos y su media es: " + medianega);

        long contposi = nums.stream().filter(i -> i >= 0).collect(Collectors.counting());
        double mediaposi = nums.stream().filter(i -> i >= 0).collect(Collectors.averagingInt(i -> i));
        System.out.println("hay " + contposi + " numeros positivos y su media es: " + mediaposi);

    }

    public static void main(String[] args) {
//        Stream<Integer> strInteger = Stream.of(1, 2, 3, 4, 5, 6);
//        IntStream strInteger2 = Arrays.stream(new int[]{4, 6, 7, 8});
//        Stream<Integer> strInteger3 = Stream.iterate(3, x -> x + 3).limit(10);
        Stream<Integer> strInteger4 = Stream.generate(new Random()::nextInt).limit(5);
//        Stream<String> strString = Arrays.asList("Uno", "dos", "tres").parallelStream();

        negativosPositivos(strInteger4);
//        listarInteger(strInteger4);

        ArrayList<Persona> miLista = new ArrayList<Persona>();
        miLista.add(new Persona("Miguel", -12341));
        miLista.add(new Persona("Alicia", 34));
        miLista.add(new Persona("Carlos", 32));
        miLista.add(new Persona("Pedro", 23));
        miLista.add(new Persona("Juan", 21));
        miLista.add(new Persona("Jhojahn", 12346));


        Stream<Persona> strPersonas = miLista.stream();
        media(strPersonas);

//        System.out.println("Listado 1:");
//        listarNombres(strPersonas);
//        //No puedo ejecutar 2 veces el listado sobre el mismo stream ya recorrido
//        // listarNombres(strPersonas);
//
//        Supplier<Persona> supplier = LambdaPersona::crearPersona;
//        Stream<Persona> strPersonas2;
//        strPersonas2 = Stream.generate(supplier).limit(3);
//        System.out.println("Listado 2:");
//        listarNombres(strPersonas2);


//        //Desde fichero de texto:
//        String fichero = "datos.txt"; //Nombre y edad separados por coma
//        //Muestra la suma de edades de los datos del fichero
//        try (Stream<String> stream = Files.lines(Paths.get(fichero))) {
//            stream.map(linea -> linea.split(","))
//                    .map(Persona::crearDesdeArray)
//                    .mapToDouble(o -> o.getEdad())
//                    .onClose(() -> System.out.println(" es la suma de edades"))
//                    .reduce(Double::sum)
//                    .ifPresent(System.out::print);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        System.out.println("Listado 3 (de fichero):");
//        try (Stream<String> stream = Files.lines(Paths.get(fichero))) {
//            stream.map(linea -> linea.split(","))
//                    .map(Persona::crearDesdeArray)
//                    .forEach(System.out::println);
//            //  .forEach(System.out::println);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
