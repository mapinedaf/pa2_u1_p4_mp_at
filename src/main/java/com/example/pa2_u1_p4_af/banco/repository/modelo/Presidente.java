package com.example.pa2_u1_p4_af.banco.repository.modelo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton") 
public class Presidente {

    private String nombre;
    private String apellido;
    private String Cedula;
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getCedula() {
        return Cedula;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setCedula(String cedula) {
        Cedula = cedula;
    }
    @Override
    public String toString() {
        return "Presidente [nombre=" + nombre + ", apellido=" + apellido + ", Cedula=" + Cedula + "]";
    }
    
    
}
