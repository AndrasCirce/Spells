
package Interfaz_Grafica_de_Usuario;

import java.awt.Color;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;

/**
 *
 * @author Adeaf
 */
public class Spinner extends JFrame{
    
    JSpinner spinhr, spindt;
    SpinnerModel sdmDt, sdmHr;
    Calendar calendar;
    JPanel pnl;
    Date fecha;
    JLabel lbhr, lbdt;
    
    Spinner() {
        spinhr = new JSpinner();
        spindt = new JSpinner();
        pnl = new JPanel();
        fecha = new Date();
        lbdt = new JLabel("Año/mes/dia");
        lbhr = new JLabel("hora/minuto/segundo");
        calendar = Calendar.getInstance();
        sdmDt = new SpinnerDateModel(fecha, null, null, Calendar.YEAR);
        sdmHr = new SpinnerDateModel(fecha, null, null, Calendar.HOUR);
        
        prop();
        spinnerDate();
        construye();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    void spinnerDate() {
        spindt.setModel(sdmDt);
        spindt.setEditor(new JSpinner.DateEditor(spindt, "MM/dd/yyyy"));
        spinhr.setModel(sdmHr);
        spinhr.setEditor(new JSpinner.DateEditor(spinhr, "hh:mm:ss a"));
    }
    
    void prop() {
        setSize(600, 600);
        pnl.setLayout(null);
        pnl.setBackground(Color.BLACK);
        lbdt.setForeground(Color.yellow);
        lbhr.setForeground(Color.red);
        lbdt.setBounds(185, 15, 200, 30);
        lbhr.setBounds(185, 55, 200, 30);
        spindt.setBounds(45, 15, 100, 30);
        spinhr.setBounds(45, 55, 100, 30);
    }
    
    void construye() {
        add(pnl);
        pnl.add(lbdt);
        pnl.add(lbhr);
        pnl.add(spindt);
        pnl.add(spinhr);
    }
    
    public static void main(String[] args) {
        new Spinner();
    }
}