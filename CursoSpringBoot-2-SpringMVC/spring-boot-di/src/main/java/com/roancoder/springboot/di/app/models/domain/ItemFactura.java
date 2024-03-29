package com.roancoder.springboot.di.app.models.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ItemFactura {
	private Producto producto;
	private Integer cantidad;
	
	public Integer calcularImporte() {
		return cantidad * producto.getPrecio();
	}
}
