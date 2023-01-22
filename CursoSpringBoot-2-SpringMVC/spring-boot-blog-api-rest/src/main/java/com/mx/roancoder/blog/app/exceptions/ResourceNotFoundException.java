package com.mx.roancoder.blog.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -1050454129589217438L;
	
	private String nombreRecurso;
	private String nombreCampo;
	private Long valorCampo;
	
	public ResourceNotFoundException(String nombreRecurso, String nombreCampo, Long valorCampo) {
		super(String.format("%% No encontrado con : %s : '%s", nombreRecurso,nombreCampo,valorCampo));
		this.nombreRecurso = nombreRecurso;
		this.nombreCampo = nombreCampo;
		this.valorCampo = valorCampo;
	}
	
	

}
