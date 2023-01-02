package com.roancoder.springboot.error.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.roancoder.springboot.error.app.models.domain.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private List<Usuario> lista;
	
	
	
	public UsuarioServiceImpl() {
		this.lista = new ArrayList<>();
		this.lista.add(new Usuario(1, "Eliceo","Romero"));
		this.lista.add(new Usuario(2, "Sonia","Gonzalez"));
		this.lista.add(new Usuario(3, "Eduardo","Ramirez"));
		this.lista.add(new Usuario(4, "Santiago","Perez"));
		this.lista.add(new Usuario(5, "Saul","Ojeda"));
		this.lista.add(new Usuario(5, "Martin","Matinez"));
		this.lista.add(new Usuario(7, "Augusto","Lopez"));
	}

	@Override
	public List<Usuario> listar() {
		return lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario resultado = null;
		for(Usuario user: this.lista) {
			if(user.getId().equals(id)) {
				resultado = user;
				break;
			}
		}
		return resultado;
	}

}
