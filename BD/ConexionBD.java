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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ConexionBD {

    Connection c;
    Statement st;
    Scanner s = new Scanner (System.in);
    
    public boolean isNum(String cad) {
    String aux;
      if (cad == null)
        return false;
      try {
         Double.parseDouble(cad);
         return true;
      } catch(NumberFormatException nfe) {
        aux = "No se haga el gracioso y teclee correctamente";
          JOptionPane.showMessageDialog(null, aux);
          return false;
        }
  }
    
    public ConexionBD(){
        String cadConexion = "jdbc:sqlserver://UNIT-01:1433;"
                            + "databaseName=Biblioteca";
        try {
            c = DriverManager.getConnection(cadConexion, "sa", "sa");
             System.out.println("Conectado.");
        }catch (SQLException e) {
            System.err.println("Error " + e.getMessage());
        }
    }
    
    void Disponibilidad(){
        System.out.println("Ingrese el numero de control (AAAA/MM/DD):");
        String ncontrol = s.nextLine();
        System.out.println("Ingrese la hora con el formato (hh:mm:ss):"); 
        String nombre = s.nextLine();
        try {
            st = c.createStatement();
        ResultSet rs = st.executeQuery("select nombre from Alumno1 " +
                        "where nombre != (select nombre from "
                        + "Alumno1 where nomcontrol ='"+ncontrol+"' and "
                        + "nombre='"+nombre+"')");
        while(rs.next()){
            String d = "Aulas disponibles: "; 
            System.out.println(d + rs.getString("nombre"));
            //rs.getString("clave_aula");
        }
        rs.close();
        }catch (SQLException ex){
            System.err.println("Fallo " + ex.getMessage());
        }
    }
    
    void FechasReservas(){
        System.out.println("Ingrese la fecha de inicio de mes (AAAA/MM/DD):");
        String fechai = s.nextLine();
        System.out.println("Ingrese la fecha de fin de mes (AAAA/MM/DD):"); 
        String fechaf = s.nextLine();
        try {
            st = c.createStatement();
        ResultSet rs = st.executeQuery("select clave_aula, dias from Reserva1 " +
                                       "where dias between '"+fechai+"' "
                                        + "and '"+fechaf+"'");
        while(rs.next()){
            String d = "Fechas de reserva por mes: "; 
            System.out.println(d + rs.getString("clave_aula")+" "+rs.getString("dias"));
            //rs.getString("clave_aula");
        }
        rs.close();
        }catch (SQLException ex){
            System.err.println("Fallo " + ex.getMessage());
        }
    }
    
    void Reserva(){
        System.out.println("Ingrese la fecha (AAAA/MM/DD):");
        String fecha = s.nextLine();
        System.out.println("Ingrese el horario (hh:mm:ss"); 
        String hora = s.nextLine();
        System.out.println("Ingrese el aula: "); 
        String aula = s.nextLine();
        System.out.println("Ingrese la clave de grupo: "); 
        String grupo = s.nextLine();
        System.out.println("Ingrese el software a utilizar: "); 
        String soft = s.nextLine();
        try {
            st = c.createStatement();
        ResultSet rs = st.executeQuery("if exists (select * from Reserva1 where dias = '"+fecha+"' and horarios = '"+hora+"' and clave_aula ='"+aula+"')" +
" print 'ya existe una reserva en esa hora y dia' " +
"else" +
" insert into Reserva1 values('"+grupo+"', '"+aula+"', '"+hora+"', '"+fecha+"', '"+soft+"')" +
" print 'Reserva hecha'");
        while(rs.next()){
            //String d = "Reserva: "; 
            //System.out.println("Reserva hecha");
            //rs.getString("clave_aula");
        }
        rs.close();
        }catch (SQLException ex){
            System.err.println("Fallo " + ex.getMessage());
        }
    }
    
    void Cancelar(){
        System.out.println("Ingrese la fecha (AAAA/MM/DD):");
        String fecha = s.nextLine();
        System.out.println("Ingrese el horario (hh:mm:ss"); 
        String hora = s.nextLine();
        System.out.println("Ingrese el aula: "); 
        String aula = s.nextLine();
        try {
            st = c.createStatement();
        ResultSet rs = st.executeQuery("if exists (select * from Reserva1 where dias = '"+fecha+"' and horarios = '"+hora+"' and clave_aula ='"+aula+"')" +
                "delete Reserva1 where dias = '"+fecha+"' and horarios = '"+hora+"' and clave_aula ='"+aula+"'"
                +" print 'Se ha cancelado la reserva' " +
"else" +
" print 'no existe la reserva'");
        while(rs.next()){
            //String d = "Reserva: "; 
            //System.out.println("Reserva hecha");
            //rs.getString("clave_aula");
        }
        rs.close();
        }catch (SQLException ex){
            System.err.println("Fallo " + ex.getMessage());
        }
    }
    
    void menu() {
    String aux="Elige:";
    aux +="\n1.Disponibilidad \n2.Fechas reservadas por mes \n3.Hacer reserva";
    aux +="\n4.Cancelar reservacion \n5.Salir";
    String msg;
    int resp;

    do{
      do msg=JOptionPane.showInputDialog(aux);
      while(!isNum(msg));
      resp= Integer.parseInt(msg);

      switch(resp){
        case 1: Disponibilidad(); break;
        case 2: FechasReservas(); break;
        case 3: Reserva(); break;
        case 4: Cancelar(); break;
        case 5: System.exit(0); break;
      }
    }while(resp!=5);
  }
    
    public static void main(String[] args) {
        ConexionBD c = new ConexionBD(); 
         
        c.menu();
    }
}
