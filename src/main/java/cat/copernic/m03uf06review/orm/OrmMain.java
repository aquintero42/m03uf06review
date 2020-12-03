/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.orm;

import cat.copernic.m03uf06review.conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    static List<Registre> taula = new ArrayList<>();

    public static void main(String[] args) {
        consulta();
        iterador();
    }

    public static void consulta() {
        Conexion connexioBBDD = new Conexion();
        Connection con = connexioBBDD.connect();

        try {

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
                    Registre r1 = new Registre(rs.getInt("id"), rs.getInt("edad"), rs.getDouble("salario"), horasExtra, rs.getString("iniciales"), rs.getString("diaEntrada"));
                    sumaRegistro(r1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void iterador() {
        for (Iterator it = taula.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }

    public static List<Registre> sumaRegistro(Registre r1) throws SQLException {
        taula.add(r1);
        return taula;
    }

}
