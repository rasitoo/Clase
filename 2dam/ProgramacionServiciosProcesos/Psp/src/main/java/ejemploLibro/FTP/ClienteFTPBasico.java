package ejemploLibro.FTP;

import javax.swing.*;
import javax.swing.event.*;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @author Rodrigo
 * @date 18 febrero, 2025
 */
public class ClienteFTPBasico extends JFrame {
    private static final long serialVersionUID = 1L;
    static JTextField cab = new JTextField();
    static JTextField cab2 = new JTextField();
    static JTextField cab3 = new JTextField();
    private static JTextField campo = new JTextField();
    private static JTextField campo2 = new JTextField();
    JButton botonCargar = new JButton("Subir fichero");
    JButton botonDescargar = new JButton("Descargar fichero");
    JButton botonBorrar = new JButton("Eliminar fichero");
    JButton botonCreaDir = new JButton("Crear carpeta");
    JButton botonDelDir = new JButton("Eliminar carpeta");
    JButton botonSalir = new JButton("Salir");
    static JList listaDirec = new JList();
    private final Container c = getContentPane();
    static FTPClient cliente = new FTPClient();
    String servidor = "192.168.16.1";
    String user = "usuario1";
    String pasw = "usu1";
    boolean login;
    static String direcinicial = "/";
    static String direcSelec = direcinicial;
    static String ficheroSelec = "";

    public ClienteFTPBasico() throws IOException {
        super("CLIENTE BÁSICO FTP");
        cliente.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        cliente.connect(servidor);
        login = cliente.login(user, pasw);
        cliente.changeWorkingDirectory(direcinicial);
        FTPFile[] files = cliente.listFiles();
        llenarLista(files, direcinicial);

        campo.setText("<< ARBOL DE DIRECTORIOS CONSTRUIDO >>");
        cab.setText("Servidor FTP: " + servidor);
        cab2.setText("Usuario: " + user);
        cab3.setText("DIRECTORIO RAIZ: " + direcinicial);

        listaDirec.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane barraDesplazamiento = new JScrollPane(listaDirec);
        barraDesplazamiento.setPreferredSize(new Dimension(335, 420));
        barraDesplazamiento.setBounds(new Rectangle(5, 65, 335, 420));
        c.add(barraDesplazamiento);
        c.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(510, 600);
        setVisible(true);

        // Listeners
        listaDirec.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    ficheroSelec = listaDirec.getSelectedValue().toString();
                    campo.setText("Fichero seleccionado: " + ficheroSelec);
                }
            }
        });

        botonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        botonCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Subir fichero seleccionado");
            }
        });

        botonDescargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Descargar fichero seleccionado");
            }
        });

        botonBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Eliminar fichero seleccionado");
            }
        });

        botonCreaDir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Crear carpeta");
            }
        });

        botonDelDir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Eliminar carpeta");
            }
        });
    }

    private static void llenarLista(FTPFile[] files, String direc2) {
        if (files == null) return;
        DefaultListModel modeloLista = new DefaultListModel();
        listaDirec.setForeground(Color.blue);
        Font fuente = new Font("Courier", Font.PLAIN, 12);
        listaDirec.setFont(fuente);
        listaDirec.removeAll();

        try {
            cliente.changeWorkingDirectory(direc2);
            direcSelec = direc2;
            modeloLista.addElement(direc2);

            for (int i = 0; i < files.length; i++) {
                if (!files[i].getName().equals(".") && !files[i].getName().equals("..")) {
                    String f = files[i].getName();
                    if (files[i].isDirectory()) f = "(DIR) " + f;
                    modeloLista.addElement(f);
                }
            }

            listaDirec.setModel(modeloLista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private boolean SubirFichero(String archivo, String soloNombre) throws IOException {
        cliente.setFileType(FTP.BINARY_FILE_TYPE);
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(archivo));
        boolean ok = false;
        cliente.changeWorkingDirectory(direcSelec);
        if (cliente.storeFile(soloNombre, in)) {
            String s = " " + soloNombre + "=>Subido correctamente ... ";
            campo.setText(s);
            campo2.setText("Se va a actualizar el árbol de directorios ... ");
            JOptionPane.showMessageDialog(null, s);
            FTPFile[] ff2 = cliente.listFiles();
            llenarLista(ff2, direcSelec);
            ok = true;
        } else {
            campo.setText("No se ha podido subir ... " + soloNombre);
        }
        in.close();
        return ok;
    }

    private void DescargarFichero(String NombreCompleto, String nombreFichero) {
        try {
            cliente.setFileType(FTP.BINARY_FILE_TYPE);
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(nombreFichero));
            if (cliente.retrieveFile(NombreCompleto, out)) {
                JOptionPane.showMessageDialog(null, nombreFichero + "=>Se ha descargado correctamente ... ");
            } else {
                JOptionPane.showMessageDialog(null, nombreFichero + "=>No se ha podido descargar ... ");
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void BorrarFichero(String NombreCompleto, String nombreFichero) {
        try {
            if (cliente.deleteFile(NombreCompleto)) {
                String m = nombreFichero + "=>Eliminado correctamente ... ";
                JOptionPane.showMessageDialog(null, m);
                campo.setText(m);
                FTPFile[] ff2 = cliente.listFiles();
                llenarLista(ff2, direcSelec);
            } else {
                JOptionPane.showMessageDialog(null, nombreFichero + "=>No se ha podido eliminar ... ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
        new ClienteFTPBasico();
    }
}
