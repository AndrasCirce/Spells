/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

/**
 *
 * @author Adeaf
 */


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Prueba1 {
        Connection connect;
        Statement consulta;
        ResultSet resultados;
        ResultSetMetaData metadata;

     String dataBase,
            controlador, 
            sql,
            user,
            contraseña;
     int nColumnas;

    public Prueba1() {
        dataBase = "jdbc:derby://localhost:1527/DeathList";
        controlador = "org.apache.derby.jdbc.ClientDriver";
        sql = "select * from CIRCE.THEBLESSED";
        user = "Circe";
        contraseña = "KillBill";
        nColumnas=0;
    }
    public void inicializa(){
            try {
            Class.forName(controlador);
                 //parametros - nombreDB, usuario, contraseña
            connect = DriverManager.getConnection(dataBase,user,contraseña);
            } catch (ClassNotFoundException ex) {
                System.out.println("No encontre el controlador");
            } catch (SQLException ex) {
                System.out.println("Error al conectar a la base de datos");
            }
           
    }
    
    public void realiza_consulta(){
            try {
            //instancia la consulta
            consulta = connect.createStatement();
            //ejecucion de la consulta y guarda el resultado
            //en la variable resultados
            resultados = consulta.executeQuery(sql);
            //obtiene los ecabezados, numColumna, etc de la tabla
            metadata = resultados.getMetaData();
            nColumnas = metadata.getColumnCount();
            } catch (SQLException ex) {
                System.out.println("Error al realizar la consulta");
            }
            
        
    }
    public void imprimir(){
        for (int i = 1; i <= nColumnas; i++) {
             //imprimimos los encabezados
            try{
                System.out.printf("%-10s",metadata.getColumnLabel(i)+"  ");
            }catch(SQLException sqle){
                    System.out.println("Ocurrio un error");        
            }
        }
            
        try{
            while(resultados.next()){
                System.out.println();
                for (int i = 1; i <= nColumnas; i++) {
                    try{
                        //para cada variable lleva %, s significa String
                        //- justifica del lado izquierdo
                        System.out.printf("%-10s\t",resultados.getObject(i));            
                    }catch(SQLException sqle){
                        System.out.println("Ocurrio un error");
                    }
                }
            }
        }catch(SQLException sqle){
            System.out.println("Error al accesar los datos");
        }
    }
    
        
    
    public static void main(String[] args) {
       Prueba1 bd_ahorro = new Prueba1();
        bd_ahorro.inicializa();
        bd_ahorro.realiza_consulta();
        bd_ahorro.imprimir();
    }
}