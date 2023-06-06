package com.example.pa2_u1_p4_af.banco.serrvice;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.pa2_u1_p4_af.banco.repository.CuentaRepository;
import com.example.pa2_u1_p4_af.banco.repository.TransferenciaRepository;
import com.example.pa2_u1_p4_af.banco.repository.modelo.Cuenta;
import com.example.pa2_u1_p4_af.banco.repository.modelo.Impuesto;
import com.example.pa2_u1_p4_af.banco.repository.modelo.Transferencia;
@Service
public class TransferenciaServiceImpl implements TransferenciaService {
    @Autowired
    private TransferenciaRepository transferenciaRepository;
    @Autowired
    private CuentaRepository cuentaRepository;
    @Autowired
    @Qualifier("internacional")
    private MontoDebitarService montoDebitarService;

    @Autowired 
    Impuesto impuesto;

    @Override
    public void guardar(Transferencia transferencia) {

        System.out.println("La transferencia se va a calcular con el iva");
        System.out.println(impuesto.getIva());
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
    public void realizar(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
       // Historia de usuario (Sin tener nada tecnico)
        //1.- Consultar la cuenta de origen por el numero 
        
        Cuenta ctaOrigen = this.cuentaRepository.seleccionar(numeroCtaOrigen);

        //2.- Consultar el saldo de la cuenta origen 

        BigDecimal saldoOrigen = ctaOrigen.getSaldo();

        BigDecimal montoDebitar = this.montoDebitarService.calcular(monto);

        //3.- Consultar si el saldo es suficiente 

        if (montoDebitar.compareTo(saldoOrigen) <= 0 ){
            
            //5.- Si si es suficiente ir al paso 6

            

            //6.- Realizamos la resta del saldo origen menos el monto 

            BigDecimal nuevoSaldoOrigen = saldoOrigen.subtract(montoDebitar);

            //7.- Actualizamos el nuevo saldo de la cuenta origen  

            ctaOrigen.setSaldo(nuevoSaldoOrigen);


            //8.- Consultamos la cuenta de destino por numero 

            Cuenta ctaDestino = this.cuentaRepository.seleccionar(numeroCtaDestino);

            //9.- Consultamos el saldo de la cuenta de destino 

            BigDecimal saldoDestino = ctaDestino.getSaldo();

            //10.- Realizamos la suma del saldo destino + monto

            BigDecimal nuevoSaldoDestino =  saldoDestino.add(monto);

            //11.- Actualizamos el nuevo saldo de la cuenta destino 

            ctaDestino.setSaldo(nuevoSaldoDestino);
            this.cuentaRepository.actualizar(ctaDestino);

            //12.- Creamos el resgistro (Transferencia)
            Transferencia transfer = new Transferencia();
            transfer.setCuentaOrigen(ctaOrigen);
            transfer.setCuentaDestino(ctaDestino);
            transfer.setMonto(monto);
            Double numero = Math.random();
            transfer.setNumero(numero.toString());
            transfer.setFecha(LocalDateTime.now());
            this.transferenciaRepository.insertar(transfer);


        }else{
            //4.- Si no es suficiente imprimir mensaje de no hay saldo 
            System.out.println("Saldo no disponible, su saldo es: " + saldoOrigen);
        }
    }

    @Override
    public List<Transferencia> estadoCuenta() {
        return this.transferenciaRepository.seleccionarTodo();
    }
    
}
