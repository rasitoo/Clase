package ejemploLibro.UDPMultiHilo;

/**
 * @author Rodrigo
 * @date 14 febrero, 2025
 */
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class MultiChatUDP extends JFrame implements ActionListener, Runnable {
    static MulticastSocket ms = null;
    static byte[] buf = new byte[1000];
    static InetAddress grupo = null;
    static int Puerto = 12345; // Puerto multicast
    String nombre;
    static JTextField mensaje = new JTextField();
    private JScrollPane scrollpanel;
    static JTextArea textareal;
    JButton boton = new JButton("Enviar");
    JButton desconectar = new JButton("Salir");
    boolean repetir = true;

    public MultiChatUDP(String nombre) {
        super("CONEXIÓN DEL CLIENTE CHAT: " + nombre);
        setLayout(null);
        mensaje.setBounds(10, 10, 400, 30);
        add(mensaje);
        textareal = new JTextArea();
        scrollpanel = new JScrollPane(textareal);
        scrollpanel.setBounds(10, 50, 400, 300);
        add(scrollpanel);
        boton.setBounds(420, 10, 100, 30);
        add(boton);
        desconectar.setBounds(420, 50, 100, 30);
        add(desconectar);
        textareal.setEditable(false);
        boton.addActionListener(this);
        desconectar.addActionListener(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.nombre = nombre;
    }

    public static void main(String args[]) throws IOException {
        String nombre = JOptionPane.showInputDialog("Introduce tu nombre o nick:");

        // Se crea el socket multicast
        ms = new MulticastSocket(Puerto);
        grupo = InetAddress.getByName("225.0.0.1"); // Grupo multicast

        // Nos unimos al grupo
        ms.joinGroup(grupo);

        if (!nombre.trim().equals("")) {
            MultiChatUDP server = new MultiChatUDP(nombre);
            server.setBounds(0, 0, 540, 400);
            server.setVisible(true);
            new Thread(server).start(); // Lanzar hilo
        } else {
            System.out.println("El nombre está vacío .... ");
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton) { // SE PULSA ENVIAR
            String texto = nombre + ">>" + mensaje.getText();
            try {
                // ENVIANDO mensaje al grupo
                DatagramPacket paquete = new DatagramPacket(texto.getBytes(), texto.length(), grupo, Puerto);
                ms.send(paquete);
            } catch (IOException el) {
                el.printStackTrace();
            }
        }

        if (e.getSource() == desconectar) { // SE PULSA SALIR
            String texto = "*** Abandona el chat: " + nombre + "***";
            try {
                // ENVIANDO DESPEDIDA AL GRUPO
                DatagramPacket paquete = new DatagramPacket(texto.getBytes(), texto.length(), grupo, Puerto);
                ms.send(paquete);
                ms.close();
                repetir = false;
                System.out.println("Abandona el chat: " + nombre);
                System.exit(0);
            } catch (IOException el) {
                el.printStackTrace();
            }
        }
    }

    public void run() {
        while (repetir) {
            try {
                DatagramPacket p = new DatagramPacket(buf, buf.length);
                ms.receive(p); // Recibo mensajes
                String texto = new String(p.getData(), 0, p.getLength());
                textareal.append(texto + "\n");
            } catch (SocketException s) {
                System.out.println(s.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

