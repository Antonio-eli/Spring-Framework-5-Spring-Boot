package com.roancoder.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roancoder.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	@GetMapping({"/index", "/", "", "home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framework con atributo Model!");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		usuario.setNombre("Eliceo");
		usuario.setApellido("Romero");
		usuario.setEmail("eliceoroan@gmail.com");
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Eliceo", "Romero", "eliceroan@gmail.com"));
		usuarios.add(new Usuario("Raul", "Romero", "raul@gmail.com"));
		usuarios.add(new Usuario("Elias", "Romero", "eliasMoas@gmail.com"));
		usuarios.add(new Usuario("Sara", "Giles", "sarag@gmail.com"));
		model.addAttribute("titulo", "Listado de usuarios: ");
		model.addAttribute("usuarios", usuarios);
		return "listar";
	}
}


