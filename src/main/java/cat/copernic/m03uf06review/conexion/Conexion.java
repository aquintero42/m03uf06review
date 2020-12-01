/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Adrian
 */
public class Conexion {
    
    public static Connection connect() {
        String MySQLURL = "jdbc:mysql://localhost/datos";
        String databseUserName = "root";
        String databasePassword = "";
        Connection con = null;
        
        try {
            //Class.forName("com.mysql.jdbc.Driver"); 
            con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
        }
        catch (Exception e) {
                e.printStackTrace();
        }        
        
        return con;
    }
    
}
