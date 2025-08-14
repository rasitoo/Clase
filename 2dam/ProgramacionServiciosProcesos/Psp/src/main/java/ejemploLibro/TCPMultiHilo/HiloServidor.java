package ejemploLibro.TCPMultiHilo;

/**
 * @author Rodrigo
 * @date 14 febrero, 2025
 */
import java.io.*;
import java.net.*;

import java.io.*;
import java.net.*;

public class HiloServidor extends Thread {
    DataInputStream fentrada;
    Socket socket = null;

    public HiloServidor(Socket s) {
        socket = s;

        try {
            // CREO FLUJO DE ENTRADA PARA EL NUEVO SOCKET ACEPTADO
            fentrada = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("ERROR DE E/S");
            e.printStackTrace();
        }
    }

    public void run() {
        ServidorChat.mensaje.setText("NUMERO DE CONEXIONES ACTUALES: " + ServidorChat.ACTUALES);

        // NADA MÁS CONECTARSE EL CLIENTE LE ENVÍO TODOS LOS MENSAJES
        String texto = ServidorChat.textarea.getText();
        EnviarMensajes(texto);

        while (true) {
            String cadena = "";
            try {
                cadena = fentrada.readUTF(); // lee lo que el cliente escribe

                // cuando un cliente finaliza envia un *
                if (cadena.trim().equals("*")) {
                    ServidorChat.ACTUALES--;
                    ServidorChat.mensaje.setText("NUMERO DE CONEXIONES ACTUALES: " + ServidorChat.ACTUALES);
                    break; // salir del while
                }

                ServidorChat.textarea.append(cadena + "\n");
                texto = ServidorChat.textarea.getText();
                EnviarMensajes(texto); // envío texto a todos los clientes
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }

    // ENVIA LOS MENSAJES DEL TEXTAREA A LOS CLIENTES DEL CHAT
    private void EnviarMensajes(String texto) {
        int i;
        // recorremos tabla de sockets para enviarles los mensajes
        for (i = 0; i < ServidorChat.CONEXIONES; i++) {
            Socket sl = ServidorChat.tabla[i]; // obtener socket
            try {
                DataOutputStream fsalida = new DataOutputStream(sl.getOutputStream());
                fsalida.writeUTF(texto); // escribir en el socket el texto
            } catch (SocketException se) {
                // esta excepción ocurre cuando escribimos en un socket
                // de un cliente que ha finalizado
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

