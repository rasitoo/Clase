package exprlambda.lambdapersonaprof;

public class Persona {
    String nombre;
    int edad;

    public Persona( String nombre, int edad) {
        this.edad = edad;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre+" "+edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
