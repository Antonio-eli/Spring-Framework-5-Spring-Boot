package com.roancoder.springboot.form.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.roancoder.springboot.form.app.models.domain.Role;

@Service
public class RolServiceImple implements RoleService {
	
	private List<Role> roles;
	

	public RolServiceImple() {
		this.roles = new ArrayList<>();
		this.roles.add(new Role(1,"Administrador", "ROLE_ADMIN"));
		this.roles.add(new Role(2,"Usuario", "ROLE_USER"));
		this.roles.add(new Role(3,"Moderador","ROLE_MODERATOR"));
	}
	
	@Override
	public List<Role> listar() {
		return roles;
	}

	@Override
	public Role obtenerPorId(Integer id) {
		Role resultado = null;
		for(Role role: roles) {
			if(id == role.getId()) {
				resultado = role;
				break;
			}
		}
		return resultado;
	}

}
