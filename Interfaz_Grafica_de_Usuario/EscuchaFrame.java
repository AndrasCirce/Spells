/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz_Grafica_de_Usuario;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Adeaf
 */
public class EscuchaFrame {
    JFrame Comp;
    
    public EscuchaFrame(){
        create();
        prepare();
        escucha();
        launch();
    }
    
    public void create(){
        Comp = new JFrame();
    }
    
    public void prepare(){
        Comp.setSize(400,400);
    }
    
    public void launch(){
        Comp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Comp.setVisible(true);
    }
    
    public void escucha(){
        Comp.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent ce) {
                try {
                    Thread.sleep(0);
                } catch (InterruptedException ex) {
                    Logger.getLogger(EscuchaFrame.class.getName()).
                    log(Level.SEVERE, null, ex);
                }
                Comp.setSize(400,400);
            } 
        });
        
        Comp.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                if(ke.getKeyChar() == KeyEvent.VK_ESCAPE)
                    System.exit(0);
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }
        });
        
        Comp.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                System.out.println("Focus Gained");
            }

            @Override
            public void focusLost(FocusEvent fe) {
                System.out.println("Focus Lost");
            }
        });
    }
    
    
    public static void main(String[] args) {
        new EscuchaFrame();
    }
}
