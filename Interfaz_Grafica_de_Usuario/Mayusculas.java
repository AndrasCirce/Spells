/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz_Grafica_de_Usuario;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
/**
 *
 * @author Adeaf
 */
public class Mayusculas {
    JFrame ventana;
    JPanel pnl;
    JTextField txt;
    
    public Mayusculas() {
        create();
        prepare();
        escucha();
        launch();
    }
    
    private void create(){
       ventana = new JFrame();
       pnl = new JPanel();
       txt = new JTextField(25);
    }
    
    private void prepare(){
        ventana.setTitle("TextArea");
        ventana.setSize(300, 300);
//        ventana.setLocation(null);
        ventana.add(pnl);
        pnl.add(txt);
    }
    
    private void escucha(){
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                txt.setText(txt.getText().toUpperCase());
            }
        });
    }
    
    private void launch(){
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Mayusculas();
    }
    
            
}
