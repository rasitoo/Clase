package CmdsSimples;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class CmdsSimples {

  public static int MAX_TIEMPO = 11;

  public static void main(String[] args) throws InterruptedException {
      ProcessBuilder pb=new ProcessBuilder();
    Process p=null;
    //   String[] comandoFinal = new String[]{"/bin/java", "--version"};  //en wsl
         String[] comandoFinal = new String[]{"notepad", "kk.txt"};
  //  String[] comandoFinal = new String[]{ "java", "--version"}; // en windows
  //   String[] comandoFinal = new String[]{ "bash","-c","pwd"}; // en windows da /mnt/c/Users/josema/Documents/java/ProyecJetBrains/PSP/ProcesosPesados/EsperaFinProcesoSleep
   // String[] comandoFinal = new String[]{ "java", "./target/classes/org/EscribeCadaSeg"}; // en windows
    //colocar el fichero .class en el directorio org/example de la raiz del proyecto
    File miDir = new File(".");
    String dirActual="";
    try {
      dirActual=miDir.getCanonicalPath();
      System.out.println("Dir actual:"+dirActual);
    }
    catch(Exception e) {
      e.printStackTrace();
    }

    if (System.getProperty("os.name").toLowerCase().contains("windows")) {
      System.out.println("En windows");
    } else {
        System.out.println("En wsl");
        pb.inheritIO();
    }
     pb = new ProcessBuilder(comandoFinal);
    pb.inheritIO();
    try {
       p = pb.start();
    } catch (IOException e) {
      System.err.println("Error durante ejecución del proceso");
      e.printStackTrace();
    }
    System.out.println("Proceso padre ");
    p.waitFor();
    System.out.println("Finalizó el hijo ");
  }

}
