public class Persona {
    int edad;
    String nombre;

    public Persona(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "edad=" + edad +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
