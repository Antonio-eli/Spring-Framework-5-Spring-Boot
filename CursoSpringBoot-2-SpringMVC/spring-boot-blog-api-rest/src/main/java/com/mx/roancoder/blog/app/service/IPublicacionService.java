package com.mx.roancoder.blog.app.service;

import java.util.List;

import com.mx.roancoder.blog.app.dto.PublicacionDto;

public interface IPublicacionService {
	public PublicacionDto crearPublicacion(PublicacionDto publicacionDto);
	public List<PublicacionDto> obtenerPublicaciones();
	public PublicacionDto obtenerPublicacionById(long id);
	public PublicacionDto actualizarPublicacion(PublicacionDto publicacionDto, long id);
	public void eliminarPublicacion(long id);
}