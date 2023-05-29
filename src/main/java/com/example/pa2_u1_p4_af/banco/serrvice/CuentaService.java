package com.example.pa2_u1_p4_af.banco.serrvice;

import com.example.pa2_u1_p4_af.banco.repository.modelo.Cuenta;

public interface CuentaService {

    public void guardar(Cuenta cuenta);
    public void actualizar(Cuenta cuenta);
    public void borrar(String numero);
    public Cuenta buscarPorNumero(String numero);
    


    
}
