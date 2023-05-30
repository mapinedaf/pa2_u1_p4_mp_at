package com.example.pa2_u1_p4_af.banco.serrvice;

import java.math.BigDecimal;

import com.example.pa2_u1_p4_af.banco.repository.modelo.Transferencia;

public interface TransferenciaService {
    public void guardar(Transferencia transferencia);
    public void actualizar(Transferencia transferencia);
    public void borrar(String numero);
    public Transferencia buscarPorNumero(String numero);

    public void realizar(String numeroCuentaOrigen, String numeroCuentaDestino, BigDecimal monto);


}
