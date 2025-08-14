/**
 * @author Rodrigo
 * @date 27 febrero, 2025
 */
import java.io.*;
import java.security.*;
import javax.crypto.*;

public class AlmacenaClaveSecreta {
    public static void main(String[] args) {
        try {
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128);
            // Genera clave secreta
            SecretKey clave = kg.generateKey();
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Clave.secreta"));
            out.writeObject(clave);
            out.close();
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }
}
