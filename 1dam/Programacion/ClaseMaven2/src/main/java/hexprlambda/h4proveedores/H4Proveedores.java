package hexprlambda.h4proveedores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @author Rodrigo
 * @date 04 abril, 2024
 */
public class H4Proveedores {
    //la idea es que los productos tengan un arraylist
    // de proveedores
    //en el metodo crear desde un array debe leer nombres hasta final de la linea

    public static void main(String[] args) {
        //Desde fichero de texto:
        String fichero = "productosConProveedores.txt";
        System.out.println("Prueba lectura de fichero");
        try (Stream<String> stream = Files.lines(Paths.get(fichero))) {
            stream.map(linea -> linea.split(";"))
                    .map(Producto::crearDesdeArray)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("a)      Mostrar productos que  tengan más de 1 proveedor\n");

        try (Stream<String> stream = Files.lines(Paths.get(fichero))) {
            stream.map(linea -> linea.split(";"))
                    .map(Producto::crearDesdeArray)
                    .filter(p -> p.getProveedorArrayList().size() > 1)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("b)     Mostrar productos que tienen a Ana como proveedor\n");

        try (Stream<String> stream = Files.lines(Paths.get(fichero))) {
            stream.map(linea -> linea.split(";"))
                    .map(Producto::crearDesdeArray)
                    .filter(p -> p.getProveedorArrayList().contains(new Proveedor("Ana")))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("c)      Mostrar los identificadores de los productos que no tienen ningún proveedor\n");

        try (Stream<String> stream = Files.lines(Paths.get(fichero))) {
            stream.map(linea -> linea.split(";"))
                    .map(Producto::crearDesdeArray)
                    .filter(p -> p.getProveedorArrayList().isEmpty())
                    .map(Producto::getId)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("d)     Mostrar, utilizando flatMap, los nombres de los proveedores de los productos. Solo los proveedores, no se mostrarán los productos. Si un proveedor aparece en varios productos solo se mostrará una vez\n");

        try (Stream<String> stream = Files.lines(Paths.get(fichero))) {
            stream.map(linea -> linea.split(";"))
                    .map(Producto::crearDesdeArray)
                    .flatMap( p -> p.getProveedorArrayList().stream().map(Proveedor::getNombre))
                    .distinct()
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
