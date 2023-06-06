package com.example.pa2_u1_p4_af.serrvice;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa2_u1_p4_af.repository.EstudianteRepository;
import com.example.pa2_u1_p4_af.repository.modelo.Estudiante;

@Service
public class EstudianteServicesImpl implements EstudianteServices{

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public void guardar(Estudiante estudiante) {
        // TODO Auto-generated method stub
        this.estudianteRepository.insertar(estudiante);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        // TODO Auto-generated method stub
        this.estudianteRepository.actualizar(estudiante);
    }

    @Override
    public Estudiante buscarPorCedula(String cedula) {
        // TODO Auto-generated method stub
        return this.estudianteRepository.seleccionar(cedula);
    }
    
    @Override
    public void borrar(String cedula) {
        // TODO Auto-generated method stub
        this.estudianteRepository.eliminar(cedula);
    }

    @Override
    public List<Estudiante> reporteTodo() {
        // TODO Auto-generated method stub
        return this.estudianteRepository.seleccionarTodo();
    }
}
