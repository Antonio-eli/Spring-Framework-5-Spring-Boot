package com.mx.coderroan.dI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.mx.coderroan.dI.atributo.Coche;


@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(DependencyInjectionApplication.class, args);
		
		Coche coche = context.getBean(Coche.class);
		System.out.println(coche);

	}

}
