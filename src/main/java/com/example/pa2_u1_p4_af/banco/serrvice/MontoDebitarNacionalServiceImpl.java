package com.example.pa2_u1_p4_af.banco.serrvice;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
@Service("nacional")
public class MontoDebitarNacionalServiceImpl implements MontoDebitarService{

    @Override
    public BigDecimal calcular(BigDecimal monto) {
       
        return monto;
    }

    
}
