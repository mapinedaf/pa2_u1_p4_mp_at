package com.example.pa2_u1_p4_af.banco.repository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.pa2_u1_p4_af.banco.repository.modelo.Cuenta;
@Repository
public class CuentaRepositoryImpl implements CuentaRepository{

    private static List<Cuenta> baseDatos = new ArrayList<>();
    @Override
    public void insertar(Cuenta cuenta) {
        // TODO Auto-generated method stub
        baseDatos.add( cuenta);
    }

    @Override
    public void actualizar(Cuenta cuenta) {
        // TODO Auto-generated method stub
        this.eliminar(cuenta.getNumero());
        this.insertar(cuenta);
    }

    @Override
    public void eliminar(String numero) {
        // TODO Auto-generated method stub
        Cuenta cuen = this.seleccionar(numero);
        baseDatos.remove(cuen);
    }

    @Override
    public Cuenta seleccionar(String numero) {
        // TODO Auto-generated method stub
        Cuenta cuentaEncontrada = new Cuenta();
        for (Cuenta cuen : baseDatos){
            if ( numero.equals(cuen.getNumero())){
                cuentaEncontrada = cuen;
            }
        }
        return cuentaEncontrada;
    }
    
}
