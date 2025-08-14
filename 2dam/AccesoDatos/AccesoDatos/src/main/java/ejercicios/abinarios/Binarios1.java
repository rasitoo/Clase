package ejercicios.abinarios;

import java.io.*;

/**
 * @author Rodrigo
 * @date 09 octubre, 2024
 */
public class Binarios1 {
    private static final String PATH = ".\\src\\main\\resources\\Bin1.txt";

    private String nom;
    private String dir;
    private long numtel;

    public Binarios1(String nom, String dir, long numtel) {
        this.nom = nom;
        this.dir = dir;
        this.numtel = numtel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public long getNumtel() {
        return numtel;
    }

    public void setNumtel(long numtel) {
        this.numtel = numtel;
    }

    @Override
    public String toString() {
        return "Binarios1{" +
                "nom='" + nom + '\'' +
                ", dir='" + dir + '\'' +
                ", numtel=" + numtel +
                '}';
    }

    public Binarios1 leer(DataInputStream lectura) throws IOException {
        nom = lectura.readUTF();
        dir = lectura.readUTF();
        numtel = lectura.readLong();
        return new Binarios1(nom, dir, numtel);
    }

    public void grabar(DataOutputStream f) throws IOException {
        f.writeUTF(this.getNom());
        f.writeUTF(this.getDir());
        f.writeLong(this.getNumtel());
    }

    public static void main(String[] args) {
        Binarios1 ej;
        File origen = new File(PATH);
        try {
            if (!origen.exists())
                origen.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File destino = new File(PATH);

        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(origen)); DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(destino, true))) {
            ej = new Binarios1("un nombre", "una direcion", 942334455);
            ej.grabar(outputStream);

            while (inputStream.available() > 0)
                System.out.println(ej.leer(inputStream));

            outputStream.close();
            inputStream.close();

        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
