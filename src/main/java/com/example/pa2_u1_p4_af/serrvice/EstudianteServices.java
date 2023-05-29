package com.example.pa2_u1_p4_af.serrvice;

import java.util.List;

import com.example.pa2_u1_p4_af.repository.modelo.Estudiante;

public interface EstudianteServices {
    
    public void guardar(Estudiante estudiante);
    public void actualizar(Estudiante estudiante);
    //se busca mediante cedula
    public Estudiante buscarPorCedula(String cedula);
    //eliminamos mediante cedula
    public void borrar(String cedula);
    public List<Estudiante> reporteTodo();

}
