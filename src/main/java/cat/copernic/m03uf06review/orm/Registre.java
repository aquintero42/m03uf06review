/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.m03uf06review.orm;

import java.util.Objects;

/**
 *
 * @author Adrian
 */
public class Registre {
    
    private int id;
    private int edad;
    private double salario;
    private String horasExtra;
    private String iniciales;
    private String diaEntrada;

    public Registre(int id, int edad, double salario, String horasExtra, String iniciales, String diaEntrada) {
        this.id = id;
        this.edad = edad;
        this.salario = salario;
        this.horasExtra = horasExtra;
        this.iniciales = iniciales;
        this.diaEntrada = diaEntrada;
    }

    public int getIdent() {
        return id;
    }

    public int getEdad() {
        return edad;
    }

    public double getSalario() {
        return salario;
    }

    public String getHorasExtra() {
        return horasExtra;
    }

    public String getIniciales() {
        return iniciales;
    }

    public String getDiaEntrada() {
        return diaEntrada;
    }

    @Override
    public String toString() {
        return "Registre{" + "ident=" + id + ", edad=" + edad + ", salario=" + salario + ", horasExtra=" + horasExtra + ", iniciales=" + iniciales + ", diaEntrada=" + diaEntrada + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id;
        hash = 71 * hash + this.edad;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.salario) ^ (Double.doubleToLongBits(this.salario) >>> 32));
        hash = 71 * hash + Objects.hashCode(this.horasExtra);
        hash = 71 * hash + Objects.hashCode(this.iniciales);
        hash = 71 * hash + Objects.hashCode(this.diaEntrada);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Registre other = (Registre) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.edad != other.edad) {
            return false;
        }
        if (Double.doubleToLongBits(this.salario) != Double.doubleToLongBits(other.salario)) {
            return false;
        }
        if (!Objects.equals(this.horasExtra, other.horasExtra)) {
            return false;
        }
        if (!Objects.equals(this.iniciales, other.iniciales)) {
            return false;
        }
        if (!Objects.equals(this.diaEntrada, other.diaEntrada)) {
            return false;
        }
        return true;
    }
    
    
    
}
