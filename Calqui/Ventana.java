
package Calqui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static javax.management.Query.lt;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Adeaf
 */
public class Ventana extends JFrame{

	JTextField pantalla;
	double resultado;
	String operacion;
	JPanel panelNumeros, panelOperaciones;
	boolean nuevaOperacion = true;
        private JMenuBar barram;
        private JMenu modo, numero, orientacion;
        private JMenuItem basico, cientifico, radianes, grados, horizontal, 
                vertical;

	public Ventana() {
		super();
		setSize(250, 300);
		setTitle("Calculadora Simple");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
                crear();
                prop();
	}
        
        private void crear(){
		pantalla = new JTextField("0", 20);
		pantalla.setBorder(new EmptyBorder(4, 4, 4, 4));
		pantalla.setFont(new Font("Arial", Font.BOLD, 25));
		pantalla.setHorizontalAlignment(JTextField.RIGHT);
                panelOperaciones = new JPanel();
		panelOperaciones.setLayout(new GridLayout(6, 1));
		panelOperaciones.setBorder(new EmptyBorder(4, 4, 4, 4));
                panelNumeros = new JPanel();
		panelNumeros.setLayout(new GridLayout(4, 3));
		panelNumeros.setBorder(new EmptyBorder(4, 4, 4, 4));
                barram = new JMenuBar();
                modo = new JMenu("Modo");
                numero = new JMenu("Numero");
                orientacion = new JMenu("Orientacion");
                basico = new JMenuItem("Basico");
                cientifico = new JMenuItem("Cientifico");
                radianes = new JMenuItem("Radianes");
                grados = new JMenuItem("Grados");
                horizontal = new JMenuItem("Horizontal");
                vertical = new JMenuItem("Vertical");
                
		for (int n = 9; n >= 0; n--) {
			nuevoBotonNumerico("" + n);
		}

		nuevoBotonNumerico(".");

        }
        
        private void prop(){
            JPanel panel = (JPanel) this.getContentPane();
            panel.setLayout(new BorderLayout());
            pantalla.setEditable(false);
            pantalla.setBackground(Color.WHITE);
            panel.add("North", pantalla);
            panel.add("Center", panelNumeros);
            panel.add("East", panelOperaciones);
            panel.add("South", barram);
            barram.add(modo);
            barram.add(numero);
            barram.add(orientacion);
            modo.add(basico);
            modo.add(cientifico);
            numero.add(radianes);
            numero.add(grados);
            orientacion.add(horizontal);
            orientacion.add(vertical);
            nuevoBotonOperacion("+");
            nuevoBotonOperacion("-");
            nuevoBotonOperacion("*");
            nuevoBotonOperacion("/");
            nuevoBotonOperacion("=");
            nuevoBotonOperacion("CE");
		validate();
        }
        
	private void nuevoBotonNumerico(String digito) {
		JButton btn = new JButton();
		btn.setText(digito);
		btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evt) {
				JButton btn = (JButton) evt.getSource();
				numeroPulsado(btn.getText());
			}
		});

		panelNumeros.add(btn);
	}
	
	private void nuevoBotonOperacion(String operacion) {
		JButton btn = new JButton(operacion);
		btn.setForeground(Color.RED);

		btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evt) {
				JButton btn = (JButton) evt.getSource();
				operacionPulsado(btn.getText());
			}
		});

		panelOperaciones.add(btn);
	}

	private void numeroPulsado(String digito) {
		if (pantalla.getText().equals("0") || nuevaOperacion) {
			pantalla.setText(digito);
		} else {
			pantalla.setText(pantalla.getText() + digito);
		}
		nuevaOperacion = false;
	}

	private void operacionPulsado(String tecla) {
		if (tecla.equals("=")) {
			calcularResultado();
		} else if (tecla.equals("CE")) {
			resultado = 0;
			pantalla.setText("");
			nuevaOperacion = true;
		} else {
			operacion = tecla;
			if ((resultado > 0) && !nuevaOperacion) {
				calcularResultado();
			} else {
				resultado = new Double(pantalla.getText());
			}
		}

		nuevaOperacion = true;
	}

	private void calcularResultado() {
		if (operacion.equals("+")) {
			resultado += new Double(pantalla.getText());
		} else if (operacion.equals("-")) {
			resultado -= new Double(pantalla.getText());
		} else if (operacion.equals("/")) {
			resultado /= new Double(pantalla.getText());
		} else if (operacion.equals("*")) {
			resultado *= new Double(pantalla.getText());
		}

		pantalla.setText("" + resultado);
		operacion = "";
	}
        
}

