package gficheros.gb7agenda;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Rodrigo
 * @date 16 febrero, 2024
 */
public class ServicioPersona {
    Persona pedirDatos(Scanner sc) {
        Persona p = new Persona();
        Exception e = new Exception();
        try {
            System.out.println("Es un contacto personal? S/N");
            Character c = Character.toLowerCase(sc.next().charAt(0));
            if (c == 's') {
                p.setPersonal(true);
            } else if (c == 'n') {
                p.setPersonal(false);
            } else throw e;
            System.out.println("Escribe el nombre del contacto");
            p.setNombre(sc.next());
            System.out.println("Escribe el telefono del contacto");
            p.setTlf(sc.next());
            System.out.println("Escribe el dia de nacimiento");
            p.setDiacum(sc.nextInt());
            System.out.println("Escribe el mes de nacimiento");
            p.setMescum(sc.nextInt());
        } catch (Exception f) {
            System.err.println("Caracter no valido");
        }
        return p;
    }

    void guardarPersonaFich(DataOutputStream f, Persona p) throws IOException {
        f.writeBoolean(p.isPersonal());
        f.writeUTF(";" + p.getNombre() + ";" + p.getTlf() + ";");
        f.writeInt(p.getDiacum());
        f.writeUTF(";");
        f.writeInt(p.getMescum());
        f.writeUTF("\n");
    }

    void borrarPersonaFich(DataOutputStream f, String nombre){

    }
    int buscarPersonaFich(DataInputStream f, String nombre) {
        int pos = -1;
        return pos;
    }
}
