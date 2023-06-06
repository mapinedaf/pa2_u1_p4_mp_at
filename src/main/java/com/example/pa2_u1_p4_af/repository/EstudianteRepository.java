package com.example.pa2_u1_p4_af.repository;

import java.util.List;

import com.example.pa2_u1_p4_af.repository.modelo.Estudiante;

public interface EstudianteRepository {
    
    
    public void insertar(Estudiante estudiante);
    public void actualizar(Estudiante estudiante);
    //se busca mediante un identificador
    public Estudiante seleccionar(String cedula);
    //eliminamos mediante un identificador
    public void eliminar(String cedula);
    public List<Estudiante> seleccionarTodo();


}
