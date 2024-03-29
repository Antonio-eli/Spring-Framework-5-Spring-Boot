package com.roancoder.springboot.horariointerceptor.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.roancoder.springboot.horariointerceptor.app.interceptors.HorarioInterceptor;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class AppController {
	
	@Value("${config.horario.apertura}")
	private Integer apertura;
	@Value("${config.horario.cierre}")
	private Integer cierre;
	
	@GetMapping({"/", "/index"})
	public String index(Model model) {
		model.addAttribute("titulo", "Bienvenido al horario de atención a clientes");
		return "index";
	}
	@GetMapping("/cerrado")
	public String cerrado(Model model) {
		StringBuilder mensaje = new StringBuilder("Cerrado, por favor visitemos desde las: ");
		mensaje.append(apertura);
		mensaje.append(" y las: ");
		mensaje.append(cierre);
		mensaje.append(" hrs. Gracias");
		log.info("mensaje ->", mensaje);
		model.addAttribute("titulo", "Fuera de horario de atención");
		model.addAttribute("mensaje", mensaje);
		return "cerrado";
	}

}
