package com.mx.roancoder.blog.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<PublicacionDto> obtenerPublicacionById(@PathVariable(name = "id") long id){
		return ResponseEntity.ok(publicacionService.obtenerPublicacionById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PublicacionDto> actualizarPublicacion(@RequestBody PublicacionDto publicacionDto, @PathVariable(name = "id") long id){
		PublicacionDto publiacionRespuesta = publicacionService.actualizarPublicacion(publicacionDto, id);
		return new ResponseEntity<>(publiacionRespuesta, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarPublicacion(@PathVariable(name = "id") long id){
		publicacionService.eliminarPublicacion(id);
		return new ResponseEntity<>("Publicacion eliminada con exito", HttpStatus.OK);
	}
	
}
