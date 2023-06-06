package com.example.pa2_u1_p4_af.serrvice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa2_u1_p4_af.banco.repository.ImpuestoRepository;
import com.example.pa2_u1_p4_af.banco.repository.modelo.Impuesto;


@Service
public class CargaSistemaServiceImpl implements CargaSistemaService {


    @Autowired 
    private ImpuestoRepository impuestoRepository;
    
    @Autowired 
    private Impuesto impuesto;
    
    @Override
    public void cargar() {
        System.out.println( "Iniucio de carga de impuestos");
        this.impuesto.setIva(this.impuestoRepository.seleccionar(null));
        System.out.println("Fin de carga de impuestos");
    
    }

    
}
