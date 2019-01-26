
package jmenu;
    import javax.swing.JMenu;
    import javax.swing.JMenuBar;
    import javax.swing.JMenuItem;
    import java.awt.event.*;
    import javax.swing.JButton;
    import javax.swing.JCheckBox;
    import javax.swing.JFrame;
    import javax.swing.JRadioButton;
    import java.awt.Image;
/**
 *
 * @author Adeaf
 */
public class Jmenu extends JFrame{
    private JMenuBar barram;
    private JMenu platillos, Quesadillas, sabores, ingredientes, lugar;
    private JMenuItem chorizo, bistek, pastor, soadero, huevo, mole, papa,
            tacos, tortas;
    private JRadioButton llevar, aqui, conqueso, sinqueso;
    private JCheckBox todo, solo;
    
    public Jmenu(){
        crear();
        prop();
        construye();
        
    }
    
    public void crear(){
        barram = new JMenuBar();
        platillos = new JMenu("Platillos");
        tacos = new JMenuItem("Tacos");
        tortas = new JMenuItem("Tortas");
        Quesadillas = new JMenu("Quesadillas", true);
        conqueso = new JRadioButton("Con queso");
        sinqueso = new JRadioButton("Sin queso");
        sabores = new JMenu("Sabores");
        ingredientes = new JMenu("Ingredientes");
        lugar = new JMenu("Lugar");
        chorizo = new JMenuItem("Chorizo");
        bistek = new JMenuItem("Bistek");
        soadero = new JMenuItem("Soadero");
        pastor = new JMenuItem("Pastor");
        huevo = new JMenuItem("Huevo");
        mole = new JMenuItem("Mole con arroz");
        papa = new JMenuItem("Papa");
        llevar = new JRadioButton("Para llevar");
        aqui = new JRadioButton("Comer aqui");
        todo = new JCheckBox("Con todo");
        solo = new JCheckBox("Solitos");
    }
    
    public void prop(){
        setLayout(null);
        setTitle("¿Q U E  V A  L L E V A R  G U E R O?");
        
    }
    
    public void construye(){
        barram.add(platillos);
        platillos.add(tacos);
        platillos.add(tortas);
        platillos.add(Quesadillas);
        Quesadillas.add(conqueso);
        Quesadillas.add(sinqueso);
        barram.add(sabores);
        sabores.add(chorizo);
        sabores.add(bistek);
        sabores.add(soadero);
        sabores.add(pastor);
        sabores.addSeparator();
        sabores.add(huevo);
        sabores.add(mole);
        sabores.add(papa);
        barram.add(ingredientes);
        ingredientes.add(todo);
        ingredientes.add(solo);
        barram.add(lugar);
        lugar.add(aqui);
        lugar.add(llevar);
        setJMenuBar(barram);
    }

    public static void main(String[] args) {
        Jmenu algo = new Jmenu();
        algo.setBounds(0, 0, 600, 600);
        algo.setVisible(true);
        algo.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
