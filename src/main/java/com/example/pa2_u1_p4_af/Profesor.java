package com.example.pa2_u1_p4_af;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component //le estoy delegando el control al contenedor

public class Profesor {
    private String nombre;
    private String apellido;
    private String cedula;
    private LocalDateTime fecha;

    //get y set
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
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    //toString
    @Override
    public String toString() {
        return "Profesor [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", fecha=" + fecha
                + "]";
    }

    
    
    
    
}
