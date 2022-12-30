package com.roancoder.springboot.form.app.models.domain;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pais {
	private Integer id;
	//@NotEmpty
	private String codigo;
	private String nombre;
}
