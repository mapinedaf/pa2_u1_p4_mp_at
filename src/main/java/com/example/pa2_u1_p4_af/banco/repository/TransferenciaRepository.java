package com.example.pa2_u1_p4_af.banco.repository;

import java.util.List;

import com.example.pa2_u1_p4_af.banco.repository.modelo.Transferencia;

public interface TransferenciaRepository {

    public void insertar(Transferencia transferencia);
    public void actualizar(Transferencia transferencia);
    public void eliminar(String numero);
    public Transferencia seleccionarPorNumero(String numero);
    public List<Transferencia> seleccionarTodo();
    
}
