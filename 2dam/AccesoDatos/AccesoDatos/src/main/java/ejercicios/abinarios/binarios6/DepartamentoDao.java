package ejercicios.abinarios.binarios6;


import java.io.*;
import java.util.ArrayList;

/**
 * @author Rodrigo
 * @date 16 octubre, 2024
 */
public class DepartamentoDao {
    private static final String PATH = ".\\src\\main\\resources\\Bin6.txt";
    File origen;
    File destino;
    ArrayList<Departamento> lista = new ArrayList<>();

    public DepartamentoDao() {
        origen = new File(PATH);
        destino = new File(PATH);
        try {
            if (!origen.exists())
                origen.createNewFile();
            if (!destino.exists())
                destino.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(origen))) {
            while (inputStream.available() > 0)
                lista.add(this.leer(inputStream));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private Departamento leer(DataInputStream f) throws IOException {
        int cod = f.readInt();
        String nombre = f.readUTF();
        String localidad = f.readUTF();
        return new Departamento(cod, nombre, localidad);
    }

    public boolean eliminarDep(int num) {
        lista.remove(lista.stream().filter(d-> d.getNumdep() == num).findFirst().get());
        try {
            this.actualizarBBDD();
            return true;
        }catch (IOException e){
            System.err.println(e);
            return false;
        }
    }

    public boolean anadirDep(Departamento dep) {
        try (DataOutputStream fsalida = new DataOutputStream(new FileOutputStream(destino,true))) {
            fsalida.writeInt(dep.getNumdep());
            fsalida.writeUTF(dep.getNombre());
            fsalida.writeUTF(dep.getLocalidad());
            lista.add(dep);
            return true;
        }  catch (IOException e) {
            System.err.println(e);
            return false;
        }
    }public boolean anadirDepSinLista(Departamento dep) {
        try (DataOutputStream fsalida = new DataOutputStream(new FileOutputStream(destino,true))) {
            fsalida.writeInt(dep.getNumdep());
            fsalida.writeUTF(dep.getNombre());
            fsalida.writeUTF(dep.getLocalidad());
            return true;
        }  catch (IOException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean modificarDep(int num, String nom, String loc) {
        Departamento dep = lista.stream().filter(d-> d.getNumdep() == num).findFirst().get();
        int pos = lista.indexOf(dep);
        lista.set(pos, new Departamento(num, nom, loc));
        try {
            this.actualizarBBDD();
            return true;
        }catch (IOException e){
            System.err.println(e);
            return false;
        }
    }

    private void actualizarBBDD() throws IOException {
        destino.delete();
        destino.createNewFile();
        for (int i = 0; i < lista.size(); i++){
            this.anadirDepSinLista(lista.get(i));
        }
        this.actualizarList();
    }

    private void actualizarList() {
        lista.clear();
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(origen))) {
            while (inputStream.available() > 0)
                lista.add(this.leer(inputStream));
        } catch (Exception e) {
            System.err.println(e);
        }
        listar();
    }

    public boolean encontrarDept(int num) {
        boolean encontrado = false;
        if (lista.stream().anyMatch(d -> d.getNumdep() == num))
            encontrado = true;
        return encontrado;
    }

    public void listar() {
        lista.forEach(System.out::println);
    }
}
