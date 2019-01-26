/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz_Grafica_de_Usuario;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tablero {
    JFrame ventana;
    JPanel pTablero[][] = new JPanel[8][8];

    public Tablero() {
        ventana = new JFrame("Tablero de ajedrez");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                pTablero[i][j] = new JPanel();
            }
        }

        prop();
        construir();
        mostrar();
    }

    public void prop() {
        ventana.setSize(600, 600);
        ventana.setDefaultCloseOperation(3);
        ventana.setResizable(false);
        ventana.setLayout(new GridLayout(8, 8, 0, 0));
        ventana.setLocationRelativeTo(null);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0)
                        pTablero[i][j].setBackground(Color.white);
                    else
                        pTablero[i][j].setBackground(Color.black);
                } else {
                    if (j % 2 == 0)
                        pTablero[i][j].setBackground(Color.black);
                    else
                        pTablero[i][j].setBackground(Color.white);
                }
            }
        }
    }

    public void construir() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ventana.add(pTablero[i][j]);
            }
        }
    }

    public void mostrar() {
        ventana.setVisible(true);
}
    public static void main(String[] args) {
        new Tablero();
    }
}
