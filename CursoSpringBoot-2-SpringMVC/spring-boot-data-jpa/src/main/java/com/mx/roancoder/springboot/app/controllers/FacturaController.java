package com.mx.roancoder.springboot.app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mx.roancoder.springboot.app.models.entity.Cliente;
import com.mx.roancoder.springboot.app.models.entity.Factura;
import com.mx.roancoder.springboot.app.models.entity.Producto;
import com.mx.roancoder.springboot.app.models.service.IClienteService;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/factura")
@SessionAttributes("factura")
@Log4j2
public class FacturaController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/form/{clienteId}")
	public String crear(@PathVariable(value = "clienteId") Long clienteId, Map<String, Object> model, RedirectAttributes flash) {
		Cliente cliente = clienteService.clienteId(clienteId);
		if(cliente == null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/listar";
		}
		
		Factura factura = new Factura();
		factura.setCliente(cliente);
		model.put("factura", factura);
		model.put("titulo", "Crear factura");
		return "factura/form";
	}
	
	@GetMapping(value = "/cargar-productos/{term}", produces = {"application/json"})
	public @ResponseBody List<Producto> cargarProductos(@PathVariable String term){
		log.info("term -> " + term);
		return clienteService.findByNombre(term);
	}
}
