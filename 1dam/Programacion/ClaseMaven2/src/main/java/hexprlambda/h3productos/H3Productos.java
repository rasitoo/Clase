package hexprlambda.h3productos;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Rodrigo
 * @date 31 marzo, 2024
 */
public class H3Productos {
    static boolean sinStock(String fichero){
        boolean stock = false;
        try (Stream<String> stream = Files.lines(Paths.get(fichero))) {
                    stock = stream.map(linea -> linea.split(";"))
                    .map(Producto::crearDesdeArray)
                            .anyMatch(p -> p.getCantidad() == 0);
                    } catch (IOException e) {
            e.printStackTrace();
        }
        return stock;
    }
    static boolean stock(String fichero){
        boolean stock = true;
        try (Stream<String> stream = Files.lines(Paths.get(fichero))) {
            stock = stream.map(linea -> linea.split(";"))
                    .map(Producto::crearDesdeArray)
                    .anyMatch(p -> p.getCantidad() == 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return !stock;
    }

    public static void main(String[] args) {
        //Desde fichero de texto:
        String fichero = "productosSimples.txt";
        System.out.println("1.      Mostrar nombre de producto de mayor precio.\n" +
                "\n");
        try (Stream<String> stream = Files.lines(Paths.get(fichero))) {
            stream.map(linea -> linea.split(";"))
                    .map(Producto::crearDesdeArray)
                    .onClose(() -> System.out.println(" es el producto de mayor precio"))
                    .max(Comparator.comparingDouble(Producto::getPrecio))
                    .map(Producto::getNombre)
                    .ifPresent(System.out::print);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("2.      Mostrar nombres y precios de  productos de más de 50€ ordenados de menor a mayor precio\n" +
                "\n");
        try (Stream<String> stream = Files.lines(Paths.get(fichero))) {
            stream.map(linea -> linea.split(";"))
                    .map(Producto::crearDesdeArray)
                    .filter(p -> p.getPrecio() > 50)
                    .sorted(Comparator.comparingDouble(Producto::getPrecio))
                    .forEach(p -> System.out.println(p.getNombre() + " - " + p.getPrecio() + "€"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("3.      Mostrar los nombres de los 5 productos más caros.\n" +
                "\n");
        try (Stream<String> stream = Files.lines(Paths.get(fichero))) {
            stream.map(linea -> linea.split(";"))
                    .map(Producto::crearDesdeArray)
                    .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                    .limit(5)
                    .forEach(p -> System.out.println(p.getNombre() + " - " + p.getPrecio() + "€"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("4.      Mostrar los nombres del producto que tiene el 3er precio más caro\n" +
                "\n");

        try (Stream<String> stream = Files.lines(Paths.get(fichero))) {
            List<Producto> productos =
                    stream.map(linea -> linea.split(";"))
                    .map(Producto::crearDesdeArray)
                    .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                    .toList()
                    ;

            if (productos.size() >= 3) {
                Producto tercerProducto = productos.get(2);
                System.out.println("Nombre del tercer producto más caro: " + tercerProducto.getNombre());
            } else {
                System.out.println("No hay suficientes productos para determinar el tercero más caro.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("5.      Crear una lista con los productos con precio menor de 10\n" +
                "\n");

        try (Stream<String> stream = Files.lines(Paths.get(fichero))) {
            stream.map(linea -> linea.split(";"))
                    .map(Producto::crearDesdeArray)
                    .filter(p -> p.getPrecio() < 10)
                    .sorted(Comparator.comparingDouble(Producto::getPrecio))
                    .forEach(p -> System.out.println(p.getNombre() + " - " + p.getPrecio() + "€"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("6.      Crea una lista con los nombres de productos de más de 10 caracteres y que tengan cantidad menor a 10\n" +
                "\n");

        try (Stream<String> stream = Files.lines(Paths.get(fichero))) {
            stream.map(linea -> linea.split(";"))
                    .map(Producto::crearDesdeArray)
                    .filter(p -> p.getNombre().length() > 6) //pide más de 10, pero no tengo ninguno con un nombre tan largo
                    .filter(p -> p.getCantidad() < 10)
                    .forEach(p -> System.out.println(p.getNombre() + " - " + p.getPrecio() + "€"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("7.      Incrementar el precio un 10% a todos los productos.\n" +
                "\n");

        try (Stream<String> stream = Files.lines(Paths.get(fichero))) {
            stream.map(linea -> linea.split(";"))
                    .map(Producto::crearDesdeArray)
                    .forEach(producto -> {
                        double nuevoPrecio = producto.getPrecio() * 1.1;
                        System.out.print("Producto: " + producto.getNombre());
                        System.out.print(" - Precio: anterior: " + producto.getPrecio());
                        System.out.println(" - Nuevo: " + nuevoPrecio);
                        producto.setPrecio(nuevoPrecio); // Actualizamos el precio en la lista
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("8.      Devolver el producto que empiezan por a y tenga menos de 10 en cantidad. Se debe usar el método findFirst() y si no hay ningún producto se debe devolver un producto de nombre (“NADA”).\n" +
                "\n");

        try (Stream<String> stream = Files.lines(Paths.get(fichero))) {
            stream.map(linea -> linea.split(";"))
                    .map(Producto::crearDesdeArray)
                    .filter(p ->(p.getNombre().startsWith("A") || p.getNombre().startsWith("a") )&& p.getCantidad() < 10)
                    .findFirst()
                    .ifPresentOrElse(producto -> System.out.println(producto),() -> System.out.println(new Producto("NADA")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("9.     Devolver verdadero si hay algún producto con cantidad a 0 y false en caso contrario\n" +
                "\n");

        System.out.println(sinStock(fichero));
        System.out.println("10.    Devolver verdadero si todos los productos tienen cantidad  mayor a 0 y false en caso contrario\n");

        System.out.println(stock(fichero));
    }
}
