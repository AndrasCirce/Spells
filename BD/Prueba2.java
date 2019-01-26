
package BD;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Adeaf
 */
public class Prueba2 extends JFrame {
     
     JScrollPane barra;
     JTable Tabla;
     Object[][] data = {
{"Mary", "Campione", "Esquiar", new Integer(5), new Boolean(false)},
{"Lhucas", "Huml", "Patinar", new Integer(3), new Boolean(true)},
{"Kathya", "Walrath", "Escalar", new Integer(2), new Boolean(false)},
{"Marcus", "Andrews", "Correr", new Integer(7), new Boolean(true)},
{"Angela", "Lalth", "Nadar", new Integer(4), new Boolean(false)}
};
     String [] NombresCol = {"NAME", "NICKNAME", "AGE", "RESIDENCY"};
     
     
     
     public Prueba2(){
         crear();
         construir();
         pack();
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
     }
     
     public void crear(){
         Tabla = new JTable(data, NombresCol);
         Tabla.setPreferredScrollableViewportSize(new Dimension (500, 70));
         barra =  new JScrollPane(Tabla);
         
         
     }
     
     public void prop(){
            
     }
     
     public void construir(){
         getContentPane().add(barra, BorderLayout.CENTER);
     }
     
     public static void main(String[] args) {
        new Prueba2();
    }
}
