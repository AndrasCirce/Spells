package BotonLoco;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
/**
 *
 * @author Adeaf
 */
public class CrazyButton {
    JFrame Flienzo;
    JPanel pnlcapa;
    JButton btnpush, btnpress, btnout;
    JLabel lbalgo;
    
    public CrazyButton(){
        Crea();
        Moldea();
        MOVE();
        Construye();
        
    }
    
    public void Crea(){
        Flienzo = new JFrame();
        pnlcapa = new JPanel(null);
        btnpush = new JButton("T-T-Touch");
        btnpress = new JButton("TOCAAA");
        btnout = new JButton("Salir");
        lbalgo = new JLabel();
    }
    
    public void Moldea(){
        Flienzo.setSize(600,600);
        Flienzo.setTitle("Little Running Devil");
        pnlcapa.setBackground(Color.LIGHT_GRAY);
        btnpush.setSize(100, 40);
        btnpress.setSize(100, 40);
        btnout.setBounds(300, 10, 100,40);
        
        lbalgo.setBounds(200, 300, 200, 40);
        
        
    }
    
    public void Construye(){
        Flienzo.add(pnlcapa);
        pnlcapa.add(btnpush);
        pnlcapa.add(btnpress);
        pnlcapa.add(btnout);
        pnlcapa.add(lbalgo);
        
        Flienzo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Flienzo.setVisible(true);
    }
    
    public void MOVE(){
        
       MouseMotionListener Rat = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
               lbalgo.setText("no me toques");
               
               int x = (int) (((Math.random()) * 400) + 1);
               int y = (int) (((Math.random()) * 400) + 1);
               int w = (int) (((Math.random()) * 400) + 1);
               int z = (int) (((Math.random()) * 400) + 1);
               
               if(e.getSource().equals(btnpush)){
                    btnpush.setLocation(x, y);
               }
               if(e.getSource().equals(btnpress)){
                     btnpress.setLocation(w, z);
               }
               
                   }  
            
        };
                btnpress.addMouseMotionListener(Rat);
                btnpush.addMouseMotionListener(Rat);
       
       
        btnout.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
                if(e.getSource().equals(btnout))
                    System.exit(0);
             }
        });
    }
    
    
}
