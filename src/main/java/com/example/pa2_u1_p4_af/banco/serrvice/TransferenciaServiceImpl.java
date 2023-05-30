package com.example.pa2_u1_p4_af.banco.serrvice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pa2_u1_p4_af.banco.repository.CuentaRepository;
import com.example.pa2_u1_p4_af.banco.repository.TransferenciaRepository;
import com.example.pa2_u1_p4_af.banco.repository.modelo.Cuenta;
import com.example.pa2_u1_p4_af.banco.repository.modelo.Transferencia;
@Service
public class TransferenciaServiceImpl implements TransferenciaService {
    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Autowired
    private CuentaRepository cuentaRepository;


    @Override
    public void guardar(Transferencia transferencia) {
        this.transferenciaRepository.insertar(transferencia);
    }

    @Override
    public void actualizar(Transferencia transferencia) {
    this.transferenciaRepository.actualizar(transferencia);
    }

    @Override
    public void borrar(String numero) {
        this.transferenciaRepository.eliminar(numero);
    }

    @Override
    public Transferencia buscarPorNumero(String numero) {
       return this.transferenciaRepository.seleccionarPorNumero(numero);
    }

    @Override
    public void realizar(String numeroCuentaOrigen, String numeroCuentaDestino, BigDecimal monto) {
       //1. Consultar la cuenta de origen por el
       // numero  

       Cuenta cuentaOrigen = this.cuentaRepository.seleccionarPorNumero(numeroCuentaOrigen);

        /*2. Consultar el saldo de la cuenta origen */

        BigDecimal saldoOrigen = cuentaOrigen.getSaldo();


        /*3. Validar si el saldo es suficiente*/

        if(monto.compareTo(saldoOrigen) <= 0){

            /*4.  Si  no es suficiente imprimir mensage de no hay saldo */
            /*5. Si es suficiente ir al paso 6 */
            /*6. realizamos saldo origen - monto */

            BigDecimal nuevoSaldoOrigen = saldoOrigen.subtract(monto);

            /*7. Actualizamos el nuevo saldo de la cuenta origen */

            cuentaOrigen.setSaldo(nuevoSaldoOrigen);
            this.cuentaRepository.actualizar(cuentaOrigen);


            /*8. Consultamos la cuenta de destino por el numero */

            Cuenta cuentaDestino = this.cuentaRepository.seleccionarPorNumero(numeroCuentaDestino);

            /*9. Consultamos el saldo de la cuenta destino */

            BigDecimal saldoDestino = cuentaDestino.getSaldo();

            /*10. saldo destino + monto */

            BigDecimal nuevoSaldoDestino = saldoDestino.add(monto);

            /*11. Actualizamos cuenta destino */

            cuentaDestino.setSaldo(nuevoSaldoDestino);
            this.cuentaRepository.actualizar(cuentaDestino);
            /*12. Creamos la transferencia*/

            Transferencia trans = new Transferencia();
            trans.setCuentaOrigen(cuentaOrigen);
            trans.setCuentaDestino(cuentaDestino);
            trans.setMonto(monto);
            Double numero = Math.random();
            trans.setNumero(numero.toString());
            trans.setFecha(LocalDateTime.now());


            this.transferenciaRepository.insertar(trans);

        }else{
            System.out.println("Saldo no disponible, su saldo es: " +saldoOrigen);
        }

      
































    }
    
}
