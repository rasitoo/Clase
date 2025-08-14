package iherencia.i3interfazordenar;

import lombok.Data;

import java.util.ArrayList;

/**
 * @author Rodrigo
 * @date 12 abril, 2024
 */
@Data
public class Empresa {
    ArrayList<Empleado> empleados = new ArrayList<Empleado>();
    public Empleado[] burbuja(Empleado[] v) {
        Empleado aux;
        for (int j = 0; j < v.length; j++) {
            for (int i = 0; i < v.length - 1; i++) {
                if (v[i].esMayor(v[i + 1])) {
                    aux = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = aux;
                }
            }
        }
        return v;
    }
    public Persona[] burbuja(Persona[] v) {
        Persona aux;
        for (int j = 0; j < v.length; j++) {
            for (int i = 0; i < v.length - 1; i++) {
                if (v[i].esMayor(v[i + 1])) {
                    aux = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = aux;
                }
            }
        }
        return v;
    }

    public static void main(String[] args) {
        Empresa ej = new Empresa();
        ej.empleados.add(new Empleado());
        ej.empleados.add(new Empleado());
        ej.empleados.add(new Empleado());
        ej.empleados.add(new Empleado());
        ej.empleados.add(new Empleado());
        ej.empleados.add(new Empleado());
        ej.empleados.add(new Empleado());

        Empleado[] empleados1 = ej.burbuja(ej.empleados.toArray(new Empleado[ej.empleados.size()]));

        for (int i = 0; i < empleados1.length; i++){
            System.out.println(empleados1[i]);
        }
        ArrayList<Persona> personas = new ArrayList<Persona>();
        personas.add(new Persona());
        personas.add(new Persona());
        personas.add(new Persona());
        personas.add(new Persona());
        personas.add(new Persona());
        personas.add(new Persona());
        personas.add(new Persona());
        personas.add(new Persona());

        Persona[] personas1 = ej.burbuja(personas.toArray(new Persona[personas.size()]));
        for (int i = 0; i < personas1.length; i++){
            System.out.println(personas1[i]);
        }
    }

}
