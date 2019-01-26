
package Interfaz_Grafica_de_Usuario;

import java.io.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;

/**
 *
 * @author Adeaf
 */
public class AreaDeTexto {

    JFrame ventana;
    JPanel pnl;
    JTextArea txa;
    File archivo;
    FileWriter fichero;
    PrintWriter pw;
    JScrollPane sl;
    
    public AreaDeTexto() {
        create();
        prepare();
        launch();
        write();
    }

    private void create() {
        ventana = new JFrame();
        pnl = new JPanel();
        txa = new JTextArea();
        sl = new JScrollPane();
        archivo = new File("C:\\src\\Interfaz_Grafica_de_Usuario\\archivo.txt");
    }

    private void prepare() {
        String leer = "";
        ventana.setTitle("TextArea");
        ventana.setSize(600, 600);
        ventana.add(pnl);
        ventana.getContentPane().add(sl);
        sl.setViewportView(pnl);
        txa.setText(archivo.toString());
        pnl.add(txa);
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("archivo.txt");
            fr = new FileReader(archivo);
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

    private void launch() {
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        
    }

    public void write() {
        //Escritura

        try {
            fichero = new FileWriter("archivo.txt");
            pw = new PrintWriter(fichero);
            for (int i = 0; i < 10; i++) {
                pw.println("Linea " + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        new AreaDeTexto();
    }
}
