package com.mx.roancoder.blog.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicacionDto {
	private Long id;
	private String titulo;
	private String descripcion;
	private String contenido;
}
