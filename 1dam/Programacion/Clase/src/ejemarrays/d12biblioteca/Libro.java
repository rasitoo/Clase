package ejemarrays.d12biblioteca;

public class Libro {
    int codigo;
    String titulo;
    int prestado;
    Libro(int codigo,String titulo){
        this.codigo = codigo;
        this.titulo = titulo;
        prestado = -1;
    }
    void mostrar(){
        System.out.print("Código: " + codigo);
        System.out.print("\tTítulo: " + titulo);
        if (prestado == -1)
            System.out.print("\tPRÉSTAMO DISPONIBLE");
        System.out.println();
    }
}
