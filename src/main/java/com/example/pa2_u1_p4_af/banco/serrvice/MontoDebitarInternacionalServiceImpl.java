package com.example.pa2_u1_p4_af.banco.serrvice;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
@Service("internacional")
public class MontoDebitarInternacionalServiceImpl implements MontoDebitarService {

    @Override
    public BigDecimal calcular(BigDecimal monto) {
        BigDecimal comision = monto.multiply(new BigDecimal(10)).divide(new BigDecimal(100));
        return monto.add(comision);
    }
    
}
