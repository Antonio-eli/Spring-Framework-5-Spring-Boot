package com.bolsadeideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
/*@RequestMapping:: Cuando @RequestMapping se usa en el nivel de clase, crea un URI base para el que se usará el controlador. 
 * Cuando esta anotación se utiliza en los métodos, le dará el URI en el que se ejecutarán los métodos del controlador. */
@RequestMapping("/app")
/* En el IndexController vienen en los nombres de las vistas que tienen que mostrar*/
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	/*@GetMapping:: Esta anotación relaciona los métodos en la ruta URL*/
	@GetMapping({"/index", "/", "", "/home"})
	/*
	 * Para poder pasar los datos a la vista tenemos que utilizar la  interfaz::Model:: que contiene métodos abstractos 
	 y se pasa por argumento una implementación como argumento :: model ::. Tenemos que agregar la configuración 
	 <html xmlns:th="http://www.thymeleaf.org"> en la etiqueta HTML
	  */
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		/* Retornamos el nombre de la vista y tenemos que crearlo con el mismo nombre*/
		return "index";
	}
	
	/*Si no se indica el tipo de @RequestMapping por defecto es Get*/
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Andrés");
		usuario.setApellido("Guzmán");
		usuario.setEmail("andres@correo.com");
		
		/*con el método model.addAttribute pasamos el nombre con el que se invoca en el HTML y le pasamos un valor */
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", textoListar);
		return "listar";
	}
	
	/*Método para pasar datos a la vista, pasamos como parámetro la lista que vamos a compartir*/
	@ModelAttribute("usuarios")
	/* Creamos un método para los datos que vamos a pasar a la vista. Un método independiente para listar los datos 
	 * permite todos los métodos del que el controlador pueden acceder a dicha lista */
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("Andrés", "Guzmán", "andres@correo.com"),
				new Usuario("John", "Doe", "john@correo.com"),
				new Usuario("Jane", "Doe", "jane@correo.com"),
				new Usuario("Tornado", "Roe", "roe@correo.com"));
		
		return usuarios;
	}

}
