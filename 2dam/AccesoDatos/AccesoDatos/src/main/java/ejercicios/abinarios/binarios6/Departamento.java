package ejercicios.abinarios.binarios6;

/**
 * @author Rodrigo
 * @date 16 octubre, 2024
 */
public class Departamento {
    private int numdep;
    private String nombre;
    private String localidad;

    public int getNumdep() {
        return numdep;
    }

    public void setNumdep(int numdep) {
        this.numdep = numdep;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Departamento(int numdep, String nombre, String localidad) {
        this.numdep = numdep;
        this.nombre = nombre;
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "numdep=" + numdep +
                ", nombre='" + nombre + '\'' +
                ", localidad='" + localidad + '\'' +
                '}';
    }


}
