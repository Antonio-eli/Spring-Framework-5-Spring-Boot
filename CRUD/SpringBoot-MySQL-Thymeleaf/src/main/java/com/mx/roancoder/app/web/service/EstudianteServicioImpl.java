package com.mx.roancoder.app.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mx.roancoder.app.web.entity.Estudiante;
import com.mx.roancoder.app.web.repository.IEstudianteRepository;

public class EstudianteServicioImpl implements IEstudianteServicio{

	@Autowired
	private IEstudianteRepository repository;
	
	@Override
	public List<Estudiante> listarEstudiantes() {
		return repository.findAll();
	}

}
