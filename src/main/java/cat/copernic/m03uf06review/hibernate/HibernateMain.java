/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.hibernate;

import java.sql.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * En aquesta secció cal accedir a una taula de MySQL amb un camp de cada tipus:
 * 
 * int o long, double o float, boolean, char, String i java.sql.Date
 * 
 * Recòrrer el result set i mostrar-lo per la consola com a instancies de la 
 * classe Registre, que tindrà l'estructura de la teva taula.
 * 
 * Cal usar la llibreria Hibernate.
 * 
 * 
 * @author pep
 */
public class HibernateMain {
    static Session s = cat.copernic.m03uf06review.conexion.Controller.getSessionFactory().openSession();
    static Transaction tr=s.beginTransaction();
    static cat.copernic.m03uf06review.pojos.Empresa emp = new cat.copernic.m03uf06review.pojos.Empresa();
    
    public static void main(String[] args) {
        //insert();
        //update();
        //delete();
        //consultaSimple();
        consultaHQL();
        
        tr.commit();
        s.close();
        tr = null;
    }
    
    public static void insert() {
        cat.copernic.m03uf06review.pojos.Empresa emp1 = new cat.copernic.m03uf06review.pojos.Empresa();
        emp1.setId(6);
        emp1.setEdad(18);
        emp1.setSalario(1024.54);
        emp1.setIniciales("AGF");
        emp1.setPuestoDeTrabajo("Junior Software Engineer");
        emp1.setDiaEntrada(Date.valueOf("2020-12-03"));
        s.save(emp1);
        System.out.println("Campos insertados correctamente");
    }
    
    public static void update() {
        cat.copernic.m03uf06review.pojos.Empresa emp2 = (cat.copernic.m03uf06review.pojos.Empresa) s.load(cat.copernic.m03uf06review.pojos.Empresa.class, 12); 
        emp2.setEdad(20);
        emp2.setDiaEntrada(Date.valueOf("2017-12-03"));
        s.update(emp2);
        System.out.println("Campos actualizados correctamente");
    }
    
    public static void delete() {
        cat.copernic.m03uf06review.pojos.Empresa emp3 = (cat.copernic.m03uf06review.pojos.Empresa) s.load(cat.copernic.m03uf06review.pojos.Empresa.class, 13);
        s.delete(emp3);
        System.out.println("Campos eliminados correctamente");
    }
    
    public static void consultaSimple() {
        cat.copernic.m03uf06review.pojos.Empresa emp4 = (cat.copernic.m03uf06review.pojos.Empresa) s.load(cat.copernic.m03uf06review.pojos.Empresa.class, 1);
        System.out.println("\nDatos de la consulta:\nID: " + emp4.getId() + "\nEdad: " + emp4.getEdad() + "\nSalario: " + emp4.getSalario() + "\nPuesto de trabajo: " + emp4.getPuestoDeTrabajo());
    }
    
    public static void consultaHQL() {
        String HQL = "from Empresa";
        Query q = s.createQuery(HQL);
        
        List<cat.copernic.m03uf06review.pojos.Empresa> list = q.list();
        
        for(cat.copernic.m03uf06review.pojos.Empresa emp : list) {
            System.out.println("\nDatos de la consulta:\nID: " + emp.getId() + "\nEdad: " + emp.getEdad() + "\nSalario: " + emp.getSalario() + "\nIniciales: " + emp.getIniciales() + "\nPuesto de trabajo: " + emp.getPuestoDeTrabajo() + "\nDia de entrada: " + emp.getDiaEntrada());
        }
        
    }
        
}
