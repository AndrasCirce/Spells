/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz_Grafica_de_Usuario.EnumYComboBox;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
    import javax.swing.JFrame;
    import javax.swing.JPanel;
    import javax.swing.JComboBox;
    import javax.swing.JLabel;
    
public class InterfazEnum  {
    private JFrame cuadro;
    private JPanel pnlcapa;
    private JComboBox <LIstaColores> cmblista1;
    private JComboBox <LIstaColores> cmblista2;
    private JLabel lbletrero;
    
    public InterfazEnum(){
        cuadro = new JFrame();
        pnlcapa = new JPanel();
        cmblista1 = new JComboBox();
        cmblista2 = new JComboBox();
        lbletrero = new JLabel();
        Prop();
        Armar();
        Algo();
    }
    
    public void Prop(){
        cuadro.setTitle("Killing It");
        cuadro.setSize(400,420);
        pnlcapa = new JPanel(null);
        cmblista1.setBounds(0, 0, 310, 20);
        cmblista2.setBounds(0, 30, 310, 20);
        lbletrero.setBounds(100, 250, 150, 20);
        pnlcapa.setBackground(Color.lightGray);
        cmblista1.setModel(new DefaultComboBoxModel(LIstaColores.values()));
        cmblista2.setModel(new DefaultComboBoxModel(LIstaColores.values()));
        lbletrero.setText("JENNY DEATH WHEN?");
    }
    
    public void Armar(){
        cuadro.add(pnlcapa);
        pnlcapa.add(cmblista1);
        pnlcapa.add(cmblista2);
        pnlcapa.add(lbletrero);
        cuadro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cuadro.setVisible(true);
    }
    
    public void Algo(){

        cmblista1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 LIstaColores Q = (LIstaColores) cmblista1.getSelectedItem(); 
                switch(Q){
                    case morado: pnlcapa.setBackground(Color.MAGENTA); break;
                    case rojo: pnlcapa.setBackground(Color.RED); break;
                    case amarillo: pnlcapa.setBackground(Color.YELLOW); break;
                    case verde: pnlcapa.setBackground(Color.GREEN); break;
                    case azul: pnlcapa.setBackground(Color.BLUE); break;
                    case cafe: pnlcapa.setBackground(new Color(128, 0, 0)); 
                    break;
                    case negro: pnlcapa.setBackground(Color.BLACK); break;
                    case blanco: pnlcapa.setBackground(Color.WHITE); break;
                }                
           }
        }); 
        
        cmblista2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 LIstaColores Q = (LIstaColores) cmblista2.getSelectedItem(); 
                switch(Q){
                    case morado: lbletrero.setForeground(Color.MAGENTA); break;
                    case rojo: lbletrero.setForeground(Color.RED); break;
                    case amarillo: lbletrero.setForeground(Color.YELLOW); break;
                    case verde: lbletrero.setForeground(Color.GREEN); break;
                    case azul: lbletrero.setForeground(Color.BLUE); break;
                    case cafe: lbletrero.setForeground(new Color(128, 0, 0));
                    break;
                    case negro: lbletrero.setForeground(Color.BLACK); break;
                    case blanco: lbletrero.setForeground(Color.WHITE); break;
                }                
           }
        });
    }
    
}
