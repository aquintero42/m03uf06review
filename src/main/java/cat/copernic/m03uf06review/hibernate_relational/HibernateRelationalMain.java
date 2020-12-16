/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.hibernate_relational;

//import cat.copernic.m03uf06review.conexion.Controller;
import cat.copernic.m03uf06review.pojos.Empleado;
import cat.copernic.m03uf06review.pojos.Tarea;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * En aquesta secció cal accedir a dues taules de MySQL que formin una relació
 * 
 * One to Many, com per exemple: Departament -> Empleat
 * 
 * Cada departament té molts empleats, i un empleat només treballa en un
 * departament.
 * 
 * Recòrrer la relació i mostrar-la per la consola 
 * 
 * Cal usar la llibreria Hibernate.
 * 
 * @author pep
 */
public class HibernateRelationalMain {
    private static SessionFactory factory;
    
    public static void main(String[] args) {

        HashSet set1 = new HashSet();
        set1.add(new Tarea("Comentar el código"));
        set1.add(new Tarea("Solucionar la Issue nº42"));
        set1.add(new Tarea("Preparar los cafés"));
        //insertEmpleado(new Empleado("Arnau","Bayes", 22), set1);
        
        HashSet set2 = new HashSet();
        set2.add(new Tarea("Optimizar el código"));
        set2.add(new Tarea("Solucionar la Issue nº24"));
        set2.add(new Tarea("Preparar los cafés y servirlos"));
        //updateEmpleado(new Empleado(28,"Oriol","Bayes", 25), set2);
        //delete(27);
        //listaEmpleados();
    }
    
    public static void insertEmpleado(Empleado emp, Set tar) {
        sesion();
        Session s = factory.openSession();
        Transaction tr = null;
        try {
            tr = s.beginTransaction();
            emp.setTareas(tar);
            s.save(emp);
            System.out.println("Campos insertado correctamente");
            mostrarDatos(emp);
            tr.commit();
        } catch (HibernateException e) {
            if(tr!= null) tr.rollback();
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
    
    /*public static void updateEmpleado(Integer id, Set tar) {
        sesion();
        Session s = factory.openSession();
        Transaction tr = null;        
        try {
            tr = s.beginTransaction();
            Empleado emp = s.get(Empleado.class, id);
            emp.setTareas(tar);
            s.update(emp);
            System.out.println("Campos actualizados correctamente");
            mostrarDatos(emp);
            tr.commit();
        } catch (HibernateException e) {
            if(tr!= null) tr.rollback();
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }*/
    public static void updateEmpleado(Empleado emp, Set tar) {
        sesion();
        Session s = factory.openSession();
        Transaction tr = null;        
        try {
            tr = s.beginTransaction();
            emp.setTareas(tar);
            s.update(emp);
            System.out.println("Campos actualizados correctamente");
            mostrarDatos(emp);
            tr.commit();
        } catch (HibernateException e) {
            if(tr!= null) tr.rollback();
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
    
    public static void delete(Integer id) {
        sesion();
        Session s = factory.openSession();
        Transaction tr = null;
        try {
            tr = s.beginTransaction();
            Empleado emp = s.get(Empleado.class, id);
            s.delete(emp);
            System.out.println("Campos eliminados correctamente");
            mostrarDatos(emp);            
            tr.commit();
        } catch (HibernateException e) {
            if(tr!= null) tr.rollback();
            e.printStackTrace();
        } finally {
            factory.close();
        }

    }    
    
    public static void mostrarDatos(Empleado emp) {
        System.out.println("\nID: " + emp.getId() + "\nNombre: " + emp.getNombre() + "\nApellido: " + emp.getApellido() + "\nEdad: " + emp.getEdad());            
    }
    
    public static void listaEmpleados() {
        sesion();
        Session s = factory.openSession();
        Transaction tr = null;        
        try {
            tr = s.beginTransaction();
            String HQL = "from Empleado";
            Query q = s.createQuery(HQL);
            List<Empleado> list = q.list();

            for (Iterator<Empleado> it = list.iterator(); it.hasNext();) {
                Empleado emp = it.next();
                System.out.println("\nID: " + emp.getId() + "\nNombre: " + emp.getNombre() + "\nApellido: " + emp.getApellido() + "\nEdad: " + emp.getEdad());
                Set tareas = emp.getTareas();
                for (Iterator it2 = tareas.iterator(); it2.hasNext();){
                   Tarea tar = (Tarea) it2.next(); 
                   System.out.println("Tarea: " + tar.getNombreTarea()); 
                } 
            }
            
            tr.commit();
        } catch (HibernateException e) {
          if (tr!=null) tr.rollback();
          e.printStackTrace(); 
        } finally {
          factory.close(); 
        }
    }
    
    public static void sesion() {
        try {
           factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) { 
           System.err.println("Failed to create sessionFactory object." + ex);
           throw new ExceptionInInitializerError(ex); 
        }        
    }
    
}
