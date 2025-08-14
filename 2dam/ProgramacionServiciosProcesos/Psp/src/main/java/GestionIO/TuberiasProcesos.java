package GestionIO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TuberiasProcesos {

  public static void main(String[] args) {

    ProcessBuilder pb1 = new ProcessBuilder("grep", "^video");
    //ProcessBuilder pb2 = new ProcessBuilder("sed", "s/\t\t*/:/g");
    ProcessBuilder pb2 = new ProcessBuilder("cat");
    ArrayList<ProcessBuilder> lpb = new ArrayList<ProcessBuilder>();
    lpb.add(pb1);
    lpb.add(pb2);

    // Redirección de entrada del primer proceso y de salida del último
    pb1.redirectInput(new File("/etc/mime.types"));
    pb2.redirectOutput(ProcessBuilder.Redirect.INHERIT);

    try {
      ProcessBuilder.startPipeline(lpb);
    } catch (IOException ex) {
      System.err.println("Error durante ejecución del proceso");
      System.err.println("Información detallada");
      System.err.println("---------------------");
      ex.printStackTrace();
      System.err.println("---------------------");
    }

  }

}
