package com.roancoder.springboot.error.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.roancoder.springboot.error.app.errors.UsuarioNoEncontradoException;
import com.roancoder.springboot.error.app.models.domain.Usuario;
import com.roancoder.springboot.error.app.services.UsuarioService;



@Controller
public class AppController {
	
	@Autowired
	private UsuarioService usuService;
	
	@GetMapping("/index")
	public String index() {
		//@SuppressWarnings("unused")
		//Integer valor = 100/0;
		Integer valor = Integer.parseInt("10x");
		return "index";
	}
	
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable Integer id, Model model) {
		/*Usuario usuario = usuService.obtenerPorId(id);
		
		if(usuario == null) {
			throw new UsuarioNoEncontradoException(id.toString());
		}*/
		
		Usuario usuario = usuService.obtenerPorIdOptional(id).orElseThrow(() -> new UsuarioNoEncontradoException(id.toString()));
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Detalle usuario: ".concat(usuario.getNombre()));
		return "ver";
	}
}
