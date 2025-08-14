package OtrosCmds;

import java.util.Map;
import java.util.Map.Entry;

public class MostrarEntornoEjec {

  public static void main(String[] args) {

    ProcessBuilder pb1 = new ProcessBuilder("pwd"); // Da igual el comando

    Map<String, String> env = pb1.environment();

    for (Entry<String, String> entrada : env.entrySet()) {
      System.out.printf("%s: %s\n", entrada.getKey(), entrada.getValue());
    }

  }
}
