package com.example.pa2_u1_p4_af.banco.repository;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

@Repository
public class ImpuestoRepositoryImpl implements ImpuestoRepository{

    @Override
    public Double seleccionar(String codigoImpuesto) {
        return Double.valueOf(12);
    }
    
}
