
package Interfaz_Grafica_de_Usuario;

import java.awt.Color;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.ListEditor;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Adeaf
 */
public class BloodSpinner extends JFrame{
    private JPanel pnlcapa;
    private JLabel lbletrero;
    private JSpinner spin;
    private Date date;
    private SpinnerDateModel sdm;
    private JSpinner.DateEditor dateeditor;
    private SpinnerListModel listmodel;
    private String [] tipoS = {"O+","A+","AB","O-", "A-", "AB-", "B", "B-"};
    private JSpinner spin2;

    public BloodSpinner(){
    crear();
    Prop();
    construye();
    oye();
}
 public void crear(){
     setTitle("JSpinner");
     lbletrero = new JLabel("OOOOOOO");
     pnlcapa = new JPanel();
     date = new Date();
     sdm = new SpinnerDateModel(date, null, null, Calendar.HOUR);
     spin = new JSpinner(sdm);
     dateeditor = new JSpinner.DateEditor(spin, "HH/MM/SS");
     listmodel = new SpinnerListModel(tipoS);
     spin2 = new JSpinner(listmodel);
 }        

 public void Prop(){
     setLocationRelativeTo(null);
     setSize(400,500);
     pnlcapa.setBackground(Color.black);
     spin.setBounds(10,10,40,20);
     lbletrero.setForeground(Color.yellow);
     pnlcapa.add(spin);
     pnlcapa.add(lbletrero);
     add(pnlcapa);
     spin2.setBounds(150, 50, 100, 30);
     pnlcapa.setLayout(null);
 }
 
 public void construye(){
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    pnlcapa.add(spin2); 
 }
         
 private void oye(){
     spin.addChangeListener(new ChangeListener() {
         @Override
         public void stateChanged(ChangeEvent ce) {
             lbletrero.setText(String.format("%d: %d: %d", 
                     sdm.getDate().getHours(),
                     sdm.getDate().getMinutes(), 
                     sdm.getDate().getSeconds()));
         }
     
     });
     }
 
    public static void main(String[] args) {
            new BloodSpinner();
    }
}
