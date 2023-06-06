package com.example.pa2_u1_p4_af;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.pa2_u1_p4_af.banco.repository.modelo.Cajero;
import com.example.pa2_u1_p4_af.banco.repository.modelo.Impuesto;
import com.example.pa2_u1_p4_af.banco.repository.modelo.Presidente;
import com.example.pa2_u1_p4_af.banco.repository.modelo.Transferencia;
import com.example.pa2_u1_p4_af.banco.serrvice.CuentaService;
import com.example.pa2_u1_p4_af.banco.serrvice.TransferenciaService;
import com.example.pa2_u1_p4_af.serrvice.CargaSistemaService;

@SpringBootApplication
public class Pa2U1P4AlApplication implements CommandLineRunner{
	
	@Autowired 
	private Cajero cajero ;

	@Autowired
	private Cajero cajero2;

	@Autowired
	private Presidente presidente;

	@Autowired
	private Presidente presidente2;

	@Autowired
	private CargaSistemaService cargaSistemaService;

	@Autowired 
	private Impuesto impuesto;

	@Autowired 
	private TransferenciaService transferenciaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4AlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		this.cajero.setNombre("Marco");
		this.cajero.setApellido("Pineda");
		this.cajero.setSalary(BigDecimal.valueOf(1233));;
		System.out.println(cajero);
		System.out.println(cajero2);

		this.presidente.setApellido("Biden");
		this.presidente.setNombre("biden");
		this.presidente.setCedula("123456");

		System.out.println(presidente);
		this.presidente2 .setApellido("Taco");
		System.out.println(presidente);


		System.out.println("Segunda parte");
		this.cargaSistemaService.cargar();

		System.out.println(this.impuesto);

		Transferencia trans = new Transferencia();
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(BigDecimal.valueOf(100));

		this.transferenciaService.guardar(trans);



	}

	

}
