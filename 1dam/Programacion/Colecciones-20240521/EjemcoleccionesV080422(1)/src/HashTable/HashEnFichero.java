package HashTable;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HashEnFichero {
	static void escritura(){
		try (OutputStream fo= new FileOutputStream("fich.dat")){
			 Properties p = new Properties();
			 p.setProperty("clave1A","Juan");
			 p.setProperty("clave2B","Pepe");
			 p.setProperty("clave3C","Ana");
			 p.store(fo, "escritura Realizada");
		}catch (Exception e){
			System.out.println("Error");
		}
	}
	static void añadir(){
		try (OutputStream fo= new FileOutputStream("fich.dat", true)){
			 Properties p = new Properties();
			 p.setProperty("clave4D","Oscar" );
			 p.setProperty("clave5E","Marta");
			 p.store(fo, null);
		}catch (Exception e) {
			System.out.println("Error");
		}
	}
	static void lecturaClaves(){
		try (InputStream fi= new FileInputStream("fich.dat")){
			 Properties p = new Properties();
			 p.load(fi);
			 String clavePepe=p.getProperty("Pepe");
			 System.out.println("Clave de Pepe:"+clavePepe);
			 String claveNoExiste=p.getProperty("No existe");  //null
			 System.out.println("Clave de No existe:"+claveNoExiste);
			 System.out.println("TODOS los usuarios.");
			 for (String s : p.stringPropertyNames())
				 System.out.println(s);
		}catch (Exception e){
			System.out.println("Error");
		}
	}
	static void lecturaClaveValor(){
	  try (InputStream fi= new FileInputStream("fich.dat")){
		Properties p = new Properties();
		p.load(fi);		  
        Set set = p.entrySet();
        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            Map.Entry entry = (Map.Entry)itr.next();
            System.out.println(entry.getKey() + " = "
                               + entry.getValue());
        }
	  }catch (Exception e){
		System.out.println("Error");
	  }
    }
	static void valoresSistema(){
		Properties p = System.getProperties();
        Set set = p.entrySet();
        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            Map.Entry entry = (Map.Entry)itr.next();
            System.out.println(entry.getKey() + " = "
                               + entry.getValue());
        }
    }
	
	public static void main(String[] args) {
		lecturaClaveValor();
	}

}
