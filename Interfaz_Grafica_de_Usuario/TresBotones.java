
package Interfaz_Grafica_de_Usuario;

/**
 *
 * @author Adeaf
 */
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TresBotones {

    JFrame Comp;
    JPanel pnlCont;
    JButton btnBueno, btnMalo, btnFeo, btnSalir;
    JLabel lblEtiqueta;

    public TresBotones() {
        create();
        prepare();
        escucha();
        launch();
    }

    private void create() {
        Comp = new JFrame();
        pnlCont = new JPanel();
        lblEtiqueta = new JLabel();
        btnBueno = new JButton("Bueno");
        btnMalo = new JButton("Malo");
        btnFeo = new JButton("Feo");
        btnSalir = new JButton("Salir");

    }

    private void prepare() {
        Comp.setTitle("Tres botones");
        Comp.setSize(400, 400);
        pnlCont.setBackground(new Color(
                (int) (Math.random() * 256),
                (int) (Math.random() * 256),
                (int) (Math.random() * 256)
        ));
        btnBueno.setBounds(50, 50, 90, 30);
        btnBueno.setBackground(Color.BLACK);
        btnBueno.setForeground(Color.WHITE);
        //posicion
        btnMalo.setBounds(100, 100, 90, 30);
        btnFeo.setBounds(150, 150, 90, 30);
        btnSalir.setBounds(200, 200, 90, 30);
        lblEtiqueta.setBounds(20, 300, 200, 40);
        Comp.add(pnlCont);
        pnlCont.add(lblEtiqueta);
        pnlCont.add(btnBueno);
        pnlCont.add(btnMalo);
        pnlCont.add(btnFeo);
        pnlCont.add(btnSalir);
    }

    private void launch() {
        Comp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Comp.setVisible(true);
    }

    private void escucha() {
        btnBueno.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblEtiqueta.setText("Usted ha oprimido el boton Bueno");
                //establecer color aleatorio al panel
                pnlCont.setBackground(new Color(
                        (int) (Math.random() * 256),
                        (int) (Math.random() * 256),
                        (int) (Math.random() * 256)
                ));
            }
        });
        
        btnMalo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblEtiqueta.setText("Usted ha oprimido el boton Malo");
                //establecer color aleatorio al panel
                pnlCont.setBackground(new Color(
                        (int) (Math.random() * 256),
                        (int) (Math.random() * 256),
                        (int) (Math.random() * 256)
                ));
            }
        });
        
        btnFeo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lblEtiqueta.setText("Usted ha oprimido el boton Feo");
                //establecer color aleatorio al panel
                pnlCont.setBackground(new Color(
                        (int) (Math.random() * 256),
                        (int) (Math.random() * 256),
                        (int) (Math.random() * 256)
                ));
            }
        });
        
         pnlCont.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent me) {
                lblEtiqueta.setText(
                        String.format("X: %-5d Y: %-5d", me.getX(), me.getY())
                );
            }
        });
    }

    public static void main(String[] args) {
        new TresBotones();
    }
}

