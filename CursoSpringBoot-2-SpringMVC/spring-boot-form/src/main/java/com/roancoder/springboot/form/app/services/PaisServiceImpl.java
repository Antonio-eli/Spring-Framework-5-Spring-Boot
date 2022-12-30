package com.roancoder.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.roancoder.springboot.form.app.models.domain.Pais;

@Service
public class PaisServiceImpl implements PaisService{

	private List<Pais> lista;
	public PaisServiceImpl() {
		this.lista = Arrays.asList(
				new Pais(1, "", "España"), 
				new Pais(2, "MX", "México"), 
				new Pais(3, "CR", "Costa Rica"), 
				new Pais(4, "ARG", "Argentina"), 
				new Pais(5, "POL", "Polonia"), 
				new Pais(6, "INDO", "Indonesia"), 
				new Pais(7, "QTAR", "Qatar"));
	}

	@Override
	public List<Pais> listar() {
		return lista;
	}

	@Override
	public Pais obtenerPorId(Integer id) {
		Pais resultado = null;
		for(Pais pais: this.lista) {
			if(id == pais.getId()) {
				resultado = pais;
				break;
			}
		}
		return resultado;
	}

}
