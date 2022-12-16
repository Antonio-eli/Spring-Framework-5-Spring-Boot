package com.roancoder.springboot.web.app.models;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class Usuario {
	private String nombre;
	private String apellido;
	private String email;
}
