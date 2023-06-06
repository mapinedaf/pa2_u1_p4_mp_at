package com.example.pa2_u1_p4_af.banco.repository.modelo;

import java.math.BigDecimal;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component
@Scope("prototype")
public class Cajero {
    private String nombre;
    private String apellido;
    private BigDecimal salary;
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public BigDecimal getSalary() {
        return salary;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Cajero [nombre=" + nombre + ", apellido=" + apellido + ", salary=" + salary + "]";
    }
       
}
