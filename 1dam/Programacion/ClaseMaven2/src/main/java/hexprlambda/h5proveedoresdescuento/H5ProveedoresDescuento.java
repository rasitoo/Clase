package hexprlambda.h5proveedoresdescuento;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Rodrigo
 * @date 31 marzo, 2024
 */

public class H5ProveedoresDescuento {
    static ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();

    public static boolean comprobarDescuento(String nombre) {
        return proveedores.stream()
                .map(Proveedor::getNombre)
                .anyMatch(p -> p.equals(nombre));
    }

    public static String proveedorMayorDescuento(ArrayList<Proveedor> prove) {
        Optional<Proveedor> maxDesc = prove.stream()
                .max(Comparator.comparingDouble(Proveedor::getDescuento));

        return maxDesc.map(Proveedor::getNombre).orElse(null);
    }

    public static void main(String[] args) {
        String ficheroproductos = "productosConProveedores.txt";
        String ficheroproveedores = "proveedoresConDescuento.txt";

        System.out.println("a)      Mostrar la lista de los proveedores que tienen descuento\n");
        try (Stream<String> stream = Files.lines(Paths.get(ficheroproveedores))) {
            stream.map(linea -> linea.split(";"))
                    .map(Proveedor::crearDesdeArray)
                    .forEach(proveedores::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        proveedores.forEach(System.out::println);


        System.out.println();

        System.out.println("b)     Mostrar la lista de los productos que tienen proveedores con descuento\n");
        try (Stream<String> stream = Files.lines(Paths.get(ficheroproductos))) {
            stream.map(linea -> linea.split(";"))
                    .map(Producto::crearDesdeArray)
                    .filter(producto -> producto.getProveedorArrayList().stream()
                            .anyMatch(proveedor -> comprobarDescuento(proveedor.getNombre()))
                    )
                    .forEach(System.out::println);
            //tenemos stream de productos, cogemos los proveedores de cada producto y comprobamos si contiene alguno de los proveedores del arraylist proveedores usando el metodo comprobar descuento

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        System.out.println("c)      Mostrar el descuento mayor que nos da un proveedor\n");

        try (Stream<String> stream = Files.lines(Paths.get(ficheroproveedores))) {
            stream.map(linea -> linea.split(";"))
                    .map(Proveedor::crearDesdeArray)
                    .max(Comparator.comparingDouble(Proveedor::getDescuento))
                    .map(Proveedor::getDescuento)
                    .ifPresent(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();

        System.out.println("d)     Mostrar el nombre del proveedor que nos da mayor descuento\n");

        try (Stream<String> stream = Files.lines(Paths.get(ficheroproveedores))) {
            stream.map(linea -> linea.split(";"))
                    .map(Proveedor::crearDesdeArray)
                    .max(Comparator.comparingDouble(Proveedor::getDescuento))
                    .map(Proveedor::getNombre)
                    .ifPresent(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        System.out.println("e)     Mostrar el nombre de los productos suministrados por proveedores que hacen el máximo descuento.\n");

        try (Stream<String> stream = Files.lines(Paths.get(ficheroproductos))) {
            stream.map(linea -> linea.split(";"))
                    .map(Producto::crearDesdeArray)
                    .filter(producto -> producto.getProveedorArrayList().stream()
                            .anyMatch(p -> p.getNombre().equalsIgnoreCase(proveedorMayorDescuento(proveedores))))
                    .map(Producto::getNombre)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        System.out.println("f)       Mostrar el precio total de todos los productos almacenados (precio de cada producto por cantidad)\n");

        try (Stream<String> stream = Files.lines(Paths.get(ficheroproductos))) {
            stream.map(linea -> linea.split(";"))
                    .map(Producto::crearDesdeArray)
                    .forEach(p -> System.out.println(p.getCantidad() * p.getPrecio() + " es el precio total de " + p.getNombre()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        System.out.println("g)      Mostrar el precio total de todos los productos almacenados teniendo en cuenta, al calcular el precio que lo ha suministrado el proveedor de cada producto que hace el mayor descuento. Por tanto si el precio es 1.0€ y hay un proveedor que lo suministra que hace un 10% y otro que hace un 20% de descuento consideraríamos que lo hemos comprado al del 20% y el precio que se utilizará será de 1.0€*(1-20/100)= 0.8€\n");

        try (Stream<String> stream = Files.lines(Paths.get(ficheroproductos))) {
            stream.map(linea -> linea.split(";"))
                    .map(Producto::crearDesdeArray)
                    .forEach(p -> System.out.println((p.getCantidad() * p.getPrecio()) * (1 - (p.mayorDescuento(proveedores) / 100)) + " es el precio con descuento de " + p.getNombre()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
