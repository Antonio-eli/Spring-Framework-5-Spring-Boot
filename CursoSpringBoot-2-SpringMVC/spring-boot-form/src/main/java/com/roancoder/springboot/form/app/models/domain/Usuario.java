package com.roancoder.springboot.form.app.models.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.roancoder.springboot.form.app.validation.IdentificadorRegex;
import com.roancoder.springboot.form.app.validation.Requerido;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
//import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
	//@Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][0-9]{3}[-][A-z]{1}")
	@IdentificadorRegex
	private String identificador;
	//@NotEmpty(message = "El campo nombre no puede estar vacio")
	private String nombre;
	//@NotEmpty
	@Requerido
	private String apellido;
	@NotBlank
	@Size(min = 3, max = 8)
	private String username;
	@NotEmpty
	private String password;
	//@NotEmpty
	@Requerido
	@Email(message = "El formato del email no es valido")
	private String email;
	
	@NotNull
	@Min(5)
	@Max(5000)
	private Integer cuenta;
	
	@NotNull
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
}
