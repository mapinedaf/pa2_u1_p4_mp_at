package com.example.pa2_u1_p4_af;

public class MatriculaCalculo {

    public void realizarMatricula(String tipo){

        if(tipo.equals("1")){
            Materia mat = new Materia();
            mat.setNombre("P. web");
            //insertar en la base 
            System.out.println("se inserto materia");
        }else{
            MateriaExtraordinaria matX = new MateriaExtraordinaria();
            matX.setNombre("P. web");
            matX.setCantidadCreditos(null);
            //insertar en la base 
            System.out.println("se inserto materia extraordinaria");

        }

    }
    
}
