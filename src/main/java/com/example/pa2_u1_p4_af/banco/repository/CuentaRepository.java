package com.example.pa2_u1_p4_af.banco.repository;

import com.example.pa2_u1_p4_af.banco.repository.modelo.Cuenta;

public interface CuentaRepository {

    public void insertar(Cuenta cuenta);
    public void actualizar(Cuenta cuenta);

    public void eliminar(String numero);
    public Cuenta seleccionarPorNumero(String numero);
    
}
