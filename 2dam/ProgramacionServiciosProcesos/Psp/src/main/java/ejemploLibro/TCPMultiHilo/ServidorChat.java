package ejemploLibro.TCPMultiHilo;

/**
 * @author Rodrigo
 * @date 14 febrero, 2025
 */

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ServidorChat extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    static ServerSocket servidor;
    static final int PUERTO = 44444;
    static int CONEXIONES = 0;
    static int ACTUALES = 0;
    static int MAXIMO = 10;

    //GUI
    static JTextField mensaje = new JTextField("");
    static JTextField mensaje2 = new JTextField("");
    private JScrollPane scrollpanel;
    static JTextArea textarea;
    JButton salir = new JButton("Salir");
    static Socket tabla[] = new Socket[MAXIMO];

    public ServidorChat() {
        super("VENTANA DEL SERVIDOR DE CHAT");
        setLayout(null);
        mensaje.setBounds(10, 10, 400, 30);
        add(mensaje);
        mensaje.setEditable(false);

        mensaje2.setBounds(10, 348, 400, 30);
        add(mensaje2);
        mensaje2.setEditable(false);

        textarea = new JTextArea();
        scrollpanel = new JScrollPane(textarea);
        scrollpanel.setBounds(10, 50, 400, 300);
        add(scrollpanel);
        salir.setBounds(420, 10, 100, 30);
        add(salir);

        textarea.setEditable(false);
        salir.addActionListener(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salir) {
            try {
                servidor.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.exit(0);
        }
    }
    //\GUI

    public static void main(String[] args) throws IOException {
        servidor = new ServerSocket(PUERTO);
        System.out.println("Servidor iniciado ...");
        //GUI
        ServidorChat pantalla = new ServidorChat();
        pantalla.setBounds(0, 0, 540, 400);
        pantalla.setVisible(true);
        mensaje.setText("NUMERO DE CONEXIONES ACTUALES: " + 0);
        //\GUI
        while (CONEXIONES < MAXIMO) {
            Socket s;
            try {
                s = servidor.accept();//El servidor.accept escucha en busca de una conexion, hasta que no ocurre el codigo no continua
            } catch (SocketException ns) {
                //Si la encuentra entonces se añade la conexion a la tabla y se suma 1 al número de conexiones
                break;
            }

            tabla[CONEXIONES] = s;
            CONEXIONES++;
            ACTUALES++;

            HiloServidor hilo = new HiloServidor(s); //Se hace un hilo servidor para el nuevo socket aceptado
            hilo.start();
        }

        if (!servidor.isClosed()) {
            try {
                //GUI
                mensaje2.setForeground(Color.red);
                mensaje2.setText("MÁXIMO Nº DE CONEXIONES ESTABLECIDAS: " + CONEXIONES);
                //\GUI
                servidor.close(); //si superamos el número de conexiones el servidor se cierra (mejorable)
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Servidor finalizado ...");
    }
}
