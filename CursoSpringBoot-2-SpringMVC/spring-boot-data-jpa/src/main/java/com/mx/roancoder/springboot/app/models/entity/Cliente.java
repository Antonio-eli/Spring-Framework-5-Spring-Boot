package com.mx.roancoder.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="clientes")
@Setter
@Getter
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre; 
	private String apellido; 
	private String email; 
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;
	
	public void prePersist() {
		createAt = new Date();
	}
	

}
