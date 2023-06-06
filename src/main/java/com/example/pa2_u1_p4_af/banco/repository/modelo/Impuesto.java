package com.example.pa2_u1_p4_af.banco.repository.modelo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Impuesto {
    
    private Double iva;

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    @Override
    public String toString() {
        return "Impuesto [iva=" + iva + "]";
    }

    



}
