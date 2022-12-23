package com.roancoder.springboot.form.app.models.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	@NotEmpty
	private String email;
}
