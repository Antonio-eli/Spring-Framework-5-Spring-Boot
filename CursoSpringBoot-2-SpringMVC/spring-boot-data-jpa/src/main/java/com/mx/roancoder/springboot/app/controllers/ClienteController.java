package com.mx.roancoder.springboot.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.mx.roancoder.springboot.app.models.dao.IClienteDao;
import com.mx.roancoder.springboot.app.models.entity.Cliente;

import jakarta.validation.Valid;





@Controller
@SessionAttributes("cliente")
public class ClienteController {
	
	@Autowired
	private IClienteDao clienteDao;
	
	@GetMapping({"/", "", "/listar"})
	private String listar(Model model) {
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteDao.findAll());
		return "listar";
	}
	
	@GetMapping("/form")
	public String crear(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario del cliente");
		return "form";
	}
	@GetMapping("/form/{id}")
	public String editar(@PathVariable Long id, Map<String, Object> model) {
		Cliente cliente = null;
		if( id > 0 ) {
			cliente = clienteDao.clienteId(id);
		}else {
			return "redirect:listar";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar cliente");
		return "form";
	}
	
	@PostMapping("/form")
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) {
		if(result.hasErrors()){
			model.addAttribute("titulo", "Formulario del cliente");
			return "form";
		}
		clienteDao.save(cliente);
		status.isComplete();
		return "redirect:listar";
	}
	
	
}
