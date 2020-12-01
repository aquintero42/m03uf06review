/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * En aquesta secció cal accedir a una taula de MySQL amb un camp de cada tipus:
 * 
 * int o long, double o float, boolean, char, String i java.sql.Date
 * 
 * Recòrrer el result set i mostrar-lo per la consola com a instancies de la 
 * classe Registre, que tindrà l'estructura de la teva taula.
 * 
 * 
 * @author pep
 */
public class OrmMain {

    public static void main(String[] args) {
        String MySQLURL = "jdbc:mysql://localhost/datos";
            String databseUserName = "root";
            String databasePassword = "";
            Connection con = null;
            List<Registre> taula = new ArrayList<>();
            try {
                Class.forName("com.mysql.jdbc.Driver"); 
                con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
                if (con != null) {
                    Statement stmt = con.createStatement();
                    String query = "select * from empresa;";
                    ResultSet rs = stmt.executeQuery(query);

                    while (rs.next()) {
                        int horas = rs.getInt("horasExtra");
                        String horasExtra = "";
                        if (horas == 0) {
                            horasExtra = "No";
                        } else if (horas == 1) {
                            horasExtra = "Si";
                        }
                        
                        taula.add(new Registre(rs.getInt("id"),rs.getInt("edad"),rs.getDouble("salario"),horasExtra,rs.getString("iniciales"),rs.getString("diaEntrada")));

                    }
                    
                    for(Iterator it = taula.iterator(); it.hasNext();) {
                            System.out.println(it.next());
                    }
            }
        }
        catch (Exception e) {
                e.printStackTrace();
        }
    }
    
}
