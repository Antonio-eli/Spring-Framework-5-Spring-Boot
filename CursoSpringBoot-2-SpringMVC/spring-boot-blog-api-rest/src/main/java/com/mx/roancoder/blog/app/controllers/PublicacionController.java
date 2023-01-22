package com.mx.roancoder.blog.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.roancoder.blog.app.dto.PublicacionDto;
import com.mx.roancoder.blog.app.service.IPublicacionService;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {
	@Autowired
	private IPublicacionService publicacionService;
	
	@PostMapping
	public ResponseEntity<PublicacionDto> guadarPublicacion(@RequestBody PublicacionDto publicacionDto){
		return new ResponseEntity<>(publicacionService.crearPublicacion(publicacionDto), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<PublicacionDto> listarPublicaciones(){
		return publicacionService.obtenerPublicaciones();
	}
	
}
