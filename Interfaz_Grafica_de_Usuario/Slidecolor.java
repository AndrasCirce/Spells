
package Interfaz_Grafica_de_Usuario;

/**
 *
 * @author Adeaf
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.*;
import javax.swing.plaf.*;

    
public class Slidecolor extends JFrame {
  private final int ancho = 600;
  private final int altura = 300;
  private JPanel pnl, pnlcontrol;
  private JLabel lbl;
  private JSlider slr, slg, slb;
  
  public Slidecolor(){
    Crear();
    Prop();
    Construye();
    Control();
    mixColores();
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
  }
  
  public void Crear(){
    pnl = new JPanel();
    lbl = new JLabel("JENNY DEATH WHEN?");
    slg = new JSlider(0, 255, 0);
    slr = new JSlider(0, 255, 0);
    slb = new JSlider(0, 255, 0);
    pnlcontrol = new JPanel();
  }
  
  public void Prop(){
    lbl.setFont(new Font("serif", Font.BOLD, 50));
    setSize(ancho,altura);
    pnlcontrol.setLayout(new GridLayout(3, 2));
  }
  
  public void Construye(){
      pnl.add(lbl, BorderLayout.CENTER);
      add(pnl, BorderLayout.CENTER);
      pnlcontrol.add(slg);
      pnlcontrol.add(slb);
      pnlcontrol.add(slr);
      add(pnlcontrol, BorderLayout.SOUTH);
  }
  
  public void Control(){
      class EscuchaColor implements ChangeListener{

          @Override
          public void stateChanged(ChangeEvent ce) {
          mixColores();
          }
      }
      
      ChangeListener escucha = new EscuchaColor();
      slg.addChangeListener(escucha);
      slr.addChangeListener(escucha);
      slb.addChangeListener(escucha);
  }

  public void mixColores(){
       int azul = slg.getValue();
       int a = slr.getValue();
       int Q = slb.getValue();
       pnl.setBackground(new Color(azul, a ,Q));
       lbl.setForeground(new Color(Q, a, azul));
       pnl.repaint();
       lbl.repaint();
}

    public static void main(String[] args) {
        new Slidecolor();
    }
 
}

 