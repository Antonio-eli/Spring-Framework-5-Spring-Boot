package com.roancoder.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequestScope
@Getter
@Setter
public class Factura implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Value("${factura.descripcion}")
	private String descripcion;
	
	@Autowired
	private Cliente cliente;
	
	@Autowired
	@Qualifier("itemsFacturaOficina")
	private List<ItemFactura> items;
	
	@PostConstruct
	public void inicializar() {
		cliente.setNombre(cliente.getNombre().concat(" ").concat("Antonio"));
		descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
	}
	
	@PreDestroy
	public void destruir() {
		log.info("Factura destruida {}: ".concat(descripcion));
	}

}
