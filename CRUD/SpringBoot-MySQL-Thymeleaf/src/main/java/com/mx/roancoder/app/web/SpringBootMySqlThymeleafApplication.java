package com.mx.roancoder.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mx.roancoder.app.web.entity.Estudiante;
import com.mx.roancoder.app.web.repository.IEstudianteRepository;

@SpringBootApplication
public class SpringBootMySqlThymeleafApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMySqlThymeleafApplication.class, args);
	}

	
	@Autowired
	private IEstudianteRepository repositorio;
	
	@Override
	public void run(String... args) throws Exception {
		Estudiante estudiante = new Estudiante("Eliceo", "Romero", "eliceoroan@gmail.com");
		repositorio.save(estudiante);
		
		Estudiante estudiante1 = new Estudiante("Elias", "Romero", "elias@gmail.com");
		repositorio.save(estudiante1);
		
	}

}
