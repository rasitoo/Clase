package ejercicio1ficheros.operacionesbinarias;

import java.io.Serializable;

/**
 * @author Rodrigo
 * @date 03 diciembre, 2024
 */
public class Tienda implements Serializable {
    String id;
    String nombre;
    String localidad;
    double beneficiosAnuales;
    double beneficiosMensuales;

    public Tienda(String id, String nombre, String localidad, double beneficiosAnuales, double beneficiosMensuales) {
        this.id = id;
        this.nombre = nombre;
        this.localidad = localidad;
        this.beneficiosAnuales = beneficiosAnuales;
        this.beneficiosMensuales = beneficiosMensuales;
    }

    public Tienda() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public double getBeneficiosAnuales() {
        return beneficiosAnuales;
    }

    public void setBeneficiosAnuales(double beneficiosAnuales) {
        this.beneficiosAnuales = beneficiosAnuales;
    }

    public double getBeneficiosMensuales() {
        return beneficiosMensuales;
    }

    public void setBeneficiosMensuales(double beneficiosMensuales) {
        this.beneficiosMensuales = beneficiosMensuales;
    }
}
