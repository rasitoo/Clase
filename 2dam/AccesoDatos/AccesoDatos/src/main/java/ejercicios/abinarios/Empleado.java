package ejercicios.abinarios;

import java.io.*;

/**
 * @author Rodrigo
 * @date 08 octubre, 2024
 */
public class Empleado {

    private static final String PATH = ".\\src\\main\\resources\\empleados.txt";


    private int cod;
    private String nom;
    private int salario;
    private String fechnac;

    // El cod son 4 bytes, el nom
    @Override
    public String toString() {
        return "Empleado{" +
                "cod=" + cod +
                ", nom='" + nom + '\'' +
                ", salario=" + salario +
                ", fechnac='" + fechnac + '\'' +
                '}';
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getFechnac() {
        return fechnac;
    }

    public void setFechnac(String fechnac) {
        this.fechnac = fechnac;
    }

    public Empleado(int cod, String nom, int salario, String fechnac) {
        this.cod = cod;
        this.nom = nom;
        this.salario = salario;
        this.fechnac = fechnac;
    }

    public Empleado leerEmpleados(DataInputStream lectura) throws IOException {
        cod = lectura.readInt();
        nom = lectura.readUTF();
        salario = lectura.readInt();
        fechnac = lectura.readUTF();
        return new Empleado(cod, nom, salario, fechnac);
    }

    public void grabarEmpleado(DataOutputStream f) throws IOException {
        f.writeInt(this.getCod());
        f.writeUTF(this.getNom());
        f.writeInt(this.getSalario());
        f.writeUTF(this.getFechnac());
    }

    public static void main(String[] args) {
        Empleado empleado;
        File origen = new File(PATH);
        try {
            if (!origen.exists())
                origen.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File destino = new File(PATH);
        boolean leido = false;


        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(origen)); DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(destino, true))) {
            empleado = new Empleado(111111, "Luis Jimenez Rosa", 1200, "18/10/1995");
            empleado.grabarEmpleado(outputStream);

            empleado = new Empleado(111112, "Carlos Diaz Sosa", 1300, "18/10/1992");
            empleado.grabarEmpleado(outputStream);

            empleado = new Empleado(111113, "Maria Garcia Fernandez", 1100, "18/10/1990");
            empleado.grabarEmpleado(outputStream);

            while (inputStream.available() > 0)
                System.out.println(empleado.leerEmpleados(inputStream));


        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
