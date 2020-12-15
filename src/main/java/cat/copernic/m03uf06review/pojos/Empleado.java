/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.pojos;

import java.util.Set;

/**
 *
 * @author Adrian
 */
public class Empleado {
    private Integer id;
    private String nombre;
    private String apellido;
    private int edad;
    private Set tareas;
    
    public Empleado() {
    }

    public Empleado(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Set getTareas() {
        return tareas;
    }

    public void setTareas(Set tareas) {
        this.tareas = tareas;
    }
    
}
