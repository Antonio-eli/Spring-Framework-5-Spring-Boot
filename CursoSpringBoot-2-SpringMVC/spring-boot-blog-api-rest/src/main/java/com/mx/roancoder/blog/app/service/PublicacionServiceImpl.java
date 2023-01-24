package com.mx.roancoder.blog.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.roancoder.blog.app.dto.PublicacionDto;
import com.mx.roancoder.blog.app.entity.Publicacion;
import com.mx.roancoder.blog.app.exceptions.ResourceNotFoundException;
import com.mx.roancoder.blog.app.repository.IPublicacionRepositorio;

@Service
public class PublicacionServiceImpl implements IPublicacionService{

	@Autowired
	private IPublicacionRepositorio publicacionRepositorio;
	
	@Override
	public PublicacionDto crearPublicacion(PublicacionDto publicacionDto) {
		Publicacion publicacion = mapearEntity(publicacionDto);
		Publicacion nuevaPublicacion = publicacionRepositorio.save(publicacion);
		PublicacionDto publicacionRespuesta = mapearDto(nuevaPublicacion);
		return publicacionRespuesta;
	}

	@Override
	public List<PublicacionDto> obtenerPublicaciones() {
		List<Publicacion> publicaciones = publicacionRepositorio.findAll();
		return publicaciones.stream().map(publicacion -> mapearDto(publicacion)).collect(Collectors.toList());
	}
	
	//Convierte a DTO
	private PublicacionDto mapearDto(Publicacion publicacion) {
		PublicacionDto publicacionDto = new PublicacionDto();
		publicacionDto.setId(publicacion.getId());
		publicacionDto.setTitulo(publicacion.getTitulo());
		publicacionDto.setDescripcion(publicacion.getDescripcion());
		publicacionDto.setContenido(publicacion.getContenido());
		
		return publicacionDto;
	}
	//Convertimos de DTO a Entity
	private Publicacion mapearEntity(PublicacionDto publicacionDto) {
		Publicacion publicacion = new Publicacion();
		
		publicacion.setId(publicacionDto.getId());
		publicacion.setTitulo(publicacionDto.getTitulo());
		publicacion.setDescripcion(publicacionDto.getDescripcion());
		publicacion.setContenido(publicacionDto.getContenido());
		
		return publicacion;
	}

	@Override
	public PublicacionDto obtenerPublicacionById(long id) {
		Publicacion publicacion = publicacionRepositorio.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Publicacion", "id", id));
		return mapearDto(publicacion);
	}

	@Override
	public PublicacionDto actualizarPublicacion(PublicacionDto publicacionDto, long id) {
		Publicacion publicacion = publicacionRepositorio.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Publicacion", "id", id));
		
		publicacion.setTitulo(publicacionDto.getTitulo());
		publicacion.setDescripcion(publicacionDto.getDescripcion());
		publicacion.setContenido(publicacionDto.getContenido());
		
		Publicacion publicacionActualizada = publicacionRepositorio.save(publicacion);
		
		return mapearDto(publicacionActualizada);
	}

	@Override
	public void eliminarPublicacion(long id) {
		Publicacion publicacion = publicacionRepositorio.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Publicacion", "id", id));
		publicacionRepositorio.delete(publicacion);
	}

}
