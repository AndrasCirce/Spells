/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz_Grafica_de_Usuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Plantilla implements ActionListener {

    private JFrame ventana;
    private JPanel pnlCont;
    private JButton btnaceptar, btnSalir;

    public Plantilla() {
        ventana = new JFrame();
        pnlCont = new JPanel();
        btnaceptar = new JButton("Aceptar");
        btnSalir = new JButton("Salir");

        propiedades();
        armar();

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    private void propiedades() {
        ventana.setTitle("Hola que hace");
        ventana.setBounds(200, 200, 300, 400);
        pnlCont.setBackground(Color.YELLOW);
        btnaceptar.setBackground(Color.GREEN);
        btnSalir.setBackground(Color.GREEN);
        btnaceptar.addActionListener(this);
        btnSalir.addActionListener(this);
    }

    private void armar() {
        ventana.add(pnlCont, BorderLayout.CENTER);
        ventana.add(btnaceptar, BorderLayout.SOUTH);
        ventana.add(btnSalir, BorderLayout.NORTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnaceptar)) {
            JOptionPane.showMessageDialog(null, "Hola que hace");
        }

        if (e.getSource().equals(btnSalir)) {
            System.exit(0);
        }
    }

}
