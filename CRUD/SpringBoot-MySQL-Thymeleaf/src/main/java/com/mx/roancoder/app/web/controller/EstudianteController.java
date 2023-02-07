package com.mx.roancoder.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mx.roancoder.app.web.service.IEstudianteServicio;

@Controller
public class EstudianteController {
	@Autowired
	private IEstudianteServicio servicio;
	
	@GetMapping({"/estudiantes", "/"})
	public String listarEstudiantes(Model model) {
		model.addAttribute("estudiantes", servicio.listarEstudiantes());
		return "estudiantes";
	}
	
}
