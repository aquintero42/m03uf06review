/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.hibernate;

import cat.copernic.m03uf06review.conexion.Controller;
import cat.copernic.m03uf06review.pojos.Empresa;
import java.sql.Date;
import java.util.Iterator;
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
    static Session s = Controller.getSessionFactory().openSession();
    static Transaction tr = s.beginTransaction();
    static Empresa emp = new Empresa();
    
    public static void main(String[] args) {
        //insert(new Empresa(null,25,935.32,true,"AGF","Junior Software Engineer", new java.util.Date(2020 - 12 - 10)));
        //update(new Empresa(5,33,4725.72,false,"ABC","Business Analyst", new java.util.Date(1970 - 01 - 01)));
        //delete(12);
        consultaSimple(1);
        //consultaHQL();
        
        tr.commit();
        s.close();
        tr = null;
    }
    
    public static void insert(Empresa emp) {
        s.save(emp);
        System.out.println("Campos insertados correctamente");
        mostrarDatos(emp);
    }
    
    public static void update(Empresa emp) {
        emp.getId();
        s.update(emp);
        System.out.println("Campos actualizados correctamente");
        mostrarDatos(emp);
    }
    
    public static void delete(Integer id) {
        Empresa emp = s.get(Empresa.class, id);
        s.delete(emp);
        System.out.println("Campos eliminados correctamente");
        mostrarDatos(emp);
    }
    
    public static void mostrarDatos(Empresa emp) {
        System.out.println("\nID: " + emp.getId() + "\nEdad: " + emp.getEdad() + "\nSalario: " + emp.getSalario() + "\nIniciales: " + emp.getIniciales() + "\nPuesto de trabajo: " + emp.getPuestoDeTrabajo() + "\nDia de entrada: " + emp.getDiaEntrada());    
    }
    
    public static void consultaSimple(Integer id) {
        Empresa emp = (Empresa) s.get(Empresa.class, id);
        System.out.println("\nID: " + emp.getId() + "\nEdad: " + emp.getEdad() + "\nSalario: " + emp.getSalario() + "\nIniciales: " + emp.getIniciales() + "\nPuesto de trabajo: " + emp.getPuestoDeTrabajo() + "\nDia de entrada: " + emp.getDiaEntrada());        
    }
    
    public static void consultaHQL() {
        String HQL = "from Empresa";
        Query q = s.createQuery(HQL);
        
        List<Empresa> list = q.list();
        
        for (Iterator<Empresa> it = list.iterator(); it.hasNext();) {
            emp = it.next();
            System.out.println("\nDatos de la consulta:\nID: " + emp.getId() + "\nEdad: " + emp.getEdad() + "\nSalario: " + emp.getSalario() + "\nIniciales: " + emp.getIniciales() + "\nPuesto de trabajo: " + emp.getPuestoDeTrabajo() + "\nDia de entrada: " + emp.getDiaEntrada());
        }
        
    }
        
}
