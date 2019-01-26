/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz_Grafica_de_Usuario;

import javax.swing.JOptionPane;

/**
 *
 * @author Adeaf
 */
public class ArgumentosVariables {
    
    public int suma(int ... y){
        int r =0;
        System.out.println("Me diste "+(y.length)+" argumentos");
        for (int i = 0; i < y.length; i++) {
            r += y[i];
        }
        return r;
    }
    
    public static void main(String[] args) {
        ArgumentosVariables algo = new ArgumentosVariables();
        JOptionPane.showMessageDialog(null, "La suma es "
                +algo.suma(5,1,2,3,4));
    }
}
