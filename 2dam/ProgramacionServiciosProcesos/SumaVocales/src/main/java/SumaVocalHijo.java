import java.io.*;
import java.text.Normalizer;

/**
 * La clase SumaVocalHijo se encarga de contar las ocurrencias de una vocal específica
 * en un archivo de entrada y escribir el resultado en un archivo de salida.
 * <p>
 *
 * La clase lee la ruta del archivo de entrada, la vocal a contar y la ruta del archivo de salida desde la entrada estándar.
 * Luego cuenta las ocurrencias de la vocal especificada (sin distinguir entre mayúsculas y minúsculas) en el archivo de entrada y escribe el conteo en el archivo de salida.
 * <p>
 *

 * Autor: Chema y Rodrigo
 * Fecha: 14 enero, 2025
 * </p>
 */
public class SumaVocalHijo {

    /**
     * El método main de la clase SumaVocalHijo.
     * <p>
     * Este método lee la ruta del archivo de entrada, la vocal a contar y la ruta del archivo de salida desde la entrada estándar.
     * Luego cuenta las ocurrencias de la vocal especificada (sin importar tilde, mayúscula o minúscula) en el archivo de entrada y escribe el conteo en el archivo de salida.
     * <p>
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     * @throws IOException Si ocurre un error de E/S.
     */
    public static void main(String[] args) throws IOException {
        String inputFile;
        char vocal;
        String outputFile;
        int count = 0;

        //Para recibir los datos del proceso padre usé la consola, de esta forma el padre escribe en la consola y el hijo la lee, es la única forma que he encontrado.

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            inputFile = ".\\" + br.readLine();
            vocal = br.readLine().charAt(0);
            outputFile = br.readLine();
        }


        //Este reader lee el texto de entrada hasta que termine mediante un while.
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                //Separa las tildes con el normalizer, sacado de https://es.stackoverflow.com/questions/31178/c%C3%B3mo-limpiar-string-de-tildes-en-java
                line = Normalizer.normalize(line, Normalizer.Form.NFD);
                //lee carácter por carácter y si coincide con la vocal que recibimos del proceso padre por consola suma 1
                for (char c : line.toCharArray()) {
                    if (Character.toLowerCase(c) == Character.toLowerCase(vocal)) {
                        count++;
                    }
                }
            }
        }
        //Se crea el archivo donde se pondrá el número de vocales
        File f = new File(outputFile);
        f.createNewFile();
        //Se escribe el número de vocales
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(String.valueOf(count));
        }

    }
}
