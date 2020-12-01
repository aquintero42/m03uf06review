/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * En aquesta secció cal accedir a una taula de MySQL amb un camp de cada tipus:
 * 
 * int o long, double o float, boolean, char, String i java.sql.Date
 * 
 * Int: Edad
 * Double: Salario
 * Boolean: HorasExtra
 * Char: Inicial
 * String: PuestoDeTrabajo
 * java.sql.Date: Dia de entrada
 * 
 * Recòrrer el result set i mostrar-lo per la consola.
 * 
 * 
 * @author pep
 */
public class JdbcMain {

    public static void main(String[] args) {
        String MySQLURL = "jdbc:mysql://localhost/datos";
            String databseUserName = "root";
            String databasePassword = "";
            Connection con = null;
            try {
                Class.forName("com.mysql.jdbc.Driver"); 
                con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
                if (con != null) {
                    Statement stmt = con.createStatement();
                    String query = "select * from empresa;";
                    ResultSet rs = stmt.executeQuery(query);

                    while (rs.next()) {
                        int ident = rs.getInt("id");
                        int edad = rs.getInt("edad");
                        double salario = rs.getDouble("salario");
                        String horasExtra = rs.getString("horasExtra");
                        String iniciales = rs.getString("iniciales");
                        String diaEntrada = rs.getString("diaEntrada");
                        
                        if (horasExtra == "0") {
                            horasExtra = "No";
                        } else {
                            horasExtra = "Si";
                        }

                        System.out.println( "ID:" + ident + " Edad:" + edad + " Salario:" + salario + " Horas extra:" + horasExtra + " Iniciales:" + iniciales + " Dia de entrada:" + diaEntrada);

                }
            }
        }
        catch (Exception e) {
                e.printStackTrace();
        }    

    }
    
}
