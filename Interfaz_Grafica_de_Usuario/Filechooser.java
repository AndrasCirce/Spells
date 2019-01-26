package Interfaz_Grafica_de_Usuario;

import java.io.*;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Adeaf
 */
public class Filechooser {

    JFrame ventana;
    JPanel pnl;
    JTextArea txa;
    File archivo;
    JScrollPane sl;
    JButton btn;
    JFileChooser seek;

    public Filechooser() {
        create();
        prepare();
        launch();
        abrir();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    private void create() {
        ventana = new JFrame();
        pnl = new JPanel();
        txa = new JTextArea();
        sl = new JScrollPane();
        btn = new JButton("Abrir");
        archivo = new File("");
        seek = new JFileChooser();
    }

    private void prepare() {
        ventana.setTitle("TextArea");
        ventana.setSize(600, 600);
        ventana.getContentPane().add(sl);
        sl.setViewportView(pnl);
        //txa.setText("hola");

    }

    public void launch() {
        ventana.add(pnl);
        pnl.add(txa);
    }

    public void abrir() {
        File scriba = null;
        FileReader fr = null;
        BufferedReader br = null;

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            //string a almacena ruta de archivo
            String a = (selectedFile.getAbsolutePath());
            try {

                // Apertura del fichero y creacion de BufferedReader para poder
                // hacer una lectura comoda (disponer del metodo readLine()).
                scriba = new File(a);
                txa.setText(a);
                fr = new FileReader(scriba);
                br = new BufferedReader(fr);
                // Lectura del fichero
                String linea;
                while ((linea = br.readLine()) != null) {
                    txa.append(linea + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Filechooser();
    }
}
