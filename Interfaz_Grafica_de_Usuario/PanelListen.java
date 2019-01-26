/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz_Grafica_de_Usuario;

/**
 *
 * @author Adeaf
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;


public class PanelListen {
    private JFrame marco;
    private JPanel hoja;
    private JButton btn;

    public PanelListen(){
        marco = new JFrame();
        hoja = new JPanel();
        btn = new JButton("Aceptar");
        prop();
        armar();
        escucha();
    }
    public void prop(){
    marco.setSize(300,300);
    marco.setDefaultCloseOperation(3);
}
 
    
    public void armar(){
        marco.add(hoja, BorderLayout.CENTER);
        hoja.add(btn);
    }
    
    public void escucha(){
        hoja.addMouseListener(new MYListen());
        
}
    class MYListen implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            hoja.setBackground(Color.yellow);
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }
        
    }
}
