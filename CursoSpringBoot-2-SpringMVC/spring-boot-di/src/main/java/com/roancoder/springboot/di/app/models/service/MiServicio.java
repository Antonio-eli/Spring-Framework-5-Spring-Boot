package com.roancoder.springboot.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
//@Component("miServicioPrincipal")
public class MiServicio implements IServicio {
	
	@Override
	public String operacion() {
		return "Ejecutando algun proceso importante simple...";
	}
}
