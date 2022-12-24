package com.roancoder.springboot.form.app.models.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
	//@Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][0-9]{3}[-][A-z]{1}")
	private String identificador;
	//@NotEmpty(message = "El campo nombre no puede estar vacio")
	private String nombre;
	@NotEmpty
	private String apellido;
	@NotEmpty
	@Size(min = 3, max = 8)
	private String username;
	@NotEmpty
	private String password;
	@NotEmpty
	@Email(message = "El formato del email no es valido")
	private String email;
}
