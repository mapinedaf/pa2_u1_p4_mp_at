package com.example.pa2_u1_p4_af;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.pa2_u1_p4_af.repository.modelo.Estudiante;
import com.example.pa2_u1_p4_af.serrvice.EstudianteServices;

@SpringBootApplication
public class Pa2U1P4AlApplication implements CommandLineRunner{
	@Autowired
	private EstudianteServices estudianteServices;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4AlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Estudiante myEstudiante = new Estudiante();
		myEstudiante.setNombre("Andres");
		myEstudiante.setApellido("Lugmaña");
		myEstudiante.setCedula("1724210685");
		myEstudiante.setFechaNacimiento(LocalDateTime.of(2000, 07, 27, 0, 0, 0));

		Estudiante myEstudiante1 = new Estudiante();
		myEstudiante1.setNombre("Marco");
		myEstudiante1.setApellido("Pineda");
		myEstudiante1.setCedula("17242104283");
		myEstudiante1.setFechaNacimiento(LocalDateTime.of(2000, 9, 27, 0, 0, 0));
		//1.- Guardar
		this.estudianteServices.guardar(myEstudiante);
		this.estudianteServices.guardar(myEstudiante1);
		

		


		
		//5.-Imprimir
		List<Estudiante> reporte = this.estudianteServices.reporteTodo();
		System.out.println("Reporte de todos los estudiantes");
		System.out.println("Reporte 1");
		for(Estudiante estu : reporte){
			System.out.println(estu);
		}
		//2.-Actualizar
		myEstudiante1.setApellido("Fernandez");

		this.estudianteServices.actualizar(myEstudiante1);
		System.out.println("Reporte 2");
		for(Estudiante estu : reporte){
			System.out.println(estu);
		}
		//4.-Eliminar
		this.estudianteServices.borrar("17242104283");
		System.out.println("Reporte 3");
		for(Estudiante estu : reporte){
			System.out.println(estu);
		}
		//3.-Buscar
		System.out.println("Cedula: 1724210685 \n" +this.estudianteServices.buscarPorCedula("1724210685"));
		//Busqueda inexistente
		System.out.println("Cedula: 172421068 \n" +this.estudianteServices.buscarPorCedula("172421068"));


	}

}
