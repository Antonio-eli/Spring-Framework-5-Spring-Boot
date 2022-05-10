package com.bolsadeideas.springboot.form.app.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;

@Controller
public class FormController {
	
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("titulo", "Formulario usuarios");
		/*Tenemos que retornar la clase de tipo usuario*/
		model.addAttribute("usuario", usuario);
		return "form";
	}
	
	@PostMapping("/form")
	/*	@Valid:: Con esta anotación típicas  validamos el Form para ello 
	  	nos vamos a la clase usuario y le indicamos que los 
 		campos no deben ser vacios con la anotación @NotEmpty
 	*/
	
	/*BindingResult propio de spring:: esta Interface nos permite obtener el resultado de una validación
	 * y contiene los errores que pueden haber ocurrido.*/
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model) {
		
		model.addAttribute("titulo", "Resultado form");
		
		if(result.hasErrors()) {
			/*Map :: HashMap :: es una Interface que nos permite una forma simple y poderosa de almacenar y recuperar datos*/
			Map<String, String> errores = new HashMap<>();
			result.getFieldErrors().forEach(err ->{
				errores.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
			});
			model.addAttribute("error", errores);
			return "form";
		}
		
		model.addAttribute("usuario", usuario);

		return "resultado";
	}

}
