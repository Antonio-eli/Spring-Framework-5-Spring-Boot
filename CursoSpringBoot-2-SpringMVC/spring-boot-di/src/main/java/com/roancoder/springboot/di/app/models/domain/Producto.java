package com.roancoder.springboot.di.app.models.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Producto {
	
	private String nombre;
	private Integer precio;
}
