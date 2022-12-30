package com.roancoder.springboot.form.app.models.domain;

import java.util.Date;
import java.util.List;


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
	@IdentificadorRegex
	private String identificador;
	private String nombre;
	@Requerido
	private String apellido;
	@NotBlank
	@Size(min = 3, max = 8)
	private String username;
	@NotEmpty
	private String password;
	@Requerido
	@Email(message = "El formato del email no es valido")
	private String email;
	
	@NotNull
	@Min(5)
	@Max(5000)
	private Integer cuenta;
	
	@NotNull
	@Past
	private Date fechaNacimiento;
	
	@NotNull
	private Pais pais;
	
	@NotEmpty
	private List<Role> roles;
	
	private Boolean habilitar;
	
	private String genero;
	
	private String valorSecreto;
}
