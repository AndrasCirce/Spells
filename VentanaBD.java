package BD;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adeaf
 */
public class VentanaBD extends JFrame {

    Connection connect;
    Statement consulta;
    ResultSet resultados;
    ResultSetMetaData metadata;
    JScrollPane barra;
    JTable Tabla;
    DefaultTableModel modelo;
    JSpinner spin;
    String [] bds  = {"select * from CIRCE.THEDAMNED", 
        "select * from CIRCE.THEBLESSED"};
    JComboBox combo;
    
    String dataBase,
            controlador,
            sql,
            sql2,
            user,
            contraseña,
            Q;
    int nColumnas;

    public VentanaBD() {
        Crear();
        Construir();
        inicializa();
        realiza_consulta();
        Llenar();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    public void Crear() {

        modelo = new DefaultTableModel();
        Tabla = new JTable(modelo);
        Tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
        barra = new JScrollPane(Tabla);
        dataBase = "jdbc:derby://localhost:1527/DeathList";
        controlador = "org.apache.derby.jdbc.ClientDriver";
        sql = "select * from CIRCE.THEDAMNED";
        sql2 = "select * from CIRCE.THEBlESSED";
        user = "Circe";
        contraseña = "KillBill";
        nColumnas = 0;
//        combo = new JComboBox<String>(bds);
        //Instancia que define que bd leer en base a la eleccion de combobox
//        combo.addItemListener(event -> {
//            if (event.getStateChange() == ItemEvent.SELECTED) {
//                System.out.println(event.getItem().toString());
//            }
//        });
    }

    public void inicializa() {
        try {
            Class.forName(controlador);
            //parametros - nombreDB, usuario, contraseña
            connect = DriverManager.getConnection(dataBase, user, contraseña);
        } catch (ClassNotFoundException ex) {
            System.out.println("No encontre el controlador");
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos");
        }
    }

    public void realiza_consulta() {
        try {
            //instancia la consulta
            consulta = connect.createStatement();
            //ejecucion de la consulta y guarda el resultado
            //en la variable resultados
            //impresion de base de datos a leer
//            String A = oye();
//            System.out.println(sql);
            resultados = consulta.executeQuery(sql2);
            //obtiene los ecabezados, numColumna, etc de la tabla
            metadata = resultados.getMetaData();
            nColumnas = metadata.getColumnCount();
        } catch (SQLException ex) {
            System.out.println("Error al realizar la consulta");
        }
    }

    public void Llenar() {
        // Se crea un array de etiquetas para rellenar
        Object[] etiquetas = new Object[nColumnas];
        // Se obtiene cada una de las etiquetas para cada columna
        for (int i = 0; i < nColumnas; i++) {
            try {
                // Nuevamente, para ResultSetMetaData la primera columna es la 1.
                etiquetas[i] = metadata.getColumnLabel(i + 1);
            } catch (SQLException ex) {
                Logger.getLogger(VentanaBD.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(etiquetas[i]);
        }
        modelo.setColumnIdentifiers(etiquetas);

        try {
            //RELLENAR FILAS
            // Bucle para cada resultado en la consulta
            while (resultados.next()) {
                // Se crea un array que será una de las filas de la tabla.
                Object[] fila = new Object[nColumnas];

                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                for (int i = 0; i < nColumnas; i++) {
                    fila[i] = resultados.getObject(i + 1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
                    System.out.println(fila[i]);
                }
                // Se añade al modelo la fila completa.
                modelo.addRow(fila);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VentanaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Construir() {
       //add(combo, BorderLayout.NORTH);
        getContentPane().add(barra, BorderLayout.CENTER);
    }
    
    //metodo que devuelve la bd elegida

//    public String oye(){
//        
//        combo.addItemListener(event -> {
//            if (event.getStateChange() == ItemEvent.SELECTED) {
//                Q = event.getItem().toString();
//            }
//        });
//        return Q;
//    }
    
    public static void main(String[] args) {
        new VentanaBD();
    }
}