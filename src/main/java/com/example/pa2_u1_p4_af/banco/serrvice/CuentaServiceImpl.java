package com.example.pa2_u1_p4_af.banco.serrvice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa2_u1_p4_af.banco.repository.CuentaRepository;
import com.example.pa2_u1_p4_af.banco.repository.modelo.Cuenta;


@Service
public class CuentaServiceImpl implements CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public void guardar(Cuenta cuenta) {
        // TODO Auto-generated method stub
        this.cuentaRepository.insertar(cuenta);
    }

    @Override
    public void actualizar(Cuenta cuenta) {
        // TODO Auto-generated method stub
        this.cuentaRepository.actualizar(cuenta);
    }

    @Override
    public void borrar(String numero) {
            this.cuentaRepository.eliminar(numero);
    }

    @Override
    public Cuenta buscarPorNumero(String numero) {
        // TODO Auto-generated method stub
        return this.cuentaRepository.seleccionarPorNumero(numero);
    }
    
}
